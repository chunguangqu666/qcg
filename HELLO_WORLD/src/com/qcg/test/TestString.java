package com.qcg.test;

import java.io.*;

/**
 *
 * String 练习
 */
public class TestString {
    //取左串
    public String leftStr(String s,int len){
       //[0,len)
        String str= s.substring(0,len);
        return str;
    }
    //取右串
    public String rightStr(String s,int len){
        return s.substring(s.length()-len);
    }

    public static void main(String[] args) {
//        TestString testString = new TestString();
//        String str1="abcdefghijk";
//        String test1=testString.leftStr(str1,3);
//        System.out.println(test1);
//        String test2=testString.rightStr(str1,3);
//        System.out.println(test2);

        FileOutputStream fo = null;
        try {
            File f =new File("D:\\data\\a.txt");
            fo = new FileOutputStream(f);
            if(f.exists()){

            }else{
                f.createNewFile();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fo.write("haha".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
