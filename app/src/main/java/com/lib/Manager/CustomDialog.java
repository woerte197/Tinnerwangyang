package com.lib.Manager;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.wangyang.tinnerwangyang.Activity.BaseActivity;
import com.example.wangyang.tinnerwangyang.R;

import java.util.List;

public class CustomDialog extends Dialog {
	public static final int type_listview = 0;
	public static final int type_gridview = 1;
	public CustomDialog(Context context, int theme) {
		super(context, theme);
	}

	public CustomDialog(Context context) {
		super(context);
	}

	public interface MyDialoglistener {
		void callback();
	}

	public static class Builder {
		private Context context;
		private String title;
		private String message;
		private String bottomMessage;
		private int drawable;

		public int getDrawable() {
			return drawable;
		}

		public void setDrawable(int drawable) {
			this.drawable = drawable;
		}

		private String pbText;
		private String nbText;
		private int mar = 0;
		private View contentView;
		private DialogListAdapter adapter;
		private OnClickListener pbListener,nbListener;
		private OnItemClickListener listener;

		public void setListener(OnItemClickListener lis) {
			this.listener = lis;
		}

		public Builder(Context context) {
			this.context = context;
		}

		public Builder setMessage(String message) {
			this.message = message;
			return this;
		}
		public Builder setBottomMessage(String message) {
			this.bottomMessage = message;
			return this;
		}
        public Builder setIcon(int drawable)
		{
			this.drawable=drawable;
			return this;
		}
		public Builder setMessage(int message) {
			this.message = (String) context.getText(message);
			return this;
		}

		public Builder setTitle(int title) {
			this.title = (String) context.getText(title);
			return this;
		}

		public Builder setTitle(String title) {
			this.title = title;
			return this;
		}

		public Builder setContentView(View v) {
			this.contentView = v;
			return this;
		}

		public Builder setPositiveButton(int positiveButtonText, int mar,OnClickListener listener) {
			this.pbText = (String) context.getText(positiveButtonText);
			this.pbListener = listener;
			this.mar = mar;
			return this;
		}

		public Builder setPositiveButton(int positiveButtonText,OnClickListener listener) {
			this.pbText = (String) context.getText(positiveButtonText);
			this.pbListener = listener;
			return this;
		}

		public Builder setPositiveButton(String positiveButtonText,OnClickListener listener) {
			this.pbText = positiveButtonText;
			this.pbListener = listener;
			return this;
		}

		public Builder setNegativeButton(int negativeButtonText,OnClickListener listener) {
			this.nbText = (String) context.getText(negativeButtonText);
			this.nbListener = listener;
			return this;
		}

		public Builder setNegativeButton(String negativeButtonText,OnClickListener listener) {
			this.nbText = negativeButtonText;
			this.nbListener = listener;
			return this;
		}

		public CustomDialog create(int type) {
			return createGrid(false, -1,type,true);
		}
		public CustomDialog create(int type,boolean showTitle) {
			return createGrid(false, -1,type,showTitle);
		}
		public CustomDialog create() {
			return createGrid(false, -1,CustomDialog.type_listview,true);
		}

