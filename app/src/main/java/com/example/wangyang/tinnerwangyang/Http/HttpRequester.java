package com.example.wangyang.tinnerwangyang.Http;

/**
 * Created by wangyang on 3/1/18.
 */

import com.example.wangyang.tinnerwangyang.Exit.ECKit;
import com.example.wangyang.tinnerwangyang.R;
import com.example.wangyang.tinnerwangyang.common.ConnectionMgr;
import com.example.wangyang.tinnerwangyang.common.FormFile;
import com.example.wangyang.tinnerwangyang.common.IOUtils;
import com.example.wangyang.tinnerwangyang.common.NetworkUnavailableException;
import com.example.wangyang.tinnerwangyang.common.Setting;
import com.example.wangyang.tinnerwangyang.common.URLProcessUtil;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.SSLException;

/**
 * HTTP 协议请求
 */


/**
 * HTTP 协议请求
 */
public class HttpRequester {
    private static final int TIMEOUT_CONNECTION = 5 * 1000; // 连接超时时间
    private static final int TIMEOUT_READ = 15 * 1000; // 读取超时时间

    /**
     * 直接通过HTTP协议提交数据到服务器,实现如下面表单提交功能:
     *
     * @param url
     *            上传路径
     * @param params
     *            请求参数 key为参数名,value为参数值
     * @param files
     *            要上传文件
     *
     */
    public static byte[] post(String url, Map<String, String> params,
                              FormFile[] files, Map<String, String> headers) throws Exception {
        // TODO将来需要加重试次数和流量限制
        HttpURLConnection connection = null;
        try {
            connection = postConnection(url, params, files, headers);
            int responseCode = connection.getResponseCode();
            if (responseCode >= 200 && responseCode < 299) {
                InputStream inStream = new BufferedInputStream(
                        connection.getInputStream());
                ByteArrayOutputStream outSteam = new ByteArrayOutputStream(2048);
                try {
                    byte[] buffer = new byte[2048];
                    int len = -1;
                    while ((len = inStream.read(buffer)) != -1) {
                        outSteam.write(buffer, 0, len);
                    }
                } finally {
                    IOUtils.closeQuietly(outSteam);
                    IOUtils.closeQuietly(inStream);
                }

                byte[] result = outSteam.toByteArray();
                ConnectionMgr.getInstance().removeActiveConnection(connection);
                return result;

            } else {
                throw new HttpResponseStatusErrorException(responseCode);
            }
        } catch (NetworkUnavailableException e) {
            throw e;
        } catch (SocketTimeoutException e) {
            HttpTimeoutException timeoutException = new HttpTimeoutException();
            throw timeoutException;
        } catch (Exception e) {
            if (e instanceof HttpResponseStatusErrorException) {
                HttpResponseStatusErrorException statusErrorException = (HttpResponseStatusErrorException) e;
                if (statusErrorException.statusCode > 0
                        && statusErrorException.statusCode < 500) {
                    throw e;
                }
            }
        } finally {
            if (connection != null) {
                ConnectionMgr.getInstance().removeActiveConnection(connection);
                connection.disconnect();
            }
        }

        throw new HttpBaseException(
                ECKit.getString(R.string.msg_toast_err_network));
    }

    /**
     * 发起Get请求
     *
     * @param url
     * @param params
     * @param header
     * @return
     * @throws Exception
     */
    public static byte[] get(String url, Map<String, String> params,
                             Map<String, String> header) throws Exception {
        // TODO将来需要加重试次数和流量限制
        Map<String, String> headers2 = new HashMap<String, String>();

        if (header != null) {
            headers2.putAll(header);
        }
        HttpURLConnection connection = getConnection(url, params, headers2);
        try {

            int statusCode = connection.getResponseCode();
            if (statusCode >= 200 && statusCode < 299) {
                InputStream inStream = new BufferedInputStream(
                        connection.getInputStream());
                byte[] result = readStream(inStream);
                ConnectionMgr.getInstance().removeActiveConnection(connection);
                return result;
            } else {
                throw new HttpResponseStatusErrorException(statusCode);
            }

        } catch (HttpResponseStatusErrorException e) {
            throw e;
        } catch (SocketTimeoutException e) {
            HttpTimeoutException timeoutException = new HttpTimeoutException();
            throw timeoutException;
        } catch (NetworkUnavailableException e) {
            throw e;
        } catch (Exception e) {
            if (e instanceof HttpResponseStatusErrorException) {
                HttpResponseStatusErrorException statusErrorException = (HttpResponseStatusErrorException) e;
                if (statusErrorException.statusCode > 0
                        && statusErrorException.statusCode < 500) {
                    throw e;
                }
            }
        } finally {
            if (connection != null) {
                ConnectionMgr.getInstance().removeActiveConnection(connection);
                connection.disconnect();

            }
        }

        throw new HttpBaseException(
                ECKit.getString(R.string.msg_toast_err_network));
    }

