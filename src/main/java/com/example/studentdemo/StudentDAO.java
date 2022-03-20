package com.example.studentdemo;

import java.util.List;

public interface StudentDAO {
	
	public Student getrollno(int rollno);
	
	public boolean addStudent(Student stu);
	
	public List<Student> getAllStudents();
	
	public Student getname(String name);

}
