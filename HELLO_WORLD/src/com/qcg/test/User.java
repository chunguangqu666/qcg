package com.qcg.test;

import java.math.BigInteger;

public class User {
    private static final Double CM_PER = 2.54;

    public static void main(String[] args) {
        double parperWidth = 8.5;
        double paperHerght = 11;
        System.out.println("PaperSize is " + parperWidth * CM_PER + "by" + paperHerght * CM_PER);
        BigInteger a = BigInteger.valueOf(100);
        System.out.println(a.getClass());

    }
}
