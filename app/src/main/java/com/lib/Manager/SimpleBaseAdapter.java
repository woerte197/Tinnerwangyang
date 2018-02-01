package com.lib.Manager;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.wangyang.tinnerwangyang.Activity.BaseActivity;
import com.example.wangyang.tinnerwangyang.ViewUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimpleBaseAdapter<T> extends android.widget.BaseAdapter {

	private static final String tag = "SimpleBaseAdapter";
	protected List<T> mData;
	protected BaseActivity mCtx;
	protected int mClickIndex = -1;
	protected List<BaseComparator<T>> mComparators = new ArrayList<BaseComparator<T>>();

	public int getmClickIndex() {
		return mClickIndex;
	}

	public void setmClickIndex(int mClickIndex) {
		this.mClickIndex = mClickIndex;
	}

	public void addComparator(BaseComparator<T> mComparator) {
		this.mComparators.add(mComparator);
	}

	public BaseActivity getCtx() {
		return mCtx;
	}

	public List<T> getData() {
		return mData;
	}
	public int indexOf(Object bean) {
		return mData.indexOf(bean);
	}


	public void setData(List<T> d) {
		mData = d;
	}

	public SimpleBaseAdapter(List<T> mData, BaseActivity mCtx) {
		super();
		this.mData = mData;
		this.mCtx = mCtx;
	}
	protected View inflate(int rid) {
		return ViewUtils.getInflater(mCtx).inflate(rid, null);
	}
	protected View inflate(int layoutId, ViewGroup parent, boolean add) {
		return ViewUtils.getInflater(mCtx).inflate(layoutId, parent,add);
	}
	public void append(List<T> items,int start) {
		int effCount = 0;
		int updateCount = 0;
		for(T bean :items){
			int index = mData.indexOf(bean);
			if(index != -1){
				T item = mData.get(index);
				if(item instanceof JSONResponseData){
					((JSONResponseData)item).copyOtherData(bean);
					updateCount++;
				}
				continue;
			}else {
				if(start == -1){
					mData.add(bean);
				}else{
					mData.add(0, bean);
				}
				effCount++;
			}
		}
		Log.i(tag, "插入行数："+effCount+" 更新行数："+updateCount);

	}
	public void append(T item) {
		if(mData.indexOf(item) ==-1){  //21006  58921 mData.indexOf(bean) mData.get(99)
			mData.add(item);
		}
	}
	public void clearData(){
		mData.clear();
	}

	public int getCount() {
		return mData == null? 0 :mData.size();
	}

	public T getItem(int position) {
		return mData.get(position);
	}
	public T getLastItem() {
		return getItem(getCount() -1);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		return null;
	}
	/**
	 * 更新某一行数据
	 * @param obj
	 */
	public void updateItem(T obj,AdapterView listView){
		int index = mData.indexOf(obj);
		if(index != -1){
			T item = mData.get(index);
			if(item instanceof JSONResponseData){
				((JSONResponseData)item).copyOtherData(obj);
				int headerViewCount = 0;
				if(listView instanceof ListView){
					headerViewCount = ((ListView)listView).getHeaderViewsCount();
				}
				index = index +headerViewCount;
				int visibleFirstPosi = listView.getFirstVisiblePosition();
				int visibleLastPosi = listView.getLastVisiblePosition();
				if (index >= visibleFirstPosi && index <= visibleLastPosi) {
					updateItemView(item);
				}
			}else{
				//mData.set(index, obj);
			}
		}
	}
	/**
	 * 更新指定项内容
	 * @param obj
	 */
	public void updateItemView(Object obj){
		if(obj != null){
			if(obj instanceof JSONResponseData){
				int index = indexOf(obj);
				if(index != -1){
					JSONResponseData a = (JSONResponseData)mData.get(index);
					a.copyOtherData(obj);
					notifyDataSetChanged();
				}
			}
		}
	}
	/**
	 * 更新数据
	 */
	public void updateItemList(Object data,AdapterView listView){
		if(data instanceof JSONResponseData){
			updateItem((T)data,listView);
		}
		if(data instanceof List){
			List<T> d = (List<T>) data;
			for(T obj : d){
				updateItem((T)obj,listView);
			}
		}
		//notifyDataSetChanged();
	}
	/**
	 * 插入一行数据
	 * @param obj
	 */
	public void insertItem(int position,T obj){
		int index = mData.indexOf(obj);
		if(index == -1){
			mData.add(position, obj);
			notifyDataSetChanged();
		}
	}
	/**
	 * 删除一行数据
	 * @param obj
	 */
	public void deleteItem(T obj){
		int index = getIndex(obj);
		if(index != -1){
			removeItem(obj);
			notifyDataSetChanged();
		}
	}
	protected void removeItem(T obj){
		try{
			mData.remove(obj);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public int getIndex(T obj){
		return mData.indexOf(obj);
	}
	public T getSelectedItem(){
		if(mClickIndex ==-1){
			return null;
		}
		return mData.get(mClickIndex);
	}

	public void notifyDataSetChanged() {
		for (int i = 0; i < mComparators.size(); i++) {
			Collections.sort(mData, mComparators.get(i));
		}
		super.notifyDataSetChanged();
	}

	public void onDestory() {
		if (mComparators != null) {
			mComparators.clear();
		}
		if (mData != null) {
			mData.clear();
		}
		mCtx = null;
	}

	public boolean isEmpty(){
		return mData.size() == 0;
	}
//	protected CommonRecyclerAdapter mRecyleAdapter;
//	public  CommonRecyclerAdapter getRecyleAdapter(){
//		return null;
//	};
}
