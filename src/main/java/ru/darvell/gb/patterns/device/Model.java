package ru.darvell.gb.patterns.device;

public interface Model {

    DeviceData readArchData(long beginTime, long endTime);
    void sendCommand(String command);
}
