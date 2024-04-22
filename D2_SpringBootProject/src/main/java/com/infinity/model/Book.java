package com.infinity.model;

public class Book 
{
	private int id;
	private String bookTitle;
	private String author;
	
	public Book() 
	{
		super();
	}

	public Book(int id, String bookTitle, String author) 
	{
		super();
		this.id = id;
		this.bookTitle = bookTitle;
		this.author = author;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getBookTitle() 
	{
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) 
	{
		this.bookTitle = bookTitle;
	}

	public String getAuthor()
	{
		return author;
	}

	public void setAuthor(String author) 
	{
		this.author = author;
	}

	@Override
	public String toString()
	{
		return "Book [id=" + id + ", bookTitle=" + bookTitle + ", author=" + author + "]";
	}

}
