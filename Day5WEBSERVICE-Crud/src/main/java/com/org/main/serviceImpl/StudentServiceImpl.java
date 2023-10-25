package com.org.main.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.main.model.Student;
import com.org.main.repository.StudentRepository;
import com.org.main.service.StudentServiceInt;

@Service
public class StudentServiceImpl implements StudentServiceInt{

	@Autowired
	StudentRepository sr;
	
	@Override
	public Student savestudent(Student s) {
		
		return sr.save(s);
	}

	@Override
	public List<Student> getAllStudent() {
		
		return sr.findAll();
	}

	@Override
	public void deleteStudent(int stuId) {
		
		sr.deleteById(stuId);
		
	}

	@Override
	public Student updateStudentdata(int stuId, Student s) {
		
		Optional<Student>	op=sr.findById(stuId);
		if(op.isPresent())
		{
			Student ss=op.get();
			ss.setStuName(s.getStuName());
			return sr.save(ss);
		}
		else {
			return null;
		}
	}
}

