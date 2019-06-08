package top.zeimao77.terminal.service;

import top.zeimao77.aligenie.entity.AligeniePayload;
import top.zeimao77.consts.AligenieDeviceType;

//灯
public abstract class LightService extends AbstractTerminal {

    AligenieDeviceType deviceType = AligenieDeviceType.LIGHT;

    public LightService(String terminalId, AligenieDeviceType deviceType) {
        super(terminalId,deviceType);
    }

    public abstract void turn(AligeniePayload payload);


}