    /**
     * 获得Get请求的连接对象
     *
     * @param url
     * @param params
     * @param headers
     * @return
     * @throws Exception
     */
    public static HttpURLConnection getConnection(String url,
                                                  Map<String, String> params, Map<String, String> headers)
            throws Exception {
        // append parameter
        if (!ECKit.isNetworkAvailable()) {
            throw new NetworkUnavailableException();
        }
        if (params != null) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                url = URLProcessUtil.appendParameter(url, entry.getKey(),
                        entry.getValue());
            }
        }

        HttpURLConnection conn = buildURLConnetion(url, headers);
        conn.setConnectTimeout(TIMEOUT_CONNECTION);
        conn.setReadTimeout(TIMEOUT_READ);
        conn.setRequestMethod("GET");

        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                conn.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }

        return conn;
    }

    /**
     * 读取流
     *
     * @param inStream
     * @return 字节数组
     * @throws Exception
     */
    private static byte[] readStream(InputStream inStream) throws Exception {
        ByteArrayOutputStream outSteam = new ByteArrayOutputStream(2048);
        byte[] buffer = new byte[2048];
        int len = -1;
        while ((len = inStream.read(buffer)) != -1) {
            outSteam.write(buffer, 0, len);
        }
        outSteam.close();
        inStream.close();
        return outSteam.toByteArray();
    }

    /**
     * 获得http请求对象，可能走加密通道
     *
     * @param urlAddress
     * @return
     * @throws IOException
     */
    private static HttpURLConnection buildURLConnetion(String urlAddress,
                                                       Map<String, String> header) throws Exception {
        //  未来加入https处理
        URL url = new URL(urlAddress);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        ConnectionMgr.getInstance().addActiveConnection(connection);
        return connection;
    }

    /**
     * 提交请求，请求成功后。 注意，提交方式默认是POST。如果要特殊需要GET请求的地方，请自行设置：<br>
     * conn.setDoInput(true);<br>
     * conn.setRequestMethod("GET");<br>
     *
     * @param urlString
     *            URL地址
     * @param params
     *            文本参数
     * @param files
     *            上传的文件对象
     * @param headers
     *            http请求头
     * @return
     * @throws Exception
     */
    public static HttpURLConnection postConnection(String urlString,
                                                   Map<String, String> params, FormFile[] files,
                                                   Map<String, String> headers) throws Exception {
        if (!ECKit.isNetworkAvailable()) {
            throw new NetworkUnavailableException();
        }
        final String BOUNDARY = "---------------------------7da2137580612"; // 数据分隔线
        final String ENDLINE = "--" + BOUNDARY + "--\r\n";// 数据结束标志
        final String CHARSET = Setting.URL_ENCODE;
        long fileDataLength = 0;
        if (files != null) {
            int i = 0;
            for (FormFile uploadFile : files) {// 得到文件类型数据的总长度
                StringBuilder fileExplain = new StringBuilder();
                fileExplain.append("--");
                fileExplain.append(BOUNDARY);
                fileExplain.append("\r\n");
                fileExplain.append("Content-Disposition: form-data;name=\""
                        + String.format("file%d", i) + "\";filename=\""
                        + uploadFile.getFilname() + "\"\r\n");
                fileExplain.append("Content-Type: "
                        + uploadFile.getContentType() + "\r\n\r\n");
                fileExplain.append("\r\n");
                fileDataLength += fileExplain.length();
                File file = uploadFile.getFile();
                if (file != null) {
                    fileDataLength += file.length();
                } else {
                    fileDataLength += uploadFile.getData().length;
                }
                i++;
            }
        }

        StringBuilder textEntity = new StringBuilder();
        if (params != null) {
            for (Map.Entry<String, String> entry : params.entrySet()) {// 构造文本类型参数的实体数据
                textEntity.append("--");
                textEntity.append(BOUNDARY);
                textEntity.append("\r\n");
                textEntity.append("Content-Disposition: form-data; name=\""
                        + entry.getKey() + "\"\r\n\r\n");
                textEntity.append(entry.getValue());
                textEntity.append("\r\n");
            }
        }

        // 计算传输给服务器的实体数据总长度
        long dataLength = textEntity.toString().getBytes().length
                + fileDataLength;
        if (dataLength > 0) {
            dataLength += ENDLINE.getBytes().length;
        }
        HttpURLConnection connection = buildURLConnetion(urlString, headers);
        // 设置请求头信息
        connection.setDoInput(true);
        connection.setDoOutput(true);
        if (files != null && files.length > 0) {
            connection.setConnectTimeout(TIMEOUT_CONNECTION * (files.length + 1));
            connection.setReadTimeout(TIMEOUT_READ * (files.length + 1));
        } else {
            connection.setConnectTimeout(TIMEOUT_CONNECTION);
            connection.setReadTimeout(TIMEOUT_READ);
        }
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Connection", "Keep-Alive");
        connection.setRequestProperty("Charset", CHARSET);
        connection.setRequestProperty("Content-Type",
                "multipart/form-data; boundary=" + BOUNDARY);
        connection.setRequestProperty("Content-Length", dataLength + "");
        connection.setRequestProperty("Accept-Language", "zh-CN");
        connection.setRequestProperty("Expect", "100-continue");

        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                connection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }

        // 把所有文件类型的实体数据发送出来
        if ((params != null && !params.isEmpty())
                || (files != null && files.length > 0)) {
            OutputStream outStream = null;
            try {
                outStream = new BufferedOutputStream(
                        connection.getOutputStream());
                if (params != null && !params.isEmpty()) {
                    // 把所有文本类型的实体数据发送出来
                    byte[] bytes = textEntity.toString().getBytes();
                    outStream.write(bytes);
                    outStream.flush();
                }

                if (files != null && files.length > 0) {
                    int i = 0;
                    for (FormFile uploadFile : files) {
                        StringBuilder fileEntity = new StringBuilder();
                        fileEntity.append("--");
                        fileEntity.append(BOUNDARY);
                        fileEntity.append("\r\n");
                        fileEntity
                                .append("Content-Disposition: form-data;name=\""
                                        + String.format("file%d", i)
                                        + "\";filename=\""
                                        + uploadFile.getFilname() + "\"\r\n");
                        fileEntity.append("Content-Type: "
                                + uploadFile.getContentType() + "\r\n\r\n");
                        byte[] bytes = fileEntity.toString().getBytes();
                        outStream.write(bytes);

                        InputStream is = null;
                        try {
                            try {
                                is = uploadFile.getInStream();
                            } catch (IOException e) {
                                throw new HttpBaseException("上传的文件无法打开", e);
                            }

                            if (is != null) {
                                byte[] buffer = new byte[2048];
                                int len = 0;
                                while ((len = is.read(buffer)) != -1) {
                                    outStream.write(buffer, 0, len);
                                }
                            } else if (uploadFile.getData() == null) {
                                throw new IllegalArgumentException(
                                        "upload file is null");
                            } else {
                                outStream.write(uploadFile.getData(), 0,
                                        uploadFile.getData().length);
                            }
                            outStream.write("\r\n".getBytes());
                        } finally {
                            if (is != null) {
                                IOUtils.closeQuietly(is);
                            }
                        }
                        i++;
                    }
                    outStream.flush();
                }

                // 下面发送数据结束标志，表示数据已经结束
                byte[] bytes = ENDLINE.getBytes();
                outStream.write(bytes);
                outStream.flush();
            } catch (Exception e) {
                ConnectionMgr.getInstance().removeActiveConnection(connection);
                if (e.getMessage().contains("was not verified")) {
                    throw new SSLException(e);
                }
                throw e;
            } finally {
                IOUtils.closeQuietly(outStream);
            }
        }

        return connection;
    }

    /**
     * 提交一段二进制数据
     *
     * @param url
     * @param bytes
     * @param headers
     * @return
     * @throws Exception
     */
    public static byte[] postConnection(String url, byte[] bytes,
                                        Map<String, String> headers) throws Exception {
        if (!ECKit.isNetworkAvailable()) {
            throw new NetworkUnavailableException();
        }
        HttpURLConnection conn = buildURLConnetion(url, headers);
        try {
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setConnectTimeout(TIMEOUT_CONNECTION);
            conn.setReadTimeout(TIMEOUT_READ);
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("Charset", Setting.URL_ENCODE);
            if (headers != null) {
                for (Map.Entry<String, String> entry : headers.entrySet()) {
                    conn.setRequestProperty(entry.getKey(), entry.getValue());
                }
            }
            conn.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length", bytes.length + "");

            OutputStream outStream = conn.getOutputStream();
            outStream.write(bytes);
            outStream.flush();
            outStream.close();

            byte[] result = readStream(conn.getInputStream());
            conn.disconnect();

            return result;
        } catch (NetworkUnavailableException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }

}