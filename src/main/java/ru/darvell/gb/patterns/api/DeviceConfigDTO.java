package ru.darvell.gb.patterns.api;

public class DeviceConfigDTO {

    private String ipAddr;
    private Long port;
    private String label;

    public DeviceConfigDTO(String ipAddr, Long port, String label) {
        this.ipAddr = ipAddr;
        this.port = port;
        this.label = label;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public Long getPort() {
        return port;
    }

    public void setPort(Long port) {
        this.port = port;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
