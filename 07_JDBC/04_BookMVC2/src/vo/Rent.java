package vo;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
// 스키마가 work
@NoArgsConstructor @AllArgsConstructor @Data
public class Rent { // -> rent
	
	private int rentNo;
	private String id; // foreign key (Client)
	private int bookNo; // foreign key (Book) --> book_no
	private LocalDate rentDate; // --> rent_date
	
	// --------------------------- VO, DTO
	//private Member member;
	private Book book;
}





