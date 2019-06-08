package top.zeimao77.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.zeimao77.aligenie.entity.AligeniePayload;
import top.zeimao77.consts.*;
import top.zeimao77.terminal.nativec.Gpion;
import top.zeimao77.terminal.service.AbstractTerminal;

public class Light extends AbstractTerminal {

    private static Logger logger = LoggerFactory.getLogger(Light.class);

    //GPIO控制口
    private Gpio gpio;

    //开关状态
    private Turn turn;

    //颜色
    private Color color;

    //亮度
    private Integer birghtNessValue;

    public Light(String terminalId) {
        super(terminalId, AligenieDeviceType.LIGHT);
    }

    @Override
    public void init() {
        Gpion.gpioInit(gpio, GpioMode.OUTPUT);
    }

    public void turnOn(AligeniePayload payload) {
        this.turn = Turn.ON;
        Gpion.gpioWrite(gpio,Level.HIGHT);
    }

    public void turnOff(AligeniePayload payload) {
        this.turn = Turn.OFF;
        Gpion.gpioWrite(gpio,Level.LOW);
    }

    public void setBrightness(AligeniePayload payload) {

    }

    public void adjustUpBrightness(AligeniePayload payload) {

    }

    public void adjustDownBrightness(AligeniePayload payload) {

    }

    public void setColor(AligeniePayload payload) {

    }

    public Gpio getGpio() {
        return gpio;
    }

    public void setGpio(Gpio gpio) {
        this.gpio = gpio;
    }
}
