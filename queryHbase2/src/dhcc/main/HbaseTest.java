package dhcc.main;

import dhcc.util.hbaseUtil;

public class HbaseTest {
    public static void main(String[] args) throws Exception {
        String tablename=args[0];
        String family=args[1];

        String [] fam={"info"};
        hbaseUtil.createTable("aa",fam);


    }
}
