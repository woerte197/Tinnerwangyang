package com.example.wangyang.tinnerwangyang.Http;

/**
 * Created by wangyang on 3/1/18.
 */


@SuppressWarnings("serial")
public class HttpBaseException extends Exception {

    public int errorCode = -1;
    public String httpResultString;

    /**
     * API异常的基类
     *
     * @param msg
     */
    public HttpBaseException(String msg) {
        super(msg);
    }

    public HttpBaseException(String msg, int ecode) {
        super(msg);
        this.errorCode = ecode;
    }

    public HttpBaseException(String msg, int ecode, String httpResultString) {
        super(msg);
        this.errorCode = ecode;
        this.httpResultString = httpResultString;
    }

    public HttpBaseException(String msg, Throwable t) {
        super(msg, t);
    }

}
