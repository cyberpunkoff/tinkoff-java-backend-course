package edu.hw6.task6.port;

import java.util.Map;
import java.util.Objects;

public final class PortDescriptionUtils {
    @SuppressWarnings("MultipleStringLiterals")
    private static final Map<Integer, String> PORT_MAP = Map.ofEntries(
        Map.entry(23, "Telnet"),
        Map.entry(110, "POP3"),
        Map.entry(143, "IMAP"),
        Map.entry(67, "DHCP"),
        Map.entry(123, "NTP"),
        Map.entry(161, "SNMP"),
        Map.entry(445, "SMB"),
        Map.entry(548, "AFP"),
        Map.entry(137, "NetBIOS"),
        Map.entry(8080, "HTTP Proxy"),
        Map.entry(1080, "SOCKS"),
        Map.entry(3306, "MySQL"),
        Map.entry(1433, "MSSQL"),
        Map.entry(1521, "Oracle"),
        Map.entry(389, "LDAP"),
        Map.entry(636, "LDAP"),
        Map.entry(5722, "SMB2"),
        Map.entry(500, "IKE"),
        Map.entry(1701, "L2TP"),
        Map.entry(1723, "PPTP"),
        Map.entry(5060, "SIP"),
        Map.entry(5061, "SIP"),
        Map.entry(16384, "RTP"),
        Map.entry(32767, "RTP"),
        Map.entry(3128, "HTTPS Proxy, Squid"),
        Map.entry(5900, "VNC"),
        Map.entry(6667, "IRC"),
        Map.entry(6697, "IRC"),
        Map.entry(5353, "Bonjour, Zeroconf"),
        Map.entry(2049, "NFS"),
        Map.entry(6379, "Redis"),
        Map.entry(11211, "Memcached"),
        Map.entry(873, "Rsync"),
        Map.entry(5222, "XMPP"),
        Map.entry(5223, "XMPP"),
        Map.entry(443, "VMware vSphere Client")
    );

    private PortDescriptionUtils() {
    }

    public static String getPortDescription(int value) {
        String result = PORT_MAP.get(value);
        return Objects.requireNonNullElse(result, "");
    }
}
