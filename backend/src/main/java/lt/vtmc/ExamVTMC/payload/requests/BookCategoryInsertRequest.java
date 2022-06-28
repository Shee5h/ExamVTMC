package lt.vtmc.ExamVTMC.payload.requests;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookCategoryInsertRequest {

	@NotBlank
	private String categoryName;
	
}
