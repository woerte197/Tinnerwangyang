package com.lib.Manager;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.wangyang.tinnerwangyang.Activity.BaseActivity;
import com.example.wangyang.tinnerwangyang.Exit.ECKit;
import com.example.wangyang.tinnerwangyang.R;

import java.util.ArrayList;
import java.util.List;

public class DialogListAdapter extends SimpleBaseAdapter<DialogItem> {
	private int layoutId;
	public DialogListAdapter(List<DialogItem> mData, BaseActivity mCtx, boolean radio, int layoutId) {
		super(mData, mCtx);
		this.isRadio = radio;
		this.layoutId = layoutId;
	}

	private CustomDialog mDialog;
	private boolean isRadio = false;
	// 是否需要自动关闭窗口
	private boolean checkDismiss = true;
	private OnItemClickListener mListener;
	private ArrayList<HolderView> holders = new ArrayList<HolderView>();

	public void setDialog(CustomDialog dialog) {
		this.mDialog = dialog;
	}

	public void setListener(OnItemClickListener listener) {
		this.mListener = listener;
	}

	public boolean isRadio() {
		return isRadio;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		final DialogItem bean = mData.get(position);
		HolderView holder = null;
		if (convertView == null) {
			holder = new HolderView();
			holders.add(holder);
			holder.bean = bean;
			convertView = inflate(layoutId);
			holder.name = (TextView) convertView.findViewById(R.id.tvName);
			holder.checkbox = (CheckBox) convertView .findViewById(R.id.checkbox);
			holder.imgIcon = (ImageView) convertView.findViewById(R.id.imgIcon);
			holder.checkbox.setFocusable(false);
			holder.checkbox.setClickable(false);
			convertView.setTag(holder);
		} else {
			holder = (HolderView) convertView.getTag();
		}
		final CheckBox checkbox = holder.checkbox;
		if (bean.getImgId() != -1) {
			holder.imgIcon.setVisibility(View.VISIBLE);
			holder.imgIcon.setImageResource(bean.getImgId());
		}
		if (isRadio) {
			holder.checkbox.setVisibility(View.VISIBLE);
			convertView.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					for (DialogItem b : mData) {
						b.setChecked(false);
					}
					for (int i = 0; i < holders.size(); i++) {
						if (holders.get(i).checkbox.isChecked()) {
							holders.get(i).checkbox.setChecked(false);
						}
					}
					checkbox.setChecked(true);
					bean.setChecked(true);
					if (mListener != null) {
						mListener.onItemClick(null, null, position, position);
					}
					if (mDialog != null) {
						if(checkDismiss) {
							mDialog.dismiss();
						}
					}
				}

			});
		} else {
			holder.checkbox.setVisibility(View.GONE);
			final TextView name = holder.name;
			convertView.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					bean.setChecked(!bean.isCheck());
					checkbox.setChecked(bean.isCheck());
					name.setTextColor(ECKit.getColor(bean.isCheck() ? (R.color.blue_color) :R.color.dialog_text_color));
					if (mListener != null) {
						mListener.onItemClick(null, null, position, position);
					}
					if (mDialog != null) {
						if(checkDismiss)
						{
							mDialog.dismiss();
						}
					}
				}
			});
		}
		holder.name.setTextColor(ECKit.getColor(bean.isCheck() ? R.color.blue_color : R.color.common_deep_text_color));
		holder.checkbox.setChecked(bean.isCheck());
		holder.name.setText(bean.toString());
		return convertView;
	}

	class HolderView {
		TextView name;
		CheckBox checkbox;
		DialogItem bean;
		ImageView imgIcon;
	}

}
