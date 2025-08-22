package com.example.LabraryManageSystem;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	@Autowired
	private final BookRepository bookrepo;
	
	public BookService(BookRepository bookrepo) {
		this.bookrepo=bookrepo;
	}
	
	//fetch by id
	public Book getById(long Bookno) {
		return bookrepo.findById(Bookno).orElse(null);
	}
	
	//fetch all
	public List<Book> getAll(){
		return bookrepo.findAll();
	}
	
	//add new
	public void addNew(Book book) {
		bookrepo.save(book);
	}
	
	//update
	public void update(Book book) {
		bookrepo.save(book);
	}
	
	//delet by id
	public void delete(Long Bookno) {
		bookrepo.deleteById(Bookno);
	}
}
