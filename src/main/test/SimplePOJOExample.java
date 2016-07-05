import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.Future;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

/**
 * write Title here
 * <p>
 * write Description here
 * </p>
 *
 * @author Jade ZHANG E-mail:pioneer_zcy@163.com
 * @copyright 2015-2016 sh.lianjia.com.
 * @date 16/5/5
 */

public class SimplePOJOExample {
    public static void main(String[] args) throws Exception {
        PoolProperties p = new PoolProperties();
        p.setUrl("jdbc:mysql://139.196.228.19:3306/test");
        p.setDriverClassName("com.mysql.jdbc.Driver");
        p.setUsername("root");
        p.setPassword("1234");
        p.setJmxEnabled(true);
        p.setTestWhileIdle(false);
        p.setTestOnBorrow(true);
        p.setValidationQuery("SELECT 1");
        p.setTestOnReturn(false);
        p.setValidationInterval(30000);
        p.setTimeBetweenEvictionRunsMillis(30000);
        p.setMaxActive(100);
        p.setInitialSize(10);
        p.setMaxWait(10000);
        p.setRemoveAbandonedTimeout(60);
        p.setMinEvictableIdleTimeMillis(30000);
        p.setMinIdle(10);
        p.setLogAbandoned(true);
        p.setRemoveAbandoned(true);
        p.setJdbcInterceptors(
                "org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;" +
                        "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");

        /**
         * 普通连接
         */
         norConnection(p);
        /**
         * 从空闲队列中获取一个连接,
         * idle中存在的连接对象有些可能并没有绑定物理连接,
         * 连接将要被使用时,才会初始化
         */
        /**
         * 对从空闲队列中获取的连接进行配置和验证
         */

        /**
         * 异步连接
         */
        //asyncConnection(p);

    }

    public static void norConnection(PoolProperties p) throws Exception {
        DataSource datasource = new DataSource();
        datasource.setPoolProperties(p);

        int count = 100;
        while (count-- != 0) {


            Connection con = null;
            try {
                con = datasource.getConnection();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from product");
                int cnt = 1;
                while (rs.next()) {
                    System.out.println((cnt++) + ". id:" + rs.getString("id") +
                            " amount:" + rs.getString("amount"));
                }
                rs.close();
                st.close();
            } finally {
                if (con != null) try {
                    con.close();
                } catch (Exception ignore) {
                }
            }
        }
    }

    public static void asyncConnection(PoolProperties p) throws Exception {

        p.setFairQueue(true);

        DataSource datasource = new DataSource();
        datasource.setPoolProperties(p);

        int count = 100;
        while (count-- != 0) {
            System.out.println(count);

            Connection con = null;
            try {
                Future<Connection> future = datasource.getConnectionAsync();
                while (!future.isDone()) {
                    System.out.println("Connection is not yet available. Do some background work");
                    try {
                        Thread.sleep(3000); //simulate work
                    } catch (InterruptedException x) {
                        Thread.currentThread().interrupt();
                    }
                }
                con = future.get(); //should return instantly
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from product");
                int cnt = 1;
                while (rs.next()) {
                    System.out.println((cnt++) + ". id:" + rs.getString("id") +
                            " amount:" + rs.getString("amount"));
                }
                rs.close();
                st.close();
            } finally {
                if (con != null) try {
                    con.close();
                } catch (Exception ignore) {
                }
            }
        }
    }


}
