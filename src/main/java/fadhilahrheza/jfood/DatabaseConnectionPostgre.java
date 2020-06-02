package fadhilahrheza.jfood;

import java.nio.channels.ScatteringByteChannel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Here is the class DatabaseConnectionPostgre.
 * This is how to connect to postgreSQL.
 *
 * @author Fadhilah Rheza P
 * @version 1.0
 */
public class DatabaseConnectionPostgre
{
    public static Connection connection()
    {
        Connection c = null;

        try
        {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/jfood";
            String user = "postgres";
            String password = "";
            c = DriverManager.getConnection(url, user, password);
            System.out.println("Opened database successfully");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println(e.getClass().getName() + " " + e.getMessage());
            System.exit(0);
        }
        return c;
    }
}