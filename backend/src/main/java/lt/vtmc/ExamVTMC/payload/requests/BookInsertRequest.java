package lt.vtmc.ExamVTMC.payload.requests;

//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import lt.vtmc.ExamVTMC.models.BookCategory;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookInsertRequest {

	@NotBlank
	private String bookName;
	
	@NotBlank
	private String summary;
	
	@NotNull
	private int isbn;
	
	@NotNull
	private int pageCount;
	
    @NotNull
    private Long categoryId;
	
}
