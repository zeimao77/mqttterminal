#include <wiringPi.h>
#include <wiringPiI2C.h>
#include <stdio.h>
#include <unistd.h>

#define LM75ADDR 0x48

int main(){
  int fd = -1;
  int val = -1;
  double tempval = 0;
  wiringPiSetup();
  fd = wiringPiI2CSetup(LM75ADDR);

  if(fd >=0){
    while(1) {
      tempval = 0;
      printf("=================================\r\n");
      val =  wiringPiI2CReadReg16(fd,0); 
      unsigned char c2 = (char) val;
      unsigned char c1 = (char) (val >> 8);
      printf("c2 = %x;",c2);
      printf("c1 = %x\r\n",c1);
      if(c2 & 0x0080) {
        printf("-");
        c2 = ~c2;
        c1 += 0x20;
      }else {
        printf("+");
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
      printf("TEMP = %f",tempval);
      usleep(100000);
    }

  } else { 
     printf("IIC初始化失败..."); 
  }
return 0;
}
