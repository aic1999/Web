package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//���ͣ������ʱ��֪����ʲô���ͣ�ʹ�õ�ʱ��֪��
public class PageBean {
	public int pageNum=1;	//	��ǰҳ��,Ĭ��
	public int totalCount=0;	//	����
	public int totalPage=0; //��ҳ��
	public int pageSize=15;	//ÿҳ��¼��,д�����̶�15��
	public PageBean(){
		pageUser();
		culPageNum();
	}
	public void culPageNum(){
		if(totalCount%pageSize==0){
			this.totalPage=totalCount/pageSize;
		}else{
			this.totalPage=totalCount/pageSize +1;
		}
	}
	public void pageUser( )  {
		String sql="select count(*) from worker";
		ConnDB connDB= new ConnDB();
		Connection connection=null;
		Statement statement=null;
		ResultSet rs=null;
		connection=connDB.getConnection();
		try {
			statement=connection.createStatement();
			ResultSet rSet = statement.executeQuery(sql);
			if(rSet.next()){
				this.totalCount=rSet.getInt(1);
				System.out.print("�õ���������"+this.totalCount);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
