package app;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
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
		
		System.out.println("\n TESTE 5 -> SELLER UPDATE");
		seller = sellerDao.findById(1);
		seller.setName("Marta Waine");
		sellerDao.update(seller);
		System.out.println("UPDATE COMPLETED WITH SUCCESS");
			
		
		System.out.println("\n TESTE 6 -> SELLER DELETE");
		System.out.println("ENTER ID FOR DELETE");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("DELETED WITH SUCCES!!!!!");
		
		
	
	}

}
