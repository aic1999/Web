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
	
	//�������ݿ����Ӷ���
	Connection connection =null;
	//�������ݿ�������
	try {
		Class.forName(driverName);
		
		connection=DriverManager.getConnection(url, username, password);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("�Ҳ��������������Ƿ񵼰�");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("�������ݿ����������� ���û���֮�໹��url");
	}
	
	
	return connection;
	
}


}
