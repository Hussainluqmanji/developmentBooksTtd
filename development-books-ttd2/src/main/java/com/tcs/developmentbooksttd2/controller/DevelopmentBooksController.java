package com.tcs.developmentbooksttd2.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DevelopmentBooksController {

	@GetMapping("/getAllBooks")
	public List<String> getAllAvailableBooksName() {
		return Arrays.asList("Clean Code", "The Clean Coder", "Clean Architecture",
				"Test Driven Development by Example", "Working Effectively With Legacy Code");
	}
}
