package earlgrey.view;

import java.sql.SQLException;
import java.util.Scanner;

import com.example.view.Login;
import com.example.view.Register;

import earlgrey.dao.AdminDao;
import earlgrey.dao.AdminDaoImpl;
import earlgrey.service.AdminService;
import earlgrey.vo.TeacherVO;

public class AdminUI {
	private Scanner scan;
	private AdminService service;
	private boolean flag;
	
	
	
	
	public int showMenu() {
		System.out.println("1. ȸ�� ��ȸ�ϱ�\n" + 
				"2. ���� ��ȸ�ϱ�\n" + 
				"3. ȸ�� ���� ������Ʈ\n" + 
				"4. ���� ���� ������Ʈ\n" + 
				"5. ���α׷� ������Ʈ\n"+
				"6.���α׷� ����\n"+
				"0.���α׷� ����");
		Scanner scan = new Scanner(System.in);
		return scan.nextInt();
		
	}
}
