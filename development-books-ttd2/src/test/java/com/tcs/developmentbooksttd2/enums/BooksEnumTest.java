package com.tcs.developmentbooksttd2.enums;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class BooksEnumTest {

	@Test
	public void booksEnumShouldContainFiveDevelopmentBooks() {
		assertEquals(5, BooksEnum.values().length);
	}
}
