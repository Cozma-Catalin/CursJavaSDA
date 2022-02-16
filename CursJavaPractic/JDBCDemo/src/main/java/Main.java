import java.sql.*;

public class Main {



    public static void main(String[] args) throws SQLException {

         final String DATABASE_HOST =
                "jdbc:mysql://localhost:3306/school?serverTimezone=UTC";
         final String DATABASE_USERNAME = "root";
         final String DATABASE_PASSWORD = "123456";
        Connection conn = DriverManager.getConnection(
               DATABASE_HOST,DATABASE_USERNAME,DATABASE_PASSWORD);


        String selectQuery = "select * from students where major = 'Info'";
        PreparedStatement selectStatement = conn.prepareStatement(selectQuery);
        ResultSet result = selectStatement.executeQuery();

        // parcurgem rezultatele pentru a le afisa
        // result set contine fiecare rand returnat de selectul nostru din baza de date

        while(result.next()){
            String name = result.getString("name");
            String firstName = result.getString("surname");
            String yearOfBirth = result.getString("year_of_birth");

            System.out.println("Studentul cu optional info este: " + name + " " + firstName + " "  + yearOfBirth);
        }
    }
}
