package ru.darvell.gb.patterns.device.models;

import ru.darvell.gb.patterns.device.DeviceData;
import ru.darvell.gb.patterns.device.Model;

public class Spt1 implements Model {

    @Override
    public DeviceData readArchData(long beginTime, long endTime) {
        return new DeviceData();
    }

    @Override
    public void sendCommand(String command) {
        calculate(command);
    }

    private String calculate(String command) {
        return command.isBlank() ? "" : command + "123";
    }
}
