package earlgrey.vo;

import java.util.Date;

public class Lecture {
	private int lectureid;
	private int empno;
	private String lectureTime;
	private int capacity;
	
	public Lecture(int empno, String lectureTime, int capacity) {
		super();
		this.empno = empno;
		this.lectureTime = lectureTime;
		this.capacity = capacity;
	}
	public int getLectureid() {
		return lectureid;
	}
	public void setLectureid(int lectureid) {
		this.lectureid = lectureid;
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getLectureTime() {
		return lectureTime;
	}
	public void setLectureTime(String lectureTime) {
		this.lectureTime = lectureTime;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	@Override
	public String toString() {
		return String.format("Lecture [lectureid=%s, empno=%s, lectureTime=%s, capacity=%s]", lectureid, empno,
				lectureTime, capacity);
	}
	
	

}
