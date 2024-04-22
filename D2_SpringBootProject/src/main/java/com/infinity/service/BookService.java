package com.infinity.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.infinity.model.Book;

public class BookService 
{
	private static  List<Book> list=new ArrayList<>();
	
	static
	{
		list.add(new Book(101, "Java", "James Goshling"));
		list.add(new Book(102, "Python", "James Goshling"));
		list.add(new Book(103, "C++", "Yashwant Kanitkar"));
		list.add(new Book(104, "JavaScript", "Balaji Gapat"));
		list.add(new Book(105, "Kotlin", "James Goshling"));	
	}
	
	public List<Book> getAllBooks()
	{
		return list;
	}
	
	public Book getBookById(int id)
	{
		 Optional<Book> optinalBook= list.stream()
				 						.filter(book->book.getId()==id)
				 						.findFirst();
		 
		 if(optinalBook.isPresent())
			 return optinalBook.get();
		 else
			 return null;
	}
	
}
