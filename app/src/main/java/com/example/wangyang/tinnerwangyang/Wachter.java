package com.example.wangyang.tinnerwangyang;

import java.io.Serializable;

/**
 * Created by nanchaodong on 2017/3/7.
 */

public interface Wachter extends Serializable {
    int type(TypeFactory typeFactory);
    String getType();
}
