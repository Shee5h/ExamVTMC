package lt.vtmc.ExamVTMC.payload.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookCategoryResponse {
	
	private Long categoryId;

	private String categoryName;
}
