package com.dhcc.main;

import com.dhcc.util.hbaseUtil;

public class HbaseTest {
    public static void main(String[] args) throws Exception {
        String tablename=args[0];
        String family=args[1];
        hbaseUtil hbaseutil = new hbaseUtil();
        String [] fam={"info"};
        hbaseUtil.createTable("aa",fam);


    }
}
