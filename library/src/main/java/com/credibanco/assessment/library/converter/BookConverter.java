package com.credibanco.assessment.library.converter;

import java.util.ArrayList;
import java.util.List;

import com.credibanco.assessment.library.dto.BookDto;
import com.credibanco.assessment.library.dto.BookReportDto;
import com.credibanco.assessment.library.model.Book;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class BookConverter {

	public Book toEntity(BookDto bookDto) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(bookDto, Book.class);
	}

	public List<BookReportDto> toBookReportDto(List<Book> bookList) {
		List<BookReportDto> bookReportDtos = new ArrayList<>();
		for (Book book : bookList) {
			BookReportDto bookReportDto = new BookReportDto();
			bookReportDto.setId(book.getId());
			bookReportDto.setTitle(book.getTitle());
			bookReportDto.setPagesNumber(book.getPagesNumber());
			bookReportDto.setYear(book.getYear());
			bookReportDto.setGenre(book.getGenre().getGenreDescription());
			bookReportDto.setEditorial(book.getEditorial().getName());
			bookReportDto.setAuthor(book.getAuthor().getFullName());
			bookReportDtos.add(bookReportDto);
		}
		return bookReportDtos;
	}
}
