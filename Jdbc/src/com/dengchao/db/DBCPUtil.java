package com.dengchao.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

public class DBCPUtil {
    public DBCPUtil() {
        initDbcp();
    }

    private static DataSource DS;
    private static final String configFile = "/dbcp.properties";

    public Connection getConn() {
        Connection con = null;
        if (DS != null) {
            try {
                con = DS.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return con;
        }
        return con;
    }

    public static void initDbcp() {
        Properties pops = new Properties();
        try {
            pops.load(DBCPUtil.class.getResourceAsStream(configFile));
            DS = BasicDataSourceFactory.createDataSource(pops);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
