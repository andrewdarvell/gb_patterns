package ru.darvell.gb.patterns.reading.processor;

import ru.darvell.gb.patterns.device.DeviceData;
import ru.darvell.gb.patterns.reading.processing.BaseChainHandler;

import java.util.List;

public class DataBaseWriter extends BaseChainHandler {

    @Override
    public void handle(List<DeviceData> deviceData) {
        System.out.println("write data to Data base");
        super.handle(deviceData);
    }
}
