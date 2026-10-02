package com.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ConnectionFactory.ConnectionFactory;
import com.DTO.CourseDTO;

public class CourseDAOimp implements CourseDAO{
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet res=null;
	public void addCourse(CourseDTO course)
	{
		try {
			con=ConnectionFactory.Connect();
			
			//String q="insert into course(course_id,course_name,duration,fees) values(?,?,?,?)";
			
			//pstmt=con.prepareStatement(q);
			
			CallableStatement ctmt=con.prepareCall("{call insertcourse(?,?,?,?)}");
			ctmt.setInt(1, course.getCourseid());
			ctmt.setString(2, course.getCourseName());
			ctmt.setString(3, course.getDuration());
			ctmt.setDouble(4, course.getFees());
			
			ctmt.executeUpdate();
			System.out.println("Insertion Successfull");
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public List<CourseDTO> getAllCourses()
	{
		ArrayList<CourseDTO> arrlist=new ArrayList<CourseDTO>();
		try {
			con=ConnectionFactory.Connect();
			
	//		String q="select * from course";
			
	//		pstmt=con.prepareStatement(q);
			
			CallableStatement ctmt=con.prepareCall("{call getcourse}");
			res=ctmt.executeQuery();
			
			while(res.next())
			{
				int courseId=res.getInt(1);
				String coursename=res.getString(2);
				String courseduration=res.getString(3);
				int coursefees=res.getInt(4);
				
				CourseDTO c1=new CourseDTO(courseId,coursename,courseduration,coursefees);
				
				arrlist.add(c1);
			}
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return arrlist;
	}
	public CourseDTO getCourseById(int id)
	{
		ArrayList<CourseDTO> arrlist=new ArrayList<CourseDTO>();
		CourseDTO c1=null;
		try {
			con=ConnectionFactory.Connect();
			
			//String q="select * from course where course_id=?";
			
			//pstmt=con.prepareStatement(q);
			
			CallableStatement ctmt=con.prepareCall("{call GetCourseById(?)}");
			ctmt.setInt(1, id);
			res=ctmt.executeQuery();
			
			while(res.next())
			{
				int courseId=res.getInt(1);
				String coursename=res.getString(2);
				String courseduration=res.getString(3);
				Double coursefees=res.getDouble(4);
				
				c1=new CourseDTO(courseId,coursename,courseduration,coursefees);
			}
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return c1;
	}
	public void updateCourse(CourseDTO course)
	{
		try {
			con=ConnectionFactory.Connect();
			
			String q="update course set course_name=?,duration=?,fees=?  where course_id=?";
			
			pstmt=con.prepareStatement(q);
			
			pstmt.setString(1, course.getCourseName());
			pstmt.setString(2, course.getDuration());
			pstmt.setDouble(3, course.getFees());
			pstmt.setInt(4, course.getCourseid());
			
			pstmt.executeUpdate();
			System.out.println("Updation Successfull");
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void deleteCourse(int id)
	{
		try {
			con=ConnectionFactory.Connect();
			
			String q="delete from course where course_id=?";
			
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
	public List<CourseDTO> searchByName(String name)
	{
		ArrayList<CourseDTO> arrlist=new ArrayList<CourseDTO>();
		try {
			con=ConnectionFactory.Connect();
			
			String q="select * from course where course_name like ?";
			
			pstmt=con.prepareStatement(q);
			pstmt.setString(1,"%"+name+"%");
			res=pstmt.executeQuery();
			
			while(res.next())
			{
				int courseId=res.getInt(1);
				String coursename=res.getString(2);
				String courseduration=res.getString(3);
				int coursefees=res.getInt(4);
				
				CourseDTO c1=new CourseDTO(courseId,coursename,courseduration,coursefees);
				
				arrlist.add(c1);
			}
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return arrlist;
	}
	public List<CourseDTO> searchByDuration(String duration)
	{
		ArrayList<CourseDTO> arrlist=new ArrayList<CourseDTO>();
			try {
				con=ConnectionFactory.Connect();
				
				String q="select * from course where duration=?";
				
				pstmt=con.prepareStatement(q);
				pstmt.setString(1,duration);
				res=pstmt.executeQuery();
				
				while(res.next())
				{
					int courseId=res.getInt(1);
					String coursename=res.getString(2);
					String courseduration=res.getString(3);
					int coursefees=res.getInt(4);
					
					CourseDTO c1=new CourseDTO(courseId,coursename,courseduration,coursefees);
					
					arrlist.add(c1);
				}
				}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return arrlist;
	}
	public List searchByFeeRange(double min, double max)
	{
		ArrayList<CourseDTO> arrlist=new ArrayList<CourseDTO>();
		try {
			con=ConnectionFactory.Connect();
			
			String q="select * from course where fees between ? and ?";
			
			pstmt=con.prepareStatement(q);
			pstmt.setDouble(1,min);
			pstmt.setDouble(2, max);
			res=pstmt.executeQuery();
			
			while(res.next())
			{
				int courseId=res.getInt(1);
				String coursename=res.getString(2);
				String courseduration=res.getString(3);
				int coursefees=res.getInt(4);
				
				CourseDTO c1=new CourseDTO(courseId,coursename,courseduration,coursefees);
				
				arrlist.add(c1);
			}
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return arrlist;
	}
	public int countCourses()
	{
		int count=0;
		try {
			
			con=ConnectionFactory.Connect();
			
			String q="select count(*) from course";
			
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
