package com.example.wangyang.tinnerwangyang.common;

/**
 * Created by wangyang on 3/1/18.
 */

import android.text.TextUtils;

import com.example.wangyang.tinnerwangyang.Exit.ECKit;

/**
 * Created by jamessu on 16/7/18.
 */

public class ErrorMessage {
    public static final int ERROR_CODE_7001 = 7001;
    public static final int ERROR_CODE_7002 = 7002;
    public static final int ERROR_CODE_8000 = 8000;
    public static final int ERROR_CODE_8001 = 8001;
    public static final int ERROR_CODE_8002 = 8002;
    public static final int ERROR_CODE_9017 = 9017;
    public static final int ERROR_CODE_9015 = 9015;
    public static final int ERROR_CODE_9013 = 9013;
    public static final int ERROR_CODE_9012 = 9012;
    public static final int ERROR_CODE_9010 = 9010;
    public static final int ERROR_CODE_9009 = 9009;
    public static final int ERROR_CODE_9008 = 9008;
    public static final int ERROR_CODE_9007 = 9007;
    public static final int ERROR_CODE_9006 = 9006;
    public static final int ERROR_CODE_9005 = 9005;
    public static final int ERROR_CODE_9004 = 9004;
    public static final int ERROR_CODE_9003 = 9003;
    public static final int ERROR_CODE_9002 = 9002;
    public static final int ERROR_CODE_9001 = 9001;
    public static final int ERROR_CODE_9000 = 9000;
    public static final int ERROR_CODE_9101 = 9101;
    public static final int ERROR_CODE_9102 = 9102;
    public static final int ERROR_CODE_9020 = 9020;
    public static final int ERROR_CODE_90021 = 90021;

    private static final String ERROR_7001 = "订单已成功支付";
    private static final String ERROR_7002 = "付款时间失效，请联系您的顾问重新发起邀约";
    private static final String ERROR_8000 = "入库失败";
    private static final String ERROR_8001 = "cookie获取失败";
    private static final String ERROR_8002 = "获取⽤用户信息失败";
    private static final String ERROR_9017 = "您的操作过于频繁，请稍后再试";
    private static final String ERROR_9015 = "用户被屏蔽";
    private static final String ERROR_9013 = "用户已关注";
    private static final String ERROR_9012 = "用户更新失败";
    private static final String ERROR_9010 = "用户Id为空";
    private static final String ERROR_9009 = "手机号不存在";
    private static final String ERROR_9008 = "帐号或密码错误";
    private static final String ERROR_9007 = "手机号为空";
    private static final String ERROR_9006 = "密码为空";
    private static final String ERROR_9005 = "验证码错误";
    private static final String ERROR_9004 = "验证码为空";
    private static final String ERROR_9003 = "密码格式错误";
    private static final String ERROR_9002 = "验证码发送失败";
    private static final String ERROR_9001 = "手机号已注册";
    private static final String ERROR_9000 = "手机号格式错误";
    private static final String ERROR_9101 = "签名错误";
    private static final String ERROR_9102 = "登录过期";
    private static final String ERROR_9020 = "该验证码已失效，请重新获取";
    private static final String ERROR_90021 = "三十秒内不能重复发送验证码";
    private static final String ERROR_NET_CONNECT = "请检查网络连接状态!";
    private static final String ERROR_CONTENT_NULL = "内容不能为空!";
    private static final String ERROR_TITLE_NULL = "标题不能为空!";
    private static final String ERROR_CODE_NULL = "验证码不能为空!";
    private static final String ERROR_PASS_LESS_6 = "密码不能小于6位!";
    private static final String ERROR_PASS_NULL = "密码不能为空!";
    private static final String ERROR_PHONE_NOT_CORRECT = "请输入正确的手机号!";
    private static final String ERROR_PHONE_NULL = "手机号不能为空!";
    public static String getErrorMessage(Result result){
        String msg = getErrorMessage(result,"请检查网络连接");
        return msg;
    }
    public static String getErrorMessage(Result result,String defaultMsg){
        String msg = null;
        if(result != null){
            switch(result.getErrorCode()){
                case ERROR_CODE_8000: msg = ERROR_8000; break;
           //     case ERROR_CODE_7001: msg = ERROR_7001; ECKit.getPM().pushOrderSuccess();break;
                case ERROR_CODE_7002: msg = ERROR_7002; break;
                case ERROR_CODE_8001: msg = ERROR_8001; break;
                case ERROR_CODE_8002: msg = ERROR_8002; break;
                case ERROR_CODE_9000: msg = ERROR_9000; break;
                case ERROR_CODE_9001: msg = ERROR_9001; break;
                case ERROR_CODE_9002: msg = ERROR_9002; break;
                case ERROR_CODE_9003: msg = ERROR_9003; break;
                case ERROR_CODE_9004: msg = ERROR_9004; break;
                case ERROR_CODE_9005: msg = ERROR_9005; break;
                case ERROR_CODE_9006: msg = ERROR_9006; break;
                case ERROR_CODE_9007: msg = ERROR_9007; break;
                case ERROR_CODE_9008: msg = ERROR_9008; break;
                case ERROR_CODE_9009: msg = ERROR_9009; break;
                case ERROR_CODE_9010: msg = ERROR_9010; break;
                case ERROR_CODE_9012: msg = ERROR_9012; break;
                case ERROR_CODE_9013: msg = ERROR_9013; break;
                case ERROR_CODE_9015: msg = ERROR_9015; break;
                case ERROR_CODE_9017: msg = ERROR_9017; break;
                case ERROR_CODE_9101: msg = ERROR_9101; break;
                case ERROR_CODE_9102: msg = ERROR_9102; break;
                case ERROR_CODE_9020: msg = ERROR_9020; break;
                case ERROR_CODE_90021: msg = ERROR_90021; break;

                case MessageCode.NET_CONNECT:
                    msg = ERROR_NET_CONNECT;
                    break;
                case MessageCode.NET_REFRESE:
                    msg = ERROR_NET_CONNECT;
                    break;
                case MessageCode.NET_TIMEOUT:
                    msg = ERROR_NET_CONNECT;
                    break;
                default:
                    msg = defaultMsg;
                    break;
            }
        }else{
            msg = defaultMsg;
        }
        return msg;
    }
    /**
     * 验证手机号和密码
     *
     * @param phoneNum
     *            手机号
     * @param password
     *            密码
     * @return string 错误消息
//     */
//    public static String verifyPhoneAndPass(String phoneNum, String password) {
//        String phoneResult = verifyPhoneNum(phoneNum);
//        String passResult = verifyPassword(password);
//        if (TextUtils.isEmpty(phoneResult)) {
//            if (TextUtils.isEmpty(passResult)) {
//                return "";
//            } else {
//                return passResult;
//            }
//        } else {
//            return phoneResult;
//        }
//    }

