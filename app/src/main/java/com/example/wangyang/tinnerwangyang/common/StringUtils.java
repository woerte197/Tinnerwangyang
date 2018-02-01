package com.example.wangyang.tinnerwangyang.common;

/**
 * Created by wangyang on 3/1/18.
 */

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;

import com.example.wangyang.tinnerwangyang.Exit.ECKit;
import com.example.wangyang.tinnerwangyang.R;

import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringUtils {
    private static final String FORMAT_STR_2F_MB = "%.2fMB";
    private static final String HEADER_NULL = "#";
    private static final String UMENG_CHANNEL = "UMENG_CHANNEL";
    private static final String APP_DEBUG = "APP_DEBUG";
    private static final String APP_SHOW_LOG = "APP_SHOW_LOG";
    private static final String QQ_APPKEY = "QQ_APPKEY";
    private static final String UNIT_WAN = "万";

    private static final String DATE_MIN_AGO = "分钟前";
    private static final String DATE_JUST = "刚刚";
    private static final String DATE_HOUR_AGO = "小时前";
    private static final String DATE_DAY_AGO = "天前";
    public static final SimpleDateFormat sdfyyyMMddChar = new SimpleDateFormat("yyyy年MM月dd日");

    public static String formateMB(double value) {
        return String.format(FORMAT_STR_2F_MB, value);
    }

    /**
     * 验证手机号
     *
     * @param phoneNum
     * @return
     */
    public static boolean isCellphone(String phoneNum) {
//		Pattern pattern = Pattern.compile("1[0-9]{10}");
//		Matcher matcher = pattern.matcher(phoneNum);
//		if (matcher.matches()) {
//			return true;
//		} else {
//			return false;
//		}
        return true;
    }


    public static boolean isCellphone2(String phoneNum) {
        Pattern pattern = Pattern.compile("1[0-9]{10}");
        Matcher matcher = pattern.matcher(phoneNum);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }


    public static String getHeadUrl(String headName) {
        return headName;
    }

    public static String getTimeForChar(Long time) {
        String sb = new String();
        if (time != null) {
            Date now = new Date();
            time = time * 1000;
            Date date = new Date(time);
            long l = now.getTime() - date.getTime();
            long day = l / (24 * 60 * 60 * 1000);
            long hour = (l / (60 * 60 * 1000) - day * 24);
            long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
            long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);


            if (day > 0) {
                //按日期格式进行区别
                if (day < 4) {
                    sb = (day + DATE_DAY_AGO);
                } else {
                    sb = sdfyyyMMddChar.format(time);
                }
            } else if (hour > 0) {
                sb = (hour + DATE_HOUR_AGO);
            } else if (min > 0) {
                if (min <= 15) {
                    sb = DATE_JUST;
                } else {
                    sb = (min + DATE_MIN_AGO);
                }
            } else {
                sb = DATE_JUST;
            }
        }
        return sb;
    }

    public static String getTimeForChar(SimpleDateFormat format, Long time) {
        String sb = new String();
        if (time != null) {
            time = time * 1000;
            sb = format.format(time);
        }
        return sb;
    }
//
//	public static String getTimeForChar(Long time) {
//		String sb = new Strin

//		if(time!=null){
//			Date now = new Date();
//			time = time *1000;
//			Date date = new Date(time);
//			long l = now.getTime() - date.getTime();
//			long day = l / (24 * 60 * 60 * 1000);
//			long hour = (l / (60 * 60 * 1000) - day * 24);
//			long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
//			long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
//
//
//			if (day > 0){
//				//按日期格式进行区别
//				if(day<30){
//					sb = (day + "天前");
//				}else{
//					sb = sdfyyyMMddChar.format(time);
//				}
//				sb = (day + "天前");
//			}else if (hour > 0){
//				sb = (hour + "小时前");
//			}else if (min > 0){
//				if(min<=1){
//					sb = ("刚刚");
//				}else if(min<=10){
//					sb = (10 + "分前");
//				}else if(min<=20){
//					sb = (20 + "分前");
//				}else if(min<=30){
//					sb = (30 + "分前");
//				}else if(min<=40){
//					sb = (40 + "分前");
//				}else if(min<=50){
//					sb = (50 + "分前");
//				}
//				else{
//					sb = (min + "分前");
//				}
//			} else{
//				sb = ("刚刚");
//			}
//		}
//		return sb;
//	}

    /**
     * 得到一个用户的用户名,如果用昵称则返回昵称,如果没有则返回电话号码
     *
     * @param userInfo
     * @return
     */
//    public static String getUserName(UserInfo userInfo) {
//        String name = "";
//        if (userInfo != null) {
//            if (TextUtils.isEmpty(userInfo.getNickName())) {
//                name = userInfo.getUsername();
//            } else {
//                name = userInfo.getNickName();
//            }
//        }
//        return name;
//    }

    /**
     * 得到一个用户的用户名,如果用昵称则返回昵称,如果没有则返回电话号码
     */
