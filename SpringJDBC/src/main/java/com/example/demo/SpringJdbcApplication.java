package com.example.demo;



import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import model.Student;
import service.StudentService;

@SpringBootApplication
@ComponentScan(basePackages = {"service", "controller", "model","repository"})
public class SpringJdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context  = SpringApplication.run(SpringJdbcApplication.class, args);
		
		Student s = context.getBean(Student.class);
		s.setMarks(89);
		s.setName("ankur");
		s.setRollNo(105);
		
		
		StudentService service = context.getBean(StudentService.class);
		service.addStudent(s);
		
		 List<Student> students = service.getStudents();
		 System.out.println(students);
		
	}

	

}
