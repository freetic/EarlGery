import java.util.Scanner;
import java.util.Vector;

public class Input {
	private Vector<Salary> vector;
	private Scanner scan;
	
	public Input() {
		
		this.scan = new Scanner(System.in);
	}
	
	public void input() { 
		System.out.println("�����ȣ : ");    String sabun = this.scan.next();
		System.out.println("����̸� : ");    String name = this.scan.next();
		System.out.println("�⺻�� : ");      int defSalary = this.scan.nextInt();
		System.out.println("�߰��ð� : ");    int nightHour = this.scan.nextInt();
		System.out.println("������ : ");       int family = this.scan.nextInt();
		Salary sal = new Salary(sabun, name, defSalary, nightHour, family);
		
	}
}