//    public static String getReadCount(Article article) {
//        try {
//            String text = "";
//            int count = Integer.valueOf(article.getReadCount());
//            if (count < 10000) {
//                text = count + "";
//            } else {
//                int w = count / 10000;
//                int g = count % 10000 / 1000;
//                text = w + "." + g + UNIT_WAN;
//            }
//            return text;
//        } catch (Exception e) {
//            return "";
//        }
//
//    }

    public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        } else {
            return false;
        }
    }

    public static String getFormatMessage(Object code, String message) {
        return " {'message':'" + message + "','result':-1,'errorcode':" + code + "}";
    }

    public static String getFormatMessage(Object code, Exception e) {
        return " {'message':'" + e.getMessage() + "','result':-1,'errorcode':" + code + "}";
    }

    /**
     * 获取索引列表的头字母
     *
     * @param headerName
     * @return
     */
//    public static String getHeader(String headerName) {
//        String header = null;
//        try {
//            if (Character.isDigit(headerName.charAt(0))) {
//                header = HEADER_NULL;
//            } else {
//                String firstName = headerName.substring(0, 1);
//                String h1 = HanziToPinyin.getInstance().get(firstName).get(0).target.substring(0, 1).toUpperCase();
//                char h = h1.toLowerCase().charAt(0);
//                if (h < 'a' || h > 'z') {
//                    header = HEADER_NULL;
//                } else {
//                    header = h1;
//                }
//
//            }
//        } catch (Exception e) {
//            header = HEADER_NULL;
//        }
//
//        return header;
//    }

    /**
     * 获取索引列表的头字母
     *
     *
     * @return
     */
//    public static String getHeaderFull(String headerName) {
//        String header = null;
//        if (Character.isDigit(headerName.charAt(0))) {
//            header = HEADER_NULL;
//        } else {
//            try {
//                String firstName = headerName.substring(0, 1);
//                String h1 = HanziToPinyin.getInstance().get(firstName).get(0).target.substring(0, 1).toUpperCase();
//                char h = h1.toLowerCase().charAt(0);
//                if (h < 'a' || h > 'z') {
//                    header = HEADER_NULL;
//                } else {
//                    header = h1.toLowerCase() + "  " + firstName;
//                }
//            } catch (Exception e) {
//                header = HEADER_NULL;
//            }
//        }
//        return header;
//    }

    // 获取ApiKey
    public static String getMetaValue(String metaKey) {
        Bundle metaData = null;
        String apiKey = null;
        if (metaKey == null) {
            return null;
        }
        try {
            Context ctx = ECKit.getApp();
            ApplicationInfo ai = ctx.getPackageManager().getApplicationInfo(
                    ctx.getPackageName(), PackageManager.GET_META_DATA);
            if (null != ai) {
                metaData = ai.metaData;
            }
            if (null != metaData) {
                apiKey = metaData.get(metaKey).toString();
            }
        } catch (PackageManager.NameNotFoundException e) {

        }
        return apiKey;
    }

    public static String getQQAPPKEYMetaValue() {
        return getMetaValue(QQ_APPKEY);
    }

    public static String getAPPDEBUGMetaValue() {
        return getMetaValue(APP_DEBUG);
    }

    public static String getAPP_SHOW_LOG_MetaValue() {
        return getMetaValue(APP_SHOW_LOG);
    }

    public static String getUMENG_CHANNEL_MetaValue() {
        return getMetaValue(UMENG_CHANNEL);
    }

    public static String getString(int res) {
        return ECKit.getContext().getString(res);
    }

    public static boolean isHttpString(String str) {
        return !TextUtils.isEmpty(str) && str.contains(Setting.STR_HTTP);
    }

    public static String convert2String(Long count) {
        return StringUtils.isEmpty(count) ? "0" : count + "";
    }

    public static String getPariseCount(Long count) {
        String pariseCount = count == 0 ? StringUtils.getString(R.string.msg_label_praise) : StringUtils.convert2String(count);
        return pariseCount;
    }

    public static int getToast(int mArgType) {
        int toastMsg = R.string.msg_toast_publish_ing;
        switch (mArgType) {
            case Setting.PUBLIC_QUESTION:
                toastMsg = R.string.msg_toast_publish_answer_ing;
                break;
            case Setting.PUBLIC_REPLY:
                toastMsg = R.string.msg_toast_publish_reply_ing;
                break;
            case Setting.PUBLIC_ARTICLE:
                toastMsg = R.string.msg_toast_publish_ing;
                break;
        }
        return toastMsg;
    }
