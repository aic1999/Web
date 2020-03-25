package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//泛型，定义的时候不知道是什么类型，使用的时候知道
public class PageBean {
	public int pageNum=1;	//	当前页数,默认
	public int totalCount=0;	//	总数
	public int totalPage=0; //总页数
	public int pageSize=15;	//每页记录数,写死，固定15条
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
				System.out.print("得到了总数："+this.totalCount);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
