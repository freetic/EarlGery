import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.Vector;



public class MainClass {

	private Scanner scan;
	
	public MainClass() {
	
		this.scan = new Scanner(System.in);
	}
	public static void main(String[] args) throws SQLException {
		MainClass mc = new MainClass();
		
		while(true) {
			int choice = mc.showMenu();
			if(choice >= 1 && choice <= 4 ) mc.process(choice);
			else break;
		}
		System.out.println("Program is over...");
	}
	void process(int choice) throws SQLException {
		
		switch(choice) {
			case 1: input();  break;
			case 2: search();  break;
			//case 3: update();  break;
			case 4: output();  break;
		}
	}
	void search() throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		Connection conn = DBConnection.getConnection("mariadb.properties");
		stmt = conn.createStatement();
		System.out.print("검색할 사원번호 : ");
		String sabun = this.scan.next();
		String sql = "SELECT empno, ename, gibon, yagan, gajok FROM emp WHERE empno = "+"'"+sabun+"'";
		rs = stmt.executeQuery(sql);
		if(rs.next()) {
			System.out.printf("%s\t%s\t%d\t%d\t%d\t",rs.getString("empno"),rs.getString("ename"),
							rs.getInt("gibon"),rs.getInt("yagan"),rs.getInt("gajok"));
			System.out.println();
		}
		else {System.out.println("해당 사원의 데이터가 없습니다.");}
				
		DBClose.close(conn, stmt, rs);
		
	}
	void input() {
		Input input = new Input();    input.input();
		Calc calc = new Calc();    calc.calc();
	}
	void output() throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		Connection conn = DBConnection.getConnection("mariadb.properties");
		stmt = conn.createStatement();
		String sql = "SELECT e.empno, e.ename, e.buseo, e.gibon, h.ho, g.gi, y.ya, e.chong, e.silsu  " +
						" FROM emp e ,hogub h,  gibon g, yagan y "+
						" WHERE e.hogub = h.pkey"
						+ " AND e.gibon = g.pkey"
						+ " AND e.yagan = y.pkey";
		rs = stmt.executeQuery(sql);
		while(rs.next()) {
			System.out.print(rs.getString("empno")+"\t"+rs.getString("ename")+rs.getString("buseo")+
					"\t"+rs.getInt("gibon")+"\t"+rs.getInt("ho")+"\t"+rs.getInt("gi")+"\t"+rs.getInt("ya")+"\t"+rs.getInt("chong")
					+"\t"+rs.getInt("silsu"));
			System.out.println();
		}
		
	}
	
	
	int showMenu() {
		System.out.println("***********Menu**********");
		System.out.println("1. 입력");
		System.out.println("2. 검색");
		System.out.println("3. 수정");
		System.out.println("4. 출력");
		System.out.println("5. 종료");
		System.out.print("선택 >> : ");  
		return this.scan.nextInt();
	}
}
