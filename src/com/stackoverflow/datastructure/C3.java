package com.stackoverflow.datastructure;

/**
 * Created by jonasd on 2016-11-16.
 */
public class C3 extends C {


    public final String name;

    public C3(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof C3) {
            return this.name.equals(((C3)obj).name);
        } else {
            return false;
        }
    }


}
