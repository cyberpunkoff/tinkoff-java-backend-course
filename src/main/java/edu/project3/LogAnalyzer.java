package edu.project3;

import edu.project3.logloader.HttpLogLoader;
import edu.project3.logloader.LogLoader;
import edu.project3.reportgenerator.AdocReportGenerator;
import edu.project3.reportgenerator.MarkdownReportGenerator;
import edu.project3.reportgenerator.ReportGenerator;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.LogRecord;
import picocli.CommandLine.Option;

public class LogAnalyzer {
    @Option(names = {"--path"})
    private String path;
    @Option(names = {"--from"})
    private LocalDate from;
    @Option(names = {"--to"})
    private LocalDate to;
    @Option(names = {"--format"})
    private String format;

    ReportGenerator reportGenerator;
    LogLoader logLoader;


    public void run() {
        if (UrlUtils.isValidUrl(path)) {
            logLoader = new HttpLogLoader(path);
        } else {
            logLoader = new LocalFileLogLoader(path);
        }

        if (format.equals("markdown")) {
            reportGenerator = new MarkdownReportGenerator();
        } else if (format.equals("adoc")) {
            reportGenerator = new AdocReportGenerator();
        } else {
            reportGenerator = new AdocReportGenerator();
        }

        List<String> textLogRecords = logLoader.getLogRecords();

        List<LogRecord> logRecords = textLogRecords.forEach(LogRecord::parse).toList();

        LogReport logReport = new LogReport(logRecords, to, from, logLoader.getFileNames());

    }
}
