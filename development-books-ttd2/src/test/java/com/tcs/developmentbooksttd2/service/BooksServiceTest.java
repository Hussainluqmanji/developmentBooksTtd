package com.tcs.developmentbooksttd2.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
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
	public void getAllBooks() {
		List<Books> books = service.getAllBooks();
		assertEquals(5, books.size());
	}

	@Test
	public void buyBookSuccess() {
		List<BooksInput> books = new ArrayList<BooksInput>();
		books.add(new BooksInput(1, 1));
		double result = service.calculateBooksCostWithDiscount(books);
		assertEquals(50.0, result, 0.0);

	}

	@Test
	public void buyMultipleCopliesOfSameBooks() {
		List<BooksInput> books = new ArrayList<BooksInput>();
		books.add(new BooksInput(1, 1));
		double result = service.calculateBooksCostWithDiscount(books);

		assertEquals(50.0, result, 0.0);

	}

	@Test
	public void buyTwoDiffBookAndGetDiscount() {
		List<BooksInput> books = new ArrayList<BooksInput>();
		books.add(new BooksInput(1, 1));
		books.add(new BooksInput(2, 1));
		double result = service.calculateBooksCostWithDiscount(books);
		assertEquals(95.0, result, 0.0);
	}

	@Test
	public void buyThreeDiffBookAndGetDiscount() {
		List<BooksInput> books = new ArrayList<BooksInput>();
		books.add(new BooksInput(1, 1));
		books.add(new BooksInput(2, 1));
		books.add(new BooksInput(3, 1));
		double result = service.calculateBooksCostWithDiscount(books);
		assertEquals(135.0, result, 0.0);

	}
	
	@Test
	public void buyFourDiffBookAndGetDiscount() {
		List<BooksInput> books = new ArrayList<BooksInput>();
		books.add(new BooksInput(1, 1));
		books.add(new BooksInput(2, 1));
		books.add(new BooksInput(3, 1));
		books.add(new BooksInput(4, 1));
		double result = service.calculateBooksCostWithDiscount(books);
		assertEquals(160.0, result, 0.0);

	}
	
	@Test
	public void buyFiveDiffBookAndGetDiscount() {
		List<BooksInput> books = new ArrayList<BooksInput>();
		books.add(new BooksInput(1, 1));
		books.add(new BooksInput(2, 1));
		books.add(new BooksInput(3, 1));
		books.add(new BooksInput(4, 1));
		books.add(new BooksInput(5, 1));
		double result = service.calculateBooksCostWithDiscount(books);
		assertEquals(187.5, result, 0.0);

	}
}
