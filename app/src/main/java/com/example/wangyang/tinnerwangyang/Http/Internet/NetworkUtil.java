package com.example.wangyang.tinnerwangyang.Http.Internet;

/**
 * Created by wangyang on 28/12/17.
 */

public class NetworkUtil {
    public static boolean verifyNetwork(){
        boolean connect=true;
        try{
//            @SuppressLint("WrongConstant")ConnectivityManager connectivityManager
////                    =(ConnectivityManager) ECKit.getApp().getSystemService("connectivity");
//            NetworkInfo.State mobile =connectivityManager.getNetworkInfo(0).getState();
//            NetworkInfo.State wifi=connectivityManager.getNetworkInfo(1).getState();
//            if (mobile.equals(NetworkInfo.State.CONNECTED)&&mobile.equals(NetworkInfo.State.CONNECTING)
//                    &&wifi.equals(NetworkInfo.State.CONNECTED)&&wifi.equals(NetworkInfo.State.CONNECTING)){
//                connect=false;
//            }
         }catch (Exception e){

        }
        return connect;
    }
}
