package ru.darvell.gb.patterns.device;

public interface Device {

    DeviceData readAchData(long startTime, long endTime);

    void sendCommand(String command);
}
