package com.tcs.developmentbooksttd2.service;

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
		double finalPrice = calculatePriceForBooksWithDiscount(totalBooks);;
		return finalPrice;
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
