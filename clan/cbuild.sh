sudo gcc -I "/usr/lib/jvm/jdk-8-oracle-arm32-vfp-hflt/include" -I "/usr/lib/jvm/jdk-8-oracle-arm32-vfp-hflt/include/linux" -I "/opt/code/zeimao77-zn/clan/include" -lwiringPi -o libraspberry-zn.so -shared lib/top_zeimao77_terminal_nativec_Gpion.c java/java_jstring.c java/java_jbyteArray.c hardware/top_zeimao77_terminal_nativec_OledSpi.c hardware/top_zeimao77_terminal_nativec_Lm75aI2c.c lib/bmp.c
