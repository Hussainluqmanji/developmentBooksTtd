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
		double actualCost = totalBooks * SINGLE_BOOK_PRICE;
		double discount = 0;
		if (totalBooks == 2) {
			discount = 5;
		}

		else if (totalBooks == 3) {
			discount = 10;
		}
		double finalPrice = actualCost - (actualCost * (discount / 100));
		return finalPrice;
	}
}
