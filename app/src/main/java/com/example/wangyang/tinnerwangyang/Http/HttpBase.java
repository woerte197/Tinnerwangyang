package com.example.wangyang.tinnerwangyang.Http;

import android.os.Handler;
import android.os.Message;

import com.example.wangyang.tinnerwangyang.common.BaseRunnable;
import com.example.wangyang.tinnerwangyang.common.JThreadPool;
import com.example.wangyang.tinnerwangyang.common.MessageCode;
import com.example.wangyang.tinnerwangyang.common.Request;
import com.example.wangyang.tinnerwangyang.common.Result;
import com.example.wangyang.tinnerwangyang.common.Setting;

import java.lang.reflect.Type;
import java.util.concurrent.ThreadPoolExecutor;

public class HttpBase<T> extends BaseRunnable {
	protected Request url;
	protected Result<T> result = new Result();
	private int status = Setting.http_load_un;
	public HttpBase(String url,Type t,String baseurl){
		this.url = new Request(url,t,baseurl);
	}
	public HttpBase(Request request){
		this.url = request;
	}
	@Override
	public void run() {
		handler.sendEmptyMessage(Setting.http_load_prepare);
		execute();
		if (result.getResult() == MessageCode.NET_ERROR) {
			cancel();
		} else {
			asyncSuccess();
			handler.sendEmptyMessage(Setting.http_load_success);
		}
	}

	public int getStatus(){
		return status;
	}

	public void startHttpDef() {
		ThreadPoolExecutor pool = JThreadPool.getGlobalSingleThreadPool();
		pool.execute(this);
	}
	protected Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			status = msg.what;
			switch (msg.what) {
				case Setting.http_load_success:
					success();
					break;
				case Setting.http_load_fail:
					fail();
					break;
				case Setting.http_load_prepare:
					prepare();
					break;
				case Setting.http_load_loading:
					loading();
					break;
				case Setting.http_load_cache_success:
					loadCacheData();
					break;
				case Setting.http_load_stop:
					stop();
					break;
			}
		}
	};

	public void execute(){} ;
	protected void asyncSuccess() { }
	protected void asyncFail() { }
	protected void loadCacheData() { }
	protected void success() {  }
	protected void stop() {  }
	protected void fail() {  }
	protected void prepare() { }
	protected void loading() {  }

	public boolean isRunning() {
		return status == Setting.http_load_prepare;
	}
	public void cancel(){
		asyncFail();
		handler.sendEmptyMessage(Setting.http_load_fail);
	}
	public void toStop(){
		stop();
		status = Setting.http_load_stop;
	}
	public Result<T> getResult(){
		return result;
	}
	public boolean isFail(){
		return status == Setting.http_load_fail;
	}
	public boolean isStop(){
		return status == Setting.http_load_stop;
	}

	public Request getUrl(){
		return url;
	}

}
