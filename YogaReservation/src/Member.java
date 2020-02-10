public class Member {
  private String Email;
    private String Password;
    private String Name;
    private String Phone;
	public Member(String email, String password, String name, String phone) {

		Email = email;
		Password = password;
		Name = name;
		Phone = phone;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	@Override
	public String toString() {
		return "MemberDTO [Email=" + Email + ", Password=" + Password + ", Name=" + Name + ", Phone=" + Phone + "]";
	}
    
    
    
   
    
}