    /**
     * 验证手机号和密码验证码
     *
     * @param phoneNum
     *            手机号
     * @param password
     *            密码
     * @param captcha
     *            验证码
     * @return string 错误消息
     */
//    public static String verifyPhoneAndPassAndCap(String phoneNum,
//                                                  String password, String captcha) {
//        String phoneAndPassResult = verifyPhoneAndPass(phoneNum, password);
//        String captChaResult = verifyCaptcha(captcha);
//        if (TextUtils.isEmpty(phoneAndPassResult)) {
//            if (TextUtils.isEmpty(captChaResult)) {
//                return "";
//            } else {
//                return captChaResult;
//            }
//        } else {
//            return phoneAndPassResult;
//        }
//    }
    /**
     * 验证手机号
     *
     * @param phoneNum
     *            手机号
     * @return string 错误消息
//     */
//    public static String verifyPhoneNum(String phoneNum) {
//        String value = null;
//        if (TextUtils.isEmpty(phoneNum)) {
//            value = ERROR_PHONE_NULL;
//        }
//        else if (!StringUtils.isCellphone(phoneNum)) {
//            value = ERROR_PHONE_NOT_CORRECT;
//        }
//
//        return value;
//    }

    /**
     * 验证密码
     *
     * @param password
     *            密码
     * @return string 错误消息
     */

    public static String verifyPassword(String password) {
        String value = null;
        if (TextUtils.isEmpty(password)) {
            value = ERROR_PASS_NULL;
        } else if (password.length() < 6) {
            value = ERROR_PASS_LESS_6;
        }
//		else if(!password.matches(regex)){
//			value = "请输入带有字母和数字的密码";
//		}
        return value;
    }

    /**
     * 验证码
     *
     * @param captcha
     *            密码
     * @return string 错误消息
     */
    public static String verifyCaptcha(String captcha) {
        String value = null;
        if (TextUtils.isEmpty(captcha)) {
            value = ERROR_CODE_NULL;
        }
        return value;
    }
    /**
     * 验证标题
     * @param title
     * @return
     */
    public static String verifyTitle(String title){
        String result = null;
        if(TextUtils.isEmpty(title)){
            result = ERROR_TITLE_NULL;
        }
        return result ;
    }
    /**
     * 验证内容
     * @param content
     * @return
     */
    public static String verifyContent(String content){
        String result = null;
        if(TextUtils.isEmpty(content)){
            result = ERROR_CONTENT_NULL;
        }
        return result ;
    }
}
