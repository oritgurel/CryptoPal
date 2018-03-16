package com.cryptopal.android.enteteis;

/**
 * Created by Test on 16/03/2018.
 */

public class Exchange  {

    String name ;

    public String getName() {
        return name;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    boolean isConfirmed;

    public Exchange(String name, boolean isConfirmed) {
        this.name = name;
        this.isConfirmed = isConfirmed;
    }
}
