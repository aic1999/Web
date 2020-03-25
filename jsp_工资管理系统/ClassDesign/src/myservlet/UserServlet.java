package myservlet;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.mysql.fabric.Response;
import com.oracle.jrockit.jfr.RequestableEvent;

import entity.User;

import java.sql.Connection;
import java.sql.Date;

import util.ConnDB;
import util.PageBean;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private ConnDB connDB=new ConnDB();
	PreparedStatement preparedStatement;
	Connection connection=null;
	Statement statement=null;
	ResultSet rs=null;
	HttpSession session;
	boolean sign=false;
	SimpleDateFormat df ;
	private static final long serialVersionUID = 1L;
    public UserServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		connection=connDB.getConnection();
		session=request.getSession();
		df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		request.setCharacterEncoding("utf-8");
		//为什么request放在这里就有用？？？？
		//这个getAttibute在这里不好用，得到的null
		String action=request.getParameter("action");
		System.out.println(action);
		if (action.equals("revise")) {
			UpdateUser(request, response);
		}else if((action.equals("id"))){
			String sql="select * from worker where id ="+ request.getParameter("nd");
			readUser(request, response,sql);
		}else if((action.equals("name"))){
			//别忘了加上引号，因为name是String
			String sql="select * from worker where name ='"+ request.getParameter("nd")+"'";
			readUser(request, response,sql);
		}else if(action.equals("del")){
			deleteUser(request,response);
		}else if(action.equals("sign")){
			sign=true;
			String time=df.format(System.currentTimeMillis());
			String sql="update worker set signtime = '"+time+"' where id="+request.getParameter("id");
			timeUser(request,response,sql);
			if(session.getAttribute("user").equals("worker")){
				session.setAttribute("signtime",time );
			}
		}else if(action.equals("send")){
			String sql="update worker set sendtime = '"+df.format(System.currentTimeMillis())+"' ";
			timeUser(request,response,sql);
			culculate(request, response);
		}
		else if(action.equals("adduser")){
			addUser(request,response);
		}else if(action.equals("absent")){
			
			absentUser(request,response );
		}
	}
	private void absentUser(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		
		int[] aid=(int[])session.getAttribute("aid");
		 for(int i=0;aid[i]!=0;i++){ //id=0说明已经遍历完迟到的人了
	  	     System.out.println(aid[i]);
			 String sql="select * from worker where id = "+aid[i];
		     List<User> list = new ArrayList<User>();
				try {
					statement=connection.createStatement();
					rs = statement.executeQuery(sql);
					if(rs.next()){
		 				User user=new User();
						user.setSendtime(rs.getString(2));
						user.setSigntime(rs.getString(1));
						user.setPosition(rs.getString(9));
						user.setId(rs.getInt(8));
						user.setName(rs.getString(7));
						user.setDeduct(rs.getFloat(4));
						user.setWages(rs.getInt(6));
						user.setRewards(rs.getInt(5));
						list.add(user);				
					}
					request.setAttribute("users", list);
					//response.sendRedirect("absdetail.jsp");
					 request.getRequestDispatcher("absdetail.jsp")
					 .forward(request, response);	
				} catch (SQLException e) {
		 			e.printStackTrace();
				} 
		  }
	}
	private void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String name =request.getParameter("name");
		String psw =request.getParameter("psw");
		String deduct =request.getParameter("deduct");
		String rewards =request.getParameter("rewards");
		String wages =request.getParameter("wages");
		String position =request.getParameter("position");
		//是否可以在这里优化以下，如果connection是静态变量。那么就不用每一次创建操作对象的时候就创建一次对象把？直接使用ULS中的能做得到么？
		//Field 'id' doesn't have a default value
		//解决：在mysql中设置自增id即可
		String sql="insert into worker(name,psw,deduct,rewards,wages,position)values(?,?,?,?,?,?)";
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, psw);
			preparedStatement.setString(3, deduct);
			preparedStatement.setString(4, rewards);
			preparedStatement.setString(5, wages);
			preparedStatement.setString(6, position);
			int i=preparedStatement.executeUpdate();
			if(i>0){
				System.out.print("input ok");
			}else{
				System.out.print("input error");
			}
			response.sendRedirect("userList");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private void readUser(HttpServletRequest request,HttpServletResponse response,String sql) throws IOException, ServletException{
		try {
			statement=connection.createStatement();
			ResultSet rSet = statement.executeQuery(sql);
			if(rSet.next()){
				request.setAttribute("name", rSet.getString(7));
				request.setAttribute("wages", rSet.getInt(6));
				request.setAttribute("rewards", rSet.getInt(5));
				request.getRequestDispatcher("workerView.jsp").forward(request, response);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void culculate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String sql="select wages from worker ";
		int totalWages=0;
		int oldMoney=0;
		int i;
		try {
			statement=connection.createStatement();
			ResultSet rSet = statement.executeQuery(sql);
			while(rSet.next()){
				totalWages+=rSet.getInt(1);
			}
			sql="select money from info";
			rSet = statement.executeQuery(sql);
			if(rSet.next()){
				oldMoney=rSet.getInt(1);
			}
			sql="update info set money=? ";
			preparedStatement = connection.prepareStatement(sql);
			//这个索引是对应问号的，不是对应数据库的
			if((oldMoney-totalWages)>=0){
				preparedStatement.setInt(1, oldMoney-totalWages);
		 
				i=preparedStatement.executeUpdate();
			}else{
				//这个和超链接传参都需要用${param.}(或者getParameter)接受
				response.sendRedirect("NoMoney.jsp?needMoney="+totalWages+"&curMoney="+oldMoney);
				return;//不加上这个会报错IllegalComponentStateException ,如果刚好余额不足就不会走下面的语句了，如果走了下面的语句就会响应两次...所以报错
			}
			response.sendRedirect("userList");
			return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	private void timeUser(HttpServletRequest request,HttpServletResponse response,String sql) throws IOException{
		try {
			statement=connection.createStatement();
			int i = statement.executeUpdate(sql);//不是执行语句了
			if(i>0){
				System.out.print("time ok！");
				if(sign){
					response.sendRedirect("test.jsp");
					sign=false;
					return;
				}
			}else{
				System.out.print("time error！");
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private void deleteUser(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String id = request.getParameter("id");
		String sql="delete from worker where id="+id;
		int i = 0;
		try {
			statement=connection.createStatement();
			i = statement.executeUpdate(sql);//不是执行语句了
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(i>0)
			System.out.print("delete ok");
		else 
			System.out.print("delete error");
		response.sendRedirect("userList");
		
	}
	private void UpdateUser(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String sql="update worker set deduct=?,rewards=?,wages=?,position=? ,name=?,psw=? where id="+request.getParameter("id");
		try {
			preparedStatement = connection.prepareStatement(sql);
			//这个索引是对应问号的，不是对应数据库的
			preparedStatement.setString(5,  request.getParameter("name"));
			preparedStatement.setString(6,  request.getParameter("psw"));
			preparedStatement.setString(4, request.getParameter("position"));
			if(session.getAttribute("user").equals("manager")){
				preparedStatement.setInt(2, Integer.parseInt(request.getParameter("rewards")));
				preparedStatement.setInt(3, Integer.parseInt(request.getParameter("wages")));
				preparedStatement.setFloat(1, Float.parseFloat(request.getParameter("deduct")));
			}else{
				preparedStatement.setInt(2, (int) session.getAttribute("rewards"));
				preparedStatement.setInt(3, (int)session.getAttribute("wages"));
				preparedStatement.setFloat(1, (float)session.getAttribute("deduct"));
			}
			int i=preparedStatement.executeUpdate();
			if(i>0){
				System.out.print("revise ok！");
				
			}else{
				System.out.print("revise error！");
			}
			
			//重定向
			//request.getRequestDispatcher("userlist")
			//.forward(request,response);
			if(session.getAttribute("user").equals("manager")){
				response.sendRedirect("userList");
			}else{
				response.sendRedirect("workerView.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
