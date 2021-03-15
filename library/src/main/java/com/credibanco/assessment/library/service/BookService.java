package com.credibanco.assessment.library.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import com.credibanco.assessment.library.controller.RestUtils;
import com.credibanco.assessment.library.converter.BookConverter;
import com.credibanco.assessment.library.dto.ApiResponse;
import com.credibanco.assessment.library.dto.BookDto;
import com.credibanco.assessment.library.dto.BookReportDto;
import com.credibanco.assessment.library.exceptions.AuthorNotExistException;
import com.credibanco.assessment.library.exceptions.BookExistException;
import com.credibanco.assessment.library.exceptions.EditorialNotExistException;
import com.credibanco.assessment.library.exceptions.MaximumBookException;
import com.credibanco.assessment.library.model.Author;
import com.credibanco.assessment.library.model.Book;
import com.credibanco.assessment.library.model.Editorial;
import com.credibanco.assessment.library.repository.AuthorRepository;
import com.credibanco.assessment.library.repository.BookRepository;
import com.credibanco.assessment.library.repository.EditorialRepository;
import com.credibanco.assessment.library.util.Message;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private EditorialRepository editorialRepository;

	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private RestUtils restUtils;

	@Autowired
	MessageSource messageSource;

	@Autowired
	private BookConverter bookConverter;

	private Logger logger = LogManager.getLogger(BookService.class);

	public List<BookReportDto> findAll() {
		return bookConverter.toBookReportDto(bookRepository.findAll());
	}

	public Optional<Book> findById(Long id) {
		return bookRepository.findById(id);
	}

	public List<Book> findByKeyWords(String author, String title, int year) {
		List<Author> listAuthor = authorRepository.findByFullNameContainingIgnoreCase(author);
		return bookRepository.findByAuthorInAndTitleContainingIgnoreCaseAndYear(listAuthor, title, year);
	}

	public ResponseEntity<ApiResponse> save(BookDto bookDto)
			throws BookExistException, AuthorNotExistException, EditorialNotExistException, MaximumBookException {
		ApiResponse isValidResponse = restUtils.validateInsertBook(bookDto);
		if (Boolean.FALSE.equals(isValidResponse.getSuccess())) {
			return ResponseEntity.badRequest().body(isValidResponse);
		}
		Optional<Book> bookOpt = bookRepository.findByTitleAndAuthorAndEditorial(bookDto.getTitle(),
				bookDto.getAuthor(), bookDto.getEditorial());
		if (bookOpt.isPresent() && bookDto.getId() == null
				|| bookOpt.isPresent() && !bookOpt.get().getId().equals(bookDto.getId())) {
			throw new BookExistException();
		}
		Optional<Author> authorOpt = authorRepository.findById(bookDto.getAuthor().getId());
		if (!authorOpt.isPresent()) {
			throw new AuthorNotExistException();
		}
		Optional<Editorial> editorialOpt = editorialRepository.findById(bookDto.getEditorial().getId());
		if (editorialOpt.isPresent()) {
			if (bookRepository.countBooksByEditorial(bookDto.getEditorial()) >= editorialOpt.get().getMaximumBooks()) {
				throw new MaximumBookException();
			}
		} else {
			throw new EditorialNotExistException();
		}
		try {
			Book book = bookConverter.toEntity(bookDto);
			String msj = book.getId() == null ? "Libro Guardado." : "Libro Actualizado.";
			bookRepository.save(book);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(book.getId())
					.toUri();
			return ResponseEntity.created(location).body(new ApiResponse(true, msj));
		} catch (Exception e) {
			logger.error(String.format(Message.MSJERROR, this.getClass().getName(), e.getMessage()));
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al guardar libro");
		}
	}

	public ResponseEntity<ApiResponse> delete(Long bookId) {
		Optional<Book> bookOpt = bookRepository.findById(bookId);
		if (!bookOpt.isPresent()) {
			return ResponseEntity.badRequest().body(new ApiResponse(false, "El libro a eliminar no existe."));
		}
		try {
			bookRepository.deleteById(bookId);
			return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse(true, "Libro Eliminado"));
		} catch (Exception e) {
			logger.error(String.format(Message.MSJERROR, this.getClass().getName(), e.getMessage()));
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al guardar libro");
		}
	}
}