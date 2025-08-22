package com.example.LabraryManageSystem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/Book")
@CrossOrigin(origins = "http://localhost:4200")
public class BookRestController {
	@Autowired
	private final BookService bookserv;

	public BookRestController(BookService bookserv) {
	    this.bookserv = bookserv;
	}
	
	@GetMapping
	public List<Book> listbook(){
		return bookserv.getAll();
	}
	
	@PostMapping("/register")
	public Book savelib(@RequestBody Book book) {
		bookserv.addNew(book);
		return book;
	}
	
	@GetMapping("/{Bookno}")
	public Book getLibById( @PathVariable("Bookno") Long Bookno) {
		Book book=bookserv.getById(Bookno);
		if(book!=null) {
			System.out.println("Book :"+book);
			return book;
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Book not found");
	}
	
	@PutMapping("/update/{Bookno}")
	public Book updateBook(@PathVariable("Bookno") Long Bookno,@RequestBody Book book1) {
		Book existbook=bookserv.getById(Bookno);
		if(existbook!=null) {
			existbook.setName(book1.getName());
			existbook.setAuthorname(book1.getAuthorname());
			existbook.setReceiveDate(book1.getReceiveDate());
			existbook.setPrice(book1.getPrice());
			existbook.setRemovingDate(book1.getRemovingDate());
			bookserv.update(existbook);
			return existbook;
		}
		return null;
	}
	
	@DeleteMapping("/delete/{Bookno}")
	public String deleteBook(@PathVariable("Bookno") Long Bookno) {
		bookserv.delete(Bookno);
		return Bookno+" Book Deleted SuccessFully";
	}
	
}
