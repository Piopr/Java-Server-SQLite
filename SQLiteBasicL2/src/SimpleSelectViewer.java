import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SimpleSelectViewer {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		try(Connection c=DriverManager.getConnection("jdbc:sqlite:firma.db")){

			boolean koniec=false;
			Scanner sc=new Scanner(System.in);
			System.out.println("Podaj zapytanie select: ");
			while(!koniec && sc.hasNextLine()) {
				String linia=sc.nextLine();
				switch(linia) {
				case "q":{
					koniec=true;
					break;
				}
				default:{
					Statement st = c.createStatement();
					ResultSet rs = st.executeQuery(linia);
					ResultSetMetaData rsmd = rs.getMetaData();
					
					int liczba_kolumn = rsmd.getColumnCount();
					
					for ( int i = 1; i <= liczba_kolumn; i++) {
						System.out.print(rsmd.getColumnName(i));
						
						if ( i != liczba_kolumn) {
							System.out.print("  ::  ");
						}
					}
					System.out.println("");
					
		
					while(rs.next()) {
						for ( int i = 1; i <= liczba_kolumn; i++) {
							System.out.print(rs.getString(i));
							
							if ( i != liczba_kolumn) {
								System.out.print("  ::  ");
							}
						}
						System.out.println("");
					}
				}
				}
				System.out.println("Podaj zapytanie select");
			}
			System.out.println("Koniec zapytañ.");
		}
	}

}
