package top.zeimao77.consts;

@SuppressWarnings("unused")
public enum Color {
    //天猫精灵所支持的控制和查询颜色不一样，
    // 下面以Q_开头表示支持的查询色，
    // 下面以C_开关表示支持的通用都可以支持;

    C_RED("Red","红色"),
    C_YELLOW("Yellow","黄色"),
    C_BLUE("Blue","蓝色"),
    C_GREEN("Green","绿色"),
    C_WHITE("White","白色"),
    C_BLACK("Black","黑色"),
    C_CYAN("Cyan","青色"),
    C_PURPLE("Purple","紫色"),
    C_ORANGE("Orange","橙色"),

    Q_Pink("Pink","粉红"),
    Q_Violet("Violet","紫罗兰"),
    Q_Magenta("Magenta","洋红"),
    Q_Indigo("Indigo","靛青"),
    Q_SlateBlue("SlateBlue","蓝灰色"),
    Q_DarkBlue("DarkBlue","深蓝色"),
    Q_SkyBlue("SkyBlue","天蓝色"),
    Q_DarkCyan("DarkCyan","深青色"),
    Q_Beige("Beige","浅褐色"),
    Q_Brown("Brown","棕色"),
    ;

    String color;
    String name;

    Color(String color,String name){
        this.color = color;
        this.name = name;
    }

    public String getColor() {
        return color;
    }
}
