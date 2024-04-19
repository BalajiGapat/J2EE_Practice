package com.infinity.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infinity.model.Book;
import com.infinity.service.BookService;

@RestController
//@ResponseBody
@RequestMapping("/api") //URL => http://localhost:8080/api
public class BookController  
{
	private BookService bookService=new BookService();
	
	//@RequestMapping(value="/home", method=RequestMethod.GET)
	@GetMapping("/home") //URL => http://localhost:8080/api/home
	public String home()
	{
		Book bk=new Book(123, "Java Programming", "James Goshling");
		System.out.println("book: "+bk);
		return "This is Home page!!! & Book: \n"+bk;
	}
	
	
	@GetMapping("/books") //URL =>  http://localhost:8080/api/books
	public List<Book> getAllBook()
	{
		bookService.getAllBooks().forEach(b->System.out.println(b));
		return bookService.getAllBooks();
	}
	
}
