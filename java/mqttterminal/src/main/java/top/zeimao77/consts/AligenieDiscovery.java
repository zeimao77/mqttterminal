package top.zeimao77.consts;

public enum AligenieDiscovery {

    DISCOVERYDEVICES("DiscoveryDevices"),//设备发现（获取设备列表）
    DISCOVERYDEVICESRESPONSE("DiscoveryDevicesResponse"),
    ;

    String discovery;

    AligenieDiscovery(String discovery){
        this.discovery = discovery;
    }

    public String getDiscovery() {
        return discovery;
    }
}
