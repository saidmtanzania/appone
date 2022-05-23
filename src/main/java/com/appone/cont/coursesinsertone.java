package com.appone.cont;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class coursesinsertone
 */
@WebServlet("/coursesinsertone")
public class coursesinsertone extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public coursesinsertone() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String regNo= (String) session.getAttribute("name");
		String courses[] = request.getParameterValues("semesterone");
		
		String choose = "";
		PrintWriter out = response.getWriter();
				for(int i=0;i<courses.length;i++) {
					choose+=courses[i]+" ";
				}
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useSSL=false","root","");
					PreparedStatement pst = con.prepareStatement("INSERT INTO course (regNo, cname, semester) VALUES (?,?,?)");
					pst.setString(1, regNo);
					pst.setString(2, choose);
					pst.setInt(3, 1);
					pst.executeUpdate();
					out.println("Successfully inserted");
					response.sendRedirect("semesterone");	}catch(Exception e) {
		e.printStackTrace();
	}
	}
		

}
