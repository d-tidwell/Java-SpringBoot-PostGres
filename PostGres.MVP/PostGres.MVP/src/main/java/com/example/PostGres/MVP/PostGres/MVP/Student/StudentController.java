package com.example.PostGres.MVP.PostGres.MVP.Student;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
	//resources for API Layer
	
	private final StudentService studentService;
	
	@Autowired
	//autowired connects the instance studentServices to this constructor
	//must also have the @Service on the StudentService class
	//so the the two are connected at runtime and layered pattern of design 
	//segregating the two is adhered to
	
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@GetMapping
	public List<Student> getStudents() {
		return studentService.getStudents();
	}
	
	@PostMapping(path= "/addStudent")
	public void registerNewStudent(@RequestBody Student student) {
		studentService.addNewStudent(student);
	}
	
	@DeleteMapping(path= "/dropStudent/{studentId}")
	public void deleteStudent(@PathVariable("studentID") Long studentId) {
		studentService.deleteStudent(studentId);
	}
	
	@PutMapping(path= "/editStudent/{studentId}")
	public void updateStudent(
			@PathVariable("studentId") Long studentId,
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String email) {
		studentService.updateStudent(studentId,name, email);
	}
			
	

}
