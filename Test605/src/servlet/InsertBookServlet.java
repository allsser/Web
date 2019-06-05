package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BookDAO;
import service.BookService;
import service.BookServiceImpl;
import vo.BookVO;

@WebServlet("/book.do")
public class InsertBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");  //요청
		response.setContentType("text/html;charset=utf-8");  //html에서 한들 출력, 응답
		
		PrintWriter out = response.getWriter();
	
		BookDAO dao = new BookDAO();
		BookService service = new BookServiceImpl(dao); 	
		BookVO vo = new BookVO();
		vo.setAuthor(request.getParameter("author"));
		vo.setPrice(Integer.parseInt(request.getParameter("price")));
		vo.setTitle(request.getParameter("title"));
		
		try {		
			int i = service.addBook(vo);
			response.sendRedirect("list.do");
			//out.print("<h1>"+i+"개의 row 입력 완료");
		} catch (Exception e) {
			//out.print("<h2> 문제 발생 : "+ e);
			request.setAttribute("exception", e);
			
			getServletContext().
			getRequestDispatcher("/error.jsp").
			forward(request, response);
			//response.sendRedirect("error.jsp");
		}
		
		if(service != null) {	
			List<BookVO> list = service.bookList();
			list.forEach(i->System.out.println(i));		
		}
	}
}
