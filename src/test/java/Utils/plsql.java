package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class plsql {  
    public static final String url = "jdbc:mysql://mysql.jjjr.17money.test:3306";  
    public static final String name = "com.mysql.cj.jdbc.Driver";  
    public static final String user = "test";  
    public static final String password = "jjjr@2016";  
  
    static String sql = null;  
    static plsql db1 = null;  
    static ResultSet ret = null;  
    public Connection conn = null;  
    public PreparedStatement pst = null;  
    public static ResultSetMetaData m=null;//获取 列信息
    
    public plsql(String sql) {  
        try {  
            Class.forName(name);//指定连接类型  
            conn = DriverManager.getConnection(url, user, password);//获取连接  
            pst = conn.prepareStatement(sql);//准备执行语句  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
  
    public void close() {  
        try {  
            this.conn.close();  
            this.pst.close();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
    }  
    public static String[] getsql(String sql) {  
        db1 = new plsql(sql);//创建DBHelper对象  
             String[] str = new String[50];
        try {  
            ret = db1.pst.executeQuery();//执行语句，得到结果集  
            m=ret.getMetaData(); 
            int columns=m.getColumnCount();          //获得列数
			while (ret.next()) {
				for(int i=1;i<=columns;i++){
					str[i-1]=ret.getString(i);
				//	System.out.print(str[i-1]+"\t");
				}	
            }//显示数据  
            ret.close();  
            db1.close();//关闭连接  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }
		return str;  
    }  
    
    public static void main(String[] args) {
    	 sql = "select jjjr2_sns.u_user.custom_id  from jjjr2_sns.u_user   where jjjr2_sns.u_user.username='15080605720'";//SQL语句  
		
		 String[] str = new String[50];
		 str=db1.getsql(sql);
		 for(String s:str){
			 if(s==null)
		 	 break;	 
			 System.out.print(s+"\t");
		 }
	}
}  
