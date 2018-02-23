package com.lib.Manager;

import android.util.Log;

import com.example.wangyang.tinnerwangyang.Bean.RecommendBean;
import com.example.wangyang.tinnerwangyang.Exit.Constant;
import com.example.wangyang.tinnerwangyang.Exit.ECKit;
import com.example.wangyang.tinnerwangyang.common.Result;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by wangyang on 31/1/18.
 */

public class FileUtils {
    private static String TAG = FileUtils.class.getSimpleName();
    private static RecommendBean recommendBean;
    private static Result result;

    public static RecommendBean getRecommendData() {
        StringBuffer sb = new StringBuffer();
        try {
            InputStream in = ECKit.getApp().getAssets().open("recommend.json");
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            recommendBean = Constant.GSON.fromJson(sb.toString(), Constant.TYPE_RECOMMEND);
            br.close();
            in.close();
            Log.i(TAG, String.valueOf(recommendBean));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return recommendBean;

    }

    public static Result getKnowledgesData() {
        StringBuffer sb = new StringBuffer();
        try {
            InputStream in = ECKit.getApp().getAssets().open("Knowledges.json");
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            result = Constant.GSON.fromJson(sb.toString(), Constant.TYPE_RESULT_NEWBEAN);
            br.close();
            in.close();
            Log.i(TAG, String.valueOf(result));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;

    }

    public static Result getSuccessData() {
        StringBuffer sb = new StringBuffer();
        try {
            InputStream in = ECKit.getApp().getAssets().open("Success.json");
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            result = Constant.GSON.fromJson(sb.toString(), Constant.TYPE_RESULT_ITEMBEANS);
            br.close();
            in.close();
            Log.i(TAG, String.valueOf(result));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;

    }

    public static Result getPostsData() {
        StringBuffer sb = new StringBuffer();
        try {
            InputStream in = ECKit.getApp().getAssets().open("Posts.json");
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            result = Constant.GSON.fromJson(sb.toString(), Constant.TYPE_RESULT_POSTSBEANS);
            br.close();
            in.close();
            Log.i(TAG, String.valueOf(result));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;

    }

    public static Result getPrincipleData() {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            InputStream inputStream = ECKit.getApp().getAssets().open("principle.json");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while ((line = reader.readLine()) != null) {
                stringBuffer.append(line);
            }
            result = Constant.GSON.fromJson(stringBuffer.toString(), Constant.TYPE_RESULT_NEWBEAN);
            reader.close();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Result getResultSportsData() {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            InputStream inputStream = ECKit.getApp().getAssets().open("sports.json");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while ((line = reader.readLine()) != null) {
                stringBuffer.append(line);
            }
            result = Constant.GSON.fromJson(stringBuffer.toString(), Constant.TYPE_RESULT_NEWBEAN);
            reader.close();
            inputStream.close();

        } catch (Exception e) {

        }
        return result;
    }
}
