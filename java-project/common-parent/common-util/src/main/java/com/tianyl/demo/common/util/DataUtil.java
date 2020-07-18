package com.tianyl.demo.common.util;

import java.util.Random;

public class DataUtil {

    public static String getRandomStr() {
        Random random = new Random();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            result.append((char)(random.nextInt(26) + 97));
        }
        return result.toString();
    }

    public static Integer getRandomInt() {
        return new Random().nextInt(100);
    }

//    public static void main(String[] args) {
//        System.out.println(getRandomStr());
//        System.out.println(getRandomStr());
//        System.out.println(getRandomStr());
//        System.out.println(getRandomStr());
//        System.out.println(getRandomStr());
//    }
}
