import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedSelectMain {

	public static void main(String[] args) throws SQLException  {
		try(Connection c=DriverManager.getConnection("jdbc:sqlite:firma.db")){
			PreparedStatement ps=c.prepareStatement("select * from kontrahenci "+
		"where nazwa=?");
			boolean koniec=false;
			Scanner sc=new Scanner(System.in);
			System.out.println("Podaj nazwê konrahenta:");
			while(!koniec && sc.hasNextLine()) {
				String linia=sc.nextLine();
				switch(linia) {
				case "q":{
					koniec=true;
					break;
				}
				default:{
					ps.setString(1, linia);
					ResultSet rs=ps.executeQuery();
					while(rs.next()) {
						System.out.println(rs.getString("idknt")+" "+rs.getString("nazwa"));
					}
				}
				}
				System.out.println("Podaj nazwê konrahenta:");
			}
			System.out.println("Koniec zapytañ.");
		}

	}

}
