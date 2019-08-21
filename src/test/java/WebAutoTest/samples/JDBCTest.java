package WebAutoTest.samples;

import org.testng.annotations.Test;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {


    public  void authenticationGuild() throws ClassNotFoundException, SQLException {
        //封装获取普通用户手机号码的方法
        String driver = "com.mysql.jdbc.Driver";    //驱动程序名
        String url = "jdbc:mysql://47.94.171.119:3389/gradevin";   //URL指向要访问的数据库名
        String user = "root";
        String password = "test1rootmysql";
        java.sql.Connection con;
        String sql;
        String name = null;
        String selectname ;

        Class.forName(driver);  //动态加载驱动程序
        con = DriverManager.getConnection(url, user, password);    //getConnection()方法连接数据库
        if (!con.isClosed())
            System.out.println("数据库连接成功！");
        Statement statement = con.createStatement();    //创建statement类对象，用来执行SQL语句
        sql = "SELECT name FROM shopnc_sal_agent WHERE mobile = '18163914977' ORDER BY id DESC LIMIT 1;";
        //普通用户
        ResultSet rs = statement.executeQuery(sql);     //ResultSet类，用来存放获取的结果集
        while (rs.next()) {
            name = rs.getString("name");  //获取name这一列的数据
            System.out.println(name);
        }
        rs.close();     //关闭ResultSet对象
        con.close();    //关闭数据库连接
        selectname = name;
    }
@Test
public void test()throws ClassNotFoundException, SQLException{
    JDBCTest test = new JDBCTest();
    test.authenticationGuild();

}
}
