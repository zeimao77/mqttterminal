#include "top_zeimao77_terminal_nativec_OledSpi.h" 

JNIEXPORT void JNICALL Java_top_zeimao77_terminal_nativec_OledSpi_oledDrawImg(JNIEnv * env, jclass clazz, jbyteArray byteArr) {
  unsigned char* buff = jbyteArrayToCharPointer(env,clazz,byteArr);
  #ifdef WINDOWS
  int len = (int)jbyteArraySize(env,clazz,byteArr);
  printf("buff sizeof = %d\r\n",len);
  for(int i=0;i<len;i++){
    printf("buff[%d] = 0x%x\r\n",i,buff[i]);
  }
  #endif
  #ifndef WINDOWS
  unsigned char i,j;
  unsigned int ind = 0;
  for(i=0;i<8;i++){
    OLED_setFocus(0,i);
    for(j=0;j<128;j++){
      OLED_writeData(buff[ind++]);
    }
  }
  #endif
}

JNIEXPORT void JNICALL Java_top_zeimao77_terminal_nativec_OledSpi_oledDrawAscii
  (JNIEnv * env, jclass clazz, jchar x0, jchar page , jchar ind) {
  unsigned char c_x0 = x0;
  unsigned char c_page = page;
  unsigned char c_ind = ind;
  #ifdef WINDOWS
  printf("Oled_drawAscii(%d,%d,0x%x);\r\n",c_x0,c_page,c_ind);
  #endif
  #ifndef WINDOWS
  unsigned char i;
  OLED_setFocus(c_x0,c_page);
  for(i=0;i<8;i++){
    OLED_writeData(ASCIITAB[c_ind-0x20][i]);
  }
  OLED_setFocus(x0,page+1);
  for(;i<16;i++){
    OLED_writeData(ASCIITAB[c_ind-0x20][i]);
  }
  #endif
}

JNIEXPORT void JNICALL Java_top_zeimao77_terminal_nativec_OledSpi_oledDrawChinese
  (JNIEnv * env, jclass clazz, jchar x0, jchar page, jbyteArray byteArr) {
  unsigned char* dat = jbyteArrayToCharPointer(env,clazz,byteArr);
  #ifdef WINDOWS
  int len = (int)jbyteArraySize(env,clazz,byteArr);
  printf("buff sizeof = %d\r\n",len);
  for(int i=0;i<len;i++){
    printf("buff[%d] = 0x%x\r\n",i,dat[i]);
  }
  #endif
  #ifndef WINDOWS
  unsigned char i;
  OLED_setFocus(x0,page);
  for(i=0;i<16;i++){
    OLED_writeData(dat[i]);
  }
  OLED_setFocus(x0,page+1);
  for(;i<32;i++){
    OLED_writeData(dat[i]);
  }
  #endif
}

void OLED_setFocus(unsigned char x, unsigned char y){ 
  OLED_writeCmd(0xb0+y);
  OLED_writeCmd(((x&0xf0)>>4)|0x10);
  OLED_writeCmd((x&0x0f)|0x01);
}

void OLED_gpioInit(){
  #ifndef WINDOWS
  pinMode(OLED_DC,OUTPUT);
  pinMode(OLED_RES,OUTPUT);
  pinMode(OLED_CS,OUTPUT);
  #endif
}

void OLED_writeCmd(unsigned char cmd){
  #ifndef WINDOWS
  digitalWrite(OLED_DC,0);
  unsigned char *tempData = &cmd;
  wiringPiSPIDataRW(0,tempData,1);
  digitalWrite(OLED_DC,1);
  #endif
}

void OLED_writeData(unsigned char data){
  #ifndef WINDOWS
  digitalWrite(OLED_DC,1);
  unsigned char *tempData = &data;
  wiringPiSPIDataRW(0,tempData,1);
  digitalWrite(OLED_DC,1);
  #endif
}

JNIEXPORT void JNICALL Java_top_zeimao77_terminal_nativec_OledSpi_oledDisplayOn
  (JNIEnv * env , jclass clazz) {
  #ifdef WINDOWS
    printf("Display is on\r\n");
  #endif
  #ifndef WINDOWS
  OLED_writeCmd(0x8d);
  OLED_writeCmd(0x14);
  OLED_writeCmd(0xaf);
  #endif
}

