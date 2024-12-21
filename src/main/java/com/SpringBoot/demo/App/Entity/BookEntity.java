package com.SpringBoot.demo.App.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name="books")
public class BookEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int bookId;
	//@Lob
	private String bookImage;
	private String bookTitle;
	private String bookAuthor;
	private int bookISBN;
	private int bookPrice;
	
	
	public BookEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public BookEntity(int bookId, String bookTitle, String bookAuthor, int bookISBN, int bookPrice) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.bookISBN = bookISBN;
		this.bookPrice = bookPrice;
	}


	public int getBookId() {
		return bookId;
	}


	public void setBookId(int bookId) {
		this.bookId = bookId;
	}


	public String getBookTitle() {
		return bookTitle;
	}


	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}


	public String getBookAuthor() {
		return bookAuthor;
	}


	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}


	public int getBookISBN() {
		return bookISBN;
	}


	public void setBookISBN(int bookISBN) {
		this.bookISBN = bookISBN;
	}


	public int getBookPrice() {
		return bookPrice;
	}


	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}


	public String getBookImage() {
		return bookImage;
	}


	public void setBookImage(String bookImage) {
		this.bookImage = bookImage;
	}
	
	

}
