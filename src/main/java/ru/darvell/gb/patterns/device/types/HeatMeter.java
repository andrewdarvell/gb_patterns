package ru.darvell.gb.patterns.device.types;

import ru.darvell.gb.patterns.device.DataReadException;
import ru.darvell.gb.patterns.device.DefaultDevice;
import ru.darvell.gb.patterns.device.DeviceData;
import ru.darvell.gb.patterns.device.Model;

public class HeatMeter extends DefaultDevice {

    public HeatMeter(Model model) {
        super(model);
    }

    @Override
    public DeviceData readAchData(long startTime, long endTime) {
        DeviceData deviceData = model.readArchData(startTime, endTime);
        if (deviceData == null) {
            throw new DataReadException("Cannot read data from device");
        }
        return deviceData;
    }
}
