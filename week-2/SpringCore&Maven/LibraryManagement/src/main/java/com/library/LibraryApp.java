package com.library;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;
public class LibraryApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext  context= new ClassPathXmlApplicationContext("ApplicationContext.xml");
		BookService bs = context.getBean("bookService",BookService.class);
		bs.addBook("Book1");
		context.close();
	}

}
