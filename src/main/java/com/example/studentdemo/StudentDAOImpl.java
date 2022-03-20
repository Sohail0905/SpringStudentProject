package com.example.studentdemo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;


@Repository
public class StudentDAOImpl implements StudentDAO {
	
	private List<Student> stuList = new ArrayList<>();

	public Student getrollno(int rollno) {
		
		System.out.println("Inside DAO");
		for(Student stu:stuList){
			if(stu.getRollno()==rollno){
				return stu;
			}
		}
		return null;
	}

	
	@Override
	public boolean addStudent(Student stu) {
		stuList.add(stu);
		return true;
	}

	@Override
	public List<Student> getAllStudents() {
		
		return stuList;
	}

	
	@Override
	public Student getname(String name) {
		for(Student stu:stuList){
			if(stu.getName().equals(name))
				return stu;
		}
		return null;
	}

}
