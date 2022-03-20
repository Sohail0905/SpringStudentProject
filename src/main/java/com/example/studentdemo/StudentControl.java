package com.example.studentdemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StudentControl {
	
@Autowired
private StudentService studentService;

@RequestMapping("/hello")
public String firstPage(){
	System.out.println("Inside Control Service");
	studentService.getrollno(123);
	studentService.getname("Sohail");
	return "Hello Student";
	
}
@RequestMapping("/student")
public Student firstPage(@RequestParam int rollno){
	System.out.println("Inside Control Service");
	return studentService.getrollno(rollno);
	
}

@GetMapping("/allstudents")
public List<Student> getAllStudents(){
	
	return studentService.getAllStudents();
}

@GetMapping("/student/name")
public Student getrollno(@RequestParam String name){
	
	return studentService.getname(name);
}

@PostMapping("add/student")
public boolean saveStu(@RequestBody Student stu){
	
	return studentService.addStudent(stu);
}


}
