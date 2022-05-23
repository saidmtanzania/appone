package com.appone.cont;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class studentServlet
 */
@WebServlet("/register")
public class studentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname = request.getParameter("firstname");
		String mname = request.getParameter("middlename");
		String sname = request.getParameter("surname");
		String regnum = request.getParameter("regnumber");
		String passwd = request.getParameter("password");
		RequestDispatcher disp = null;
		String INSERT = "INSERT INTO student (`fname`, `mname`, `sname`, `regno`, `passwd`)"+" VALUES"+"(?,?,?,?,?)";
		int result = 0;
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useSSL=false","root","");
			PreparedStatement preparedStatement = conn.prepareStatement(INSERT);
				preparedStatement.setString(1, fname);
				preparedStatement.setString(2, mname);
				preparedStatement.setString(3, sname);
				preparedStatement.setString(4, regnum);
				preparedStatement.setString(5,hashPassword(passwd));
				result = preparedStatement.executeUpdate();
				
				
				if(result == 0) {
					request.setAttribute("status", "failed");
					disp = request.getRequestDispatcher("register.jsp");
				}else {
					request.setAttribute("status", "success");
					disp = request.getRequestDispatcher("register.jsp");
				}
				disp.forward(request, response);
				
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private String hashPassword(String password) {
		  String hashword = null;
		  try {
		    MessageDigest md5 = MessageDigest.getInstance("MD5");
		    md5.update(password.getBytes());
		    BigInteger hash = new BigInteger(1, md5.digest());
		    hashword = hash.toString(16);

		  } catch (NoSuchAlgorithmException nsae) {
		    //Log exception}
		}
		return hashword;
	};
}
