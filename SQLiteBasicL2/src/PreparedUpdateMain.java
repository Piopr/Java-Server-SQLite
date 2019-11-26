import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class PreparedUpdateMain {

	public static void main(String[] args) throws SQLException {
		try(Connection c=DriverManager.getConnection("jdbc:sqlite:firma.db")){
			PreparedStatement ps=c.prepareStatement("update zamowienia set wartosc=? "+
		" where idzam=?");
			boolean koniec=false;
			Scanner sc=new Scanner(System.in);
			System.out.println("Wartoœc i numer zamówienia:");
			while(!koniec && sc.hasNextLine()) {
				String linia=sc.nextLine();
				switch(linia) {
				case "q":{
					koniec=true;
					break;
				}
				default:{
					StringTokenizer st=new StringTokenizer(linia);
					String par1=st.nextToken();
					String par2=st.nextToken();
					ps.setString(1, par1);
					ps.setString(2, par2);
					int colCount=ps.executeUpdate();
					
						System.out.println("Zmodyfikowano "+colCount+" rekord.");

				}
				}
				System.out.println("Wartoœc i numer zamówienia:");
			}
			System.out.println("Koniec zapytañ.");
		}

	}

}
