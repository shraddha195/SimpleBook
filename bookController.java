package com.example.LabraryManageSystem;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Book")
public class BookController {
	private final BookService bookserv;

	public BookController(BookService bookserv) {
	    this.bookserv = bookserv;
	}

	
	//get all data
	@GetMapping
	public String alldata(Model model){
	    List<Book> all = bookserv.getAll();
	    System.out.println("Fetched Records: " + all);
	    model.addAttribute("book", all);
	    return "book";
	}

	
	//add new
	@GetMapping("/register")
	public String savedata(Model model) {
		Book book=new Book();
		model.addAttribute("book", book); // matches th:object="${library}"
		return "register";
	}
	


	
	//save data
	@PostMapping("/save")
		public String save(@ModelAttribute("Book") Book book) {
		bookserv.addNew(book);
			return "redirect:/Book";
		
	
}
}
