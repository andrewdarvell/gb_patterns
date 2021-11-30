package ru.darvell.gb.patterns.reading.processor;

import ru.darvell.gb.patterns.device.DeviceData;
import ru.darvell.gb.patterns.reading.processing.BaseChainHandler;

import java.util.List;

public class LogWriter extends BaseChainHandler {

    private final String logTag;

    public LogWriter(String logTag) {
        this.logTag = logTag;
    }

    @Override
    public void handle(List<DeviceData> deviceData) {
        System.out.printf("%s: write data to log\n", logTag);
        super.handle(deviceData);
    }
}