//
//    public static long getDefaultBlockId(int mArgType) {
//        long id = 0;
//        switch (mArgType) {
//            case Setting.PUBLIC_QUESTION:
//                id = Long.parseLong(ECKit.getApp().getConfigManager().getDefaultQuestionBlockId());
//                break;
//            case Setting.PUBLIC_ARTICLE:
//                id = Long.parseLong(ECKit.getApp().getConfigManager().getDefaultPublisBlockId());
//                break;
//        }
//        return id;
//    }
//
//    public static String getReplyPre(Article article) {
//        String other = "";
//        if (article != null) {
//            other = "@" + StringUtils.getUserName(article.getUser()) + "：";
//        }
//        return other;
//    }

    public static void setResultData(Result r, int errorCode, Exception e) {
        r.setErrorCode(errorCode);
        r.setData(StringUtils.getFormatMessage(errorCode, e));
        Log.i("httpstring:", e.getMessage());

    }

    public static String getUnreadCount(int count) {
        String msg = count + "";
        if (count > 100) {
            msg = StringUtils.getString(R.string.msg_label_max_message_count);
        }
        return msg;
    }

    public static String getHourMinSec(long ms) {
        long s = ms / 1000;
        long second = s % 60;
        long minute = s / 60;

        StringBuffer sb = new StringBuffer();

        if (minute > 0) {
            if (minute < 10) {
                sb.append("0" + minute + ":");
            } else {
                sb.append(minute + ":");
            }

        } else {
            sb.append("00" + ":");
        }
        if (second > 0) {
            if (second < 10) {
                sb.append("0" + second);
            } else {
                sb.append(second);
            }

        } else {
            sb.append("00");
        }

        return sb.toString();
    }

    /**
     * 获取环信获取昵称字段
     *
     * @return
     */
//    public static String getHxExtNickName(ChatMessage message) {
//        return message.getStringAttribute(Setting.DBFIELD_NICKNAME);
//    }
//
//    /**
//     * 获取环信获取图片字段
//     *
//     * @param message 消息
//     * @return
//     */
//    public static String getHxExtImageUrl(ChatMessage message) {
//        return message.getStringAttribute(Setting.DBFIELD_IMAGEURL);
//    }
//
//    /**
//     * 用md5 加密字段并且添加到url字符中
//     *
//     * @param url 源网址
//     * @return 加密后网址
//     */
//    public static String getEncryptionString(String url) {
//        String etp = System.currentTimeMillis() + "";
//        String userId = ECKit.getApp().getUserId() + "";
//        String secret = EncryptKey.getSecretWebKeyFromJni();
//        Map<String, String> values = new HashMap<>();
//        if (!TextUtils.isEmpty(userId)) {
//            values.put("userId", userId);
//            values.put("sig", MD5Util.MD5(MD5Util.MD5(secret + etp + userId)));
//        } else {
//            values.put("sig", MD5Util.MD5(MD5Util.MD5(secret + etp)));
//        }
//        values.put("etp", etp);
//        String encode = URLEncoder.encode(Constant.GSON.toJson(values));
////        Constant.GSON.toJson(values)
//        return url + "?" + Setting.JSON_PARAMS + "=" + encode;
//    }
//
//    public static String getVideoUrl(String url, boolean isDre) {
//        if (isDre) {
//            return url;
//        } else {
//            String a[] = url.split("\\?");
//            String b = a[0].replace(Setting.PRE_VIDEO_URL, "").trim();
//            String time = String.valueOf(ECKit.getApp().getConfigManager().getTimestampDiff());
//            String wsSecret = MD5Util.MD5(EncryptKey.getVidesoKeyFromJni() + b + time);
//            String path = a[0] + "?wsSecret=" + wsSecret + "&wsTime=" + time;
//            return path;
//        }
//    }

    public static String getOrderPrice(float price) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        return decimalFormat.format(price);
    }

    public static String toSBC(String input) {
        char c[] = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == ' ') {
                c[i] = '\u3000';
            } else if (c[i] < '\177') {
                c[i] = (char) (c[i] + 65248);
            }
        }
        return new String(c);
    }

    public static String replace_n(String source) {
//		return source.replace("\n","<br />");
        return source;
    }

//    public static class CustomUrlSpan extends ClickableSpan {
//
//        private Context context;
//        private String url;
//
//        public CustomUrlSpan(Context context, String url) {
//            this.context = context;
//            this.url = url;
//        }
//
//        @Override
////        public void onClick(View widget) {
////            // 在这里可以做任何自己想要的处理
////
////            JumpManager.showWebView((BaseActivity) context, url, "", "");
////        }
//    }

    private static final String TAG = "StringUtils";

    public static Spannable hightText(String content, String keywords, Spannable spannable) {
        if (!TextUtils.isEmpty(content) && !TextUtils.isEmpty(keywords)) {
            String newContent = content.toLowerCase();
            String newKeyword = keywords.toLowerCase();
            int startIndex = newContent.indexOf(newKeyword);
            int len = keywords.length();
            ForegroundColorSpan span = new ForegroundColorSpan(Color.parseColor("#00b1e8"));
            try {
                if (startIndex >= 0) {
                    spannable.setSpan(span, 0, len, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    spannable.setSpan(span, startIndex, startIndex + len, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                }
            } catch (Exception e) {
                e.printStackTrace();
                Log.i(TAG, e.getMessage());
                Log.i(TAG, String.format("startIndex:%d,len:%d,contentLength:%d", startIndex, len, content.length()));
                Log.i(TAG, String.format("content:%s,keywords:%s", content, keywords));
            }
        }
        return spannable;
    }

}
