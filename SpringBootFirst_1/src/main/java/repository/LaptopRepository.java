package repository;

import org.springframework.stereotype.Repository;

import model.Laptop;
@Repository
public class LaptopRepository {

	
	public void save(Laptop lap) {
		
		System.out.println("saved in database");
	}
	
}
