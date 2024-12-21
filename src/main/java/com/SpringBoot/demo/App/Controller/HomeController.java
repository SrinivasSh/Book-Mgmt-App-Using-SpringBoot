package com.SpringBoot.demo.App.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.SpringBoot.demo.App.Entity.BookEntity;
import com.SpringBoot.demo.App.Service.BookService;

@Controller
public class HomeController {
	
	@Autowired
	BookService bookService;

	@GetMapping("/")
	public String displayHomePage()
	{
		return "homePage";
	}
	
	@GetMapping("/addBook")
	public String displayBookForm(Model bookBasket)
	{
		
		bookBasket.addAttribute("bookRef", new BookEntity());
		return "addBook";
	}
	
		
	@PostMapping("/collect/book")
	public String collectBookDetails(@ModelAttribute BookEntity bookInfo)
	{
		
		BookEntity receivedBookInfo=bookService.saveBookDetails(bookInfo);
	
		return "confirmBook";
		
	}
	
	@GetMapping("/read/allBooks")
	public String viewAllBooks(Model dataBasket)
	{
		List<BookEntity>receivedAllBooksInfo=bookService.readAllBooks();
		dataBasket.addAttribute("allBooks",receivedAllBooksInfo);
		return "allBooks";
	}
	
	@GetMapping("/read/particular/book/{bookId}")
	public String viewParticularBook(@PathVariable String bookId, Model dataBasket) {
		
		BookEntity particularBookInfo=bookService.readParticularBook(Integer.parseInt(bookId));
		dataBasket.addAttribute("particularBookData",particularBookInfo);
		return "particularBook";
	}
	
	@GetMapping("/delete/particular/book/{bookId}")
	public String deleteParticularBook(@PathVariable String bookId,Model messageBasket) {
		String deleteParticularBookInfo=bookService.removeParticularBook(Integer.parseInt(bookId));
		messageBasket.addAttribute("deleteMessage",deleteParticularBookInfo);
		return "deleteConfirmation";
		
	}
	
	
	//update the particular book
	@GetMapping("/update/particular/book/{BookId}")
	public String updateParticularBook(@PathVariable String BookId,Model bookBasket)
	{
		BookEntity receivedUpdatedBookData=bookService.readParticularBook(Integer.parseInt(BookId));
		bookBasket.addAttribute("bookData",receivedUpdatedBookData);
		return "bookUpdateForm";
		
	}
	
	
	//Collected updated Book Data
	@PostMapping("/collect/update/ParticularBook")
	public String collectUpdatedBookData(@ModelAttribute BookEntity receivedUpdatedBookData) {
		BookEntity receivedSavedData=bookService.updateTheParticularBook(receivedUpdatedBookData);
		return "redirect:/read/allBooks";
	}
	
}
