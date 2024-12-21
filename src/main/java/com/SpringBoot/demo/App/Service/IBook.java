package com.SpringBoot.demo.App.Service;

import java.util.List;

import com.SpringBoot.demo.App.Entity.BookEntity;


public interface IBook {
	
	public BookEntity saveBookDetails(BookEntity bookInfo);
	public List<BookEntity> readAllBooks();
	public BookEntity readParticularBook(int id);
	public String removeParticularBook(int id);
	public BookEntity updateTheParticularBook(BookEntity bookData);
	

}
