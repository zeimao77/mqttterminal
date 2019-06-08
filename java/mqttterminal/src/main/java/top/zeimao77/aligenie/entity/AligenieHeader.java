package top.zeimao77.aligenie.entity;

@SuppressWarnings("unused")
public class AligenieHeader {

    private String namespace;
    private String name;
    private String messageId;
    private Integer payLoadVersion;

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public void setPayLoadVersion(Integer payLoadVersion) {
        this.payLoadVersion = payLoadVersion;
    }

    public String getNamespace() {
        return namespace;
    }

    public String getName() {
        return name;
    }

    public String getMessageId() {
        return messageId;
    }

    public Integer getPayLoadVersion() {
        return payLoadVersion;
    }
}
