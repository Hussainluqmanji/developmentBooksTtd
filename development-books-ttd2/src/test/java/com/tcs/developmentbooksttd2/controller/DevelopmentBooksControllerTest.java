package com.tcs.developmentbooksttd2.controller;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.tcs.developmentbooksttd2.model.Books;
import com.tcs.developmentbooksttd2.model.BooksInput;
import com.tcs.developmentbooksttd2.service.BooksService;

public class DevelopmentBooksControllerTest {

	@Test
	public void getAllBooks() {
		DevelopmentBooksController controller = new DevelopmentBooksController();
		controller.service = new BooksService();
		List<Books> books = controller.getAllAvailableBooksName();
		assertEquals(5, books.size());
	}

	@Test
	public void buyBookSuccess() {
		DevelopmentBooksController controller = new DevelopmentBooksController();
		controller.service = new BooksService();
		String result = controller.buyBooks(new BooksInput(1, 1));
		assertEquals("Book bought..", result);

	}
}
