package com.Demo.web.Reposity;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Demo.web.Model.Student;



public interface Student_info extends JpaRepository<Student, Integer>{

	public Student findByname(String name);
}
