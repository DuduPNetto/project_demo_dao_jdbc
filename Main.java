import java.time.LocalDate;

import models.entities.Department;
import models.entities.Seller;

public class Main {

	public static void main(String[] args) {
	
		Department dep = new Department(1, "Department");
		LocalDate date = LocalDate.now();
		Seller seller = new Seller(1, "Name", "name@email.com", date, 1200.00, dep);
		
		System.out.println(seller);
		
	}

}
