package edu.project3.reportgenerator;

import edu.project3.LogReport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;
import net.steppschuh.markdowngenerator.text.code.Code;
import org.apache.hc.core5.http.impl.EnglishReasonPhraseCatalog;

public class AdocReportGenerator implements ReportGenerator {
    private LogReport logReport;

    @Override
    public String generateReport(LogReport logReport) {
        this.logReport = logReport;
        return generateAdocReport();
    }

    private String generateAdocReport() {
        StringBuilder report = new StringBuilder()
            .append("==== Общая информация\n\n")
            .append(buildGeneralInfoTable()).append("\n\n")
            .append("==== Запрашиваемые ресурсы\n\n")
            .append(buildResourceCountTable()).append("\n\n")
            .append("==== Коды ответа\n\n")
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

        StringBuilder result = new StringBuilder()
            .append("[cols=\"2*\",options=\"header\"] \n|===\n")
            .append("|Ресурс\n|Количество\n")
            .append("|").append("Файл(-ы)").append("\n|")
            .append(
                logReport.getPaths().stream()
                    .map(Code::new)
                    .map(Code::toString)
                    .collect(Collectors.joining(", "))
            )
            .append("\n|Начальная дата\n")
            .append("|").append(fromDate).append("\n")
            .append("|Конечная дата\n|")
            .append(toDate)
            .append("\n|Количество запросов\n|")
            .append(logReport.getRequestCount())
            .append("\n|Средний размер ответа\n|").append(logReport.getAverageBodyBytesSent()).append("b")
            .append("\n|===\n");

        return result.toString();
    }

    private String buildResourceCountTable() {
        StringBuilder result = new StringBuilder()
            .append("[cols=\"2*\",options=\"header\"] \n|===\n")
            .append("|Ресурс\n|Количество\n");

        int i = 0;

        for (var entry : logReport.getRequestedResourceCount().entrySet()) {
            if (i == 3) {
                break;
            } else {
                i++;
            }

            result.append("|").append(entry.getKey()).append("\n");
            result.append("|").append(entry.getValue()).append("\n");
        }

        result.append("|===");
        return result.toString();
    }

    private String buildResponseCodesCountTable() {
        StringBuilder result = new StringBuilder()
            .append("[cols=\"3*\",options=\"header\"] \n|===\n")
            .append("|Код\n|Имя\n|Количество\n");

        for (var entry : logReport.getResponseCodesCount().entrySet()) {
            result.append("|").append(entry.getKey()).append("\n");
            result.append("|").append(EnglishReasonPhraseCatalog.INSTANCE.getReason(entry.getKey(), null)).append("\n");
            result.append("|").append(entry.getValue()).append("\n");
        }

        result.append("|===");
        return result.toString();
    }
}
