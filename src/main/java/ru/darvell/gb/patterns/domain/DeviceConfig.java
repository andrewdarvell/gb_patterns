package ru.darvell.gb.patterns.domain;

import java.util.Objects;

public class DeviceConfig {

    private Long id;
    private String ipAddr;
    private Long port;
    private String label;

    public DeviceConfig(Long id, String ipAddr, Long port, String label) {
        this.id = id;
        this.ipAddr = ipAddr;
        this.port = port;
        this.label = label;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeviceConfig that = (DeviceConfig) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
