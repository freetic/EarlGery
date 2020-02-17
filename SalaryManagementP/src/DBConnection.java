
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
	static Connection conn = null;
	public static Connection getConnection(String fileName){//3. connection
		Properties info = new Properties();
		try {
		info.load(new FileInputStream(new File(fileName)));//CBD :component b.. development
		Class.forName(info.getProperty("db.driver"));//2. 드라이버 로딩
		conn = DriverManager.getConnection(info.getProperty("db.url"),
								info.getProperty("db.user"),info.getProperty("db.password"));
		} catch (IOException | ClassNotFoundException |SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return conn;
	}
}
