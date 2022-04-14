package com.example.PostGres.MVP.PostGres.MVP.Student;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {
	
	private final StudentRepository studentRepository;
	
	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	public List<Student> getStudents() {
		return studentRepository.findAll();
				
	}
	
	//post request
	public void addNewStudent(Student student) {
		//check if email exists or throw exception
		Optional<Student> studentOptional = studentRepository
				.findStudentByEmail(student.getEmail());
		if (studentOptional.isPresent()) {
			throw new IllegalStateException("email taken");
		}
		
		studentRepository.save(student);
		
		
	}

	public void deleteStudent(Long studentId) {
		studentRepository.findById(studentId);
		boolean exists = studentRepository.existsById(studentId);
		if (!exists) {
			throw new IllegalStateException(
					"student wit id " + studentId + "does not exists"
					);
		}
		studentRepository.deleteById(studentId);
		
	}
	
	//transactional Hibernate lets it go to a managed state so we don't query via sql statement
	@Transactional
	public void updateStudent(Long studentId, 
							  String name, 
							  String email) {
		Student student = studentRepository.findById(studentId)
				.orElseThrow(() -> new IllegalStateException(
						"student with id " + studentId + " does not exist"));
		
		if (name != null &&
				name.length()> 0 &&
				!Objects.equals(student.getName(), name)) {
			student.setName(name);
		}
		
		if (email != null &&
				email.length()> 0 &&
				!Objects.equals(student.getEmail(), email)) {
			Optional<Student> studentOptional = studentRepository
					.findStudentByEmail(email);
			student.setEmail(email);
			if (studentOptional.isPresent()) {
				throw new IllegalStateException("email taken");
			}
			student.setEmail(email);
		}
	}

}
