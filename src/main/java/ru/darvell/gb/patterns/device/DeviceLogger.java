package ru.darvell.gb.patterns.device;

import ru.darvell.gb.patterns.utils.Logger;

public class DeviceLogger implements Device {

    private DefaultDevice device;

    public DeviceLogger(DefaultDevice device) {
        this.device = device;
    }

    @Override
    public DeviceData readAchData(long startTime, long endTime) {
        Logger.getInstance().writeDebug("reading data from device");
        DeviceData deviceData = device.readAchData(startTime, endTime);
        Logger.getInstance().writeDebug(String.format("read: %s", deviceData));
        return deviceData;
    }

    @Override
    public void sendCommand(String command) {
        Logger.getInstance().writeDebug("send command to device");
        device.sendCommand(command);
        Logger.getInstance().writeDebug("command sended");
    }
}
