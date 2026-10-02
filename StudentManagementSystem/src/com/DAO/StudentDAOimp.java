package com.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ConnectionFactory.ConnectionFactory;
import com.DTO.StudentDTO;

public class StudentDAOimp implements StudentDAO{
	Connection con=null;
	Statement stmt=null;
	PreparedStatement pstmt=null;
	ResultSet res=null;
	 
	public void addStudent(StudentDTO student)
	{
		try {
		con=ConnectionFactory.Connect();
		
		//String q="insert into student(student_id,name,email,phone,age) values(?,?,?,?,?)";
		
		CallableStatement ctmt=con.prepareCall("{call insertStudent(?,?,?,?,?)}");
		//pstmt=con.prepareStatement(q);
		
		ctmt.setInt(1, student.getStudentId());
		ctmt.setString(2, student.getName());
		ctmt.setString(3, student.getEmail());
		ctmt.setInt(4, student.getPhone());
		ctmt.setInt(5, student.getAge());
		
		ctmt.executeUpdate();
		System.out.println("Insertion Successfull");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public List<StudentDTO> getAllStudents()
	{
		ArrayList<StudentDTO> arrlist=new ArrayList<StudentDTO>();
		try {
			con=ConnectionFactory.Connect();
			
			//String q="select * from student";
			
			CallableStatement ctmt=con.prepareCall("{call getstudents()}");
			//pstmt=con.prepareStatement(q);
			
			res=ctmt.executeQuery();
			
			while(res.next())
			{
				int sid=res.getInt(1);
				String name=res.getString(2);
				String email=res.getString(3);
				int phone=res.getInt(4);
				int age=res.getInt(5);
				
				StudentDTO s1=new StudentDTO(sid,name,email,phone,age);
				
				arrlist.add(s1);
			}

			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return arrlist;
	}
	
	public StudentDTO getstudentById(int id)
	{
		StudentDTO s1=null;
		try {
			con=ConnectionFactory.Connect();
			
			String q="select * from student where student_id=?";
			pstmt=con.prepareStatement(q);
			
			pstmt.setInt(1, id);
			res=pstmt.executeQuery();
			while(res.next())
			{
				int sid=res.getInt(1);
				String name=res.getString(2);
				String email=res.getString(3);
				int phone=res.getInt(4);
				int age=res.getInt(5);
				
				s1=new StudentDTO(sid,name,email,phone,age);
			}

			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return s1;
	}
	
	public void updateStudent(StudentDTO student)
	{
		try {
			con=ConnectionFactory.Connect();
			
			String q="update student set name=?,email=?,phone=?,age=? where student_id=?";
			pstmt=con.prepareStatement(q);
			
			pstmt.setString(1, student.getName());
			pstmt.setString(2, student.getEmail());
			pstmt.setInt(3, student.getPhone());
			pstmt.setInt(4, student.getAge());
			pstmt.setInt(5, student.getStudentId());
			
			pstmt.executeUpdate();
			System.out.println("Updation Successfull");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void deleteStudent(int id)
	{
		try {
			con=ConnectionFactory.Connect();
			
			String q="delete from student where student_id=?";
			
			pstmt=con.prepareStatement(q);
			
			pstmt.setInt(1, id);
			
			pstmt.executeUpdate();
			System.out.println("Deletion Successfull");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public List<StudentDTO> searchByName(String names)
	{
		ArrayList<StudentDTO> arrlist=new ArrayList<StudentDTO>();
		try {
			
			con=ConnectionFactory.Connect();
			
			String q="select * from student where name like ?";
			
			pstmt=con.prepareStatement(q);
			
			pstmt.setString(1, "%"+names+"%");
			
			res=pstmt.executeQuery();
			
			while(res.next())
			{
				int sid=res.getInt(1);
				String name=res.getString(2);
				String email=res.getString(3);
				int phone=res.getInt(4);
				int age=res.getInt(5);
				
				StudentDTO s1=new StudentDTO(sid,name,email,phone,age);
				
				arrlist.add(s1);
			}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return arrlist;
	}
	
	public List<StudentDTO> searchByAgeRange(int minAge,int maxAge)
	{
		ArrayList<StudentDTO> arrlist=new ArrayList<StudentDTO>();
		try {
			
			con=ConnectionFactory.Connect();
			
			String q="select * from student where age between ? AND ?";
			
			pstmt=con.prepareStatement(q);
			
			pstmt.setInt(1, minAge);
			pstmt.setInt(2, maxAge);
			
			res=pstmt.executeQuery();
			
			while(res.next())
			{
				int sid=res.getInt(1);
				String name=res.getString(2);
				String email=res.getString(3);
				int phone=res.getInt(4);
				int age=res.getInt(5);
				
				StudentDTO s1=new StudentDTO(sid,name,email,phone,age);
				
				arrlist.add(s1);
			}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return arrlist;
	}
	
	public int countStudents()
	{
		int count=0;
		try {
			
			con=ConnectionFactory.Connect();
			
			String q="select count(*) from student";
			
			pstmt=con.prepareStatement(q);
			
			res=pstmt.executeQuery();
			while(res.next())
			{
				count=res.getInt(1);
			}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return count;
	}
	 
}
