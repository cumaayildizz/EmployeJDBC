import java.sql.*;

public class Main {
    public static final String DB_URL = "jdbc:mysql://localhost/employe";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "mysql";


    public static void main(String[] args) {

        String sql = "SELECT * FROM employees";

        try {
            Connection connection = DriverManager.getConnection(DB_URL , DB_USER , DB_PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet data = statement.executeQuery(sql);

            while (data.next()){
                System.out.println("Employe " + data.getInt("id"));
                System.out.println("=========================================");
                System.out.println("ID       : " + data.getInt("id"));
                System.out.println("Name     : " + data.getString("name"));
                System.out.println("Position : " + data.getString("position"));
                System.out.println("Salary   : " + data.getInt("salary"));
                System.out.println("=========================================");
                System.out.println("");

            }

            connection.close();
            statement.close();
            data.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}