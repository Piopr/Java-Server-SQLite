import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Kolo {

	public static void main(String[] args) throws SQLException{
		// TODO Auto-generated method stub
		
		try(Connection con = DriverManager.getConnection("jdbc:sqlite:klienci.db")){
			PreparedStatement ps = con.prepareStatement("create table if not exists miasta (idmiasta integer primary key, nazwa text not null) ");
			ps.executeUpdate();
			ps = con.prepareStatement("create table if not exists klienci (idklienta integer primary key, nazwa text not null, idmiasta integer REFERENCES miasta (idmiasta))");
			ps.executeUpdate();
//			ps = con.prepareStatement("insert into miasta  values (1, 'Krakow')");
//			ps.executeUpdate();
//			ps = con.prepareStatement("insert into miasta  values (2, 'Wieliczka')");
//			ps.executeUpdate();
//			ps = con.prepareStatement("insert into miasta  values (3, 'Sosnowiec')");
//			ps.executeUpdate();
			
//			ps = con.prepareStatement("insert into klienci  values (1, 'Marek', 1)");
//			ps.executeUpdate();
//			ps = con.prepareStatement("insert into klienci  values (2, 'Stefan', 2)");
//			ps.executeUpdate();
//			ps = con.prepareStatement("insert into klienci  values (3, 'Romek', 3)");
//			ps.executeUpdate();
			
			ps = con.prepareStatement("select * from klienci where idmiasta=1");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString(1)+rs.getString(2)+ rs.getString(3) );
			}
			
			
		}

	}

}
