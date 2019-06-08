#include <jni.h>
#include <stdlib.h>

unsigned char* jbyteArrayToCharPointer(JNIEnv* env,jclass clazz,jbyteArray jBuffer);

jsize jbyteArraySize(JNIEnv* env,jclass clazz,jbyteArray jBuffer);