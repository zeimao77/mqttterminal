#include "top_zeimao77_terminal_nativec_Gpion.h"

JNIEXPORT jint JNICALL Java_top_zeimao77_terminal_nativec_Gpion_gpioInit
  (JNIEnv * env, jclass clazz, jint index, jint mode) {
    int c_index = (int) index;
    int c_mode = (int) mode;
    printf("Gpion_gpioInit ()=> c_index=%d  c_mode=%d\r\n",c_index,c_mode);
    #ifndef WINDOWS
      wiringPiSetup();
      pinMode(c_index,OUTPUT);
      for (int i=0;i<5;i++) {
        digitalWrite(c_index,1);
        delay(500);
        digitalWrite(c_index,0);
        delay(500);
      }
       if(c_mode == 0 ){
        pinMode(c_index,INPUT);
      } else if(c_mode == 1) {
        pinMode(c_index,OUTPUT);
      } else if(c_mode == 2) {
        pinMode(c_index,PWM_OUTPUT);
      } else if(c_mode == 3) {
        pinMode(c_index,GPIO_CLOCK);
      }
    #endif
    return SUCCESS;
  }

JNIEXPORT jint JNICALL Java_top_zeimao77_terminal_nativec_Gpion_gpioWrite
  (JNIEnv * env, jclass clazz, jint index, jint value) {
    int c_index = (int) index;
    int c_value = (int) value;
    printf("Gpion_gpioWrite ()=> c_index=%d  c_value=%d\r\n",c_index,c_value);
    #ifndef WINDOWS
      digitalWrite(c_index,c_value);
    #endif
    return SUCCESS;
  }

JNIEXPORT jint JNICALL Java_top_zeimao77_terminal_nativec_Gpion_gpioRead
  (JNIEnv * env, jclass clazz, jint index) {
    int level = -1;
    int c_index = (int) index;
    printf("Gpion_gpioRead  ()=> c_index=%s\r\n",c_index);
    #ifndef WINDOWS
      level = digitalRead(c_index);
    #endif
    return level;
  }
