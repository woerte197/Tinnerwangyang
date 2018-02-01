package com.example.wangyang.tinnerwangyang;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;

import com.example.wangyang.tinnerwangyang.Activity.BigImageActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangyang on 24/1/18.
 */

public class ImageReceiver extends BroadcastReceiver {
    private  List list = new ArrayList<>();


    @Override
    public void onReceive(Context context, Intent intent) {
        list = intent.getStringArrayListExtra("imageurl");
        Log.i("ImageReceiver",String.format(""+list));
    }
}
