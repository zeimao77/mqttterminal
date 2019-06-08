package top.zeimao77.entity;

import top.zeimao77.aligenie.entity.AligeniePayload;
import top.zeimao77.consts.AligenieDeviceType;
import top.zeimao77.consts.Gpio;
import top.zeimao77.consts.GpioMode;
import top.zeimao77.consts.Level;
import top.zeimao77.terminal.nativec.Gpion;
import top.zeimao77.terminal.service.AbstractTerminal;

public class Switch extends AbstractTerminal {

    //GPIO控制口
    private Gpio gpio;

    public Switch(String terminalId) {
        super(terminalId, AligenieDeviceType.SWITCH);
    }

    @Override
    public void init() {
        Gpion.gpioInit(gpio, GpioMode.OUTPUT);
    }

    public void turnOn(AligeniePayload payload) {
        Gpion.gpioWrite(gpio, Level.HIGHT);
    }

    public void turnOff(AligeniePayload payload) {
        Gpion.gpioWrite(gpio,Level.LOW);
    }

    public Gpio getGpio() {
        return gpio;
    }

    public void setGpio(Gpio gpio) {
        this.gpio = gpio;
    }
}
