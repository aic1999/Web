package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnDB {
private static String url="jdbc:mysql://localhost/cd";

private static String driverName="com.mysql.jdbc.Driver";

private static String username="root";

private static String password="0410";


public static Connection getConnection() 
{
	
	//定义数据库连接对象
	Connection connection =null;
	//加载数据库驱动类
	try {
		Class.forName(driverName);
		
		connection=DriverManager.getConnection(url, username, password);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("找不到驱动，请检查是否导包");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("连接数据库出错，检查密码 和用户名之类还有url");
	}
	
	
	return connection;
	
}


}
