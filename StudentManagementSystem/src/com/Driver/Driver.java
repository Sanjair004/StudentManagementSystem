package com.Driver;

import java.util.Scanner;

import com.DAO.CourseDAOimp;
import com.DAO.StudentDAOimp;
import com.DTO.CourseDTO;
import com.DTO.StudentDTO;


public class Driver {
	public static void main(String[] args)
	{
		StudentDAOimp sd1=new StudentDAOimp();
		CourseDAOimp cd1=new CourseDAOimp();
		Scanner sc=new Scanner(System.in);
		
		boolean value=true;
		
		while(value) {
		System.out.println("======================================== STUDENT MANAGEMENT SYSTEM ========================================");
		        System.out.println("========================================");
		        System.out.println("                STUDENT                 ");
		        System.out.println("========================================");

		        System.out.println("1. Add Student");
		        System.out.println("2. View All Students");
		        System.out.println("3. Find Student");
		        System.out.println("4. Update Student");
		        System.out.println("5. Delete Student");
		        System.out.println("6. Search Student by Name");
		        System.out.println("7. Search Student by Age");

		        System.out.println();

		        System.out.println("========================================");
		        System.out.println("                 COURSE                 ");
		        System.out.println("========================================");

		        System.out.println("8. Add Course");
		        System.out.println("9. View All Courses");
		        System.out.println("10. Find Course");
		        System.out.println("11. Update Course");
		        System.out.println("12. Delete Course");
		        System.out.println("13. Search Course by Name");
		        System.out.println("14. Search Course by Fee");

		        System.out.println();

		        System.out.println("========================================");
		        System.out.println("                 REPORT                 ");
		        System.out.println("========================================");

		        System.out.println("15. Count Students");
		        System.out.println("16. Count Courses");

		        System.out.println();
		        System.out.println("0. Exit");

		        System.out.println("========================================");
		        
		        int choice=sc.nextInt();
		        
		        switch(choice)
		        {
		        
		        case 1:{
		        		System.out.println("Enter the Student Id");
		        		int studentId=sc.nextInt();
		        		
		        		System.out.println("Enter the Student Name");
		        		String sname=sc.next();
		        		
		        		System.out.println("Enter the Student Email");
		        		String email=sc.next();
		        		
		        		System.out.println("Enter the Student Phone");
		        		int phone=sc.nextInt();
		        		
		        		System.out.println("Enter the Student Age");
		        		int age=sc.nextInt();
		        		
		        		if(sname.isEmpty() || email.isEmpty()|| age<0) {
		        			System.out.println("Enter a Valid Data");
		        			break;
		        		}
		        		
		        		StudentDTO s1=new StudentDTO(studentId,sname,email,phone,age);	
		        		
		        		sd1.addStudent(s1);
		        		break;
		        }
		        
		        case 2:
		        {
		        	
		        	System.out.println(sd1.getAllStudents());
		        	break;
		        }
		        
		        case 3:{
		        	
		        	System.out.println("Enter the Student Id");
		        	int id=sc.nextInt();
		        	System.out.println(sd1.getstudentById(id));
		        	break;
		        	
		        }
		        
		        case 4:{
		        	
		        		System.out.println("Enter the Student Id");
		        		int id=sc.nextInt();
		        		
		        		System.out.println("Enter the Updated Student Name");
		        		String sname=sc.next();
		        		
		        		System.out.println("Enter the Updated Student Email");
		        		String email=sc.next();
		        		
		        		System.out.println("Enter the Updated Student Phone");
		        		int phone=sc.nextInt();
		        		
		        		System.out.println("Enter the Updated Student Age");
		        		int age=sc.nextInt();
		        		
		        		if(sname.isEmpty() || email.isEmpty()|| age<0) {
		        			System.out.println("Enter a Valid Data");
		        		}
		        		
		        		StudentDTO sdto=new StudentDTO(id,sname,email,phone,age);
		        		sd1.updateStudent(sdto);
		        		
		        		break;
		        		
		        }
		        
		        case 5:{
		        	System.out.println("Enter the Student Id");
	        		int id=sc.nextInt();
	        		
	        		sd1.deleteStudent(id);
	        		break;
	        		
		        }
		        case 6:{
		        	
		        	System.out.println("Enter the Student Name");
	        		String sname=sc.next();
	        		
	        		if(sname.isEmpty())
	        		{
	        			System.out.println("Enter a Valid Name");
	        			break;
	        		}
	        		System.out.println(sd1.searchByName(sname));
	        		
	        		break;
	        		
		        }
		        
		        case 7:{
		        	
		        	System.out.println("Enter the Student Minimum Age");
	        		int Min_age=sc.nextInt();
	        		
	        		System.out.println("Enter the Student Maximum Age");
	        		int Max_age=sc.nextInt();
	        		
	        		if(Min_age<0)
	        		{
	        			System.out.println("Enter a Valid Input");
	        			
	        		}
	        		
	        		System.out.println(sd1.searchByAgeRange(Min_age, Max_age));
	        		break;
	        		
		        }
		        
		        case 8:{
		        	
		        	System.out.println("Enter the Course Id");
		        	int cid=sc.nextInt();
		        	
		        	System.out.println("Enter the Course Name");
		        	String cname=sc.next();
		        	
		        	System.out.println("Enter the Course Duration");
		        	String duration=sc.next();
		        	
		        	System.out.println("Enter the Fees");
		        	double fees=sc.nextDouble();
		        	
		        	if(cid<0|| cname.isEmpty()||duration.isEmpty() || fees<0) {
	        			System.out.println("Enter a Valid Data");
	        			break;
	        		}
		        	
		        	CourseDTO cdto=new CourseDTO(cid, cname, duration, fees);
		        	
		        	cd1.addCourse(cdto);
		        	break;
		        	
		        	
		        }
		        
		        case 9:{
		        	
		        	System.out.println(cd1.getAllCourses());
		        	break;
		        	
		        }
		        
		        case 10:{
		        	
		        	System.out.println("Enter the Course Id");
		        	int cid=sc.nextInt();
		        	
		        if(cid<0) {
	        			System.out.println("Enter a Valid Data");
	        			break;
	        		}
		        	System.out.println(cd1.getCourseById(cid));
		        	break;
		        	
		        }
		        
		        case 11:{
		        	System.out.println("Enter the Course Id");
		        	int cid=sc.nextInt();
		        	
		        	System.out.println("Enter the Updated Course Name");
		        	String cname=sc.next();
		        	
		        	System.out.println("Enter the Updated Course Duration");
		        	String duration=sc.next();
		        	
		        	System.out.println("Enter the Updated Fees");
		        	double fees=sc.nextDouble();
		        	
		        	
		        if(cid<0|| cname.isEmpty()||duration.isEmpty() || fees<0) {
	        			System.out.println("Enter a Valid Data");
	        			break;
	        		}
		        
		        	CourseDTO cdto=new CourseDTO(cid, cname, duration, fees);
		        	
		        	cd1.updateCourse(cdto);
		        	break;
		        	
		        }
		        
		        case 12:{
		        	System.out.println("Enter the Course Id");
		        	int cid=sc.nextInt();
		        	
		        	if(cid<0) {
	        			System.out.println("Enter a Valid Data");
	        			break;
	        		}
		        	
		        	cd1.deleteCourse(cid);
		        	break;
		        	
		        }
		        
		        case 13:{
		        	
		        	System.out.println("Enter the Course Name");
		        	String cname=sc.next();
		        	
		        	if(cname.isEmpty()) {
	        			System.out.println("Enter a Valid Data");
	        			break;
	        		}
		        	
		        	System.out.println(cd1.searchByName(cname));
		        	break;
		        	
		        }
		        
		        case 14:{
		        	
		         System.out.println("Enter the Min range Fees");
		         double min_fees=sc.nextDouble();
		         
		         System.out.println("Enter the Max range Fees");
		         double max_fees=sc.nextDouble();
		         
		         
		         if(min_fees<0)
		         {
		        	 System.out.println("Enter a Valid Data");
		        	 break;
		         }
		         System.out.println(cd1.searchByFeeRange(min_fees, max_fees));
		         break;
		         
		        }
		        
		        case 15:{
		        	
		        	System.out.println(sd1.countStudents());
		        	break;
		        	
		        }
		        
		        case 16:{
		        	System.out.println(cd1.countCourses());
		        	break;
		        	
		        }
		        
		        case 0:{
		        	
		        	System.out.println("Thank Youuuu");
		        	value=false;
		        	break;
		        }
		        }
		}
	}
}

