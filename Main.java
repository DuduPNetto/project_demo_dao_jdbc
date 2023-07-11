import java.util.Date;
import java.util.List;
import java.util.Scanner;

import db.DB;
import models.dao.DaoFactory;
import models.dao.DepartmentDao;
import models.dao.SellerDao;
import models.entities.Department;
import models.entities.Seller;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("=== SELLER TESTS ===");
		System.out.println();

		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("=== TEST 1: seller findById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);

		System.out.println();

		System.out.println("=== TEST 2: seller findByDepartment ===");
		Department dep = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(dep);
		list.forEach(System.out::println);

		System.out.println();

		System.out.println("=== TEST 3: seller findAll ===");
		list = sellerDao.findAll();
		list.forEach(System.out::println);

		System.out.println();

		System.out.println("=== TEST 4: seller insert ===");
		dep = new Department(3, null);
		seller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, dep);
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
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.print("Delete completed");

		System.out.println();

		System.out.println("=== DEPARTMENT TESTS ===");
		System.out.println();

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		System.out.println("=== TEST 1: department findById ===");
		Department department = departmentDao.findById(2);
		System.out.println(department);

		System.out.println();

		System.out.println("=== TEST 2: department findAll ===");
		List<Department> departments = departmentDao.findAll();
		departments.forEach(System.out::println);

		System.out.println();

		System.out.println("=== TEST 3: department insert ===");
		dep = new Department(7, "Dep");
		departmentDao.insert(dep);
		System.out.println("Inserted: New id = " + dep.getId());

		System.out.println();

		System.out.println("=== TEST 4: department update ===");
		dep = departmentDao.findById(1);
		dep.setName("Marketing");
		departmentDao.update(dep);
		System.out.println("Update completed");

		System.out.println();

		System.out.println("=== TEST 5: department delete ===");
		System.out.print("Enter id for delete test: ");
		int id2 = sc.nextInt();
		departmentDao.deleteById(id2);
		System.out.print("Delete completed");

		sc.close();
		DB.closeConnection();

	}

}
