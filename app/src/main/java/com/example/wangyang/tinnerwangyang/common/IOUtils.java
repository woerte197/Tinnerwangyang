package com.example.wangyang.tinnerwangyang.common;

/**
 * Created by wangyang on 3/1/18.
 */

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOUtils {
    public static void closeQuietly(Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (IOException ioe) {
            // ignore
        }
    }

    public static void renameTo(File oldFile, File newFile) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(oldFile);
            os = new FileOutputStream(newFile);
            int len = -1;
            byte[] buffer = new byte[2048];
            while ((len = is.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }
            oldFile.delete();
        } finally {
            IOUtils.closeQuietly(is);
            IOUtils.closeQuietly(os);
        }
    }
}