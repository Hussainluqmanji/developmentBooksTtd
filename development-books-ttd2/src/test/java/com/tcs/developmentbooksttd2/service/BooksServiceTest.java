package com.tcs.developmentbooksttd2.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.tcs.developmentbooksttd2.model.Books;

public class BooksServiceTest {

	@Test
	public void getAllBooks()
	{
		BooksService service = new BooksService();
		List<Books> books = service.getAllBooks();
		assertEquals(5, books.size());
	}
}
