package servlet;

import java.io.IOException;
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


@WebServlet("/list.do")
public class ListBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDAO dao = new BookDAO();
		BookService service = new BookServiceImpl(dao);
		List<BookVO> list = service.bookList();
		
		request.setAttribute("list", list);
		
		getServletContext().
		getRequestDispatcher("/bookList.jsp").
		forward(request, response);
	}

}
