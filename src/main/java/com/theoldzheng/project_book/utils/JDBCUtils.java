package com.theoldzheng.project_book.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Description: JDBCUtils工具类用于实现创建、关闭、增删改查等操作数据库的功能
 *
 * @author theoldzheng@163.com  @ZYD
 * @create 2021.3.15 15:57
 */
public class JDBCUtils {
    private static DruidDataSource DataSource;

    /**
     * 用静态代码块完成线程池的初始化
     */
    static {
        InputStream fis = null;

        Properties properties = null;
        try {
            fis = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");

            properties = new Properties();
            properties.load(fis);

            DataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接
     * @return 若获取连接成功，则返回一个连接connection，否则返回一个null;
     */
    public static Connection getConnection() {
        DruidPooledConnection connection = null;
        try {
            connection = DataSource.getConnection();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    /**
     * 用于关闭数据库连接
     *
     * @param connection 需要传入一个连接来关闭
     */
    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
