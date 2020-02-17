import java.util.Scanner;
import java.util.Vector;

public class Input {
	private Vector<Salary> vector;
	private Scanner scan;
	
	public Input() {
		
		this.scan = new Scanner(System.in);
	}
	
	public void input() { 
		System.out.println("사원번호 : ");    String sabun = this.scan.next();
		System.out.println("사원이름 : ");    String name = this.scan.next();
		System.out.println("기본급 : ");      int defSalary = this.scan.nextInt();
		System.out.println("야간시간 : ");    int nightHour = this.scan.nextInt();
		System.out.println("가족수 : ");       int family = this.scan.nextInt();
		Salary sal = new Salary(sabun, name, defSalary, nightHour, family);
		
	}
}
