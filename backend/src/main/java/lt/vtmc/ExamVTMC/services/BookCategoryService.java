package lt.vtmc.ExamVTMC.services;

import java.util.List;

import lt.vtmc.ExamVTMC.models.BookCategory;
import lt.vtmc.ExamVTMC.payload.requests.BookCategoryInsertRequest;
import lt.vtmc.ExamVTMC.payload.responses.BookCategoryResponse;
import lt.vtmc.ExamVTMC.repositories.BookCategoryRepository;


public class BookCategoryService {

	private BookCategoryRepository bookCategoryRepository;
	
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
	
	public List<BookCategory> getAllCategories(){
		return this.bookCategoryRepository.findAll();
	}
}
