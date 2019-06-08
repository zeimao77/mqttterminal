package top.zeimao77.terminal.service;

import top.zeimao77.aligenie.entity.AligeniePayload;
import top.zeimao77.consts.AligenieDeviceType;
import top.zeimao77.consts.ServiceErrorEnum;
import top.zeimao77.util.ServiceAssert;

public abstract class AbstractTerminal implements Terminal{

    String terminalId;
    AligenieDeviceType deviceType;
    
    void check(AligeniePayload payload) {
    	ServiceAssert.isTrue(deviceType.getDeviceType().equals(payload.getDeviceType()),ServiceErrorEnum.DEVICE_TYPE_ERROR);
    }

    public AbstractTerminal(String terminalId,AligenieDeviceType deviceType) {
        this.terminalId = terminalId;
        this.deviceType = deviceType;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public AligenieDeviceType getDeviceType() {
        return deviceType;
    }

    public abstract void init();

}
