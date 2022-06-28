package lt.vtmc.ExamVTMC.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lt.vtmc.ExamVTMC.models.BookCategory;
import lt.vtmc.ExamVTMC.payload.requests.BookCategoryInsertRequest;
import lt.vtmc.ExamVTMC.payload.requests.BookCategoryUpdateRequest;
import lt.vtmc.ExamVTMC.payload.responses.BookCategoryResponse;
import lt.vtmc.ExamVTMC.services.BookCategoryService;

@CrossOrigin
@RestController
@RequestMapping("/api/categories")
public class BookCategoryController {

private BookCategoryService bookCategoryService;
	
	@Autowired
	public BookCategoryController (BookCategoryService bookCategoryService) {
		this.bookCategoryService = bookCategoryService;
	}
	
	@PostMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ResponseStatus(HttpStatus.CREATED)
	public BookCategoryResponse addCategory(@Valid @RequestBody BookCategoryInsertRequest bookRequest) {
		return this.bookCategoryService.saveCategory(bookRequest);
	}
	
	@PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    public BookCategoryResponse updateBookCategory(@RequestBody BookCategoryUpdateRequest bookCategoryUpdateRequest) {
        return this.bookCategoryService.updateBookCategory(bookCategoryUpdateRequest);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    public BookCategoryResponse deleteBookCategory(@PathVariable Long id) {
        return this.bookCategoryService.deleteBookCategory(id);
    }
	
	@GetMapping
	public List<BookCategory> getCategories(){
		return this.bookCategoryService.getAllCategories();
	}
	
}
