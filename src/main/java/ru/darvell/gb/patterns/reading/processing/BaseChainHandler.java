package ru.darvell.gb.patterns.reading.processing;

import ru.darvell.gb.patterns.device.DeviceData;

import java.util.List;

public class BaseChainHandler implements ChainHandler {

    private ChainHandler next;

    @Override
    public void setNext(ChainHandler handler) {
        this.next = handler;
    }

    @Override
    public void handle(List<DeviceData> deviceData) {
        if (next != null) {
            next.handle(deviceData);
        }
    }
}
