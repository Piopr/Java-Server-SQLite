import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null;
		String dbName = "firma.db";
		System.out.println("Lacze z baza danych: "+dbName);
		try {
			con = DriverManager.getConnection("jdbc:sqlite:"+dbName);
			System.out.println("Polaczenie nawiazane z baza: "+dbName);
			
			Statement st0=con.createStatement();
			int rowCount = st0.executeUpdate("insert into kontrahenci (nazwa) values"+
			"('Testowe dodanie2')");
			System.out.println("Dodano "+rowCount+" rekordow");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from kontrahenci");
			while(rs.next()) {
				System.out.println(rs.getString(1)+ " " + rs.getString(2));
			}
			//rs.first(); //przeniesienie do pierwszego rzedu
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
