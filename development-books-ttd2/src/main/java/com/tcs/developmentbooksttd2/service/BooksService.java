package com.tcs.developmentbooksttd2.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tcs.developmentbooksttd2.enums.BooksEnum;

@Service
public class BooksService {

	public List<BooksEnum> getAllBooks()
	{
		return Arrays.asList(BooksEnum.values());
	}
}
