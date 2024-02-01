package com.ATDev.student.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ATDev.student.dto.Student;
import com.ATDev.student.repo.StudentRepo;

@Repository
public class StudentDao {

	@Autowired
	private StudentRepo repo;
	
	public Student saveStudent(Student student) {
		
		return repo.save(student);
	}
	
	public Student findStudentById(int id) {
		Optional<Student>optional=repo.findById(id);
		
		if (optional.isPresent()) {
			
			return repo.findById(id).get();
		}
		return null;
	}
	
	public Student updateStudent(int id,Student student) {
		Optional<Student>optional=repo.findById(id);
		if(optional.isEmpty()) {
			return null;
		}
		student.setId(id);
		return repo.save(student);
	}
	
	public Student deleteStudent(int id) {
		
		Optional<Student>optional=repo.findById(id);
		if (optional.isPresent()) {
			repo.deleteById(id);
			return optional.get();
		}
		return null;
	}
}
