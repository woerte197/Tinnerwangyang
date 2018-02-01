package com.example.wangyang.tinnerwangyang.Exit;

/**
 * 原始代码来自开源项目 DroidKit。
 */

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.hardware.Camera;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;

import com.example.wangyang.tinnerwangyang.R;
import com.example.wangyang.tinnerwangyang.common.Setting;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ECKit {

    private static final String SDCARD_PATH_FORMAT = "Android/data/%s";

    private static Context applicationContext = null;
    private static String sPackageName = null;
    private static Float sScreenDensity = null;
    private static Float sTextScale = null;
    private static File sExternalStorageDirectory = null;

    public static void onApplicationCreate(Context context) {
        if (applicationContext == null) {
            applicationContext = context;
        }
    }

    /**
     * 是否是4.0或者以后的系统
     *
     * @return
     */
    public static boolean isIcsVsersion() {
        return Build.VERSION.SDK_INT >= 14;
    }

    public static boolean isJBVsersion() {
        return Build.VERSION.SDK_INT >= 16;
    }

    public static void onApplicationTerminate() {
        applicationContext = null;
        sPackageName = null;
        sScreenDensity = null;
        sTextScale = null;
        sExternalStorageDirectory = null;
    }

    public static Context getContext() {
        return applicationContext;
    }

    public static MyApplication getApp() {
        return (MyApplication) applicationContext;
    }

    public static boolean isSdcardEnable() {
        return Environment.MEDIA_MOUNTED.equals(Environment
                .getExternalStorageState());
    }

    public static RectF getViewLocationOnScreen(View v) {
        int[] location = new int[2];
        v.getLocationOnScreen(location);
        int vx = location[0];
        int vy = location[1];
        RectF viewRectF = new RectF(vx, vy, vx + v.getMeasuredWidth(), vy
                + v.getMeasuredHeight());
        return viewRectF;
    }

    public static Activity getParentActivity(Activity activity) {
        Activity parent = activity.getParent();
        if (parent == null) {
            return activity;
        } else {
            return getParentActivity(parent);
        }
    }

    public static String getPackageName() {
        if (sPackageName == null) {
            sPackageName = applicationContext.getPackageName();
            if (sPackageName.indexOf(":") >= 0) {
                sPackageName = sPackageName.substring(0,
                        sPackageName.lastIndexOf(":"));
            }
        }

        return sPackageName;
    }

    public static AudioManager getAudioManager() {
        return (AudioManager) applicationContext
                .getSystemService(Context.AUDIO_SERVICE);
    }

    public static InputMethodManager getInputMethodManager() {
        return (InputMethodManager) applicationContext
                .getSystemService(Context.INPUT_METHOD_SERVICE);
    }

    public static float getScreenDensity() {
        if (sScreenDensity == null) {
            sScreenDensity = getDisplayMetrics().density;
        }
        return sScreenDensity.floatValue();
    }

    public static float getTextScale() {
        if (sTextScale == null) {
            sTextScale = getDisplayMetrics().scaledDensity;
        }
        return sTextScale.floatValue();
    }
    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int  dp2px(int dpValue){
        return (int) (dpValue *getScreenDensity() + 0.5f);
    }
    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip( float pxValue) {
        final float scale = getScreenDensity();
        return (int) (pxValue / scale + 0.5f);
    }
    public static File getExternalStorageDirectory() {
        if (sExternalStorageDirectory == null) {
            sExternalStorageDirectory = new File(
                    Environment.getExternalStorageDirectory(), String.format(
                    Locale.US, SDCARD_PATH_FORMAT, getPackageName()));
        }
        return sExternalStorageDirectory;
    }

    public static Resources getResources() {
        return applicationContext.getResources();
    }

    public static DisplayMetrics getDisplayMetrics() {
        return getResources().getDisplayMetrics();
    }

    public static String getString(int resource) {
        return applicationContext.getString(resource);
    }

    public static String getString(int resource, Object... formatArgs) {
        return applicationContext.getString(resource, formatArgs);
    }

    public static int getResourceId(String name) {
        return getResources().getIdentifier(name, null,
                applicationContext.getPackageName());
    }

    public static Drawable getDrawable(int resource) {
        return getResources().getDrawable(resource);
    }

    public static int getColor(int resource) {
        return getResources().getColor(resource);
    }

    public static Bitmap getBitmap(int resource) {
        return BitmapFactory.decodeResource(getResources(), resource);
    }

    public static int getPixels(float dip) {
        return Math.round(TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, dip, getDisplayMetrics()));
    }

    /**
     * 像素转换成DIP *
     */
    public static int getDips(float pixel) {
        if (pixel >= 0) {
            return (int) (pixel / getDisplayMetrics().density + 0.5f);
        } else {
            return 0;
        }
    }
    /**
     * 像素转换成DIP *
     */
    public static int getDips1(float pixel) {
        float fPx = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, pixel,getDisplayMetrics());
        return (int )fPx;
    }

    public static int getDimensionPixelSize(int id) {
        return getResources().getDimensionPixelSize(id);
    }

    public static int sp2pix(float sp) {
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                sp, getDisplayMetrics()));
    }

    public static Object getSystemService(String name) {
        return applicationContext.getSystemService(name);
    }

    public static boolean isHoneycomb() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB;
    }

    public static boolean isFroyo() {
        return Build.VERSION.SDK_INT >= 8;
    }

    public static int getAndroidApiLevel() {
        return Build.VERSION.SDK_INT;
    }

    public static Bitmap decodeBitmap(int resId) {
        return BitmapFactory.decodeResource(getResources(), resId);
    }

    /**
     * 判断系统是否带有谷歌地图
     */
    public static boolean hasGoogleMap() {
        // return
        // getContext().getPackageManager().hasSystemFeature("com.google.android.maps.MapActivity");
        try {
            Class.forName("com.google.android.maps.MapActivity");
        } catch (Throwable e) {
            return false;
        }
        return true;
    }

    /**
     * 获取网络状态是否可用 **
     */
    public static boolean isNetworkAvailable() {
        ConnectivityManager connectivity = (ConnectivityManager) applicationContext
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity == null) {
        } else {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 获得应用程序版本
     */
    public static int getVersionCode() {
        int versionCode = 0;
        try {
            PackageInfo pinfo = getContext().getPackageManager()
                    .getPackageInfo(getContext().getPackageName(),
                            PackageManager.GET_CONFIGURATIONS);
            versionCode = pinfo.versionCode;
        } catch (Exception e) {
        }
        return versionCode;
    }

    public static String getVersionName() {
        try {
            PackageInfo pinfo = getContext().getPackageManager()
                    .getPackageInfo(getContext().getPackageName(),
                            PackageManager.GET_CONFIGURATIONS);
            return pinfo.versionName;
        } catch (Throwable e) {
        }
        return "";
    }

    /**
     * 获得SDK版本号
     */
    public static int getSDKVersion() {
        return Build.VERSION.SDK_INT;
    }

    /**
     * 获得手机操作系统版本号
     */
    public static String getOSVersion() {
        return Build.VERSION.RELEASE;
    }

    /**
     * 获得手机IMEI号
     */
//    public static String getIMEI() {
//        TelephonyManager telephonyManager = (TelephonyManager) applicationContext
//                .getSystemService(Context.TELEPHONY_SERVICE);
//        return telephonyManager.getDeviceId();
//    }

    /**
     * 获得手机网卡地址
     */
//    public static String getMAC() {
//        String mac = "";
//        WifiManager wifi = (WifiManager) applicationContext
//                .getSystemService(Context.WIFI_SERVICE);
//        WifiInfo info = wifi.getConnectionInfo();
//        if (info != null && !StringUtils.isEmpty(info.getMacAddress())) {
//            mac = info.getMacAddress();
//        }
//        return mac;
//
//    }

    /**
     * 获得路由器Mac地址 *
     */
//    public static String getBSSID() {
//        WifiManager wm = (WifiManager) getSystemService(Context.WIFI_SERVICE);
//        WifiInfo info = wm.getConnectionInfo();
//
//        return info.getBSSID();
//    }

    /**
     * 获得基站id
//     */
//    public static int getCellid() {
//        TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
//        int cellid = 0;
//
//        if (tm.getCellLocation() instanceof GsmCellLocation) {
//            GsmCellLocation location = (GsmCellLocation) tm.getCellLocation();
//            cellid = location.getCid();
//        } else if (tm.getCellLocation() instanceof CdmaCellLocation) {
//            CdmaCellLocation location = (CdmaCellLocation) tm.getCellLocation();
//            cellid = location.getBaseStationId();
//        }
//
//        return cellid;
//    }

//    public static String getIMSI() {
//        TelephonyManager telephonyManager = (TelephonyManager) applicationContext
//                .getSystemService(Context.TELEPHONY_SERVICE);
//        return telephonyManager.getSimSerialNumber();
//    }

    /**
     * 基带版本
     *
     * @return
     */
    public static String getBaseband() {
        try {
            Class cl = Class.forName("android.os.SystemProperties");
            Object invoker = cl.newInstance();
            Method m = cl.getMethod("get", new Class[] { String.class,
                    String.class });
            Object result = m.invoke(invoker, new Object[] {
                    "gsm.version.baseband", "no message" });
            if (result != null) {
                return result.toString();
            }
        } catch (Throwable e) {
        }
        return null;
    }

    /**
     * 获得手机型号
     */
    public static String getModle() {
        return Build.MODEL;
    }

    /**
     * 获得手机品牌
     */
    public static String getBrand() {
        return Build.BRAND;

    }

    /**
     * 语音是否使用系统播放AMR格式 *
     */
    public static boolean AUDIO_PLAY_USE_AMR_MODE = false;

    static {
        if ("GT-I9100".equals(getModle()) || "GT-I9100G".equals(getModle())) {
            AUDIO_PLAY_USE_AMR_MODE = true;
        }
    }

    /**
     * 获得手机固件编译版本
     */
    public static String getFirmwareVersion() {
        // htc_asia_wwe/htc_pyramid/pyramid:2.3.3/GRI40/84734:user/release-keys
        String version = Build.FINGERPRINT;
        int index = version.lastIndexOf(":");
        if (index > 0) {
            String subString = version.substring(0, index);
            String[] strs = subString.split("/");
            if (strs.length > 2) {
                version = "";
                version += strs[strs.length - 2] + "/";
                version += strs[strs.length - 1];
            }
        }
        return version;

    }

    /**
     * 对指定字符串进行MD5加密
     */
    public static String getMd5Value(String sSecret) {
        try {
            MessageDigest bmd5 = MessageDigest.getInstance("MD5");
            bmd5.update(sSecret.getBytes());
            int i;
            StringBuffer buf = new StringBuffer();
            byte[] b = bmd5.digest();
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            return buf.toString();
        } catch (NoSuchAlgorithmException e) {
        }
        return "";
    }

    /**
     * 获取屏幕分辨率宽度 *
     */
    public static int getScreenWidth() {
        return getDisplayMetrics().widthPixels;
    }

    /**
     * 获取屏幕分辨率高度 *
     */
    public static int getScreenHeight() {
        return getDisplayMetrics().heightPixels;
    }

    /**
     * 获取当前系统的国家代号字符串 *
     */
    public static String getSystemCountry() {
        return Locale.getDefault().getCountry();
    }

    /**
     * 获取当前系统的语言代号字符串 *
     */
    public static String getSystemLanguage() {
        return Locale.getDefault().getLanguage();
    }

    public static final int PHONE_TYPE_GSM = TelephonyManager.PHONE_TYPE_GSM;
    public static final int PHONE_TYPE_CDMA = TelephonyManager.PHONE_TYPE_CDMA;
    public static final int PHONE_TYPE_NONE = TelephonyManager.PHONE_TYPE_NONE;
    public static final int PHONE_TYPE_SIP = TelephonyManager.PHONE_TYPE_SIP;

    /**
     * 获取手机类型 返回cdma/gsm/sip 如果没有获取到则返回null
     *
     * @return
     */
    public static int getPhoneType() {
        TelephonyManager tm = (TelephonyManager) applicationContext
                .getSystemService(Context.TELEPHONY_SERVICE);
        if (tm != null) {
            return tm.getPhoneType();
        }
        return -1;
    }

    /**
     * 判断当前手机是否是CDMA *
     */
    public static boolean isCDMAPhone() {
        return getPhoneType() == PHONE_TYPE_CDMA;
    }

    public static String getPhoneTypeByRadio() {
        int type = getPhoneType();
        if (type == PHONE_TYPE_CDMA) {
            return "CDMA";
        } else if (type == PHONE_TYPE_GSM) {
            return "GSM";
        } else if (type == PHONE_TYPE_SIP) {
            return "SIP";
        } else if (type == PHONE_TYPE_NONE) {
            return "UNKNOW";
        }

        return "UNKNOW";
    }

    /**
     * 获取本地手机号码 *
     */
//    public static String getPhoneNumber() {
//        TelephonyManager tm = (TelephonyManager) applicationContext
//                .getSystemService(Context.TELEPHONY_SERVICE);
//        if (tm != null) {
//            return tm.getLine1Number();
//        }
//        return "";
//    }

    public static String getSimOperatorNumber() {
        TelephonyManager tm = (TelephonyManager) applicationContext
                .getSystemService(Context.TELEPHONY_SERVICE);
        if (tm != null) {
            return tm.getSimOperator();
        }
        return "";
    }

    /**
     * 获得移动运营商名称
     *
     * @return
     */
    public static String getSimOperatorName() {
        TelephonyManager tm = (TelephonyManager) applicationContext
                .getSystemService(Context.TELEPHONY_SERVICE);
        if (tm != null) {
            return tm.getNetworkOperatorName();
        }
        return "UNKNOW";
    }

    public static String getSmsPayOperator() {
        String opName = getSimOperatorNumber();
        if ("46001".equals(opName) || "46006".equals(opName)) {
            return "unicom";
        } else if ("46000".equals(opName) || "46002".equals(opName)
                || "46007".equals(opName)) {
            return "mobile";
        } else if ("46003".equals(opName) || "46005".equals(opName)) {
            return "telecom";
        } else {
            return "";
        }
    }

    public static String getOperatorStrForReferee() {
        String opName = getSimOperatorNumber();
        if ("46001".equals(opName) || "46006".equals(opName)) {
            return "cnc";
        } else if ("46000".equals(opName) || "46002".equals(opName)
                || "46007".equals(opName)) {
            return "cmcc";
        } else if ("46003".equals(opName) || "46005".equals(opName)) {
            return "ctc";
        } else {
            return "other";
        }
    }

//    public static String getSimSubscriberId() {
//        TelephonyManager tm = (TelephonyManager) applicationContext
//                .getSystemService(Context.TELEPHONY_SERVICE);
//        if (tm != null) {
//            return tm.getSubscriberId();
//        }
//        return "";
//    }

    /**
     * 是否包含sim卡
     *
     * @return
     */
    public static boolean isHasSimCard() {
        TelephonyManager tm = (TelephonyManager) applicationContext
                .getSystemService(Context.TELEPHONY_SERVICE);
        if (tm != null) {
            return tm.getSimState() != TelephonyManager.SIM_STATE_ABSENT;
        }
        return false;
    }

    public static String getRadioDetail() {
        TelephonyManager tm = (TelephonyManager) applicationContext
                .getSystemService(Context.TELEPHONY_SERVICE);
        return tm.getNetworkType() + "";

    }

    /**
     * 解析图片文件，返回图片对象。根据设备自动调整图片大小
     *
     * @param file
     * @return
     */
    public static Bitmap decodeResourceBitmap(File file, int resid) {
        if (!file.exists()) {
            return null;
        }
        try {
            return decodeResourceBitmap(new FileInputStream(file), resid);
        } catch (FileNotFoundException e) {
        }
        return null;
    }

    public static Bitmap decodeResourceBitmap(InputStream is, int resId) {
        try {
            if (resId < 0) {
                resId = R.drawable.icon;
            }

            Rect pad = new Rect();
            BitmapFactory.Options opts = new BitmapFactory.Options();
            opts.inScreenDensity = getDisplayMetrics().densityDpi;
            TypedValue value = new TypedValue();
            Resources resources = getResources();
            resources.getValue(resId, value, false);

            final int density = value.density;
            if (density == TypedValue.DENSITY_DEFAULT) {
                opts.inDensity = DisplayMetrics.DENSITY_DEFAULT;
            } else if (density != TypedValue.DENSITY_NONE) {
                opts.inDensity = density;
            }
            opts.inTargetDensity = resources.getDisplayMetrics().densityDpi;

            Bitmap bitmap = BitmapFactory.decodeStream(is, pad, opts);
            is.close();
            return bitmap;
        } catch (Throwable e) {
        }

        return null;
    }

    public static String getIpAddress() {
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface
                    .getNetworkInterfaces(); en.hasMoreElements();) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf
                        .getInetAddresses(); enumIpAddr.hasMoreElements();) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    String ip = inetAddress.getHostAddress();
                    String[] splits = ip.split("\\.");
                    if (!inetAddress.isLoopbackAddress()
                            && !inetAddress.isLinkLocalAddress()) {
                        try {
                            Integer.parseInt(splits[0]);
                            return ip;
                        } catch (Exception e) {
                        }
                    }
                }
            }
        } catch (Exception e) {
        }

        return "";
    }

    /**
     * 获得指定apk文件的签名信息
     *
     * @param apkPath
     * @return
     * @throws Exception
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static Signature getApkSignature(String apkPath) throws Exception {
        if (getAndroidApiLevel() < 21) {
            Class clazz = Class.forName("android.content.pm.PackageParser");
            Method method = clazz.getMethod("parsePackage", File.class,
                    String.class, DisplayMetrics.class, int.class);

            Object packageParser = clazz.getConstructor(String.class)
                    .newInstance("");
            Object packag = method.invoke(packageParser, new File(apkPath),
                    null, getContext().getResources().getDisplayMetrics(),
                    0x0004);

            method = clazz.getMethod("collectCertificates",
                    Class.forName("android.content.pm.PackageParser$Package"),
                    int.class);
            method.invoke(packageParser, packag, PackageManager.GET_SIGNATURES);

            Signature mSignatures[] = (Signature[]) packag.getClass()
                    .getField("mSignatures").get(packag);
            return mSignatures.length > 0 ? mSignatures[0] : null;
        } else {
            PackageManager pm = getApp().getPackageManager();
            PackageInfo pkgInfo = pm.getPackageInfo(getApp().getPackageName(),
                    PackageManager.GET_SIGNATURES);
            Signature[] signatures = pkgInfo.signatures;
            return signatures.length > 0 ? signatures[0] : null;
        }

    }

    /**
     * wifi网络 *
     */
    public static final String NETWORK_TYPE_WIFI = "wifi";
    /**
     * 手机网络 *
     */
    public static final String NETWORK_TYPE_MOBILE = "mobile";

    /**
     * 2g网络 *
     */
    public static final String NETWORK_CLASS_2G = "2g";
    /**
     * 3g网络 *
     */
    public static final String NETWORK_CLASS_3G = "3g";
    /**
     * 4g网络 *
     */
    public static final String NETWORK_CLASS_4G = "4g";

    public static final String NETWORK_CLASS_UNKNOWN = "unknown";

    /**
     * 网络类型，6.3c新增，部分接口统计网络质量
     * */
    private static final int NETWORK_STATUS_UNKNOWN = -1;
    private static final int NETWORK_STATUS_WIFI = 1;
    private static final int NETWORK_STATUS_2G = 2;
    private static final int NETWORK_STATUS_3G = 3;
    private static final int NETWORK_STATUS_4G = 4;

    public static int getNetWorkStatus() {
        ConnectivityManager connManager = (ConnectivityManager) applicationContext
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetInfo = connManager.getActiveNetworkInfo();// 获取网络的连接情况
        if (activeNetInfo != null) {
            if (activeNetInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                return NETWORK_STATUS_WIFI;
            } else if (activeNetInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
                return getNetWorkStatus(activeNetInfo.getSubtype());
            }
        }

        return NETWORK_STATUS_UNKNOWN;
    }

    private static int getNetWorkStatus(int networkType) {
        switch (networkType) {
            case TelephonyManager.NETWORK_TYPE_GPRS:
            case TelephonyManager.NETWORK_TYPE_EDGE:
            case TelephonyManager.NETWORK_TYPE_CDMA:
            case TelephonyManager.NETWORK_TYPE_1xRTT:
            case TelephonyManager.NETWORK_TYPE_IDEN:
                return NETWORK_STATUS_2G;
            case TelephonyManager.NETWORK_TYPE_UMTS:
            case TelephonyManager.NETWORK_TYPE_EVDO_0:
            case TelephonyManager.NETWORK_TYPE_EVDO_A:
            case TelephonyManager.NETWORK_TYPE_HSDPA:
            case TelephonyManager.NETWORK_TYPE_HSUPA:
            case TelephonyManager.NETWORK_TYPE_HSPA:
            case TelephonyManager.NETWORK_TYPE_EVDO_B:
            case TelephonyManager.NETWORK_TYPE_EHRPD:
            case TelephonyManager.NETWORK_TYPE_HSPAP:
                return NETWORK_STATUS_3G;
            case TelephonyManager.NETWORK_TYPE_LTE:
                return NETWORK_STATUS_4G;
            default:
                return NETWORK_STATUS_UNKNOWN;
        }
    }

    /**
     * 获取当前网络类型 *
     */
    public static String getNetWorkType() {
        ConnectivityManager connManager = (ConnectivityManager) applicationContext
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetInfo = connManager.getActiveNetworkInfo();// 获取网络的连接情况
        if (activeNetInfo != null) {
            if (activeNetInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                return NETWORK_TYPE_WIFI;
            } else if (activeNetInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
                return NETWORK_TYPE_MOBILE;
            }
        }
        return null;
    }

    /**
     * 获取当前网络2G/3G/4G *
     */
    public static String getNetWorkClass() {
        ConnectivityManager connManager = (ConnectivityManager) applicationContext
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetInfo = connManager.getActiveNetworkInfo();// 获取网络的连接情况
        if (activeNetInfo != null) {
            if (activeNetInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                return NETWORK_TYPE_WIFI;
            } else if (activeNetInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
                return getNetworkClass(activeNetInfo.getSubtype());
            }
        }

        return null;
    }

    private static String getNetworkClass(int networkType) {
        switch (networkType) {
            case TelephonyManager.NETWORK_TYPE_GPRS:
            case TelephonyManager.NETWORK_TYPE_EDGE:
            case TelephonyManager.NETWORK_TYPE_CDMA:
            case TelephonyManager.NETWORK_TYPE_1xRTT:
            case TelephonyManager.NETWORK_TYPE_IDEN:
                return NETWORK_CLASS_2G;
            case TelephonyManager.NETWORK_TYPE_UMTS:
            case TelephonyManager.NETWORK_TYPE_EVDO_0:
            case TelephonyManager.NETWORK_TYPE_EVDO_A:
            case TelephonyManager.NETWORK_TYPE_HSDPA:
            case TelephonyManager.NETWORK_TYPE_HSUPA:
            case TelephonyManager.NETWORK_TYPE_HSPA:
            case TelephonyManager.NETWORK_TYPE_EVDO_B:
            case TelephonyManager.NETWORK_TYPE_EHRPD:
            case TelephonyManager.NETWORK_TYPE_HSPAP:
                return NETWORK_CLASS_3G;
            case TelephonyManager.NETWORK_TYPE_LTE:
                return NETWORK_CLASS_4G;
            default:
                return NETWORK_CLASS_UNKNOWN;
        }
    }

    /**
     * @return
     * @see ConnectivityManager#TYPE_MOBILE
     * @see ConnectivityManager#TYPE_WIFI
     */
    public static int getNetType() {
        try {
            ConnectivityManager connManager = (ConnectivityManager) applicationContext
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetInfo = connManager.getActiveNetworkInfo();
            if (activeNetInfo != null) {
                return activeNetInfo.getType();
            }
        } catch (Exception e) {
        }
        return -1;
    }

    /**
     * @return
     * @see TelephonyManager#NETWORK_TYPE_CDMA
     * @see TelephonyManager#NETWORK_TYPE_EDGE
     * @see TelephonyManager#NETWORK_TYPE_GPRS
     */
    public static int getMobileNetType() {
        try {
            TelephonyManager manager = (TelephonyManager) getContext()
                    .getSystemService(Context.TELEPHONY_SERVICE);
            return manager.getNetworkType();
        } catch (Exception e) {
        }
        return -1;
    }

    /**
     * 当前是WIFI网络，而不是移动网络 *
     */
    public static boolean isWifi() {
        return NETWORK_TYPE_WIFI.equals(getNetWorkType());
    }

    /**
     * 当前是移动网络，而不是WIFI网络 *
     */
    public static boolean isMobile() {
        return NETWORK_TYPE_MOBILE.equals(getNetWorkType());
    }

    public static final String CTWAP = "ctwap";
    public static final String CMWAP = "cmwap";
    public static final String WAP_3G = "3gwap";
    public static final String UNIWAP = "uniwap";
    public static final String WIFI = "uniwap";

    public static final int TYPE_NET_WORK_DISABLED = 0;// 网络不可用
    public static final int WAP_TYPE_CM = 1;// 移动wap
    public static final int WAP_TYPE_3G = 2;// 3gwap 联通3G wap
    public static final int WAP_TYPE_UNI = 3;// 联通2G wap
    public static final int WAP_TYPE_CT = 5;// 电信wap 10.0.0.200
    public static final int TYPE_OTHER_NET = 6;// 电信,移动,联通,wifi 等net网络
    public static Uri PREFERRED_APN_URI = Uri
            .parse("content://telephony/carriers/preferapn");

    /**
     * 获取手机APN接入点类型 *
     */
    public static int getAPNPointType() {
        int type = -1;
        try {
            final ConnectivityManager connectivityManager = (ConnectivityManager) applicationContext
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            final NetworkInfo mobNetInfoActivity = connectivityManager
                    .getActiveNetworkInfo();
            if (mobNetInfoActivity == null || !mobNetInfoActivity.isAvailable()) {

				/*
				 * 注意一： NetworkInfo 为空或者不可以用的时候正常情况应该是当前没有可用网络，
				 * 但是有些电信机器，仍可以正常联网， 所以当成net网络处理依然尝试连接网络。
				 * （然后在socket中捕捉异常，进行二次判断与用户提示）
				 */
                type = TYPE_NET_WORK_DISABLED;
            } else {
                int netType = mobNetInfoActivity.getType();
                if (netType == ConnectivityManager.TYPE_WIFI) {
                    type = TYPE_OTHER_NET;
                } else if (netType == ConnectivityManager.TYPE_MOBILE) {

					/*
					 * 注意二： 判断是否电信wap: 不要通过getExtraInfo获取接入点名称来判断类型，
					 * 因为通过目前电信多种机型测试发现接入点名称大都为#777或者null，
					 * 电信机器wap接入点中要比移动联通wap接入点多设置一个用户名和密码, 所以可以通过这个进行判断！
					 */

                    final Cursor c = applicationContext.getContentResolver()
                            .query(PREFERRED_APN_URI, null, null, null, null);
                    if (c != null) {
                        c.moveToFirst();
                        final String user = c.getString(c
                                .getColumnIndex("user"));
                        if (!TextUtils.isEmpty(user)) {
                            if (user.startsWith(CTWAP)) {
                                type = WAP_TYPE_CT;
                            }
                        }
                        c.close();
                    }

					/*
					 * 注意三： 判断是移动联通wap:
					 * 其实还有一种方法通过getString(c.getColumnIndex("proxy")获取代理ip
					 * 来判断接入点，10.0.0.172就是移动联通wap，10.0.0.200就是电信wap，但在
					 * 实际开发中并不是所有机器都能获取到接入点代理信息，例如魅族M9 （2.2）等...
					 * 所以采用getExtraInfo获取接入点名字进行判断
					 */

                    String netMode = mobNetInfoActivity.getExtraInfo();
                    if (netMode != null) {
                        netMode = netMode.toLowerCase();
                        if (netMode.equals(CMWAP)) {
                            type = WAP_TYPE_CM;
                        } else if (netMode.equals(WAP_3G)) {
                            type = WAP_TYPE_3G;
                        } else if (netMode.equals(UNIWAP)) {
                            type = WAP_TYPE_UNI;
                        }
                    }

                }
            }
        } catch (Exception ex) {
            type = TYPE_OTHER_NET;
        }
        return type;
    }

    public static boolean isWap() {
        int apnType = getAPNPointType();
        return (apnType == WAP_TYPE_3G || apnType == WAP_TYPE_CM
                || apnType == WAP_TYPE_CT || apnType == WAP_TYPE_UNI);
    }

    /**
     * 检测是否为cmwap网络模式
     *
     * @return
     */
    public static boolean isCMWAP() {
        String currentAPN = "";
        ConnectivityManager conManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = conManager
                .getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        currentAPN = info.getExtraInfo();
        if (currentAPN == null || currentAPN == "") {
            return false;
        } else {
            if (currentAPN.toLowerCase().equals("cmwap")) {
                return true;
            } else {
                return false;
            }

        }
    }

