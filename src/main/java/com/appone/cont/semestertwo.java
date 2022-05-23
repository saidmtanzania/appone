package com.appone.cont;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class semestertwo
 */
@WebServlet("/semestertwo")
public class semestertwo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public semestertwo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String regNo= (String) session.getAttribute("name");
		String str = "<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "<head>\r\n"
				+ "	<title>Dashboard</title>\r\n"
				+ "	<meta charset=\"UTF-8\">\r\n"
				+ "	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
				+ "<!--===============================================================================================-->	\r\n"
				+ "	<link rel=\"icon\" type=\"image/png\" href=\"images/icons/favicon.ico\"/>\r\n"
				+ "<!--===============================================================================================-->\r\n"
				+ "	<link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/bootstrap/css/bootstrap.min.css\">\r\n"
				+ "<!--===============================================================================================-->\r\n"
				+ "	<link rel=\"stylesheet\" type=\"text/css\" href=\"fonts/font-awesome-4.7.0/css/font-awesome.min.css\">\r\n"
				+ "<!--===============================================================================================-->\r\n"
				+ "	<link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/animate/animate.css\">\r\n"
				+ "<!--===============================================================================================-->	\r\n"
				+ "	<link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/css-hamburgers/hamburgers.min.css\">\r\n"
				+ "<!--===============================================================================================-->\r\n"
				+ "	<link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/select2/select2.min.css\">\r\n"
				+ "<!--===============================================================================================-->\r\n"
				+ "	<link rel=\"stylesheet\" type=\"text/css\" href=\"css/util.css\">\r\n"
				+ "	<link rel=\"stylesheet\" type=\"text/css\" href=\"css/main2.css\">\r\n"
				+ "	<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css\">\r\n"
				+ "<!--=============== CSS ===============-->\r\n"
				+ "    <link rel=\"stylesheet\" href=\"assets/css/styles.css\">\r\n"
				+ "<!--===============================================================================================-->\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "	<div class=\"limiter\">\r\n"
				+ "		<div class=\"container-login100\">\r\n"
				+ "			<div class=\"wrap-login100\">\r\n"
				+ "			<span class=\"login100-form-title\">\r\n"
				+ "						DASHBOARD\r\n"
				+ "					</span>\r\n"
				+ "					<div class=\"container\">\r\n"
				+ "						  <h6>SEMESTER I</h6>\r\n"
				+ "						  <table class=\"table table-dark text-dark\">\r\n"
				+ "						    <thead>\r\n"
				+ "						      <tr>\r\n"
				+ "						        <th>COURSE NAME</th>\r\n"
				+ "						      </tr>\r\n"
				+ "						    </thead>";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useSSL=false","root","");
			PreparedStatement pst = con.prepareStatement("SELECT cname FROM course WHERE regno = ? and semester=2");
			pst.setString(1, regNo);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				str+="<tbody>     \r\n"
						+ "						      <tr >\r\n"
						+ "						        <td>"+rs.getString(1)+"</td>\r\n"
						+ "						      </tr>\r\n"
						+ "						    </tbody>";
			}
			str+="</table>\r\n"
					+ "						  <div class=\"row\">\r\n"
					+ "						  <div class=\"col-md-3\">\r\n"
					+ "						  <button type=\"button\" class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#myModal\">\r\n"
					+ "						    Register Semester I\r\n"
					+ "						  </button>\r\n"
					+ "						  </div>\r\n"
					+ "						  <div class=\"col-md-6\">\r\n"
					+ "						 <!-- The Modal -->\r\n"
					+ "							  <div class=\"modal fade\" id=\"myModal\">\r\n"
					+ "							    <div class=\"modal-dialog \">\r\n"
					+ "							      <div class=\"modal-content\">\r\n"
					+ "							      \r\n"
					+ "							        <!-- Modal Header -->\r\n"
					+ "							        <div class=\"modal-header\">\r\n"
					+ "							          <h4 class=\"modal-title\">Semester I courses</h4>\r\n"
					+ "							          <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\r\n"
					+ "							        </div>\r\n"
					+ "							        <form action=\"coursesinsertone\" method=\"post\">\r\n"
					+ "							        <!-- Modal body -->\r\n"
					+ "							        <div class=\"modal-body\">\r\n"
					+ "							          <div class=\"form-group form-check\">\r\n"
					+ "									    <label class=\"form-check-label\">\r\n"
					+ "									      <input class=\"form-check-input\" name=\"semesterone\" type=\"checkbox\"> CP 311 Internet programming II\r\n"
					+ "									    </label>\r\n"
					+ "									  </div>\r\n"
					+ "									  <div class=\"form-group form-check\">\r\n"
					+ "									    <label class=\"form-check-label\">\r\n"
					+ "									      <input class=\"form-check-input\" name=\"semesterone\" type=\"checkbox\"> CP 312 Python programming\r\n"
					+ "									    </label>\r\n"
					+ "									  </div>\r\n"
					+ "									  <div class=\"form-group form-check\">\r\n"
					+ "									    <label class=\"form-check-label\">\r\n"
					+ "									      <input class=\"form-check-input\" name=\"semesterone\" type=\"checkbox\"> CP 313 Mobile app development\r\n"
					+ "									    </label>\r\n"
					+ "									  </div>\r\n"
					+ "									  <div class=\"form-group form-check\">\r\n"
					+ "									    <label class=\"form-check-label\">\r\n"
					+ "									      <input class=\"form-check-input\" name=\"semesterone\" type=\"checkbox\"> CT 314 embedded system\r\n"
					+ "									    </label>\r\n"
					+ "									  </div>\r\n"
					+ "									  <div class=\"form-group form-check\">\r\n"
					+ "									    <label class=\"form-check-label\">\r\n"
					+ "									      <input class=\"form-check-input\" name=\"semesterone\" type=\"checkbox\"> EME 311 ICT Entrepreneur\r\n"
					+ "									    </label>\r\n"
					+ "									  </div>\r\n"
					+ "									  <div class=\"form-group form-check\">\r\n"
					+ "									    <label class=\"form-check-label\">\r\n"
					+ "									      <input class=\"form-check-input\" name=\"semesterone\" type=\"checkbox\"> MT 3111 Mathematical logic\r\n"
					+ "									    </label>\r\n"
					+ "									  </div>\r\n"
					+ "									  <div class=\"form-group form-check\">\r\n"
					+ "									    <label class=\"form-check-label\">\r\n"
					+ "									      <input class=\"form-check-input\" name=\"semesterone\" type=\"checkbox\"> CP 318 Computer graphic\r\n"
					+ "									    </label>\r\n"
					+ "									  </div>\r\n"
					+ "									  <div class=\"form-group form-check\">\r\n"
					+ "									    <label class=\"form-check-label\">\r\n"
					+ "									      <input class=\"form-check-input\" name=\"semesterone\" type=\"checkbox\"> CP 316 Selected topic in SE\r\n"
					+ "									    </label>\r\n"
					+ "									  </div>\r\n"
					+ "									 \r\n"
					+ "							        </div>\r\n"
					+ "							        <!-- Modal footer -->\r\n"
					+ "							        <div class=\"modal-footer\">\r\n"
					+ "							           <button type=\"button\" class=\"btn btn-danger\" data-dismiss=\"modal\">Cancel</button>\r\n"
					+ "							          <button type=\"submit\" class=\"btn btn-primary\">Register</button>\r\n"
					+ "							        </div>\r\n"
					+ "							      </form>\r\n"
					+ "							      </div>\r\n"
					+ "							    </div>\r\n"
					+ "							  </div>\r\n"
					+ "							   <!-- The Modal -->\r\n"
					+ "							  <div class=\"modal fade\" id=\"myModal2\">\r\n"
					+ "							    <div class=\"modal-dialog \">\r\n"
					+ "							      <div class=\"modal-content\">\r\n"
					+ "							      \r\n"
					+ "							        <!-- Modal Header -->\r\n"
					+ "							        <div class=\"modal-header\">\r\n"
					+ "							          <h4 class=\"modal-title\">Semester II courses</h4>\r\n"
					+ "							          <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\r\n"
					+ "							        </div>\r\n"
					+ "							        \r\n"
					+ "							        <!-- Modal body -->\r\n"
					+ "							        <div class=\"modal-body\">\r\n"
					+ "							        <form action=\"coursesinserttwo\" method=\"POST\">\r\n"
					+ "							            <div class=\"form-group form-check\">\r\n"
					+ "									    <label class=\"form-check-label\">\r\n"
					+ "									      <input class=\"form-check-input\" name=\"semestertwo\" type=\"checkbox\"> CP 321 Distributed database system\r\n"
					+ "									    </label>\r\n"
					+ "									  </div>\r\n"
					+ "									  <div class=\"form-group form-check\">\r\n"
					+ "									    <label class=\"form-check-label\">\r\n"
					+ "									      <input class=\"form-check-input\" name=\"semestertwo\" type=\"checkbox\"> CP 322 Data mining and warehousing\r\n"
					+ "									    </label>\r\n"
					+ "									  </div>\r\n"
					+ "									  <div class=\"form-group form-check\">\r\n"
					+ "									    <label class=\"form-check-label\">\r\n"
					+ "									      <input class=\"form-check-input\" name=\"semestertwo\" type=\"checkbox\"> CP 323 Web framework development using JavaScript\r\n"
					+ "									    </label>\r\n"
					+ "									  </div>\r\n"
					+ "									  <div class=\"form-group form-check\">\r\n"
					+ "									    <label class=\"form-check-label\">\r\n"
					+ "									      <input class=\"form-check-input\" name=\"semestertwo\" type=\"checkbox\"> CS 324 Advanced Java programming language\r\n"
					+ "									    </label>\r\n"
					+ "									  </div>\r\n"
					+ "									  <div class=\"form-group form-check\">\r\n"
					+ "									    <label class=\"form-check-label\">\r\n"
					+ "									      <input class=\"form-check-input\" name=\"semestertwo\" type=\"checkbox\"> IA 321 Information communication and system security\r\n"
					+ "									    </label>\r\n"
					+ "									  </div>\r\n"
					+ "									  <div class=\"form-group form-check\">\r\n"
					+ "									    <label class=\"form-check-label\">\r\n"
					+ "									      <input class=\"form-check-input\" name=\"semestertwo\" type=\"checkbox\"> IA 326 Secure system development\r\n"
					+ "									    </label>\r\n"
					+ "									  </div>\r\n"
					+ "									  <div class=\"form-group form-check\">\r\n"
					+ "									    <label class=\"form-check-label\">\r\n"
					+ "									      <input class=\"form-check-input\" name=\"semestertwo\" type=\"checkbox\"> CP 326 Compiler technology\r\n"
					+ "									    </label>\r\n"
					+ "									  </div>\r\n"
					+ "							        \r\n"
					+ "							        <!-- Modal footer -->\r\n"
					+ "							        <div class=\"modal-footer\">\r\n"
					+ "							          <button type=\"button\" class=\"btn btn-danger\" data-dismiss=\"modal\">Cancel</button>\r\n"
					+ "							          <button type=\"submit\" class=\"btn btn-primary\">Register</button>\r\n"
					+ "							        </div>\r\n"
					+ "							        </form>\r\n"
					+ "							      </div>\r\n"
					+ "							    </div>\r\n"
					+ "							  </div>\r\n"
					+ "						  </div>\r\n"
					+ "						  </div>\r\n"
					+ "						  <div class=\"col-md-3\">\r\n"
					+ "						  <button type=\"button\" class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#myModal2\">\r\n"
					+ "						    Register Semester II\r\n"
					+ "						  </button>\r\n"
					+ "						  </div>\r\n"
					+ "						  </div>\r\n"
					+ "						    \r\n"
					+ "					</div>\r\n"
					+ "			</div>\r\n"
					+ "		</div>\r\n"
					+ "	</div>\r\n"
					+ "\r\n"
					+ "<!--===============================================================================================-->	\r\n"
					+ "	<script src=\"vendor/jquery/jquery-3.2.1.min.js\"></script>\r\n"
					+ "	<script src=\"assets/js/main.js\"></script>\r\n"
					+ "<!--===============================================================================================-->\r\n"
					+ "	<script src=\"vendor/bootstrap/js/popper.js\"></script>\r\n"
					+ "	<script src=\"vendor/bootstrap/js/bootstrap.min.js\"></script>\r\n"
					+ "<!--===============================================================================================-->\r\n"
					+ "	<script src=\"vendor/select2/select2.min.js\"></script>\r\n"
					+ "<!--===============================================================================================-->\r\n"
					+ "	<script src=\"vendor/tilt/tilt.jquery.min.js\"></script>\r\n"
					+ "	<script >\r\n"
					+ "		$('.js-tilt').tilt({\r\n"
					+ "			scale: 1.1\r\n"
					+ "		})\r\n"
					+ "	</script>\r\n"
					+ "<!--===============================================================================================-->\r\n"
					+ "	<script src=\"../js/main.js\"></script>\r\n"
					+ "</body>\r\n"
					+ "</html>";
			out.println(str);
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
