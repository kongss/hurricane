package com.hurricane.coupon.utils.utils;

import java.util.UUID;

public class HuUUID {
    public static void main(String[] args) {
        //String uuid = UUID.randomUUID().toString();
        //System.out.println(uuid.length());
    }
    public static String getUuid(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
