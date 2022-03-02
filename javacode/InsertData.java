package net.sqlitemovie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertData {

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

    public void insert(String name, String ac, String actress, String dir, int yor ) {
        String sql = "INSERT INTO Movies(moviename,actor,actress,director,year_of_release) VALUES(?,?,?,?,?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, ac);
            pstmt.setString(3, actress);
            pstmt.setString(4, dir);
            pstmt.setInt(5, yor);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public static void main(String[] args) {

        InsertData app = new InsertData();
        // insert three new rows
        app.insert("Doctor", "SivaKarthikeyan", "Priyanka Mohan","Nelson Dilipkumar", 2021);
        app.insert("Soorarai pottru", "Surya", "Aparna Balamurali", "Sudha Kongara", 2020);
        app.insert("Viswasam","Ajith", "Nayanthara","Siva" , 2019);
        app.insert("Theri","Vijay", "Samantha", "Atlee" ,2016);
    }

}