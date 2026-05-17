import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JdbcPreparedStatementDemo {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "password");
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO students (id, name) VALUES (?, ?)");
            
            pstmt.setInt(1, 101);
            pstmt.setString(2, "Alice");
            
            int rows = pstmt.executeUpdate();
            System.out.println(rows + " row(s) inserted");
            
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}