package com.example.wangyang.tinnerwangyang;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wangyang.tinnerwangyang.Exit.ECKit;


public class ToasterCommon {

	private static ToasterCommon toastCommom;
	TextView text;
	private Toast toast;

	private ToasterCommon(){
		View layout = LayoutInflater.from(ECKit.getApp()).inflate(R.layout.c_toast,null);
		text = (TextView) layout.findViewById(R.id.textview);
 		toast = new Toast(ECKit.getApp());
 		toast.setDuration(Toast.LENGTH_SHORT);
		toast.setView(layout);
	}

	public static ToasterCommon getInstance(){
		if (toastCommom==null) {
			toastCommom = new ToasterCommon();
		}
		return toastCommom;
	}

	/**
	 * 显示Toast
	 * @param tvString
	 */

	public void show(String tvString){
 		text.setText(tvString);
		toast.show();
	}

}