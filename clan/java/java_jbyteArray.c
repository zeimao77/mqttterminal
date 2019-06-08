#include "java_jbyteArray.h"

unsigned char* jbyteArrayToCharPointer(JNIEnv* env,jclass clazz,jbyteArray jBuffer){
  jbyte* bBuffer = (*env)->GetByteArrayElements(env,jBuffer,0);    
  unsigned char* buf=(unsigned char*)bBuffer; 
  return buf;
}

jsize jbyteArraySize(JNIEnv* env,jclass clazz,jbyteArray jBuffer) {
	jsize arraySize = (*env)->GetArrayLength(env,jBuffer);
	return arraySize;
}
