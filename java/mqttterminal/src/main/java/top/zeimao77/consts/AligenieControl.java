package top.zeimao77.consts;

import top.zeimao77.exception.ServiceRuntimeException;

@SuppressWarnings("unused")
public enum AligenieControl {

    TURNON("TurnOn","打开"),
    TURNOFF("TurnOff","关闭"),
    SELECTCHANNEL("SelectChannel","频道切换"),
    ADJUSTUPCHANNEL("AdjustUpChannel","频道增加"),
    ADJUSTDOWNCHANNEL("AdjustDownChannel","频道减少"),
    ADJUSTUPVOLUME("AdjustUpVolume","声音按照步长调大"),
    ADJUSTDOWNVOLUME("AdjustDownVolume","声音按照步长调小"),
    SETVOLUME("SetVolume","声音调到某个值"),
    SETMUTE("SetMute","设置静音"),
    CANCELMUTE("CancelMute","取消静音"),
    PLAY("Play","播放"),
    PAUSE("Pause","暂停"),
    CONTINUE("Continue","继续"),
    NEXT("Next","下一首或下一台"),
    PREVIOUS("Previous","上一首或下一台"),
    SETBRIGHTNESS("SetBrightness","设置亮度"),
    ADJUSTUPBRIGHTNESS("AdjustUpBrightness","调大亮度"),
    ADJUSTDOWNBRIGHTNESS("AdjustDownBrightness","调小亮度"),
    SETTEMPERATURE("SetTemperature","设置温度"),
    ADJUSTUPTEMPERATURE("AdjustUpTemperature","调高温度"),
    ADJUSTDOWNTEMPERATURE("AdjustDownTemperature","调低温度"),
    SETWINDSPEED("SetWindSpeed","设置风速"),
    ADJUSTUPWINDSPEED("AdjustUpWindSpeed","调大风速"),
    ADJUSTDOWNWINDSPEED("AdjustDownWindSpeed","调小风速"),
    SETMODE("SetMode","模式的切换"),
    SETCOLOR("SetColor","设置颜色"),
    OPENFUNCTION("OpenFunction","打开功能"),
    CLOSEFUNCTION("CloseFunction","关闭功能"),
    CANCEL("Cancel","取消"),
    CANCELMODE("CancelMode","取消模式(退出模式)"),
    ERRORRESPONSE("ErrorResponse","错误响应"),
    ;

    String control;
    String name;

    AligenieControl(String control,String name){
        this.control = control;
        this.name = name;
    }

    public String getControl() {
        return control;
    }

    public String getName(){
        return name;
    }

    private String methodName() {
        return control.substring(0,1).toLowerCase().concat(control.substring(1));
    }

    public static String getMethodName(String name) {
        for(AligenieControl control : values()) {
            if(name.equalsIgnoreCase(control.getControl())) {
               return control.methodName();
            }
        }
        throw new ServiceRuntimeException(ServiceErrorEnum.INVALIDATE_CONTROL_ORDER);
    }

}

