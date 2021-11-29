package ru.darvell.gb.patterns.device.models;

import ru.darvell.gb.patterns.device.DeviceData;
import ru.darvell.gb.patterns.device.Model;

public class Spt2 implements Model {

    @Override
    public DeviceData readArchData(long beginTime, long endTime) {
        return new DeviceData();
    }

    @Override
    public void sendCommand(String command) {
        sendBroadcast(command);
    }

    public void sendBroadcast(String command){

    }

}
