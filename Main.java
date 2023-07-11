import java.time.LocalDate;

import models.dao.DaoFactory;
import models.dao.SellerDao;
import models.entities.Department;
import models.entities.Seller;

public class Main {

	public static void main(String[] args) {
	
		Department dep = new Department(1, "Department");
		LocalDate date = LocalDate.now();
		Seller seller = new Seller(1, "Name", "name@email.com", date, 1200.00, dep);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println(seller);
		
	}

}
