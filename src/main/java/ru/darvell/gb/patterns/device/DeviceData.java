package ru.darvell.gb.patterns.device;

import java.util.Map;

public class DeviceData {

    protected Map<String, Double> doubleParams;
    protected Map<String, String> stringParams;

    @Override
    public String toString() {
        return "some fake data";
    }
}
