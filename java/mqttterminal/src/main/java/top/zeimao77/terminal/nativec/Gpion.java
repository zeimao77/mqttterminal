package top.zeimao77.terminal.nativec;

import top.zeimao77.consts.Gpio;
import top.zeimao77.consts.GpioMode;
import top.zeimao77.consts.Level;
import top.zeimao77.util.ServiceAssert;

public class Gpion {

    static {
        System.loadLibrary("raspberry-zn");
    }

    private static native int gpioInit(int index, int mode);

    public static int gpioInit(Gpio gpio,GpioMode mode) {
        ServiceAssert.notNull(gpio);
        return Gpion.gpioInit(gpio.getIndex(),mode.getIndex());
    }

    private static native int gpioWrite(int index,int value);

    public static int gpioWrite(Gpio gpio, Level level) {
        ServiceAssert.notNull(gpio);
        return Gpion.gpioWrite(gpio.getIndex(),level.getValue());
    }

    private static native int gpioRead(int index);

    public static int gpioRead(Gpio gpio) {
        ServiceAssert.notNull(gpio);
        return Gpion.gpioRead(gpio.getIndex());
    }

}
