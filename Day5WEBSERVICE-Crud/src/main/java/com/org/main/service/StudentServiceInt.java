package com.org.main.service;

import java.util.List;

import com.org.main.model.Student;

public interface StudentServiceInt {

	public Student savestudent(Student s);

	public List<Student> getAllStudent();

	public void deleteStudent(int stuId);

	public Student updateStudentdata(int stuId, Student s);
}
