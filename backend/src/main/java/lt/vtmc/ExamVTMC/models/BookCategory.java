package lt.vtmc.ExamVTMC.models;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book_categories")
public class BookCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long categoryId;
	
	private String categoryName;

}
