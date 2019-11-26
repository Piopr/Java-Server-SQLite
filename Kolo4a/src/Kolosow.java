import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Kolosow {

	public static void main(String[] args) throws SQLException{
		// TODO Auto-generated method stub
		
		try(Connection con = DriverManager.getConnection("jdbc:sqlite:sprzedaz.db")){
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select w.nazwa as Wojew, k.nazwa as Kontrahent , z.data, z.wartosc from zamowienia z left join klienci k on z.idklienta=k.idklienta left join wojewodztwa w on k.idwoj=w.idwoj");
			while(rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " +rs.getString(4));
			}
			
			PreparedStatement ps = con.prepareStatement("update zamowienia set wartosc=wartosc*2 where idklienta in (select idzam from zamowienia join klienci k on zamowienia.idklienta = k.idklienta join wojewodztwa w on k.idwoj = w.idwoj where w.nazwa = 'Mazowieckie')");
			ps.executeUpdate();
			
			rs = st.executeQuery("select w.nazwa as Wojew, k.nazwa as Kontrahent , z.data, z.wartosc from zamowienia z left join klienci k on z.idklienta=k.idklienta left join wojewodztwa w on k.idwoj=w.idwoj");
			while(rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " +rs.getString(4));
			}
			
		}

	}

}
