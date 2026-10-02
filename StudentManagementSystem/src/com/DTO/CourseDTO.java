package com.DTO;

public class CourseDTO {
	private int courseid;
	private String courseName;
	private String duration;
	private double fees;
	
	public CourseDTO(int courseid, String courseName, String duration, double fees) {
		this.courseid = courseid;
		this.courseName = courseName;
		this.duration = duration;
		this.fees = fees;
	}

	public int getCourseid() {
		return courseid;
	}

	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public String toString() {
		return "CourseDTO [courseid=" + courseid + ", courseName=" + courseName + ", duration=" + duration + ", fees="
				+ fees + "]";
	}
}
