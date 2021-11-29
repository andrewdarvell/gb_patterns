package ru.darvell.gb.patterns;

import ru.darvell.gb.patterns.device.DefaultDevice;
import ru.darvell.gb.patterns.device.DeviceLogger;
import ru.darvell.gb.patterns.device.models.Spt1;
import ru.darvell.gb.patterns.device.models.Spt2;
import ru.darvell.gb.patterns.device.types.HeatMeter;
import ru.darvell.gb.patterns.device.types.RepeatHeatMeter;

public class Main {

    public static void main(String[] args) {
        DefaultDevice heatMeter = new HeatMeter(new Spt1());
        DefaultDevice heatMeter2 = new HeatMeter(new Spt2());

        DefaultDevice repeatHeatMeter = new RepeatHeatMeter(new Spt1());
        DefaultDevice repeatHeatMeter2 = new RepeatHeatMeter(new Spt2());

        DeviceLogger deviceLogger = new DeviceLogger(repeatHeatMeter);
    }
}
