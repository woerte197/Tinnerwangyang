package com.lib.Manager;




/**
 * @author Administrator
 * 
 */
public class DialogItem {
	boolean check;
	int imgId = -1;
	Object o;
	public int getImgId() {
		return imgId;
	}

	public void setImgId(int imgId) {
		this.imgId = imgId;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}



	public DialogItem(Object o, boolean flag) {
		super();
		this.check = flag;
		this.o = o;
	}
	public DialogItem(Object o, boolean flag,int imagid) {
		super();
		this.check = flag;
		this.o = o;
		this.imgId = imagid;
	}

	public boolean isCheck() {
		return check;
	}

	public void setChecked(boolean flag) {
		this.check = flag;
	}

	public Object getO() {
		return o;
	}

	public void setO(Object o) {
		this.o = o;
	}

	public String getValue() {
		if (o instanceof String) {
			
			return o.toString();
		} else {
			return null;
		}
	}

	@Override
	public String toString() {
		if (o instanceof String) {
			return o.toString();
		} else {
			return null;
		}
	}

}