//    public static boolean isWifiOpen() {
//        WifiManager mWifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
//        if (mWifiManager != null && mWifiManager.isWifiEnabled()) {
//            return true;
//        } else {
//            return false;
//        }
//    }

    /**
     * 获取CPU字符串
     *
     * @return
     */
    private static String getCpuString() {
        if (Build.CPU_ABI.equalsIgnoreCase("x86")) {
            return "Intel";
        }

        String strInfo = getCpuName() + getMaxCpuFreq() + getMinCpuFreq();

        return strInfo;
    }

    /**
     * 获取内存值大小
     *
     * @return
     */
    private static long getTotalMemory() {
        String str1 = "/proc/meminfo";
        String str2;
        String[] arrayOfString;
        long initial_memory = 0;
        try {
            FileReader localFileReader = new FileReader(str1);
            BufferedReader localBufferedReader = new BufferedReader(
                    localFileReader, 8192);
            str2 = localBufferedReader.readLine();
            if (str2 != null) {
                arrayOfString = str2.split("\\s+");
                initial_memory = Integer.valueOf(arrayOfString[1]).intValue() / 1024;
            }
            localBufferedReader.close();
            return initial_memory;
        } catch (Throwable e) {
            return -1;
        }
    }

    /**
     * 获取摄像头数量
     *
     * @return
     */
    public static int getCameraNumbers() {
        return Camera.getNumberOfCameras();
    }

    /**
     * 传感器
     */
