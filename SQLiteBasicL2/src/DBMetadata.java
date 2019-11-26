import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBMetadata {

	public static void main(String[] args) throws SQLException {
		try(Connection c=DriverManager.getConnection("jdbc:sqlite:firma.db")){
			DatabaseMetaData dbmd=c.getMetaData();

			ResultSet tabrs=dbmd.getTables(null, null, null, new String[] {"TABLE"});
			while(tabrs.next()) {
				String tabName=tabrs.getString("TABLE_NAME");
				System.out.println(tabName);
				ResultSet colrs=dbmd.getColumns(null, null, tabName, null);
						while(colrs.next()) {
							System.out.println("-"+colrs.getString("COLUMN_NAME")+
									" "+colrs.getString("DATA_TYPE")+
									" "+colrs.getString("COLUMN_SIZE"));
						}
			}
		}
	}

}
