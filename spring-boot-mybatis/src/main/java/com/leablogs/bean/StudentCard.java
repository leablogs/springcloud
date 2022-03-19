package com.leablogs.bean;

import java.util.Date;
import java.util.List;

public class StudentCard {
	private int id;
	private int studentId;
	private Date startDate;
	private Date endDate;
	private List<Student> students;

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "StudentCard [id=" + id + ", studentId=" + studentId + ", startDate=" + startDate + ", endDate="
				+ endDate + ", students=" + students + "]";
	}
	
	
}
