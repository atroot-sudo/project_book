package com.theoldzheng.project_book.dao;

import com.theoldzheng.project_book.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Description:用于操作数据库的基底类
 *
 * @author theoldzheng@163.com  @ZYD
 * @create 2021.3.15 20:11
 */
public abstract class BaseDAO {
    private QueryRunner queryRunner = new QueryRunner();

    /**
     * 用于增删改数据库的操作。
     *
     * @param sql  要执行的sql语句
     * @param args 填充sql中的占位符
     * @return 返回sql语句影响的数据库行数，失败返回-1
     */
    public int update(String sql, Object... args) {
        Connection connection = JDBCUtils.getConnection();
        try {
            return queryRunner.update(connection, sql, args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(connection);
        }
        return -1;
    }

    /**
     * 用于查询一条JavaBean的对象的记录
     *
     * @param clazz 返回的对象类型
     * @param sql   用于执行的sql语句
     * @param args  sql的参数值
     * @param <T>   返回的泛型类型
     * @return 查询成功则返回信息，失败返回null
     */
    public <T> T queryForOne(Class<T> clazz, String sql, Object... args) {
        Connection connection = JDBCUtils.getConnection();
        try {
            return queryRunner.query(connection, sql, new BeanHandler<T>(clazz), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(connection);
        }
        return null;
    }

    /**
     * 用于查询多项结果的集合
     *
     * @param clazz 返回集合的类型
     * @param sql   sql语句
     * @param args  sql语句的参数
     * @param <T>   返回的泛型类型
     * @return
     */
    public <T> List<T> queryForList(Class<T> clazz, String sql, Object... args) {
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();
            return queryRunner.query(connection, sql, new BeanListHandler<T>(clazz), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(connection);
        }
        return null;
    }

    /**
     *  用于查询单个值
     * @param sql sql语句
     * @param args sql语句的参数
     * @return  如果查询成功，则返回值，失败返回null
     */
    public Object queryForSingleValue(String sql, Object... args) {
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();
            return queryRunner.query(connection, sql, new ScalarHandler<>(), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(connection);
        }
        return null;
    }

}
