package com.lib.Manager;

import android.databinding.Bindable;
import android.databinding.PropertyChangeRegistry;

import com.j256.ormlite.field.DatabaseField;

import java.io.Serializable;
import java.util.Observable;

public class JSONResponseData extends Observable implements Serializable, android.databinding.Observable {
    @DatabaseField(generatedId = true)
    protected long idgen;
    @DatabaseField
    protected long id;
    @DatabaseField
    protected Long loginUserId;
    @DatabaseField
    protected Long sortId = 0l;
    @DatabaseField
    protected Long status = 0l; // -1 删除
    private int notifyid = (int) System.currentTimeMillis();

    public JSONResponseData() {
    }


    public int getNotifyid() {
        return notifyid;
    }


    public void setNotifyid(int notifyid) {
        this.notifyid = notifyid;
    }


    public long getIdgen() {
        return idgen;
    }

    public void setIdgen(long idgen) {
        this.idgen = idgen;
    }

    public Long getSortId() {
        return sortId;
    }

    public void setSortId(Long sortId) {
        this.sortId = sortId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getLoginUserId() {
        return loginUserId;
    }

    public void setLoginUserId(long loginUserId) {
        this.loginUserId = loginUserId;
    }

    public Long getPrimaryKey() {
        return idgen;
    }

    public void setPrimaryKey() {

    }

    public boolean copyOtherData(Object obj) {
        return false;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        long result = 1;
        result = prime * result + id;
        return (int) result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!getClass().equals(obj.getClass()))
            return false;
        JSONResponseData other = (JSONResponseData) obj;
        return id == other.id;
    }


    private transient PropertyChangeRegistry mCallbacks;


    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        synchronized (this) {
            if (mCallbacks == null) {
                mCallbacks = new PropertyChangeRegistry();
            }
        }
        mCallbacks.add(callback);
    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        synchronized (this) {
            if (mCallbacks == null) {
                return;
            }
        }
        mCallbacks.remove(callback);
    }

    /**
     * Notifies listeners that all properties of this instance have changed.
     */
    public void notifyChange() {
        synchronized (this) {
            if (mCallbacks == null) {
                return;
            }
        }
        mCallbacks.notifyCallbacks(this, 0, null);
    }

    /**
     * Notifies listeners that a specific property has changed. The getter for the property
     * that changes should be marked with {@link Bindable} to generate a field in
     * <code>BR</code> to be used as <code>fieldId</code>.
     *
     * @param fieldId The generated BR id for the Bindable field.
     */
    public void notifyPropertyChanged(int fieldId) {
        synchronized (this) {
            if (mCallbacks == null) {
                return;
            }
        }
        mCallbacks.notifyCallbacks(this, fieldId, null);
    }
}
