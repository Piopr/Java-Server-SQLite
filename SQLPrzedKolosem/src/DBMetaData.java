import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBMetaData {

	public static void main(String[] args) throws SQLException{
		try(Connection con = DriverManager.getConnection("jdbc:sqlite:firma.db")){
			DatabaseMetaData dbmd = con.getMetaData();
			//System.out.println(dbmd.getSQLKeywords());
			
			
			ResultSet rs = dbmd.getTables(null, null, null, new String[] {"TABLE"});
			while(rs.next()) {
				String tbName = rs.getString("TABLE_NAME");
				System.out.println(tbName);
				ResultSet pola = dbmd.getColumns(null, null, tbName, null);
				while(pola.next()) {
					System.out.println("-"+pola.getString("COLUMN_NAME")+
							" "+pola.getString("DATA_TYPE")+
							" "+pola.getMetaData().getColumnType(1));
				}
			}
		}

	}

}
