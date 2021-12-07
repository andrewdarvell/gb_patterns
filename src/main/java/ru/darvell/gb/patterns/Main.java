package ru.darvell.gb.patterns;

import ru.darvell.gb.patterns.device.DefaultDevice;
import ru.darvell.gb.patterns.device.DeviceLogger;
import ru.darvell.gb.patterns.device.models.Spt1;
import ru.darvell.gb.patterns.device.models.Spt2;
import ru.darvell.gb.patterns.device.types.HeatMeter;
import ru.darvell.gb.patterns.device.types.RepeatHeatMeter;
import ru.darvell.gb.patterns.reading.DeviceManager;
import ru.darvell.gb.patterns.reading.processor.DataBaseWriter;
import ru.darvell.gb.patterns.reading.processor.LogWriter;
import ru.darvell.gb.patterns.reading.processor.MasterServerDataSender;

public class Main {

    public static void main(String[] args) {
        DefaultDevice heatMeter = new HeatMeter(new Spt1());
        DefaultDevice heatMeter2 = new HeatMeter(new Spt2());

        DefaultDevice repeatHeatMeter = new RepeatHeatMeter(new Spt1());
        DefaultDevice repeatHeatMeter2 = new RepeatHeatMeter(new Spt2());
        DeviceLogger deviceLogger = new DeviceLogger(repeatHeatMeter);



        DeviceManager deviceManager = new DeviceManager();
        deviceManager.addDevice(heatMeter);
        deviceManager.addDevice(heatMeter2);
        deviceManager.addDevice(repeatHeatMeter);
        deviceManager.addDevice(repeatHeatMeter2);
        deviceManager.addDevice(deviceLogger);

        MasterServerDataSender masterServerDataSender = new MasterServerDataSender(2);
        deviceManager.subscribe(masterServerDataSender);

        DataBaseWriter dataBaseWriter = new DataBaseWriter();
        LogWriter logWriterPrimary = new LogWriter("Primary");
        LogWriter logWriterSecondary = new LogWriter("Secondary");

        logWriterPrimary.setNext(logWriterSecondary);
        dataBaseWriter.setNext(logWriterPrimary);
        masterServerDataSender.setNext(dataBaseWriter);

        long start = System.currentTimeMillis();
        for (int i =1; i<10; i++) {
            deviceManager.readAllData(start, start + 100);
            start += 100;
        }
    }
}
