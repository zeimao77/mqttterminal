package top.zeimao77.terminal.nativec;

public class OledSpi {

    static {
        System.loadLibrary("raspberry-zn");
    }

    public static native void oledInit();

    public static native void oledClear();

    public static native void oledDisplayOn();

    public static native void oledDisplayOff();

    public static native void oledDrawImg(char[] byteArr);

    public static native void oledDrawChinese(char x0,char page,char[] byteArr);

    public static native void oledDrawAscii(char x0,char page,char ind);


}
