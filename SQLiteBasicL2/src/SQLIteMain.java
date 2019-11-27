import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLIteMain {

	public static void main(String[] args) {
		Connection con=null;
		String dbName="firma.db";
		System.out.println("��cz� z baz� "+dbName+"...");
		try {
			con=DriverManager.getConnection("jdbc:sqlite:"+dbName);
			System.out.println("Po��czenie z baz� "+dbName+" nawi�zane.");
			
			Statement st0=con.createStatement();
			int rowCount=st0.executeUpdate("insert into kontrahenci (nazwa) "+
			"values ('PKO BP')");
			System.out.println("Dodano "+rowCount+" rekord�w.");
			
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from kontrahenci");
			while(rs.next()) {
				System.out.println(rs.getString(1)+" "+rs.getString(2));
			}
			
//			rs.first();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
