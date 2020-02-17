package earlgrey.vo;

public class MemberVO {
	private String email;
	private String name;
	private String pwd;
	private String phone;

	public MemberVO(String email, String name, String pwd, String phone) {

	this.email = email;
	this.name= name;
	this.pwd = pwd;
	this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return String.format("MemberVO [email=%s, name=%s, pwd=%s, phone=%s]", email, name, pwd, phone);
	}

	

}
