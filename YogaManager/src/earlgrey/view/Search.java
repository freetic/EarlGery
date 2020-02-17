package earlgrey.view;
import java.sql.SQLException;
import java.util.Scanner;


import earlgrey.service.ReserveMgmtService;
import earlgrey.service.ReserveMgmtServiceImpl;
import earlgrey.vo.ReserveVO;




public class Search {
	private Scanner scan;
	private ReserveMgmtService service;
	
	public Search() {
		this.scan = new Scanner(System.in);
		this.service = new ReserveMgmtServiceImpl();
	}
	
	
	public ReserveVO search() throws SQLException {
		System.out.print("ȸ���� �̸��� : ");
		String userid = this.scan.next();
		ReserveVO reserve = this.service.read(userid);
		return reserve;
		}
	
	public void display(ReserveVO reserve) {
		if(reserve == null) System.out.println("���� ã�� ���߽��ϴ�.");
		else if(reserve != null) System.out.println(reserve);
	}
}



