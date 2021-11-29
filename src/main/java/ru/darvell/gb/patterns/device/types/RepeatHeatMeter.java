package ru.darvell.gb.patterns.device.types;

import ru.darvell.gb.patterns.device.DataReadException;
import ru.darvell.gb.patterns.device.DefaultDevice;
import ru.darvell.gb.patterns.device.DeviceData;
import ru.darvell.gb.patterns.device.Model;

public class RepeatHeatMeter extends DefaultDevice {


    public RepeatHeatMeter(Model model) {
        super(model);
    }

    @Override
    public DeviceData readAchData(long startTime, long endTime) {

        DeviceData deviceData;
        int tryIng = 0;
        do {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
            deviceData = model.readArchData(startTime, endTime);
            tryIng++;
        } while (deviceData == null && tryIng < 5);
        if (deviceData == null) {
            throw new DataReadException("Cannot read data from device");
        }
        return deviceData;
    }
}
