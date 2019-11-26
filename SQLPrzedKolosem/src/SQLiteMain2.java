import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteMain2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null;
		String dbName = "nowaBaza.db";
		System.out.println("Przed proba polaczenia/stworzenia " + dbName);
		
		try {
			con = DriverManager.getConnection("jdbc:sqlite:"+dbName);
			System.out.println("Polaczono z baza "+ dbName);
			PreparedStatement ps =  con.prepareStatement("create table if not exists "+
			"kontrahenci (idknt integer primary key, nazwa text not null);");
			ps.executeUpdate();
			System.out.println("Po probie stworzenia tabeli");
			ps = con.prepareStatement("create table if not exists "+
			"zamowienia (idzam integer primary key, idknt integer REFERENCES kontrahenci "+
					"(idknt), datazam DATE not null, wartosc integer not null);");
			ps.executeUpdate();
			System.out.println("Po stworzeniu drugiej tabeli");
			//ps = con.prepareStatement("insert into kontrahenci (idknt, nazwa) values (1, 'Zabka');");
			//ps.executeUpdate();
			//ps = con.prepareStatement("insert into zamowienia (idzam, idknt, datazam, wartosc) values (1, 1, '2011-11-11', "+
			//		 "1000);");
			//ps.executeUpdate();
			ps = con.prepareStatement("select k.nazwa, z.datazam, z.wartosc from kontrahenci k left join zamowienia z on "+
			"k.idknt=z.idknt;");
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select k.nazwa, z.datazam, z.wartosc from kontrahenci k left join zamowienia z on " + 
				"k.idknt=z.idknt;");
			
			while(rs.next()) {
				System.out.println(rs.getString(1)+ " "+ rs.getString(2)+" "+ rs.getString(3));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
