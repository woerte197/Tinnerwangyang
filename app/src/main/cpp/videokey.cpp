//
// Created by nanchaodong on 16/8/23.
//
#include "com_lib_view_player_VideoKey.h"
#include <string.h>
JNIEXPORT jstring JNICALL Java_com_lib_view_player_EncryptKey_getVidesoKeyFromJni
  (JNIEnv * env, jclass cla){
  return env->NewStringUTF("8424ef873a94c4521ee2cc512a64e4cbde05b898");
  }
JNIEXPORT jstring JNICALL Java_com_lib_view_player_EncryptKey_getSecretKeyFromJni
  (JNIEnv * env, jclass cla){
  return env->NewStringUTF("6B1E055E-3264-4A5C-8ED0-5693C05F55B9");
  }
JNIEXPORT jstring JNICALL Java_com_lib_view_player_EncryptKey_getSecretWebKeyFromJni
  (JNIEnv * env, jclass cla){
  return env->NewStringUTF("eb7c50680c7cfa1f0119a22402e42098");
  }
JNIEXPORT jstring JNICALL Java_com_lib_view_player_EncryptKey_getWxpayId
        (JNIEnv * env, jclass cla){
  return env->NewStringUTF("wx5584155c513d6344");
}
JNIEXPORT jstring JNICALL Java_com_lib_view_player_EncryptKey_getWxLogId
        (JNIEnv * env, jclass cla){
  return env->NewStringUTF("wx4bb43eaf704e471b");
}
JNIEXPORT jstring JNICALL Java_com_lib_view_player_EncryptKey_getWechatScreetMetaValue
        (JNIEnv * env, jclass cla){
  return env->NewStringUTF("6B1E055E-3264-4A5C-8ED0-5693C05F55B9");
}