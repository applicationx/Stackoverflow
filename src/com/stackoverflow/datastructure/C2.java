package com.stackoverflow.datastructure;

/**
 * Created by jonasd on 2016-11-16.
 */
public class C2 extends C {

    public final String name;

    public C2(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof C2) {
            return this.name.equals(((C2)obj).name);
        } else {
            return false;
        }
    }

}
