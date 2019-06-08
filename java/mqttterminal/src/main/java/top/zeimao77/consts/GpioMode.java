package top.zeimao77.consts;

public enum GpioMode {

	INPUT(0,"input"),
	OUTPUT(1,"output"),
    PWM_OUTPUT(2,"pwm_output"),
    GPIO_CLOCK(3,"gpio_clock"),
    ;

    private Integer index;
    private String name;

    private GpioMode(Integer index,String name) {
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
