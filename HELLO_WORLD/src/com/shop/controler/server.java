package com.shop.controler;

import com.shop.entity.tools;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class server {
    public static List<tools> list=new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("欢迎来到购物车系统！！！！");
        System.out.println("----------------------------------");
        System.out.println("1.添加 2.修改 3.查询 4.删除 5.退出");
        System.out.println("----------------------------------");
        Scanner sc = new Scanner(System.in);
        server server=new server();
        while (true){
            System.out.println("输入选择：");
            int i = sc.nextInt();
            switch (i){
                case 1:
                    server.add();
                    break;
                case 2:
                    server.change();
                    break;
                case 3:
                    server.query();
                    break;
                case 4:
                    server.delete();
                    break;
                case 5:
                    System.exit(0);

            }
        }
    }

    public  boolean add(){
        Scanner sc =new Scanner(System.in);
        System.out.print("输入编号：");
        int i=sc.nextInt();
        System.out.print("输入名称：");
        String name = sc.next();
        System.out.print("输入价格：");
        double v = sc.nextDouble();
        System.out.print("输入数量：");
        int n=sc.nextInt();
        tools tl =new tools(i,name,v,n);
        list.add(tl);
        return true;
    }
    public  boolean change(){
        Scanner sc =new Scanner(System.in);
        System.out.print("输入编号：");
        int i=sc.nextInt();
        System.out.print("输入数量：");
        int n=sc.nextInt();
        for (tools t: list){
            if(t.getId()==i){
                t.setNum(n);
            }
        }
        return true;
    }
    public  boolean query(){
        list.forEach(t-> System.out.println(t));
        return true;
    }
    public  boolean delete(){
        Scanner sc =new Scanner(System.in);
        System.out.print("输入编号：");
        int i=sc.nextInt();
        Iterator<tools> iterator = list.iterator();
        while (iterator.hasNext()){
            tools next = iterator.next();
            if(next.getId()==i){
                iterator.remove();
            }
        }
        return true;
    }



}
