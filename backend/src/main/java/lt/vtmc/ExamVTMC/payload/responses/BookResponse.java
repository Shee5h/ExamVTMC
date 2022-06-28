package lt.vtmc.ExamVTMC.payload.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {

	private Long bookId;
	
	private String bookName;
	
	private String summary;
	
	private int isbn;
	
	private int pageCount;
	
	private Long categoryId;
	
}
