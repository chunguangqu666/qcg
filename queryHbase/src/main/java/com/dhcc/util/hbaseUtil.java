package com.dhcc.util;

import com.dhcc.entity.Constants;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.security.UserGroupInformation;

import java.io.IOException;
import java.security.PrivilegedAction;

public class hbaseUtil {
    private static Configuration conf = null;

    static {
        String zk_adress = Constants.zk_adress;
        conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.qurom", zk_adress);
        System.setProperty("java.security.krb5.conf", "krb5.conf");
        conf.set("hadoop.security.authentication", "Kerberos");
    }

    /**
     * 获取hbase连接
     *
     * @return
     */
    public static Connection getConnection() throws IOException {
        Connection conn = null;
        try {
//            String path = "C:/";
            UserGroupInformation.setConfiguration(conf);
            UserGroupInformation.loginUserFromKeytab("aml",  "develop_aml.keytab");
            UserGroupInformation loginUser = UserGroupInformation.getLoginUser();
            conn = (Connection) loginUser.doAs(new PrivilegedAction<Object>() {
                public Object run() {
                    Connection connection = null;
                    try {

                        connection = ConnectionFactory.createConnection(conf);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return connection;
                }
            });
        } catch (IOException e1) {
            throw new RuntimeException("Kerberos身份认证失败：" + e1.getMessage(), e1);
        }
        return conn;
    }

    /**
     * 创建表
     *
     * @param tablename
     * @param family
     */
    public static void createTable(String tablename, String[] family) throws Exception {
        Connection connection = getConnection();
        HBaseAdmin admin = (HBaseAdmin) connection.getAdmin();
        TableName tableName = TableName.valueOf(tablename);
        if (admin.tableExists(tableName)) {
            System.out.println("表已存在");
        } else {
            HTableDescriptor hTableDescriptor = new HTableDescriptor(tableName);
            for (String fam : family) {
                HColumnDescriptor hColumnDescriptor = new HColumnDescriptor(fam);
                HTableDescriptor hTableDescriptor1 = hTableDescriptor.addFamily(hColumnDescriptor);
            }
            admin.createTable(hTableDescriptor);
            System.out.println("表创建完成");
        }
    }

    /**
     * 根据rowkey查询
     *
     * @param tablename
     * @param rowkey
     * @throws IOException
     */
    public void queryByRowKey(String tablename, String rowkey) throws IOException {
        TableName tableName = TableName.valueOf(tablename);
        Get get = new Get(rowkey.getBytes());
        Connection connection = getConnection();
        if (get.isCheckExistenceOnly()) {
            Table table = connection.getTable(tableName);
            Result result = table.get(get);


        }


    }

    /**
     * close
     * @param conn
     */
    public void close(Connection conn) {
        if(conn!=null){
            try {
                conn.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
