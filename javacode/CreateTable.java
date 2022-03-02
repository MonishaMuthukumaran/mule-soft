package net.sqlitemovie;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

    public static void createNewTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:/Users/monis/Desktop/sqlite/db/test.db";
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS Movies (\n"
                + "	moviename text NOT NULL,\n"
                + "	actor text NOT NULL,\n"
                + "	actress text NOT NULL,\n"
                + "	director text NOT NULL,\n"
                + "	year_of_release int NOT NULL\n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
	System.out.println("A table has been created.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        createNewTable();
    }

}