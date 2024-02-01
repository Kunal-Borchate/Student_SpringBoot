package com.ATDev.student.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ATDev.student.dto.Student;

public interface StudentRepo extends JpaRepository<Student,Integer> {

	
}
