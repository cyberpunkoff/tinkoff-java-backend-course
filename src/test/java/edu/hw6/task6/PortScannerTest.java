package edu.hw6.task6;

import edu.hw6.task6.port.PortScanner;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PortScannerTest {
    @Test
    public void checkPorts_shouldReturnListOfUsedPorts() {
        assertThat(PortScanner.scanPorts()).isNotEmpty();
    }
}
