package top.zeimao77.aligenie.entity;

import com.alibaba.fastjson.JSON;

@SuppressWarnings("unused")
public class AligenieHP {

    private AligenieHeader header;

    private AligeniePayload payload;

    public void setHeader(AligenieHeader header) {
        this.header = header;
    }

    public void setPayload(AligeniePayload payload) {
        this.payload = payload;
    }

    public AligenieHeader getHeader() {
        return header;
    }

    public AligeniePayload getPayload() {
        return payload;
    }
    
    public static AligenieHP parse(String str) {
    	return JSON.parseObject(str, AligenieHP.class);
    }
}