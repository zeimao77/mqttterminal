package top.zeimao77.consts;

public enum AligenieNamespace {

    DISCOVERY("AliGenie.Iot.Device.Discovery","设备发现"),
    CONTROL("AliGenie.Iot.Device.Control","设备控制"),
    QUERY("AliGenie.Iot.Device.Query","设备属性查询"),
    ;

    String namespace;
    String name;

    AligenieNamespace(String namespace,String name){
        this.namespace = namespace;
        this.name = name;
    }

    public String getNamespace() {
        return namespace;
    }

    public String getName(){
        return name;
    }
}
