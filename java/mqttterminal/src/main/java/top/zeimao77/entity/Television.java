package top.zeimao77.entity;

import top.zeimao77.aligenie.entity.AligeniePayload;
import top.zeimao77.consts.AligenieDeviceType;
import top.zeimao77.terminal.service.AbstractTerminal;

public class Television extends AbstractTerminal {

    public Television(String terminalId) {
        super(terminalId, AligenieDeviceType.TELEVISION);
    }

    @Override
    public void init() {

    }

    public void turnOn(AligeniePayload payload) {

    }

    public void turnOff(AligeniePayload payload) {

    }

    public void adjustUpChannel(AligeniePayload payload) {

    }

    public void adjustDownChannel(AligeniePayload payload) {

    }

    public void setMute(AligeniePayload payload) {

    }

    public void cancelMute(AligeniePayload payload) {

    }

    public void pause(AligeniePayload payload) {

    }

    public void _continue(AligeniePayload payload) {

    }


}