JNIEXPORT void JNICALL Java_top_zeimao77_terminal_nativec_OledSpi_oledDisplayOff
  (JNIEnv * env, jclass clazz) {
  #ifdef WINDOWS
  printf("Display is off\r\n");
  #endif
  #ifndef WINDOWS
  OLED_writeCmd(0x8d);
  OLED_writeCmd(0x10);
  OLED_writeCmd(0xae);
  #endif
}
void OLED_clear() {
  #ifdef WINDOWS
  printf("Display has been cleared\r\n");
  #endif
  #ifndef WINDOWS
  unsigned char i,j;
  for(i=0;i<8;i++){
    OLED_writeCmd(0xb0+i);  //设置页地址(0-7)
    OLED_writeCmd(0x00);    //设置列低地址
    for(j=0;j<128;j++){
      OLED_writeData(0x00);
    }
  }
  #endif
}

JNIEXPORT void JNICALL Java_top_zeimao77_terminal_nativec_OledSpi_oledClear
  (JNIEnv * env , jclass clazz) {
  OLED_clear();
}

JNIEXPORT void JNICALL Java_top_zeimao77_terminal_nativec_OledSpi_oledInit
  (JNIEnv * env , jclass clazz) {
  #ifdef WINDOWS
  printf("Display is initializing\r\n");
  #endif
  #ifndef WINDOWS
  OLED_gpioInit();
  int isOK = wiringPiSPISetup(0, 1000000);
  if (isOK == -1) { 
    printf("SPI SETTING FAILED\r\n"); 
  } else { 
    printf("SPI SET SUCCESSFULLY\r\n"); 
  }
  digitalWrite(OLED_RES,1);
  delay(100);
  digitalWrite(OLED_RES,0);
  delay(100);
  digitalWrite(OLED_RES,1);
  OLED_writeCmd(0xAE);  //ae/af   [显示关/显示开]
  OLED_writeCmd(0x00);
  OLED_writeCmd(0x10);  //2个4位合成一个字节作为列指针，页模式下指定显示内存的列位置
  OLED_writeCmd(0x40);  //从RAM中哪一行起读取显示内容(0x00~0x3F)
  OLED_writeCmd(0x81);  //亮度控制
  OLED_writeCmd(0xCF); 
  OLED_writeCmd(0xA1);  //0xa0左右反置 0xa1正常
  OLED_writeCmd(0xC8);  //行扫描上下反转   0xc0上下反置 0xc8正常
  OLED_writeCmd(0xA6);  //a6/a7   [正常/反白显示]
  OLED_writeCmd(0xA8);  //行扫多路
  OLED_writeCmd(0x3F);  //设置扫描哪些行
  OLED_writeCmd(0xD3);  //行扫偏移(0x00~0x3F)
  OLED_writeCmd(0x00);  //-not offset
  OLED_writeCmd(0xD5);   //设置时钟分频
  OLED_writeCmd(0x80);  //--set divide ratio, Set Clock as 100 Frames/Sec
  OLED_writeCmd(0xD9);  //充放电周期设置
  OLED_writeCmd(0xF1);  //Set Pre-Charge as 15 Clocks & Discharge as 1 Clock
  OLED_writeCmd(0xDA);  //行扫配置
  OLED_writeCmd(0x12);
  OLED_writeCmd(0xDB);  //Vcomh反压
  OLED_writeCmd(0x40);  //Set VCOM Deselect Level
  OLED_writeCmd(0x20);  //设置页地址模式 (0x00/0x01/0x02)
  OLED_writeCmd(0x02);
  OLED_writeCmd(0x8D);  //内置升压泵开关
  OLED_writeCmd(0x14);  //--set(0x10) disable
  OLED_writeCmd(0xA4);  //a4/a5  [正常/全亮显示]
  OLED_writeCmd(0xA6);  
  OLED_writeCmd(0xAF);  //--turn on oled panel
  OLED_clear(); 
  OLED_writeCmd(0xb0);    //设置页地址(0-7)
  OLED_writeCmd(0x00);    //设置列低地址
  OLED_writeCmd(0x10);    //设置列高地址
  #endif
}
