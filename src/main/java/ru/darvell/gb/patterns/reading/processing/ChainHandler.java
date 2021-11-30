package ru.darvell.gb.patterns.reading.processing;

import ru.darvell.gb.patterns.device.DeviceData;

import java.util.List;

public interface ChainHandler {
    void setNext(ChainHandler handler);
    void handle(List<DeviceData> deviceData);
}
