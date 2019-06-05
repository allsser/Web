package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login.do")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");  //요청
		response.setContentType("text/html;charset=utf-8");  //html에서 한들 출력, 응답
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		PrintWriter out = response.getWriter();
		
		
		if(id == null || pw == null || id.length() == 0 || pw.length() == 0 ) {
			response.sendRedirect("./login.jsp");
			return;
		}
		
		if(id.equals("scott") && pw.equals("1234")) {
			response.sendRedirect("./index.jsp");
			
		} else {
			response.sendRedirect("./login.html");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
