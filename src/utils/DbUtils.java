package utils;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * Created by john on 2016/8/19.
 */
public class DbUtils {
    private static String driverClass;
    private static String url;
    private static String username;
    private static String password;


    static {
        //此对象用于加载properties的文件数据
        ResourceBundle resourceBundle = ResourceBundle.getBundle("dbinfo");
        driverClass = resourceBundle.getString("driverClass");
        url = resourceBundle.getString("url");
        username = resourceBundle.getString("username");
        password = resourceBundle.getString("password");
        try {
            //注册
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //得到连接
    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(url, username, password);
    }

    //关闭资源
    public static void closeAll(ResultSet rs, Statement st, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            rs = null;
        }
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            st = null;
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            conn = null;
        }
    }
}
