import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Kolos {

	public static void main(String[] args) throws SQLException{
		// TODO Auto-generated method stub
		
		try(Connection con = DriverManager.getConnection("jdbc:sqlite:sprzedaz.db")){
			DatabaseMetaData dbmd = con.getMetaData();
			ResultSet rs = dbmd.getTables(null, null, null, new String[]  {"TABLE"});
			while(rs.next()) {
				String tbname = rs.getString("TABLE_NAME");
				System.out.println(tbname);
				ResultSet kolumny = dbmd.getColumns(null, null, tbname, null);				
				while(kolumny.next()) {
					System.out.println("-" + kolumny.getString("COLUMN_NAME"));
					
				}
//				System.out.println("-"+rs.getString("COLUMN_NAME"));
			}
			PreparedStatement ps = con.prepareStatement("select * from klienci");
			ResultSet rsTable = ps.executeQuery();			
			while(rsTable.next()) {
				System.out.println(rsTable.getString(1)+ " " + rsTable.getString(2) );
			}
			ps = con.prepareStatement("select * from wojewodztwa");
			rsTable = ps.executeQuery();			
			while(rsTable.next()) {
				System.out.println(rsTable.getString(1)+ " " + rsTable.getString(2));
			}
			
			ps = con.prepareStatement("select * from zamowienia");
			rsTable = ps.executeQuery();			
			while(rsTable.next()) {
				System.out.println(rsTable.getString(1)+ " " + rsTable.getString(2) + " " + rsTable.getString(3));
			}
			
		}
			
			

			
		}

	}


