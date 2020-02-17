package earlgrey.view;

import java.sql.SQLException;
import java.util.Scanner;

import earlgrey.service.AdminService;
import earlgrey.service.AdminServiceImpl;
import earlgrey.vo.MemberVO;
import earlgrey.vo.TeacherVO;

public class AdminUI {
	private Scanner scan;
	private AdminService service;
	private boolean flag;
	public AdminUI() {
		this.service = new AdminServiceImpl();
	}
	public void init() throws SQLException {
		int choice = showMenu();
		switch(choice) {
			case 1:  System.out.println("�������� �̸����� �Է� : "); String email = scan.next();
				this.service.readMember(email);
				//ȸ�� ��ȸ�ϱ�
			case 2: System.out.println("������ ����� �Է�:"); int empno = scan.nextInt();
				this.service.readTeacher(empno);
				//���� ��ȸ�ϱ�
			case 3: this.service.readAllMember();
				//��� ȸ�� ��ȸ�ϱ�
			case 4: this.service.readAllTeacher();
				//��� �� ��ȸ�ϱ�
			case 5:  
				System.out.println("<<������Ʈ �ϰ��� �ϴ� �������� ������ �Է�  >>");
				System.out.println("�̸��� :");String email1 = scan.next();
				MemberVO mb = this.service.readMember(email1);
			    System.out.println("<<�ٲ� ���� �Է�>>");
				System.out.println("�̸� : ");String name = scan.next();
				System.out.println("  ��й�ȣ : ");String phone = scan.next();
				MemberVO member = new MemberVO(email1, name, phone);
				int row = 	this.service.updateMember(member);
				if(row==-1) {
					System.out.println("�ش� �������� ������Ʈ�� �����Ͽ����ϴ�.  ");
				}
				//ȸ�� ���� ������Ʈ
			case 6://���� �߰�	this.empno = empno;
				//this.name = name;
				//this.phone = phone;
				System.out.println("<<���� �߰�>>");
				System.out.println("��� �Է�:  "); int empno1 = scan.nextInt();
				System.out.println("�̸� �Է� : "); String name1 = scan.next();
				System.out.println("��ȭ��ȣ :  "); String phone1 = scan.next();
				TeacherVO teacher = new TeacherVO(empno1, name1, phone1);
				row = this.service.insertTeacher(teacher);
				if(row == 1) {
					System.out.println("���� �߰� ����  ");
					
				}else {System.out.println("���� �߰��� �����Ͽ����ϴ�.");}
				
			case 7:System.out.println("������ ������ ����� �Է� : ");
			int empno2 = scan.nextInt();
			row = this.service.deleteTeahcer(empno2);
			if(row == 1) {
				System.out.println("���� ���� ����  ");
				
			}else {System.out.println("���� ������ �����Ͽ����ϴ�.");}
			case 0: System.exit(0);
		}
	}
	
	
	
	public int showMenu() {
		System.out.println("1. ȸ�� ��ȸ�ϱ�\n" + 
				"2. ���� ��ȸ�ϱ�\n" + 
				"3. ��� ȸ�� ��ȸ�ϱ�\n" + 
				"4. ��� ���� ��ȸ�ϱ�\n" + 
				"5. ȸ�� ���� ������Ʈ\n"+
				"6. ���� �߰�\n"+
				"7. ���� ����\n"
				+ "0. ����\n");
		Scanner scan = new Scanner(System.in);
		return scan.nextInt();
		
	}
	
}
