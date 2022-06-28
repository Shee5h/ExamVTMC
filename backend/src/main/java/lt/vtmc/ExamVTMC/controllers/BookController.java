package lt.vtmc.ExamVTMC.controllers;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lt.vtmc.ExamVTMC.payload.requests.BookInsertRequest;
import lt.vtmc.ExamVTMC.payload.responses.BookResponse;
import lt.vtmc.ExamVTMC.services.BookService;

@CrossOrigin
@RestController
@RequestMapping("/api/books")
public class BookController {

	private BookService bookService;
	
	public BookController (BookService bookService) {
		this.bookService = bookService;
	}
	
	@PostMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ResponseStatus(HttpStatus.CREATED)
	public BookResponse addBook(@Valid @RequestBody BookInsertRequest bookRequest) {
		return this.bookService.saveBook(bookRequest);
	}
	
}
