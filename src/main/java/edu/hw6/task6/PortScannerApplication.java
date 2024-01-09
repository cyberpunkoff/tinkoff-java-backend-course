package edu.hw6.task6;

import edu.hw6.task6.port.Port;
import edu.hw6.task6.port.PortScanner;
import java.util.List;

public final class PortScannerApplication {
    private PortScannerApplication() {
    }

    public static void run() {
        List<Port> ports = PortScanner.scanPorts();
        PortsPrinter.print(ports);
    }
}
