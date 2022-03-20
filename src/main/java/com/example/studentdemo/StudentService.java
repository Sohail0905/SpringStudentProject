package com.example.studentdemo;

import java.util.List;

public interface StudentService {
	
	public Student getrollno(int rollno);
	
	public List<Student> getAllStudents();
	
	public boolean addStudent(Student stu);
	
	public Student getname(String name);

}
