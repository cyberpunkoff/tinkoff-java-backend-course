package edu.project3;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class LogRecord {
    private static final String RECORD_REGEX =
        "^(?<remoteAddr>[^ ]*) - (?<remoteUser>[^ ]*) \\[(?<time>[^\\]]*)\\] \"(?<request>[^\"]+)\" (?<status>[^ ]*) (?<bodyBytesSent>[^ ]*) \"(?<httpReferer>[^\\\"]*)\" \"(?<httpUserAgent>[^\\\"]*)\"$";

    private String remoteAddress;
    private String remoteUser;
    private OffsetDateTime timeLocal;
    private Request request;
    private int status;
    private long bodyBytesSent;
    private String httpReferer;
    private String httpUserAgent;

    public static LogRecord parse(String record) {
        Pattern logRecordPattern = Pattern.compile(RECORD_REGEX);
        Matcher logRecordMatcher = logRecordPattern.matcher(record);

        if (!logRecordMatcher.find()) {
            throw new RuntimeException("Log record parse exception");
        }

        String pattern = "dd/MMM/yyyy:HH:mm:ss Z";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern, Locale.US);

        return LogRecord.builder()
            .remoteAddress(logRecordMatcher.group("remoteAddr"))
            .remoteUser(logRecordMatcher.group("remoteUser"))
            .timeLocal(OffsetDateTime.parse(logRecordMatcher.group("time"), dateTimeFormatter))
            .request(Request.parse(logRecordMatcher.group("request")))
            .status(Integer.parseInt(logRecordMatcher.group("status")))
            .bodyBytesSent(Long.parseLong(logRecordMatcher.group("bodyBytesSent")))
            .httpReferer(logRecordMatcher.group("httpReferer"))
            .httpUserAgent(logRecordMatcher.group("httpUserAgent"))
            .build();
    }
}
