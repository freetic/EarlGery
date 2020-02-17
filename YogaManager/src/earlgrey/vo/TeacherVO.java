package earlgrey.vo;

public class TeacherVO {
	private int empno;
	private  String name;
	private String phone;

	public TeacherVO(int empno, String name, String phone) {
		this.empno = empno;
		this.name = name;
		this.phone = phone;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return String.format("TeacherVO [empno=%s, name=%s, phone=%s]", empno, name, phone);
	}
	

}
