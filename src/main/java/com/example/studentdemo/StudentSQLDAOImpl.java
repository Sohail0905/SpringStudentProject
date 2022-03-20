package com.example.studentdemo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import javax.swing.tree.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;


@Repository("sqlDao")
public class StudentSQLDAOImpl extends JdbcDaoSupport implements StudentDAO {
	
	
	@Autowired
	DataSource dataSource;

	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}
	
	private List<Student> stuList = new ArrayList<>();

	/*public Student getrollno(int rollno) {
		
		System.out.println("Inside DAO");
		for(Student stu:stuList){
			if(stu.getRollno()==rollno){
				return stu;
			}
		}
		return null;
	}*/
	
	
   @Override
   public Student getrollno(int rollno){
	   String sql = "SELECT * from Persons WHERE rollno = ?";
	   return (Student)getJdbcTemplate().queryForObject(sql, new Object[]{rollno}, new RowMapper<Student>(){
		   @Override
		   public Student mapRow (ResultSet rs, int rwNumber) throws SQLException {
			 Student stu = new Student();
			 stu.setRollno(rs.getString("rollno"));
			 stu.setname(rs.getString("name"));
			 return stu;
		   }
	   });}
   

	
	@Override
	public boolean addStudent(Student stu) {
		String sql = "INSERT INTO Persons " +
				"(rollno, name) VALUES (?, ?)" ;
		getJdbcTemplate().update(sql, new Object[]{
				stu.getRollno(), stu.getName()
		});
		return true;
	}
	
	
	/* @Override
	public List<Student> getAllStudents() {
		
		return stuList;
	}*/
	 

	@Override
	public List<Student> getAllStudents() {
		String sql = "SELECT * FROM Persons";
		List<Map<String,Object>> rows = getJdbcTemplate().queryForList(sql);
	
		List<Student> result = new ArrayList<Student>();
		for(Map<String,Object> row:rows){
			
			Student stu = new Student();
			stu.setRollno((int)row.get("rollno"));
			
			stu.setName((String)row.get("name"));
		result.add(stu);
		
		}
		
		return result;
		
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
