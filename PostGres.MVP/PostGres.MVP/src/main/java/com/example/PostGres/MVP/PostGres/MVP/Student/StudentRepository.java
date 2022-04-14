package com.example.PostGres.MVP.PostGres.MVP.Student;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//dependency injection for data layer
@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
	
	//find record by email
	//SELECT STATEMENT from JPA
	@Query("SELECT s FROM Student s WHERE s.email= ?1")
	

	Optional<Student> findStudentByEmail(String email);
	
}
