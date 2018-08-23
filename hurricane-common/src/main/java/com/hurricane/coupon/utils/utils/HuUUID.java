package com.hurricane.coupon.utils.utils;

import java.util.UUID;

public class HuUUID {
    public static void main(String[] args) {

    }
    public static String getUuid(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }


}
