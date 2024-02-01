package com.ATDev.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ATDev.student.dto.Student;
import com.ATDev.student.service.StudentService;
import com.ATDev.student.util.ResponseStructure;

@RestController
public class StudentController {

	@Autowired
	private StudentService service;
	
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Student>> saveStudent(@RequestBody Student student){
		return service.saveStudent(student);
	}
	@GetMapping("/fetch")
	public ResponseEntity<ResponseStructure<Student>> findStudentById(@RequestParam int id){
		return service.findStudentById(id);
	}
	
	@PutMapping("/update")
	public ResponseEntity<ResponseStructure<Student>> updateStudent(@RequestParam int id,@RequestBody Student student) {
		
		return service.updateStudent(id, student);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<ResponseStructure<Student>> deleteStudent(@RequestParam int id)
	{
		return service.deleteStudent(id);
	}
}
