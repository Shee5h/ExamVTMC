package lt.vtmc.ExamVTMC.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.vtmc.ExamVTMC.models.BookCategory;
import lt.vtmc.ExamVTMC.payload.requests.BookCategoryInsertRequest;
import lt.vtmc.ExamVTMC.payload.requests.BookCategoryUpdateRequest;
import lt.vtmc.ExamVTMC.payload.responses.BookCategoryResponse;
import lt.vtmc.ExamVTMC.repositories.BookCategoryRepository;

@Service
public class BookCategoryService {

	private BookCategoryRepository bookCategoryRepository;
	
	@Autowired
    public BookCategoryService(BookCategoryRepository bookCategoryRepository) {
        this.bookCategoryRepository = bookCategoryRepository;
    }
	
	public BookCategoryResponse saveCategory(BookCategoryInsertRequest bookInsertRequest) {
        BookCategory category = new BookCategory(
                );
        category.setCategoryName(bookInsertRequest.getCategoryName());

        bookCategoryRepository.save(category);
        return new BookCategoryResponse(
                category.getCategoryId(),
                bookInsertRequest.getCategoryName()
                );
    }
	
	 public BookCategoryResponse updateBookCategory(BookCategoryUpdateRequest bookCategoryUpdateRequest) {
	        BookCategory bookCategory = bookCategoryRepository.getById(bookCategoryUpdateRequest.getCategoryId());
	        if (bookCategory == null) {
	            throw new RuntimeException("Category does not exist");
	        }
	        String categoryName = bookCategoryUpdateRequest.getCategoryName();
	        String bookCategoryName = categoryName.substring(0, 1).toUpperCase() + categoryName.substring(1);
	        Optional<BookCategory> bookCategory2 = bookCategoryRepository.findByCategoryName(bookCategoryName);
	        if (bookCategory2.isPresent()) {
	            throw new RuntimeException("Category already exists");
	        }
	        bookCategory.setCategoryName(bookCategoryName);
	        bookCategoryRepository.save(bookCategory);
	        return new BookCategoryResponse(bookCategory.getCategoryId(), bookCategory.getCategoryName());
	    }
	
	public BookCategoryResponse deleteBookCategory(Long id) {
        Optional<BookCategory> deletingBookCategory = bookCategoryRepository.findById(id);
        if (deletingBookCategory.isEmpty()) {
            throw new RuntimeException("Category does not exist");
        }
        bookCategoryRepository.deleteById(id);
        return null;
    }
	
	public List<BookCategory> getAllCategories(){
		return this.bookCategoryRepository.findAll();
	}
}
