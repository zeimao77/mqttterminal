package top.zeimao77.terminal.service;

import top.zeimao77.aligenie.entity.AligeniePayload;
import top.zeimao77.consts.AligenieDeviceType;
import top.zeimao77.consts.ServiceErrorEnum;
import top.zeimao77.exception.ServiceRuntimeException;
import top.zeimao77.util.ServiceAssert;

import java.lang.reflect.Method;

public interface Terminal {

    public String getTerminalId();

    public AligenieDeviceType getDeviceType();

    public default Method getControl(String control) {
        Method method = null;
        try {
            method = getClass().getMethod(control, AligeniePayload.class);
        } catch (NoSuchMethodException | SecurityException e) {
            throw new ServiceRuntimeException(ServiceErrorEnum.DEVICE_NOT_SUPPORT_FUNCTION);
        }
        ServiceAssert.notNull(method,ServiceErrorEnum.DEVICE_NOT_SUPPORT_FUNCTION);
        return method;
    }
}
