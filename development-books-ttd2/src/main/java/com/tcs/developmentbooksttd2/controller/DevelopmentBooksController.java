package com.tcs.developmentbooksttd2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.developmentbooksttd2.service.BooksService;

@RestController
public class DevelopmentBooksController {

	@Autowired
	BooksService service;

	@GetMapping("/getAllBooks")
	public List<String> getAllAvailableBooksName() {
		return service.getAllBooks();
	}
}
