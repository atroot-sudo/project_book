package JDBCUtilsTest;

import com.theoldzheng.project_book.utils.JDBCUtils;
import org.junit.Test;


import java.sql.Connection;

/**
 * Description:
 *
 * @author theoldzheng@163.com  @ZYD
 * @create 2021.3.15 19:49
 */
public class JDBCTest {
    @Test
    public void test1() {

            //测试数据库连接池的连接和释放
            Connection connection = JDBCUtils.getConnection();
            System.out.println(connection);
            JDBCUtils.close(connection);

}

}
