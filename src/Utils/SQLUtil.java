package src.Utils;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLWarning;

public class SQLUtil {


    static public void displayResultSet(ResultSet rs) throws SQLException {
        int i;

        // Get the ResultSetMetaData.  This will be used for the column headings
        ResultSetMetaData rsmd = rs.getMetaData();

        // Get the number of columns in the result set
        int numCols = rsmd.getColumnCount();

        // Display column headings
        for (i = 1; i <= numCols; i++) {
            if (i > 1) System.out.print(",");
            System.out.print(rsmd.getColumnLabel(i));
        }
        System.out.println("\n-------------------------------------");

        // Display data, fetching until end of the result set
        while (rs.next()) {
            // Loop through each column, getting the
            // column data and displaying
            for (i = 1; i <= numCols; i++) {
                if (i > 1) System.out.print(",");
                System.out.print(rs.getString(i));
            }
            System.out.println("");
            // Fetch the next result set row
        }
    }


    static public boolean printSQLWarnings(SQLWarning warn)
            throws SQLException {
        boolean rc = false;

        if (warn != null) {
            System.out.println("\n *** Warning ***\n");
            rc = true;
            while (warn != null) {
                System.out.println("SQLState: " + warn.getSQLState());
                System.out.println("Message:  " + warn.getMessage());
                System.out.println("Vendor:   " + warn.getErrorCode());
                System.out.println("");
                warn = warn.getNextWarning();
            }
        }
        return rc;
    }


    static public boolean printSQLExceptions(SQLException ex) {
        boolean rc = false;

        if (ex != null) {
            System.out.println("\n*** SQLException caught ***\n");
            rc = true;
            while (ex != null) {
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("Message:  " + ex.getMessage());
                System.out.println("Vendor:   " + ex.getErrorCode());
                System.out.println("");
                ex = ex.getNextException();
            }
        }
        return rc;
    }

    static public boolean printSQLExceptions(String method, SQLException ex) {
        boolean rc = false;

        if (ex != null) {
            System.out.println("\n*** SQLException caught in " + method + " ***\n");
            rc = true;
            while (ex != null) {
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("Message:  " + ex.getMessage());
                System.out.println("Vendor:   " + ex.getErrorCode());
                System.out.println("");
                ex = ex.getNextException();
            }
        }
        return rc;
    }

    static public void printDriverInfo(Connection con) throws SQLException {
        // Get the DatabaseMetaData object and display
        // some information about the connection
        DatabaseMetaData dma = con.getMetaData();

        System.out.println("Database\t" + dma.getDatabaseProductVersion());
        System.out.println("Driver\t\t" + dma.getDriverVersion());
        System.out.println("URL\t\t" + dma.getURL() + ", user '" + dma.getUserName() + "'");
        System.out.println("-------------------------------------");
    }

}

