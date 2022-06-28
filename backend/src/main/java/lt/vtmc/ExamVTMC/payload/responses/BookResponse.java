package lt.vtmc.ExamVTMC.payload.responses;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lt.vtmc.ExamVTMC.models.BookCategory;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {

	private Long bookId;
	
	private String bookName;
	
	private String summary;
	
	private int isbn;
	
	private int pageCount;
	
	@ManyToOne
    @JoinColumn(name = "book_category_id")
	private BookCategory bookCategory;
	
}
