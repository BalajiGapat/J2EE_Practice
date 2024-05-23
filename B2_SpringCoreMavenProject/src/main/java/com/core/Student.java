package com.core;

public class Student 
{
	private int studentID;
	private String studentName;
	private String studentAdress;
	
	
	
	// Setters and Getters :
	public int getStudentID()
	{
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentAdress() {
		return studentAdress;
	}
	public void setStudentAdress(String studentAdress) {
		this.studentAdress = studentAdress;
	}
	
	
	// Constructors :
	public Student(int studentID, String studentName, String studentAdress) {
		super();
		this.studentID = studentID;
		this.studentName = studentName;
		this.studentAdress = studentAdress;
	}
	
	public Student() {
		super();
	}
	
	
	public String toString() {
		return "Student [studentID=" + studentID + ", studentName=" + studentName + ", studentAdress=" + studentAdress
				+ "]";
    }
	
}
