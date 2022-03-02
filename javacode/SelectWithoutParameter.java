package net.sqlitemovie;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectWithoutParameter {

    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:/Users/monis/Desktop/sqlite/db/test.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    
    /**
     * select all rows in the warehouses table
     */
    public void selectAll(){
        String sql = "SELECT moviename,actor,actress,director,year_of_release FROM Movies";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getString("moviename") +  "\t" + 
                                   rs.getString("actor") + "\t" +
 		           rs.getString("actress") + "\t" +
		           rs.getString("director") + "\t" +
                                   rs.getInt("year_of_release"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        SelectWithoutParameter app = new SelectWithoutParameter();
        app.selectAll();
    }

}