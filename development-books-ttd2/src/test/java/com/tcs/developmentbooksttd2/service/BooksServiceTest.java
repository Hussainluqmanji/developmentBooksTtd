package com.tcs.developmentbooksttd2.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.tcs.developmentbooksttd2.model.Books;
import com.tcs.developmentbooksttd2.model.BooksInput;

public class BooksServiceTest {

	BooksService service;

	@BeforeEach
	public void setUp() {
		service = new BooksService();
	}
	
	@Test
	public void getAllBooks()
	{
		List<Books> books = service.getAllBooks();
		assertEquals(5, books.size());
	}
	
    @Test
    public void buyBookSuccess() {
        double result = service.buyBooks(new BooksInput(1, 1));
        assertEquals(50.0, result, 0.0);

    }
    
    @Test
    public void buyMultipleCopliesOfSameBooks() {
        double result = service.buyBooks(new BooksInput(1, 5));
        assertEquals(250.0, result, 0.0);

    }
}
