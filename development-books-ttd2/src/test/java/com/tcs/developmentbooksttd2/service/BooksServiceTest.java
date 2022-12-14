package com.tcs.developmentbooksttd2.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.tcs.developmentbooksttd2.model.Books;
import com.tcs.developmentbooksttd2.model.BooksInput;
import com.tcs.developmentbooksttd2.model.PriceSummary;

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
		PriceSummary result = service.calculateBooksCostWithDiscount(books);
		assertEquals(50.0, result.getFinalPrice(), 0.0);
	}

	@Test
	public void buyMultipleCopliesOfSameBooks() {
		List<BooksInput> books = new ArrayList<BooksInput>();
		books.add(new BooksInput(1, 1));
		PriceSummary result = service.calculateBooksCostWithDiscount(books);
		assertEquals(50.0, result.getFinalPrice(), 0.0);
	}

	@Test
	public void buyTwoDiffBookAndGetDiscount() {
		List<BooksInput> books = new ArrayList<BooksInput>();
		books.add(new BooksInput(1, 1));
		books.add(new BooksInput(2, 1));
		PriceSummary result = service.calculateBooksCostWithDiscount(books);
		assertEquals(95.0, result.getFinalPrice(), 0.0);
	}

	@Test
	public void buyThreeDiffBookAndGetDiscount() {
		List<BooksInput> books = new ArrayList<BooksInput>();
		books.add(new BooksInput(1, 1));
		books.add(new BooksInput(2, 1));
		books.add(new BooksInput(3, 1));
		PriceSummary result = service.calculateBooksCostWithDiscount(books);
		assertEquals(135.0, result.getFinalPrice(), 0.0);
	}

	@Test
	public void buyFourDiffBookAndGetDiscount() {
		List<BooksInput> books = new ArrayList<BooksInput>();
		books.add(new BooksInput(1, 1));
		books.add(new BooksInput(2, 1));
		books.add(new BooksInput(3, 1));
		books.add(new BooksInput(4, 1));
		PriceSummary result = service.calculateBooksCostWithDiscount(books);
		assertEquals(160.0, result.getFinalPrice(), 0.0);
	}

	@Test
	public void buyFiveDiffBookAndGetDiscount() {
		List<BooksInput> books = new ArrayList<BooksInput>();
		books.add(new BooksInput(1, 1));
		books.add(new BooksInput(2, 1));
		books.add(new BooksInput(3, 1));
		books.add(new BooksInput(4, 1));
		books.add(new BooksInput(5, 1));
		PriceSummary result = service.calculateBooksCostWithDiscount(books);
		assertEquals(187.5, result.getFinalPrice(), 0.0);
	}

	@Test
	public void buyTwoSetsOfAllFiveBooks() {
		List<BooksInput> books = new ArrayList<BooksInput>();
		books.add(new BooksInput(1, 2));
		books.add(new BooksInput(2, 2));
		books.add(new BooksInput(3, 2));
		books.add(new BooksInput(4, 2));
		books.add(new BooksInput(5, 2));
		PriceSummary result = service.calculateBooksCostWithDiscount(books);
		assertEquals(375.0, result.getFinalPrice(), 0.0);
	}

	@Test
	public void buyMultipleRandomBooks() {
		List<BooksInput> books = new ArrayList<BooksInput>();
		books.add(new BooksInput(1, 2));
		books.add(new BooksInput(2, 2));
		books.add(new BooksInput(3, 2));
		books.add(new BooksInput(4, 2));
		books.add(new BooksInput(5, 12));
		PriceSummary result = service.calculateBooksCostWithDiscount(books);
		assertEquals(875.0, result.getFinalPrice(), 0.0);
	}
	
	@Test
	public void userOnlyBoughtSimilarBooks() {
		List<BooksInput> books = new ArrayList<BooksInput>();
		books.add(new BooksInput(1, 10));
		PriceSummary result = service.calculateBooksCostWithDiscount(books);
		assertEquals(500.0, result.getFinalPrice(), 0.0);
	}
	
	@Test
	public void checkMaximumDiscountedPrice() {
		List<BooksInput> books = new ArrayList<BooksInput>();
		books.add(new BooksInput(1, 2));
		books.add(new BooksInput(2, 2));
		books.add(new BooksInput(3, 2));
		books.add(new BooksInput(4, 1));
		books.add(new BooksInput(5, 1));
		PriceSummary result = service.calculateBooksCostWithDiscount(books);
		assertEquals(320.0, result.getFinalPrice(), 0.0);
	}
}
