package com.tcs.developmentbooksttd2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.developmentbooksttd2.model.Books;
import com.tcs.developmentbooksttd2.model.BooksInput;
import com.tcs.developmentbooksttd2.service.BooksService;

@RestController
public class DevelopmentBooksController {

	@Autowired
	BooksService service;

	@GetMapping("/getAllBooks")
	public List<Books> getAllAvailableBooksName() {
		return service.getAllBooks();
	}
	
	@PostMapping("/buyBooks")
	public double buyBooks(@RequestBody List<BooksInput> booksBought) {
		return service.calculateBooksCostWithDiscount(booksBought);
	}
}
