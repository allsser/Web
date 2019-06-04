package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDAO;
import service.BookService;
import service.BookServiceImpl;
import vo.BookVO;

@WebServlet("/book.do")
public class InsertBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");  //요청
		response.setContentType("text/html;charset=utf-8");  //html에서 한들 출력, 응답
		
		PrintWriter out = response.getWriter();
	
		String bookno = request.getParameter("bookno");
		String title = request.getParameter("title");
		String price = request.getParameter("price");
		
			
		if(bookno != null) {
			//response.sendRedirect("./login.html");
			BookDAO dao = new BookDAO();
			BookService service = new BookServiceImpl(dao); 	
			
			BookVO user = new BookVO("bookno", "title", 1234);
			try {
				service.addBook(user);
				out.print("성굥");
			} catch (Exception e) {
				out.print("실패");
			}
		
			if(service != null) {	
				List<BookVO> list = service.bookList();
				list.forEach(i->System.out.println(i));
			}		
		}
		
	}

}
