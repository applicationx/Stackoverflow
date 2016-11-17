package com.stackoverflow.datastructure;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonasd on 2016-11-16.
 */
public class A implements Parent<B> {
    public List<B> bs = new ArrayList<>();

    @Override
    public List<B> getChildren() {
        return bs;
    }
}
