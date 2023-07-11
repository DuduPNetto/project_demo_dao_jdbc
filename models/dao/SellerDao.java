package models.dao;

import java.util.List;

import models.entities.Department;
import models.entities.Seller;

public interface SellerDao {

	void insert(Seller department);

	void update(Seller department);

	void deleteById(Integer id);

	Seller findById(Integer id);

	List<Seller> findByDepartment(Department department);

	List<Seller> findAll();
	

}
