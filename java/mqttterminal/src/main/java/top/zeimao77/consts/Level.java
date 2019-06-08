package top.zeimao77.consts;

public enum Level {

    HIGHT(1),
    LOW(0);

    Integer value;

    private Level(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
