package app;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("===== TESTE 1: find by ID =====");
		Department dep = departmentDao.findById(3);
		System.out.println(dep);
		
		System.out.println();
		System.out.println("===== TESTE 2: FIND ALL");
		List<Department> list = departmentDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		}
		
		
		System.out.println();
		System.out.println("===== TESTE 3: INSERT =====");
		Department newDepartment = new Department(5, "Music");
		departmentDao.insert(newDepartment);
		System.out.println("New Department INSRTED!! New ID -> "+newDepartment.getId());
		
		System.out.println();
		System.out.println("===== TESTE 4: UPDATE =====");
		Department dep2 = departmentDao.findById(1);
		dep2.setName("Food");
		departmentDao.update(dep2);
		System.out.println("UPDATE COMPLETED!");
		
		
		System.out.println();
		System.out.println("===== TESTE 5: DELETE =====");
		System.out.println("ENTER ID FOR DELETE: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("DELETE COMPLETED");
		
		sc.close();
		
		
		
		
		
	}

}
