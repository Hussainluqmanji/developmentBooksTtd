package com.tcs.developmentbooksttd2.controller;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class DevelopmentBooksControllerTest {

	@Test
	public void getAllBooks() {
		DevelopmentBooksController controller = new DevelopmentBooksController();
		List<String> books = controller.getAllAvailableBooksName();
		assertEquals(5, books.size());
	}
}
