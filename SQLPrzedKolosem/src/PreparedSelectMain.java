import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedSelectMain {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		try(Connection con = DriverManager.getConnection("jdbc:sqlite:firma.db")){
			PreparedStatement ps = con.prepareStatement("select * from kontrahenci where nazwa=?");
			boolean koniec = false;
			Scanner sc = new Scanner(System.in);
			System.out.println("Podaj nazwe kontrahenta: ");
			while(!koniec && sc.hasNextLine()) {
				String linia = sc.nextLine();
				switch(linia) {
				case "q":{
					koniec=!koniec;
					break;
					
				}
				default:{
					ps.setString(1, linia);
					ResultSet rs = ps.executeQuery();
					while(rs.next()) {
						System.out.println(rs.getString(1) + " "+ rs.getString("nazwa"));
						
					}
				}
				}
				System.out.println("Podaj nazwe kontrahenta: ");
			}
			System.out.println("koniec zapytan");
		}

	}

}
