package com.appone.cont;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class studentLogin
 */
@WebServlet("/login")
public class studentLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String regNo = request.getParameter("regNumber");
		String passwd = request.getParameter("pass");
		
		HttpSession session = request.getSession();
		RequestDispatcher dispt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useSSL=false","root","");
			PreparedStatement pst = con.prepareStatement("SELECT * FROM student WHERE regno = ? and passwd = ?");
			pst.setString(1, regNo);
			pst.setString(2, hashPassword(passwd));
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				session.setAttribute("name", rs.getString("regNo"));
				dispt = request.getRequestDispatcher("dashboard.jsp");
			}else {
				request.setAttribute("status", "failed");
				dispt = request.getRequestDispatcher("index.jsp");
			}
			dispt.forward(request, response);
;		}catch(Exception e) {
			e.printStackTrace();
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
