package com.tcs.developmentbooksttd2.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class BooksServiceTest {

	@Test
	public void getAllBooks()
	{
		BooksService service = new BooksService();
		List<String> books = service.getAllBooks();
		assertEquals(5, books.size());
	}
}
