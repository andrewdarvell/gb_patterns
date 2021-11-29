package ru.darvell.gb.patterns.device;

public class DefaultDevice implements Device{

    protected Model model;

    public DefaultDevice(Model model) {
        this.model = model;
    }

    @Override
    public DeviceData readAchData(long startTime, long endTime) {
        return model.readArchData(startTime, endTime);
    }

    @Override
    public void sendCommand(String command) {
        model.sendCommand(command);
    }

}
