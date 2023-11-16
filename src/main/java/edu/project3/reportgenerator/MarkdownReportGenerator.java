package edu.project3.reportgenerator;

import edu.project3.LogReport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;
import net.steppschuh.markdowngenerator.table.Table;
import net.steppschuh.markdowngenerator.text.code.Code;
import net.steppschuh.markdowngenerator.text.heading.Heading;
import org.apache.hc.core5.http.impl.EnglishReasonPhraseCatalog;

public class MarkdownReportGenerator implements ReportGenerator {
    LogReport logReport;

    @Override
    public String generateReport(LogReport logReport) {
        this.logReport = logReport;
        return generateMarkdownReport();
    }

    private String generateMarkdownReport() {
        StringBuilder report = new StringBuilder()
            .append(new Heading("Общая информация", 4)).append("\n\n")
            .append(buildGeneralInfoTable()).append("\n\n")
            .append(new Heading("Запрашиваемые ресурсы", 4)).append("\n\n")
            .append(buildResourceCountTable()).append("\n\n")
            .append(new Heading("Коды ответа", 4)).append("\n\n")
            .append(buildResponseCodesCountTable());

        return report.toString();
    }

    private String buildGeneralInfoTable() {
        String fromDate;
        String toDate;

        if (logReport.getFromDate().equals(LocalDate.MIN)) {
            fromDate = "-";
        } else {
            fromDate = logReport.getFromDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        }

        if (logReport.getToDate().equals(LocalDate.MAX)) {
            toDate = "-";
        } else {
            toDate = logReport.getFromDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        }

        Table.Builder tableBuilder = new Table.Builder()
            .withAlignments(Table.ALIGN_CENTER, Table.ALIGN_RIGHT)
            .withRowLimit(6)
            .addRow("Метрика", "Значение")
            .addRow(
                "Файл(-ы)",
                logReport.getPaths().stream()
                    .map(Code::new)
                    .map(Code::toString)
                    .collect(Collectors.joining(", "))
            )
            .addRow("Начальная дата", fromDate)
            .addRow("Конечная дата", toDate)
            .addRow("Количество запросов", logReport.getRequestCount())
            .addRow("Средний размер ответа", logReport.getAverageBodyBytesSent() + "b");

        return tableBuilder.build().toString();
    }

    private String buildResourceCountTable() {
        Table.Builder tableBuilder = new Table.Builder()
            .withAlignments(Table.ALIGN_CENTER, Table.ALIGN_RIGHT)
            .withRowLimit(4)
            .addRow("Ресурс", "Количество");

        for (var entry : logReport.getRequestedResourceCount().entrySet()) {
            tableBuilder.addRow(new Code(entry.getKey()), entry.getValue());
        }

        return tableBuilder.build().toString();
    }

    private String buildResponseCodesCountTable() {
        Table.Builder tableBuilder = new Table.Builder()
            .withAlignments(Table.ALIGN_CENTER, Table.ALIGN_CENTER, Table.ALIGN_RIGHT)
            .addRow("Код", "Имя", "Количество");

        for (var entry : logReport.getResponseCodesCount().entrySet()) {
            tableBuilder.addRow(
                entry.getKey(),
                EnglishReasonPhraseCatalog.INSTANCE.getReason(entry.getKey(), null),
                entry.getValue()
            );
        }

        return tableBuilder.build().toString();
    }
}
