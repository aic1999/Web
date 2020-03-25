package myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import entity.User;
import util.ConnDB;
import util.PageBean;

@WebServlet("/userList")
public class UserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PageBean pageBean=new PageBean();
	
	//重新跳回这个界面，他的全局变量会重新赋值么？不会
    public UserListServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//每次进来，都从新读取记录数目（新增了怎么办）
		pageBean.pageUser();
		pageBean.culPageNum();
		ConnDB connDB= new ConnDB();
		String num=request.getParameter("pageNum");
		if(num!=null&&!num.equals(""))
			pageBean.pageNum=Integer.parseInt(num);
		String sql = "select * from worker limit "+(pageBean.pageNum-1)*pageBean.pageSize+","+pageBean.pageSize+"";;
		Connection connection=null;
		Statement statement=null;
		ResultSet rs=null;
		connection=connDB.getConnection();
		List<User> list = new ArrayList<User>();
		try {
			statement=connection.createStatement();
			rs = statement.executeQuery(sql);
			while(rs.next()){
				//如果记录类型不匹配则会出现sqlexception
				User user=new User();
				user.setSendtime(rs.getString(2));
				user.setSigntime(rs.getString(1));
				user.setPosition(rs.getString(9));
				user.setId(rs.getInt(8));
				user.setName(rs.getString(7));
				user.setDeduct(rs.getFloat(4));
				user.setWages(rs.getInt(6));
				user.setRewards(rs.getInt(5));
				user.setPsw(rs.getString(3));
				list.add(user);				
			}
			request.setAttribute("users", list);
			request.setAttribute("pageNum", pageBean.pageNum);
			request.setAttribute("totalCount", pageBean.totalCount);
			request.setAttribute("totalPage", pageBean.totalPage);
			request.setAttribute("pageSize", pageBean.pageSize);

			request.getRequestDispatcher("MangerView.jsp")
			.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
