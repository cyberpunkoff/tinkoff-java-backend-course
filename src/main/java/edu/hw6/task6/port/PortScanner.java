package edu.hw6.task6.port;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;
import static edu.hw6.task6.port.PortDescriptionUtils.getPortDescription;

public final class PortScanner {
    public static final int LOWER_PORT_SCAN_BOUND = 0;
    public static final int UPPER_PORT_SCAN_BOUND = 49151;

    private PortScanner() {
    }

    public static List<Port> scanPorts() {
        List<Port> ports = new ArrayList<>();

        for (int i = LOWER_PORT_SCAN_BOUND; i <= UPPER_PORT_SCAN_BOUND; i++) {
            try {
                ServerSocket serverSocket = new ServerSocket(i);
                serverSocket.close();
            } catch (IOException e) {
                ports.add(new Port(i, Port.Type.TCP, getPortDescription(i)));
            }

            try {
                DatagramSocket datagramSocket = new DatagramSocket(i);
                datagramSocket.close();
            } catch (IOException e) {
                ports.add(new Port(i, Port.Type.UDP, getPortDescription(i)));
            }

        }

        return ports;
    }

}
