package lt.vtmc.ExamVTMC.payload.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookCategoryUpdateRequest {
	
	@NotNull
	private Long categoryId;

	@NotBlank
	private String categoryName;
	
}
