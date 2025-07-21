package app;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
	
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		Seller seller = sellerDao.findById(1);
		
		System.out.println("TESTE 1 -> FIND BY ID");
		System.out.println(seller);
	
		System.out.println("\n TESTE 2 -> FIND BY DEPARTMENT");
		Department department = new Department (2, null);
		
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}
	    
		System.out.println("\n TESTE 3 -> FIND ALL");
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n TESTE 4 -> SELLER INSERT");
		Seller newSeller = new Seller(null, "Greg", "Greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("INSERTED! New ID = "+newSeller.getId());
	
	}

}
