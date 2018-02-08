package com.example.wangyang.tinnerwangyang.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wangyang.tinnerwangyang.ViewHolder.BaseRecyclerHolder;
import com.example.wangyang.tinnerwangyang.R;
import com.example.wangyang.tinnerwangyang.TypeFactoryList;
import com.example.wangyang.tinnerwangyang.Wachter;
import com.youth.banner.WeakHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import rx.Subscription;

/**
 * Created by nanchaodong on 2017/3/7.
 */


/**
 * Created by nanchaodong on 2017/3/7.
 */

public class BaseRecyclerAdapter extends RecyclerView.Adapter<BaseRecyclerHolder> {
    private static final String TAG = "BaseRecyclerAdapter";
    private Context mCtx;
    protected List<Wachter> datas;
    private TypeFactoryList typeFactoryList;
    private String keywords;
    public HashMap<Integer, Integer> positionMap = new HashMap<>();
    private Subscription mSubscription;
    private WeakHandler handler;
    // private StatusItem statusItem;

    public BaseRecyclerAdapter(Context context) {
        this.mCtx = context;
        typeFactoryList = new TypeFactoryList();
        datas = new ArrayList<Wachter>();
        // statusItem = new StatusItem();
    }

    public BaseRecyclerAdapter initHandler() {
        handler = new WeakHandler();
        return this;
    }

    public void showErrorMsg() {
        //  statusItem.setMsg(mCtx.getString(msg));
        //   statusItem.setObj(obj);
        datas.clear();
        //    datas.add(statusItem);
        notifyDataSetChanged();
    }

    public WeakHandler getHandler() {
        return handler;
    }

    public Subscription getmSubscription() {
        return mSubscription;
    }

    public void setmSubscription(Subscription mSubscription) {
        this.mSubscription = mSubscription;
    }

    public <T extends Wachter> void addData(List<T> list) {
        positionMap = new HashMap<>();
        this.datas.clear();
        this.datas.addAll(list);
        notifyItemRangeChanged(0, this.datas.size());
    }

    public <T extends Wachter> void addBean(T t) {
        this.datas.add(t);
        notifyItemInserted(this.datas.size() - 1);
    }

    public void setKeyWords(String keyWords) {
        this.keywords = keyWords;
    }
    public Wachter getBean(int position) {
        return datas.get(position);
    }

    public String getType(int position) {
        return datas.get(position).getType();
    }

    public Context getmCtx() {
        return mCtx;
    }

    public List<Wachter> getDatas() {
        return datas;
    }

    @Override
    public BaseRecyclerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return typeFactoryList.createViewHolder(viewType, itemView);
    }

    @Override
    public void onBindViewHolder(BaseRecyclerHolder holder, int position) {
        try {
            holder.setKeyWords(this.keywords);
            holder.setUpView(datas.get(position), position, this);
        } catch (Exception e) {
        }
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    @Override
    public int getItemViewType(int position) {
        try {
            return datas.get(position).type(typeFactoryList);

        } catch (Exception e) {

            return R.layout.item_error;
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public void onViewDetachedFromWindow(BaseRecyclerHolder holder) {
        super.onViewDetachedFromWindow(holder);


    }

    @Override
    public void onViewAttachedToWindow(BaseRecyclerHolder holder) {
        super.onViewAttachedToWindow(holder);

    }
}
