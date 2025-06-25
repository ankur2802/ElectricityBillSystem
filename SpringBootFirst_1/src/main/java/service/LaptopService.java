package service;

import java.sql.Savepoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Laptop;
import repository.LaptopRepository;

@Service
public class LaptopService {

	@Autowired
	private LaptopRepository repo;
	
	public void addLaptop(Laptop lap) {
		repo.save(lap);
		System.out.println("method called");
	}
	
	
	public boolean isGoodForProg(Laptop lap) {
		return true;
	}
	
}

