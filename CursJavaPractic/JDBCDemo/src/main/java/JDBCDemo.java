
import java.sql.*;


public class JDBCDemo {


    public static void main(String[] args) {




        try(     Connection dbCon = DBConnection.getConnection("MySQL");
                 Statement getStatement = dbCon.createStatement();
                 ResultSet result = getStatement.executeQuery( "select * from students inner join address on students.address_id = address.id where address_id = 29")) {
            // Class.forName("com.mysql.cj.jdbc.Driver");
            // Driver driver = new com.mysql.cj.jdbc.Driver();
            // DriverManager.registerDriver(driver);


        /*   String insertAddressQuery = "insert into address(city,street) values ('Galati','Calugareni')";
            PreparedStatement insertAddressStatement = dbCon.prepareStatement(insertAddressQuery);
            int rows = insertAddressStatement.executeUpdate();
            if(rows>0){
                System.out.println("inserare adresa reusita !");
            }else{
                System.out.println("inserare adresa esuata !");
            }

            //insert folosind Statement
            String insertQuery = "insert into students(name,surname,year_of_birth,major,address_id) values ('Marian','Cozma',1987,'Info',29)";
            Statement insertStatement = dbCon.createStatement();
            int rows = insertStatement.executeUpdate(insertQuery);
            if (rows > 0) {
                System.out.println("inserare reusita cu Statement !");
            } else {
                System.out.println("inserare esuata !");
            }

            //insert folosind PreparedStatement
            String insertQuery2 = "insert into students(name,surname,year_of_birth,major,address_id) values (?,?,?,?,?)";
            PreparedStatement insertPrepStmt = dbCon.prepareStatement(insertQuery2);
            insertPrepStmt.setString(1, "Catalin");
            insertPrepStmt.setString(2, "Cozma");
            insertPrepStmt.setInt(3, 1989);
            insertPrepStmt.setString(4, "Info");
            insertPrepStmt.setInt(5, 29);
            rows = insertPrepStmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Insert reusit cu PreparedStatement");
            }
*/
            // parcurgem rezultatele pentru a le afisa
            // result set contine fiecare rand returnat de selectul nostru din baza de date



            String format = "%-5s%-10s%-10s%-10s%-10s%-10s\n";
            while (result.next()) {
                String id = result.getString("id");
                String name = result.getString("name");
                String firstName = result.getString("surname");
                String yearOfBirth = result.getString("year_of_birth");
                String major = result.getString("major");
                String city = result.getString("address.city");
                String street = result.getString("address.street");
                String address = city + " ," + street;
                System.out.format(format,id,name,firstName,yearOfBirth,major,address);
              //  System.out.println("Studentul cu optional info este: " + name + " " + firstName + " " + yearOfBirth + " major = " + major + " " + address);
            }

         /*   String deleteQuery="delete from address";
            PreparedStatement deleteAddress = dbCon.prepareStatement(deleteQuery);
            int rows = deleteAddress.executeUpdate();
            if(rows>0){
                System.out.println("stergere reusita");
            }
         */


        } catch (SQLException e) {
            e.printStackTrace();
        }/* finally {
            assert result != null;
            result.close();
            getStatement.close();
            dbCon.close();
        }*/
    }



}