//    public static String getSensorInfo() {
//        try {
//            SensorManager sm = (SensorManager) getSystemService(getContext().SENSOR_SERVICE);
//            Sensor sensor = sm.getDefaultSensor(Sensor.TYPE_ORIENTATION);
//
//            String orSensor = sensor.getName();
//
//            Sensor sensor1 = sm.getDefaultSensor(Sensor.TYPE_GRAVITY);
//            String gSensor = sensor1.getName();
//
//            if ((!StringUtils.isEmpty(orSensor))
//                    && (!StringUtils.isEmpty(gSensor))) {
//                return orSensor + gSensor;
//            } else if (!StringUtils.isEmpty(orSensor)) {
//                return orSensor;
//            } else if (!StringUtils.isEmpty(gSensor)) {
//                return gSensor;
//            }
//        } catch (Throwable e) {
//            e.printStackTrace();
//        }
//        return "unknown";
//    }

//    public static String getHwInfo() {
//        String info = getIMEI() + getTotalMemory() + getBaseband()
//                + getScreenWidth() + getScreenHeight() + getScreenDensity()
//                + getSensorInfo();
//
//        String result = getMd5Value(info);
//        return result;
//    }

    private static String getCpuName() {
        try {
            FileReader fr = new FileReader("/proc/cpuinfo");
            BufferedReader br = new BufferedReader(fr);
            String text = br.readLine();
            String[] array = text.split(":\\s+", 2);
            for (int i = 0; i < array.length; i++) {
            }
            return array[1];
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getMaxCpuFreq() {
        String result = "";
        ProcessBuilder cmd;
        try {
            String[] args = { "/system/bin/cat",
                    "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq" };
            cmd = new ProcessBuilder(args);
            Process process = cmd.start();
            InputStream in = process.getInputStream();
            byte[] re = new byte[24];
            while (in.read(re) != -1) {
                result = result + new String(re);
            }
            in.close();
        } catch (IOException ex) {
            ex.printStackTrace();
            result = "N/A";
        }
        return result.trim();
    }

    private static String getMinCpuFreq() {
        String result = "";
        ProcessBuilder cmd;
        try {
            String[] args = { "/system/bin/cat",
                    "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq" };
            cmd = new ProcessBuilder(args);
            Process process = cmd.start();
            InputStream in = process.getInputStream();
            byte[] re = new byte[24];
            while (in.read(re) != -1) {
                result = result + new String(re);
            }
            in.close();
        } catch (IOException ex) {
            ex.printStackTrace();
            result = "N/A";
        }
        return result.trim();
    }

    /**
     * 判断字符串是否为Email格式
     *
     * @param email
     * @return
     */
    public static boolean isEmailFormat(String email) {
        Pattern pattern = Pattern.compile("\\w[\\w.-]*@[\\w.-]+\\.\\w+");
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            return false;
        }
        return true;
    }

    /**
     * 是否是数字
     *
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }

    /**
     * 按照指定的字节数截取字符串(GBK)
     *
     * @param str
     *            要截取的字符串
     * @param subSLength
     *            要截取的字节数
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String subStr(String str, int subSLength)
            throws UnsupportedEncodingException {
        if (str == null)
            return "";
        else {
            int tempSubLength = subSLength;// 截取字节数
            String subStr = str.substring(0,
                    str.length() < subSLength ? str.length() : subSLength);// 截取的子串
            int subStrByetsL = subStr.getBytes("GBK").length;// 截取子串的字节长度
            // int subStrByetsL = subStr.getBytes().length;//截取子串的字节长度
            // 说明截取的字符串中包含有汉字
            while (subStrByetsL > tempSubLength) {
                int subSLengthTemp = --subSLength;
                subStr = str.substring(0,
                        subSLengthTemp > str.length() ? str.length()
                                : subSLengthTemp);
                subStrByetsL = subStr.getBytes("GBK").length;
                // subStrByetsL = subStr.getBytes().length;
            }
            return subStr;
        }
    }

    public static int parseColor(String color) {
        if (!TextUtils.isEmpty(color)) {
            String[] rgbs = color.split(",");
            int[] rgb_int = new int[3];
            try {
                rgb_int[0] = Integer.parseInt(rgbs[0]);
                rgb_int[1] = Integer.parseInt(rgbs[1]);
                rgb_int[2] = Integer.parseInt(rgbs[2]);
                return Color.rgb(rgb_int[0], rgb_int[1], rgb_int[2]);
            } catch (Exception e) {
            }
        }
        return Color.rgb(22, 154, 255);
    }

    public static String urlEncodeString(String src) {
        String result = "";
        try {
            result = URLEncoder.encode(src, Setting.URL_ENCODE);
        } catch (Throwable e) {
        }
        return result;
    }

    public static String urlDecodeString(String src) {
        String result = "";
        try {
            result = URLDecoder.decode(src, Setting.URL_ENCODE);
        } catch (Throwable e) {
        }
        return result;
    }

    /**
     * 获取状态栏高度
     *
     * @return
     */
    public static int getStatusBarHeight(Activity activity) {
        if (activity == null) {
            return 0;
        }
        Rect rectangle = new Rect();
        Window window = activity.getWindow();
        window.getDecorView().getWindowVisibleDisplayFrame(rectangle);
        return rectangle.top;
    }

    /**
     * 判断一个字符串是否为json格式
     *
     * @param string
     * @return
     */
    public static boolean isJSONString(String string) {
        try {
            JSONObject json = new JSONObject(string);
            json = null;
            return true;
        } catch (Exception e) {
            return false;
        }
    }
//    public static void executeRunnable(Runnable run){
//        getApp().getServiceManager().executeThreadPool(run);
//    }
//    public static PageManager getPM(){
//        return getApp().getPageManager();
//    }
    public static String getPhoneMode(){
        return android.os.Build.MODEL.trim();
    }
}
