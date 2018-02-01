package com.example.wangyang.tinnerwangyang.Http;

import com.example.wangyang.tinnerwangyang.Exit.ECKit;
import com.example.wangyang.tinnerwangyang.R;

/**
 * Created by wangyang on 3/1/18.
 */


public class HttpTimeoutException extends HttpBaseException {

    /**
     * 网络不可用异常
     */
    private static final long serialVersionUID = 1L;

    public HttpTimeoutException(String msg){
        super(msg);
    }

    public HttpTimeoutException(){
        super(ECKit.getString(R.string.msg_toast_err_network_timeout));
    }
}
