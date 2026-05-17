import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcStatementDemo {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "password");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT name FROM students");
            
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}