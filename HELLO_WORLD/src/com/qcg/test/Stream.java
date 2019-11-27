package com.qcg.test;

import java.io.*;

public class Stream {
    public static void main(String[] args) throws IOException {
        File f = new File("d:/qcg/aa.txt");
//        InputStream in = new FileInputStream(f);
//        byte [] b = new byte[8];
//        int temp;
//        StringBuffer sb = new StringBuffer();
//        while ((temp=in.read(b))!=-1){
//            sb.append(new String(b,0,temp));
//        }
//        System.out.println(sb);
//        in.close();
//        ReadAsStream(f);
//        ReadAsReader(f);
        try {
            WriteAsStream(f);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String ReadAsStream(File f) throws IOException {
        FileInputStream in = new FileInputStream(f);
        byte[] b = new byte[8];
        int temp;
        StringBuffer sb = new StringBuffer();
        while ((temp = in.read()) != -1) {
            System.out.println((char) temp);
//            sb.append(new String(b,0,temp));
        }
//        System.out.println(sb);
        in.close();
        return sb.toString();
    }

    public static String ReadAsReader(File f) throws IOException {
        FileReader fileReader = new FileReader(f);
        int temp;
        StringBuffer sb = new StringBuffer();
        while ((temp = fileReader.read()) != -1) {
            System.out.println((char) temp);
        }
        fileReader.close();
        return "";
    }

    public static void WriteAsStream(File f) throws Exception {
        System.out.println(f.exists());
        if (!f.exists()) {
            System.out.println(f.getAbsolutePath());
            System.out.println(f.getParent());
            String parent = f.getParent();
            File fs=new File(parent);
            fs.mkdir();

            f.createNewFile();

        }
        BufferedWriter bw = new BufferedWriter(new FileWriter(f, true));
        bw.write("haha");
        bw.flush();
        bw.close();


    }

    public void WriteAsWriter() {

    }

}