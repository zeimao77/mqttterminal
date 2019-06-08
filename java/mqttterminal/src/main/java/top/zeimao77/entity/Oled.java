package top.zeimao77.entity;

import top.zeimao77.consts.AligenieDeviceType;
import top.zeimao77.terminal.nativec.OledSpi;
import top.zeimao77.terminal.service.Terminal;

public class Oled extends OledSpi implements Terminal {

    String terminalId;

    public Oled(String terminalId) {
        this.terminalId = terminalId;
    }

    public void turnOn() {
        OledSpi.oledDisplayOn();
    }

    public void turnOff() {
        OledSpi.oledDisplayOff();
    }

    public void pause() {
        OledSpi.oledClear();
    }

    public static void drawStr(int page,String str) {
        for(int i=0;i<str.length();i++) {
            Oled.oledDrawAscii((char)(i*8),(char)page,str.charAt(i));
        }
    }

    @Override
    public String getTerminalId() {
        return this.terminalId;
    }

    @Override
    public AligenieDeviceType getDeviceType() {
        return AligenieDeviceType.TELEVISION;
    }

}
