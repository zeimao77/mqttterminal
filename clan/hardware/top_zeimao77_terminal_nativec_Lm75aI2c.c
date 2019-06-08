#include "top_zeimao77_terminal_nativec_Lm75aI2c.h" 

JNIEXPORT jint JNICALL Java_top_zeimao77_terminal_nativec_Lm75aI2c_lm75aInit
  (JNIEnv *env, jclass clazz) {
  #ifndef WINDOWS
  lm75a_fd  = wiringPiI2CSetup(LM75ADDR);
  return lm75a_fd;
  #endif
  #ifdef WINDOWS
  return -1;
  #endif
  }

JNIEXPORT jint JNICALL Java_top_zeimao77_terminal_nativec_Lm75aI2c_lm75aGetTemp
  (JNIEnv *env, jclass clazz) {
  #ifndef WINDOWS
  unsigned char flag = 0;
  int tempval = 0;
  int val = 0;
  val =  wiringPiI2CReadReg16(lm75a_fd,0); 
  unsigned char c2 = (char) val;
  unsigned char c1 = (char) (val >> 8);
  printf("c2 = %x;",c2);
  printf("c1 = %x\r\n",c1);
  if(c2 & 0x0080) {
    flag = 1;
    c2 = ~c2;
    c1 += 0x20;
  }
  if(c2 & 0x40) {
    tempval += 64;
  } 
  if(c2 & 0x20) {
    tempval += 32;
  }
  if(c2 & 0x10) {
    tempval += 16;
  }
  if(c2 & 0x08) {
    tempval += 8;
  }
  if(c2 & 0x04) {
    tempval += 4;
  }
  if(c2 & 0x02) {
    tempval += 2;
  }
  if(c2 & 0x01) {
    tempval += 1;
  }
  if(c1 & 0x80) {
    tempval += 0.5;
  }
  if(c1 & 0x40) {
    tempval += 0.25;
  }
  if(c1 & 0x20) {
    tempval += 0.125;
  }
  if(flag = 1) {
    tempval = 0 - tempval;
  }
  return tempval;
  #endif
  #ifdef WINDOWS
  return 0;
  #endif
}

