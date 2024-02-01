package com.ATDev.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ATDev.student.dao.StudentDao;
import com.ATDev.student.dto.Student;
import com.ATDev.student.exception.IdNotFoundException;
import com.ATDev.student.util.ResponseStructure;





@Service
public class StudentService {

	@Autowired
	private StudentDao dao;
	
	
	
	public ResponseEntity<ResponseStructure<Student>> saveStudent(Student student){
		ResponseStructure<Student>structure=new ResponseStructure<>();
		structure.setMessage("Successfully Saved");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveStudent(student));
		return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.CREATED);
	}
	
	
	
	public ResponseEntity<ResponseStructure<Student>>findStudentById(int id){
		Student student=dao.findStudentById(id);
		if (student!=null) {
			ResponseStructure<Student>structure=new ResponseStructure<>();
			structure.setMessage("Student Successfully Found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(student);
			return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.FOUND);
		}
		else {
			throw new IdNotFoundException("Student id not found");
		}
	}
	
	
	
	public ResponseEntity<ResponseStructure<Student>> updateStudent(int id,Student student){
		Student dbStudent=dao.updateStudent(id, student);
		if (dbStudent!=null) {
			ResponseStructure<Student>structure=new ResponseStructure<>();
			structure.setMessage("Student Successfull Updated");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dbStudent);
			return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.OK);
		} else {
			
			throw new IdNotFoundException("Student id not found");

		}
	}
	
	
	
	public ResponseEntity<ResponseStructure<Student>> deleteStudent(int id){
		Student student=dao.deleteStudent(id);
		if (student!= null) {
			ResponseStructure<Student>structure=new ResponseStructure<>();
			structure.setMessage("Student Successfully Deleted ");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(student);
			return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.OK);
		} else {
		      throw new IdNotFoundException("Student id not found");
		}
	}
}
