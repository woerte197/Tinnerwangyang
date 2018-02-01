package com.example.wangyang.tinnerwangyang.Http;

/**
 * Created by wangyang on 3/1/18.
 */


import com.example.wangyang.tinnerwangyang.Exit.ECKit;
import com.example.wangyang.tinnerwangyang.R;

/**
 * http状态码异常, 非200
 *
 */
public class HttpResponseStatusErrorException extends HttpBaseException {
    private static final long serialVersionUID = 1L;
    public int statusCode = -1;
    public HttpResponseStatusErrorException(int statusCode){
        super(ECKit.getString(R.string.msg_toast_err_network_statuserror)+"("+statusCode+")");
        this.statusCode = statusCode;
    }

    @Override
    public String toString() {
        String msg = getLocalizedMessage();
        String name = getClass().getName();
        if (msg == null) {
            return name;
        }
        return name + ": "  + msg + "["+statusCode+"]";
    }
}
