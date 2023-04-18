import java.sql.*;


public class Main {
    static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    static final String USER = "postgres";
     static final String PASS = "n550490162";
    static final String QUERY = "SELECT id,login, fullname, email, age, gender from users order by id";



    public static void main(String[] args) {
        try(Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
        Statement stmt = conn.createStatement();
        ) {
            ResultSet rs= stmt.executeQuery(QUERY);
                while(rs.next()){
                    System.out.print("ID:" + rs.getString("id") + " Login: " + rs.getString("login") +
                            " Name: " + rs.getString("fullname") + " Email: " + rs.getString("email") +
                            "Age: " + rs.getInt("age"));
                    if (rs.getString("gender").equals("F")){
                        System.out.println(" Gender: " + Gender.FEMALE);
                    }else
                        System.out.println(" Gender: " + Gender.MALE);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}

