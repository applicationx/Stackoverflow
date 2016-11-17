package com.stackoverflow.datastructure;

/**
 * Created by jonasd on 2016-11-16.
 */
public class C1 extends C {

    public final String name;

    public C1(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof C1) {
            return this.name.equals(((C1) obj).name);
        } else {
            return false;
        }
    }
}
