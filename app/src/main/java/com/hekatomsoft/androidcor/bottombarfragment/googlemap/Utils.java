package com.hekatomsoft.androidcor.bottombarfragment.googlemap;


public class Utils {
    public static boolean convertIntToBoolean(int state) {
        boolean value = false;
        if (state == 0) {
            value = false;
        } else if (state == 1) {
            value = true;
        }
        return value;
    }


}