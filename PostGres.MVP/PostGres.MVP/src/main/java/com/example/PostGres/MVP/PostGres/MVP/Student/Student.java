package com.example.PostGres.MVP.PostGres.MVP.Student;

import java.time.LocalDate;

public class Student {
	private Long id;
	private String name;
	private String email;
	private LocalDate dob;
	private Integer age;
	
	
	public Student() {
		
	}
	
	//all fields
	public Student(Long id, String name, 
			String email, LocalDate dob, 
			Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.age = age;
	}
	
	//w/o ID
	public Student( String name, String email, 
			String string, LocalDate 
			localDate, Integer age) {
		super();
		this.name = name;
		this.email = email;
		this.dob = localDate;
		this.age = age;
	}
	 


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", dob=" + dob + ", age=" + age + "]";
	}
	
	
}
