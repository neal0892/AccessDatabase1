import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
//import java.sql.Timestamp;
import java.util.Date;


public class DatabaseConnection {
	static Connection con;

	public static int authenticate(String username, String password) throws SQLException, ClassNotFoundException {
		initialise();
		PreparedStatement ps = con.prepareStatement("select * from credentials where name=? and password=?");
		ps.setString(1, username);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return rs.getInt(1);
	}

	public static boolean isUserPresent(String newuser) throws SQLException, ClassNotFoundException {
		initialise();
		PreparedStatement ps = con.prepareStatement("select * from credentials where name=?");
		ps.setString(1, newuser);
		ResultSet rs = ps.executeQuery();
		return rs.next();
	}

	public static int putUserData(String newuser, String pass1) throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "oracle");
		PreparedStatement ps = con.prepareStatement("insert into credentials(ID, NAME, PASSWORD) values (?, ?, ?)");
		ps.setInt(1, 1);
		ps.setString(2, newuser);
		ps.setString(3, pass1);
		return ps.executeUpdate();
	}

	private static void initialise() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "oracle");

	}

	public static int getId(String name) throws ClassNotFoundException, SQLException {
		initialise();
		PreparedStatement ps = con.prepareStatement("select ID from credentials where name=?");
		ps.setString(1, name);
		ResultSet rs=ps.executeQuery();
		rs.next();
		return rs.getInt(1);
	}

	public static void writeData(int id, String article) throws ClassNotFoundException, SQLException{
		initialise();
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		PreparedStatement ps = con.prepareStatement("insert into data (TWEETID, ID ,TWEET, TIME) values(?, ?, ?, ?)");
		ps.setInt(1, 1);
		ps.setInt(2, id);
		ps.setString(3, article);
		ps.setTimestamp(4, ts);
		ps.executeQuery();
	}
	
	

}
