package utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils 
{
    private static volatile Connection connection;

    private DBUtils() 
    {
        // Private constructor to prevent instantiation
    }

    public static Connection openConnection() throws SQLException 
    {
        // Double-checked locking pattern
        if (connection == null) 
        {
            synchronized (DBUtils.class)
            {
                if (connection == null) 
                {
                    String url = "jdbc:mysql://localhost:3306/dac22?useSSL=false&allowPublicKeyRetrieval=true";
                    connection = DriverManager.getConnection(url, "root", "root");
                }
            }
        }
        return connection;
    }
}
