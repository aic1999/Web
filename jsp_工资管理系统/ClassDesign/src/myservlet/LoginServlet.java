package myservlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.sun.xml.internal.bind.v2.model.core.ID;
import com.sun.xml.internal.bind.v2.runtime.Name;

import util.ConnDB;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    request.setCharacterEncoding("utf-8");
			login(request, response);
		 
	}
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		session.setAttribute("user", request.getParameter("user"));
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		//这如果是getAttribute就会得到 null 
		String sql = "select * from "+request.getParameter("user")+" where name='"+username+
				"' and psw='"+pwd+"'";
		//2.连接数据库
		ConnDB db = new ConnDB();
		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet=null;
		connection=db.getConnection();
		try {
			statement=connection.createStatement();
			ResultSet rSet = statement.executeQuery(sql);
			if(rSet.next()){
				if(request.getParameter("user").equals("worker")){
				//用户存在，保存用户信息到session
//				request.setAttribute("id", rSet.getInt(8));
//				request.setAttribute("name", username);
//				request.setAttribute("wages", rSet.getInt(6));
//				request.setAttribute("rewards", rSet.getInt(5));
//				request.setAttribute("position", rSet.getString(9));
//				request.setAttribute("deduct", rSet.getFloat(4));
//				request.setAttribute("signtime", rSet.getString(1));
				
				session.setAttribute("id", rSet.getInt(8));
				session.setAttribute("name", username);
				session.setAttribute("wages", rSet.getInt(6));
				session.setAttribute("rewards", rSet.getInt(5));
				session.setAttribute("position", rSet.getString(9));
				session.setAttribute("deduct", rSet.getFloat(4));
				session.setAttribute("signtime", rSet.getString(1));
				//没有下面那个，修改密码的时候就是""值，稳妥一点
				//session.setAttribute("psw",  rSet.getString(2));
				System.out.print("loginservlet:success in worker");
				//跳转到主页面
				//request.getRequestDispatcher("workerView.jsp").forward(request, response);
				response.sendRedirect("workerView.jsp");
			
				}else{
					request.setAttribute("name", username);
					System.out.println("loginservlet:success in manager");
					//跳转到主页面
					response.sendRedirect("userList");
					//request.getRequestDispatcher("userList").forward(request, response);
				}
			}
			else{
				System.out.print("fail in");
				//返回登陆页面
				response.sendRedirect("login.jsp");
				session.setAttribute("loginError", "1");
				//request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
