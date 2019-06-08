package top.zeimao77.consts;

@SuppressWarnings("unused")
public enum AligenieDeviceType {

    TELEVISION("television","电视"),
    LIGHT("light","灯"),
    AIRCONDITION("aircondition","空调"),
    AIRPURIFIER("airpurifier","空气净化器"),
    OUTLET("outlet","插座"),
    SWITCH("switch","开关"),
    ROBOTICVACUUM("roboticvacuum","扫地机器人"),
    CURTAIN("curtain","窗帘"),
    HUMIDIFIER("humidifier","加湿器"),
    FAN("fan","风扇"),
    BOTTLEWARMER("bottlewarmer","暖奶器"),
    SOYMILKMAKER("soymilkmaker","豆浆机"),
    KETTLE("kettle","电热水壶"),
    WATERCOOLER("watercooler","饮水机"),
    COOKER("cooker","电饭煲"),
    WATERHEATER("waterheater","热水器"),
    OVEN("oven","烤箱"),
    WATERPURIFIER("waterpurifier","净水器"),
    FRIDGE("fridge","冰箱"),
    STB("STB","机顶盒"),
    SENSOR("sensor","传感器"),
    WASHMACHINE("washmachine","洗衣机"),
    SMARTBED("smartbed","智能床"),
    AROMAMACHINE("aromamachine","香薰机"),
    WINDOW("window","窗"),
    KITCHENVENTILATOR("kitchenventilator","抽油烟机"),
    FINGERPRINTLOCK("fingerprintlock","指纹锁"),
    TELECONTROLLER("telecontroller","万能遥控器"),
    DISHWASHER("dishwasher","洗碗机"),
    DEHUMIDIFIER("dehumidifier","除湿机"),
    DRYER("dryer","干衣机"),
    WALLHUNGBOILER("wall-hung-boiler","壁挂炉"),
    MICROWAVEOVEN("microwaveoven","微波炉"),
    HEATER("heater","取暖器"),
    MOSQUITODISPELLER("mosquitoDispeller","驱蚊器"),
 	TREADMILL("treadmill","跑步机"),
 	SMARTGATING("smart-gating","智能门控(门锁)"),
 	SMARTBAND("smart-band","智能手环"),
 	HANGER("hanger","晾衣架"),
    ;

    String deviceType;
    String name;

    AligenieDeviceType(String deviceType,String name){
        this.deviceType = deviceType;
        this.name = name;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public String getName(){
        return name;
    }
}
