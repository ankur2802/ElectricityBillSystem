package repository;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
import model.Student;


@Repository
public class StudentRepo {

	public JdbcTemplate jdbc;
	
	
	
	public JdbcTemplate getJdbc() {
		return jdbc;
	}

	@Autowired
	public void setJdbc(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	public void save(Student s) {
		String sql = "insert into student (rollNo, name, marks) values (?,?,?)";
		
	//	System.out.println("added");
		int rows = jdbc.update(sql,s.getRollNo(), s.getName(), s.getMarks());
		System.out.println("rows affected " + rows);
	}

	public List<Student> findAll() {
		
		List<Student> students = new ArrayList<>();
		return students;
	}

}
