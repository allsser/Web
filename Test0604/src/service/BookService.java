package service;

import java.util.List;

import vo.BookVO;

public interface BookService {  //이름에 Service 가 불어야 됨 규칙! 인터페이스 약속
	List<BookVO> bookList();
	
	//int addBook(String t, String a, int p, String d) throws Exception;
	int addBook(BookVO vo) throws Exception;  //위에있는 코드보다 깔끔하고 좋다. //insert

}
