package edu.project3.reportgenerator;

import edu.project3.LogReport;
import nl.jworks.markdown_to_asciidoc.Converter;

public class AdocReportGenerator implements ReportGenerator {
    @Override
    public String generateReport(LogReport logReport) {
        return Converter.convertMarkdownToAsciiDoc(new MarkdownReportGenerator().generateReport(logReport));
    }
}
