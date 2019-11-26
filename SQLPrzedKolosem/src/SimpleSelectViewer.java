import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SimpleSelectViewer {

	public static void main(String[] args) throws SQLException {
		try(Connection con = DriverManager.getConnection("jdbc:sqlite:firma.db")){
			boolean koniec = false;
			System.out.println("Podaj zapytanie sql: ");
			Scanner sc = new Scanner(System.in);
			while(!koniec && sc.hasNextLine()) {
				String linia = sc.nextLine();
				switch(linia) {			
					case "q":{
						koniec=!koniec;
						break;
					}
					default:{
						Statement st = con.createStatement();
						ResultSet rs = st.executeQuery(linia);
						ResultSetMetaData rsmd = rs.getMetaData();
						
						int kolumny = rsmd.getColumnCount();
						
						for(int i=1; i<=kolumny; i++) {
							System.out.print(rsmd.getColumnName(i));
							System.out.print("  ::  ");
						}
						System.out.println("");
						
						while(rs.next()) {
							for(int i=1; i<=kolumny; i++) {
							System.out.print(rs.getString(i));
							System.out.print("  ::  ");
							}	
							System.out.println("");
						}
						
					}
				}
				System.out.println("Podaj zapytanie sql: ");
			}
			System.out.println("koniec zapytan");
			
		}

	}

}
