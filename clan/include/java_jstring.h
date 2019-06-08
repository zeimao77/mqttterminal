#include <jni.h>
#include <stdlib.h>
#include <string.h>

#ifndef __JAVA_JSTRING_H__

#define __JAVA_JSTRING_H__

char* jstringToChar(JNIEnv* env, jstring jstr);

jstring charToJstring(JNIEnv* env, const char* str);

#endif
