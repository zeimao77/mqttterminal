package top.zeimao77.aligenie.entity;

import java.util.Map;

@SuppressWarnings("unused")
public class AligeniePayload {

    private String accessToken;
    private String deviceId;
    private String deviceType;
    private String attribute;
    private String value;
    private Map<String,String> extensions;

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setExtensions(Map<String, String> extensions) {
        this.extensions = extensions;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public String getAttribute() {
        return attribute;
    }

    public String getValue() {
        return value;
    }

    public Map<String, String> getExtensions() {
        return extensions;
    }
}
