package com.example.wangyang.tinnerwangyang.ViewHolder;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.example.wangyang.tinnerwangyang.Activity.BigImageActivity;
import com.example.wangyang.tinnerwangyang.Adapter.BaseRecyclerAdapter;
import com.example.wangyang.tinnerwangyang.Bean.Photos;
import com.example.wangyang.tinnerwangyang.Bean.PostsBean;
import com.example.wangyang.tinnerwangyang.Bean.UrlSettingBean;
import com.example.wangyang.tinnerwangyang.Bean.UserBean;
import com.example.wangyang.tinnerwangyang.Wachter;
import com.example.wangyang.tinnerwangyang.databinding.LayoutPostsbeanBinding;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by wangyang on 18/1/18.
 */

public class ViewPostsBeansItemHolder extends BaseRecyclerHolder<PostsBean, LayoutPostsbeanBinding> {
    private static final String TAG = ViewPostsBeansItemHolder.class.getSimpleName();
    private BaseRecyclerAdapter adapter;
    private List<String> list=new ArrayList<>();
    private UrlSettingBean urlSettingBean;
    public ViewPostsBeansItemHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setUpView(PostsBean model, int position, BaseRecyclerAdapter adapter) {
        Intent intent=new Intent();
        intent.putStringArrayListExtra("imageurl", (ArrayList<String>) list);
        intent.setAction("com.image");
        context.sendBroadcast(intent);
        UserBean userBean = model.getUser();
        bindView.setUserbean(userBean);
        bindView.setPosts(model);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        String s = model.getCreated_at().substring(0, 19);
       // String s1=model.getCreated_at().substring()
        try {
            Date d1 = df.parse(df.format(new Date()));
            Date d2 = df.parse(s);
            long diff = d1.getTime() - d2.getTime();//这样得到的差值是微秒级别
            long days = diff / (1000 * 60 * 60 * 24);
            long hours = (diff - days * (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
            long minutes = (diff - days * (1000 * 60 * 60 * 24) - hours * (1000 * 60 * 60)) / (1000 * 60);
            if (hours<1){
                String sss = ( minutes + "分钟前");
                bindView.textTime.setText(sss);
            }else {
                String sss = (hours + "小时" + minutes + "分钟前");
                bindView.textTime.setText(sss);
            }

//            "" + days + "天"

        } catch (ParseException e) {
            e.printStackTrace();
        }
        initData(model);
    }

    private void initData(PostsBean m) {
        List<Wachter> list = new ArrayList<>();
        adapter = new BaseRecyclerAdapter(context);
        bindView.recycleImage.setAdapter(adapter);
        bindView.recycleImage.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        list.addAll(m.getPhotos());
        adapter.addData(list);
    }


}
