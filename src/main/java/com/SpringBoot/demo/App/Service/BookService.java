package com.SpringBoot.demo.App.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBoot.demo.App.Entity.BookEntity;
import com.SpringBoot.demo.App.Repository.BookRepository;

@Service
public class BookService implements IBook{

	@Autowired
	BookRepository bookRepo;
	@Override
	public BookEntity saveBookDetails(BookEntity bookInfo) {
		BookEntity receivedBookData=bookRepo.save(bookInfo);
		return receivedBookData;
		
	}

	public List<BookEntity> readAllBooks() {
		List<BookEntity> receivedAllBooks=bookRepo.findAll();
		return receivedAllBooks;
	}

	@Override
	public BookEntity readParticularBook(int bookId) {
		BookEntity receivedParticulaeBook=bookRepo.findById(bookId).get();
		return receivedParticulaeBook;
	}

	@Override
	public String removeParticularBook(int id) {
		bookRepo.deleteById(id);
		return "Delete particular book successfully" ;
	}

	
	public BookEntity updateTheParticularBook(BookEntity bookData) {
	BookEntity receivedUpdatedData=bookRepo.findById(bookData.getBookId()).get();
	
	receivedUpdatedData.setBookId(bookData.getBookId());
	receivedUpdatedData.setBookImage(bookData.getBookImage());
	receivedUpdatedData.setBookTitle(bookData.getBookTitle());
	receivedUpdatedData.setBookAuthor(bookData.getBookAuthor());
	receivedUpdatedData.setBookISBN(bookData.getBookISBN());
	receivedUpdatedData.setBookPrice(bookData.getBookPrice());
	
	BookEntity savedUpdatedBookData=bookRepo.save(receivedUpdatedData);
	return savedUpdatedBookData;
	}

}
