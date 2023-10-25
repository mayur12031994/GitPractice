package com.org.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.org.main.model.Student;
import com.org.main.service.StudentServiceInt;

@RestController
public class HomeController {

	@Autowired
	StudentServiceInt ssi;
	
	@PostMapping(value="/savestudent")
//	@RequestMapping(value="/savestudent",method=RequestMethod.POST)
	public Student saveStudent(@RequestBody Student s)
	{
		ssi.savestudent(s);
		return s;
	}
	@GetMapping(value="/getstudent")
	public List<Student> getstudent()
	{
		return ssi.getAllStudent();
	}
	@DeleteMapping(value="/deletestudent/{stuId}")
	public String deletestudent(@PathVariable int stuId)
	{
		ssi.deleteStudent(stuId);
		return "delete rocord";
	}
	@PutMapping(value="/updatestudent/{stuId}")
	public Student updateStudent(@RequestBody Student s,@PathVariable int stuId)
	{
		Student student= ssi.updateStudentdata(stuId, s);
		
		return student;
	}
}
