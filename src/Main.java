import java.sql.*;

public class Main {

    static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    static final String USER = "postgres";
     static final String PASS = "n550490162";
    static final String QUERY = "SELECT id, login, fullname, email, age, gender FROM users";


    public static void main(String[] args) {
        try(Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
        Statement stmt = conn.createStatement();
        ) {
            System.out.println("***BEFORE***");
            ResultSet rs= stmt.executeQuery(QUERY);

                while(rs.next()){
                System.out.print("ID: " + rs.getInt(("id")));
                System.out.print(", Age: " + rs.getInt(("age")));
                System.out.print(", Login: " + rs.getString(("login")));
                System.out.print(", Fullname: " + rs.getString(("fullname")));
                System.out.print(", Email: " + rs.getString(("email")));
                System.out.println(", Gender: " + rs.getString(("gender")));
            }
            String sql = "DELETE FROM users WHERE id=5";
            stmt.executeUpdate(sql);

            System.out.println();
            System.out.println("***AFTER***");

            ResultSet rs1= stmt.executeQuery(QUERY);

            while(rs1.next()){
                System.out.print("ID: " + rs1.getInt(("id")));
                System.out.print(", Age: " + rs1.getInt(("age")));
                System.out.print(", Login: " + rs1.getString(("login")));
                System.out.print(", Fullname: " + rs1.getString(("fullname")));
                System.out.print(", Email: " + rs1.getString(("email")));
                System.out.println(", Gender: " + rs1.getString(("gender")));
            }

        }catch(SQLException e){
            e.printStackTrace();
        }

    }
    }
