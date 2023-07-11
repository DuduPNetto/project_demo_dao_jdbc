import java.util.Date;
import java.util.List;
import java.util.Scanner;

import db.DB;
import models.dao.DaoFactory;
import models.dao.SellerDao;
import models.entities.Department;
import models.entities.Seller;

public class Main {

	public static void main(String[] args) {

		System.out.println("=== SELLER TESTS ===");
		System.out.println();

		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("=== TEST 1: seller findById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);

		System.out.println();

		System.out.println("=== TEST 2: seller findByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		list.forEach(System.out::println);

		System.out.println();

		System.out.println("=== TEST 3: seller findAll ===");
		list = sellerDao.findAll();
		list.forEach(System.out::println);

		System.out.println();

		System.out.println("=== TEST 4: seller insert ===");
		department = new Department(3, null);
		seller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(seller);
		System.out.println("Inserted: New id = " + seller.getId());

		System.out.println();

		System.out.println("=== TEST 5: seller update ===");
		seller = sellerDao.findById(1);
		seller.setName("Joao Blue");
		sellerDao.update(seller);
		System.out.println("Update completed");

		System.out.println();

		System.out.println("=== TEST 6: seller delete ===");
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.print("Delete completed");
		sc.close();

		DB.closeConnection();

		System.out.println();

		System.out.println("=== DEPARTMENT TESTS ===");
		System.out.println();

		System.out.println("=== TEST 1: department findById ===");

		// System.out.println("=== TEST 2: department findAll ===");
		// System.out.println("=== TEST 3: department insert ===");
		// System.out.println("=== TEST 4: department update ===");
		// System.out.println("=== TEST 5: department delete ===");

	}

}
