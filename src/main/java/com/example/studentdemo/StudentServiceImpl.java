package com.example.studentdemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	@Qualifier("sqlDao")
	private StudentDAO studao;

	public Student getrollno(int rollno) {
		System.out.println("Inside Service");
		return studao.getrollno(rollno);
	}

	@Override
	public List<Student> getAllStudents() {
		return studao.getAllStudents();
	}

	@Override
	public boolean addStudent(Student stu) {
		
		return studao.addStudent(stu);
	}

	@Override
	public Student getname(String name) {
		
		return studao.getname(name);
	}

}
