package app;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
	
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		Seller seller = sellerDao.findById(1);
		
		System.out.println("TESTE 1 -> FIND BY ID");
		System.out.println(seller);
	

	}

}
