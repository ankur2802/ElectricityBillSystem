package model;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import service.LaptopService;

@SpringBootApplication
@ComponentScan(basePackages = {"service", "controller", "model","repository"})
public class SpringBootFirst1Application {
	
	
	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(SpringBootFirst1Application.class, args);
		
		LaptopService service = context.getBean(LaptopService.class);
		
		
		Laptop lap= context.getBean(Laptop.class);
		service.addLaptop(lap);
		
		
		
		
//		Alien obj = context.getBean(Alien.class);
//		obj.code();
//		System.out.println(obj.getAge());
//		
		
		
		
//		Laptop obj1=context.getBean(Laptop.class);
//		obj1.compile();
		
		
//		 Laptop xx= obj.laptop;
//		 System.out.println(xx);
	}

}
