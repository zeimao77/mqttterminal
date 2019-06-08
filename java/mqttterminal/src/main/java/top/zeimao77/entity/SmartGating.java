package top.zeimao77.entity;

import top.zeimao77.consts.AligenieDeviceType;
import top.zeimao77.terminal.service.AbstractTerminal;

public class SmartGating extends AbstractTerminal {

    public SmartGating(String terminalId) {
        super(terminalId, AligenieDeviceType.SMARTGATING);
    }

    @Override
    public void init() {

    }
}
