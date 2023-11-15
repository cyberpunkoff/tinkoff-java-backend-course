package edu.project3;

import java.time.ZonedDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class LogRecord {
    private String remoteAddress;
    private String remoteUser;
    private ZonedDateTime timeLocal;
    private Request request;
    private int status;
    private long bodyBytesSent;
    private String httpReferer;
    private String httpUserAgent;

    public static LogRecord parse(String record) {
        String[] props = record.split(" ");
        return LogRecord.builder()
            .remoteAddress(props[0])
            .remoteUser(props[1])
            .timeLocal(ZonedDateTime.parse(props[2]))
            .request(Request.parse(props[3]))
            .status(Integer.parseInt(props[4]))
            .bodyBytesSent(Long.parseLong(props[5]))
            .httpReferer(props[6])
            .httpUserAgent(props[7])
            .build();
    }
}
