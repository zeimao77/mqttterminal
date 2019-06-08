package top.zeimao77.aligenie.entity;

import com.alibaba.fastjson.JSONArray;

import java.util.Map;

@SuppressWarnings("unused")
public class AligenieResult {

    private AligenieHeader header;

    private Map<String, Object> payload;

    private JSONArray properties;

    public void setHeader(AligenieHeader header) {
        this.header = header;
    }

    public AligenieHeader getHeader() {
        return header;
    }

    public void setPayload(Map<String, Object> payload) {
        this.payload = payload;
    }

    public Map<String, Object> getPayload() {
        return payload;
    }

    public JSONArray getProperties() {
        return properties;
    }

    public void setProperties(JSONArray properties) {
        this.properties = properties;
    }
}
