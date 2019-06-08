package top.zeimao77.consts;

@SuppressWarnings("unused")
public enum AligenieMode {

    AUTO("auto","自动模式"),
    COLD("cold","制冷模式"),
    HEAT("heat","制热模式"),
    VENTILATE("ventilate","通风模式"),
    AIRSUPPLY("airsupply","送风模式"),
    DEHUMIDIFICATION("dehumidification","除湿模式"),
    READING("reading","阅读模式"),
    MOVIE("movie","影院模式"),
    SLEEP("sleep","睡眠模式"),
    LIVE("live","生活模式"),
    MANUAL("manual","手动模式"),
    SILENT("silent","静音模式"),
    ENERGY("energy","省电模式"),
    NORMALWIND("normalWind","正常风模式"),
    NATUREWIND("natureWind","自然风模式"),
    SLEEPWIND("sleepWind","睡眠风模式"),
    QUIETWIND("quietWind","静音风模式"),
    COMFORTABLEWIND("comfortableWind","舒适风模式"),
    BABYWIND("babyWind","宝宝风模式"),
    COTTONS("cottons","棉织物模式"),
    SYNTHETICS("synthetics","化纤模式"),
    WOOL("wool","羊毛模式"),
    HYGIENE("hygiene","除菌模式"),
    DRUMCLEAN("drumClean","筒清洁模式"),
    SILK("silk","丝绸模式"),
    HOLIDAY("holiday","假日模式"),
    MUSIC("music","音乐模式"),
    SMART("smart","智能模式"),
    ZEROGRAVITY("zeroGravity","零重力模式"),
    SNORESTOP("snoreStop","止鼾模式"),
    DIFFUSE("diffuse","多人模式"),
    SWING("swing","摇摆模式"),
    POWER("power","强效模式"),
    COMMON("common","普通模式"),
    ;

    String mode;
    String name;

    AligenieMode(String mode,String name){
        this.mode = mode;
        this.name = name;
    }

    public String getMode() {
        return mode;
    }
}
