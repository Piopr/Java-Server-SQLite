import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedUpdateMain {

	public static void main(String[] args) throws SQLException{
		// TODO Auto-generated method stub
		
		try(Connection con = DriverManager.getConnection("jdbc:sqlite:firma.db")){
			PreparedStatement ps = con.prepareStatement("update zamowienia set wartosc=? where idzam=?");
			boolean koniec = false;
			Scanner sc = new Scanner(System.in);
			while(!koniec && sc.hasNextLine()) {
				String linia = sc.nextLine();
			}
		}

	}

}
