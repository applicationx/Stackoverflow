package com.stackoverflow.datastructure;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonasd on 2016-11-16.
 */
public class B implements Parent<C> {
    public List<C> cs = new ArrayList<>();

    @Override
    public List<C> getChildren() {
        return cs;
    }
}
