package com.credibanco.assessment.library.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.credibanco.assessment.library.dto.ApiResponse;
import com.credibanco.assessment.library.dto.BookDto;
import com.credibanco.assessment.library.dto.BookReportDto;
import com.credibanco.assessment.library.model.Book;
import com.credibanco.assessment.library.service.BookService;
import com.credibanco.assessment.library.util.Message;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequestMapping("/book")
@CrossOrigin("*")
public class BookController {

	private Logger logger = LogManager.getLogger(BookController.class);

	@Autowired
	private BookService bookService;

	@GetMapping()
	public List<BookReportDto> findAll() {
		return bookService.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Book> findById(@PathVariable("id") Long id) {
		return bookService.findById(id);
	}

	@GetMapping("/{author}/{title}/{year}")
	public List<Book> findByKeyWords(@PathVariable("author") String author, @PathVariable("title") String title,
			@PathVariable("year") int year) {
		return bookService.findByKeyWords(author, title, year);
	}

	@PostMapping
	public ResponseEntity<ApiResponse> create(@Valid @RequestBody BookDto bookDto) {
		try {
			return bookService.save(bookDto);
		} catch (Exception e) {
			logger.error(String.format(Message.MSJERROR, this.getClass().getName(), e.getMessage()));
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(false, e.getMessage()));
		}
	}

	@PutMapping
	public ResponseEntity<ApiResponse> update(@Valid @RequestBody BookDto bookDto) {
		try {
			return bookService.save(bookDto);
		} catch (Exception e) {
			logger.error(String.format(Message.MSJERROR, this.getClass().getName(), e.getMessage()));
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(false, e.getMessage()));
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> delete(@PathVariable("id") Long bookId) {
		try {
			return bookService.delete(bookId);
		} catch (Exception e) {
			logger.error(String.format(Message.MSJERROR, this.getClass().getName(), e.getMessage()));
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(false, e.getMessage()));
		}
	}
}