package top.zeimao77.consts;

public enum Gpio {

    GPIO_0(0,"gpio0"),
    GPIO_1(1,"gpio1"),
    GPIO_2(2,"gpio2"),
    GPIO_3(3,"gpio3"),
    GPIO_4(4,"gpio4"),
    GPIO_5(5,"gpio5"),
    GPIO_6(6,"gpio6"),
    GPIO_7(7,"gpio7"),
    GPIO_8(8,"gpio8"),
    GPIO_9(9,"gpio9"),
    GPIO_10(10,"gpio10"),
    GPIO_11(11,"gpio11"),
    GPIO_12(12,"gpio12"),
    GPIO_13(13,"gpio13"),
    GPIO_14(14,"gpio14"),
    GPIO_15(15,"gpio15"),
    GPIO_16(16,"gpio16"),
    GPIO_17(17,"gpio17"),
    GPIO_18(18,"gpio18"),
    GPIO_19(19,"gpio19"),
    GPIO_20(20,"gpio20"),
    GPIO_21(21,"gpio21"),
    GPIO_22(22,"gpio22"),
    GPIO_23(23,"gpio23"),
    GPIO_24(24,"gpio24"),
    GPIO_25(25,"gpio25"),
    ;

    Integer index;
    String name;

    private Gpio(Integer index,String name) {
        this.index = index;
        this.name = name;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
