package lt.vtmc.ExamVTMC.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bookId;
	
	@NotBlank
	private String summary;
	
	@NotNull
	private int isbn;
	
	@NotNull
	private int pageCount;
	
    @ManyToOne
    @JoinColumn(name = "book_category_id")
	private BookCategory bookCategory;
    
}
