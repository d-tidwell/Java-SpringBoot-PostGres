package com.example.PostGres.MVP.PostGres.MVP.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//dependency injection for data layer
@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
	
}
