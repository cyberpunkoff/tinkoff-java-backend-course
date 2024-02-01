package edu.project3.logloader;

import java.util.List;

public interface LogLoader {
    List<String> getLogRecords();

    List<String> getFileNames();
}
