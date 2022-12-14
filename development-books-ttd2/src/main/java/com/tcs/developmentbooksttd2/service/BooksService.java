package com.tcs.developmentbooksttd2.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.tcs.developmentbooksttd2.enums.BooksEnum;
import com.tcs.developmentbooksttd2.model.Books;
import com.tcs.developmentbooksttd2.model.BooksInput;

@Service
public class BooksService {

	private static final double SINGLE_BOOK_PRICE = 50.0;

	public List<Books> getAllBooks() {
		return Arrays.stream(BooksEnum.values()).map(bookEnum -> new Books(bookEnum.getId(), bookEnum.getTitle(),
				bookEnum.getAuthor(), bookEnum.getYear(), bookEnum.getPrice())).collect(Collectors.toList());
	}

	public double calculateBooksCostWithDiscount(List<BooksInput> booksBought) {
		int totalBooks = booksBought.stream().mapToInt(book -> book.getQuantity()).sum();
		List<Integer> bookGroups = new ArrayList<Integer>();
		double priceOfSimilarBooksLeft = 0;
		int noOfGroups = 1 + (totalBooks / booksBought.size());
		double finalPrice = 0;

		for (int i = 0; i < noOfGroups; i++) {
			int typesOfBookLeft = (int) booksBought.stream().filter(book -> book.getQuantity() > 0).count();
			if (typesOfBookLeft > 1) {
				bookGroups.add(typesOfBookLeft);
				reduceQuantityOfAlreadyBookIntoGroups(booksBought);
			} else {
				priceOfSimilarBooksLeft = calculatePriceForBooksWithoutDiscount(booksBought);
				break;
			}
		}

		finalPrice = priceOfSimilarBooksLeft + bookGroups.stream().mapToDouble(group -> calculatePriceForBooksWithDiscount(group)).sum();
		return finalPrice;
	}

	public void reduceQuantityOfAlreadyBookIntoGroups(List<BooksInput> books) {
		books.forEach(book -> {
			book.setQuantity(book.getQuantity() - 1);
		});
	}

	public double calculatePriceForBooksWithoutDiscount(List<BooksInput> books) {
		return books.stream().filter(book -> book.getQuantity() > 0).mapToDouble(book -> book.getQuantity() * SINGLE_BOOK_PRICE).sum();
	}
	
	public double calculatePriceForBooksWithDiscount(int differentBooks) {
		double discountedPrice = 0;
		double actualCost = differentBooks * SINGLE_BOOK_PRICE;
		if (differentBooks == 1)
			discountedPrice = 50;
		else if (differentBooks == 2)
			discountedPrice = actualCost - (actualCost * (5.0 / 100));
		else if (differentBooks == 3)
			discountedPrice = actualCost - (actualCost * (10.0 / 100));
		else if (differentBooks == 4)
			discountedPrice = actualCost - (actualCost * (20.0 / 100));
		else if (differentBooks == 5)
			discountedPrice = actualCost - (actualCost * (25.0 / 100));
		return discountedPrice;
	}
}
