package edu.hw6.task6;

import edu.hw6.task6.port.Port;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class PortsPrinter {
    private final static Logger LOGGER = LogManager.getLogger();

    private PortsPrinter() {
    }

    public static void print(List<Port> ports) {
        LOGGER.info(String.format("%-10s %-8s %s%n", "Протокол", "Порт", "Сервис"));
        ports.forEach(port -> LOGGER.info(String.format(
            "%-10s %-8d %s%n",
            port.getType().toString(),
            port.getValue(),
            port.getTitle()
        )));
    }
}