		public CustomDialog create(boolean flag,int type) {
			return createGrid(flag, -1,type,true);
		}
		public CustomDialog create(boolean flag) {
			return createGrid(flag, -1,CustomDialog.type_listview,true);
		}
		 
		
		public CustomDialog createGrid(boolean visableIcon, int margin,int type ,boolean showTitle) {
			final CustomDialog dialog = new CustomDialog(context,R.style.Dialog);
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			Display display = dialog.getWindow().getWindowManager().getDefaultDisplay();
			int spec = 0;
			if(showTitle){
				spec = 10;
			}else{
				spec = 8;
			}
			final int width = display.getWidth() - display.getWidth() / spec;
			View layout = inflater.inflate(R.layout.dialog, null);
			View titleLayout = layout.findViewById(R.id.titleLayout);
			View titlediv= layout.findViewById(R.id.titleDiv);
			View buttonSep= layout.findViewById(R.id.buttonSep);
			TextView tvTitle = (TextView) layout.findViewById(R.id.title);
			EditText editText=(EditText)layout.findViewById(R.id.edit_food);
			ImageView icon = (ImageView) layout.findViewById(R.id.imgIcon);
			TextView tvMessage = (TextView) layout.findViewById(R.id.message);
			TextView tvBottomMessage = (TextView) layout.findViewById(R.id.tvBottomMessage);
			Button btnPostive = ((Button) layout .findViewById(R.id.positiveButton));
			Button btnNegative = ((Button) layout .findViewById(R.id.negativeButton));
  			if(showTitle){
				titleLayout.setVisibility(View.VISIBLE);
				titlediv.setVisibility(View.VISIBLE);
			}else{
				int paddingTop = 100;
				tvMessage.setPadding(0, paddingTop+50, 0, paddingTop);
				tvBottomMessage.setPadding(0, paddingTop+50, 0, paddingTop);
				titleLayout.setVisibility(View.GONE);
				titlediv.setVisibility(View.GONE);
			}

			if (margin != -1) {
				LinearLayout.LayoutParams paraPos = (LinearLayout.LayoutParams) (btnPostive .getLayoutParams());
				LinearLayout.LayoutParams paraNev = (LinearLayout.LayoutParams) (btnNegative .getLayoutParams());
				paraPos.leftMargin = margin;
				paraPos.rightMargin = margin;
				paraNev.leftMargin = margin;
				paraNev.rightMargin = margin;
			} 
			if (visableIcon) {
				icon.setVisibility(View.VISIBLE);
			} else {
				icon.setVisibility(View.GONE);
			}
			ImageButton imgClose = (ImageButton) layout.findViewById(R.id.imgClose);
			imgClose.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					dialog.dismiss();
				}
			});
			if (pbText != null) {
				Button btn = ((Button) layout.findViewById(R.id.positiveButton));
				btn.setText(pbText);
				if (margin != 0) {
					LinearLayout.LayoutParams para = (LinearLayout.LayoutParams) btn.getLayoutParams();
					para.leftMargin = mar;
					para.rightMargin = mar;
				}
				if (pbListener != null) {
					btnPostive.setOnClickListener(new View.OnClickListener() {
						public void onClick(View v) {
							pbListener.onClick(dialog,DialogInterface.BUTTON_POSITIVE);
						}
					});
				}
			} else {
				layout.findViewById(R.id.positiveButton).setVisibility(View.GONE);
				layout.findViewById(R.id.negativeButton).setBackgroundResource(R.drawable.selector_centerbutton);

				buttonSep.setVisibility(View.GONE);
			}
			if (nbText != null) {
				((Button) layout.findViewById(R.id.negativeButton)).setText(nbText);
				if (nbListener != null) {
					btnNegative.setOnClickListener(new View.OnClickListener() {
						public void onClick(View v) {
							nbListener.onClick(dialog,DialogInterface.BUTTON_NEGATIVE);
						}
					});
				}
			} else {
				layout.findViewById(R.id.negativeButton).setVisibility(View.GONE);
				layout.findViewById(R.id.positiveButton).setBackgroundResource(R.drawable.selector_centerbutton);
				buttonSep.setVisibility(View.GONE);
			}
			if(pbText == null && nbText ==null){
				layout.findViewById(R.id.lnBottom).setVisibility(View.GONE);
			}
			tvTitle.setText(title);
			
			if(!TextUtils.isEmpty(message)){
				tvMessage.setVisibility(View.VISIBLE);
				tvMessage.setText(message);
			}else{
				tvMessage.setVisibility(View.GONE);
			}
			if(!TextUtils.isEmpty(bottomMessage)){
				tvBottomMessage.setVisibility(View.VISIBLE);
				tvBottomMessage.setText(bottomMessage);
			}else{
				tvBottomMessage.setVisibility(View.GONE);
			}
			if (message != null) {
				tvMessage.setText(message);
				
			} else if (contentView != null) {
				((LinearLayout) layout.findViewById(R.id.tvAppVersion)).removeAllViews();
				((LinearLayout) layout.findViewById(R.id.tvAppVersion)).addView(contentView,new LinearLayout.LayoutParams(width,LinearLayout.LayoutParams.FILL_PARENT,1));
			}
			if (adapter != null) {
				((TextView) layout.findViewById(R.id.message)).setVisibility(View.GONE);
				int layoutid = -1;
				switch (type) {
				case type_listview:
					layoutid = R.layout.c_dialog_listview;
					break;
				case type_gridview:
					layoutid = R.layout.c_dialog_gridview;
					break;
				}
				View c = dialog.getLayoutInflater().inflate(layoutid, null);
				AdapterView ls = (AdapterView) c.findViewById(R.id.lvDialog);
				ls.setAdapter(adapter);
				adapter.setListener(listener);
				adapter.setDialog(dialog);
				((LinearLayout) layout.findViewById(R.id.tvAppVersion)).addView(c, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT));

			}
			LinearLayout.LayoutParams para = new LinearLayout.LayoutParams(width, LinearLayout.LayoutParams.WRAP_CONTENT);
			dialog.setContentView(layout, para);
			return dialog;
		}
		
//		public CustomDialog createUpdateDialog(final HttpUpdate downloader) {
//			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//			final CustomDialog dialog = new CustomDialog(context,R.style.Dialog);
//			final View layout = inflater.inflate(R.layout.c_dialog_update, null);
//			final TextView tvTitle = ((TextView) layout.findViewById(R.id.title));
//			final TextView tvMessage = ((TextView) layout.findViewById(R.id.message));
//			final Button btnPostive = ((Button) layout.findViewById(R.id.positiveButton));
//			final Button btnNegative = ((Button) layout.findViewById(R.id.negativeButton));
//			final ProgressBar pb = ((ProgressBar) layout.findViewById(R.id.pb));
//			tvTitle.setText(title);
//			btnPostive.setText(pbText);
//			btnNegative.setText(nbText);
//			downloader.startDownload(tvMessage,pb,btnNegative);
//			View.OnClickListener listener = new View.OnClickListener() {
//				public void onClick(View v) {
//					if(v == btnPostive ){
//						pbListener.onClick(dialog,DialogInterface.BUTTON_POSITIVE);
//					}
//					if(v == btnNegative ){
//						nbListener.onClick(dialog,DialogInterface.BUTTON_NEGATIVE);
//					}
//				}
//			};
//			btnPostive.setOnClickListener(listener);
//			btnNegative.setOnClickListener(listener);
//			LinearLayout.LayoutParams para = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
//			dialog.setContentView(layout, para);
//			return dialog;
//		}


		public Builder createListAdapter(List<DialogItem> data,
										 BaseActivity act, boolean radio , int type) {
			switch(type){
			case type_listview:
				adapter = new DialogListAdapter(data, act, radio,R.layout.item_dialog_checkbox);
				break;
			case type_gridview:
				adapter = new DialogListAdapter(data, act, radio,R.layout.item_dialog_grid);
				break;
			}
			return this;
		}

	}
}