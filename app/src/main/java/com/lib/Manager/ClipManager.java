package com.lib.Manager;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;

/**
 * Created by wangyang on 11/2/18.
 */

public class ClipManager {
    private static ClipManager manager = null;

    public static ClipManager getManager() {
        if (manager == null) {
            synchronized (ClipManager.class) {
                manager = new ClipManager();
            }
        }
        return manager;
    }

    public void getClipboard(Context context, String text) {
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clipData = ClipData.newPlainText(null, text);
        clipboardManager.setPrimaryClip(clipData);
    }

}
