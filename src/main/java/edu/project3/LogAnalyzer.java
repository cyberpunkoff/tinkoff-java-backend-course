package edu.project3;

import edu.project3.logloader.HttpLogLoader;
import edu.project3.logloader.LocalFileLogLoader;
import edu.project3.logloader.LogLoader;
import edu.project3.reportgenerator.AdocReportGenerator;
import edu.project3.reportgenerator.MarkdownReportGenerator;
import edu.project3.reportgenerator.ReportGenerator;
import java.time.LocalDate;
import java.util.List;
import picocli.CommandLine.Option;

@SuppressWarnings("RegexpSinglelineJava")
public class LogAnalyzer implements Runnable {
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
        List<LogRecord> logRecords = textLogRecords.stream().map(LogRecord::parse).toList();
        LogReport logReport = new LogReport(logRecords, from, to, logLoader.getFileNames());
        System.out.println(reportGenerator.generateReport(logReport));
    }
}
