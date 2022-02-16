import java.sql.*;

public class JDBCDriverManager {





        public static void main(String[] args) {
            System.out.println("SDA Galati 3 JDBC Course");

            // clasa care ne deschide o conexiune cu baza de date este Connection;
            Connection databaseConnection;

            //Clasa care ne ajuta sa folosim query-uri sql pentru a interaction cu baza de date este PreparedStatement
            PreparedStatement statement;

            //pentru a initializa o conexiune cu baza de date avem nevoie sa:
            //      - deschidem conexiunea folosindu ne de clasa DriverManager

            try {
                databaseConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school?serverTimezone=UTC"
                        , "root", "123456");
                // parametru url al metodei getConnection contine:
                //      - jdbc - tipul de driver folosit (alte tipuri intalnite : odbc)
                //      - mysql - tipul bazei de date folosite (alte tipuri: oracle, postgres,mariadb,microsoft)
                //      - adresa bazei de date - <domain>:<port> localhost:3306
                //      - numele bazei de date
                //      - timeZone server
                //      <driver>:<tip_baza_date>://<domain>:<port>/<nume_baza_date>


                //CRUD (Create, Replace, Update , Delete)

                // Insert
                // query urile sql sunt folosite si in java
               /* String insertQuery = "insert into students(id,name,first_name,year_of_birth,electives) values(35,'Ionescu','Catalin',1989,'muzica')";

                //clasa care ne ajuta sa transformam query-ul dintr un string in query jdbc este PreparedStatement

                PreparedStatement insertStatement = databaseConnection.prepareStatement(insertQuery);

                //pentru a rula un query care modifica date din baza de date (DML) folosim metoda executeUpdate()

                int rowsInserted = insertStatement.executeUpdate();
                if (rowsInserted == 1) {
                    System.out.println("Randul a fost insert cu success");
                } else {
                    System.out.println("Randul nu a fost inserat cu success");
                }


                //Delete
                String deleteQuery = "delete from students where first_name = 'Ionut'";
                PreparedStatement deleteStatement = databaseConnection.prepareStatement(deleteQuery);
                int rowDeleted = deleteStatement.executeUpdate();
                if (rowDeleted != 0) {
                    System.out.println("intrarea a fost stearsa");
                } else {
                    System.out.println("Intrarea nu a fost stears");
                }

                //Update
                //daca studentul este nascut dupa 1987 ,schimbam optionalul in sport

                String updateQuery = "UPDATE students SET electives ='Sport' where year_of_birth > 1987";
                PreparedStatement updateStatement = databaseConnection.prepareStatement(updateQuery);
                int rowsUpdated = updateStatement.executeUpdate();
                if(rowsUpdated!=0){
                    System.out.println("intrarea a fost actualizata");
                }else{
                    System.out.println("Nicio intrare nu a fost actualizata");
                }

                // Citim din baza de date (Select)
                // studentii care au optionalul sport
                String selectQuery = "select * from students where electives = 'sport'";
                PreparedStatement selectStatement = databaseConnection.prepareStatement(selectQuery);

                // parametrizam query ul nostru
                String selectQueryWithParams = "select * from students where electives = ?";
                PreparedStatement selectStatementParams = databaseConnection.prepareStatement(selectQueryWithParams);
                selectStatementParams.setString(1,"desen");
                ResultSet resultDesen =  selectStatementParams.executeQuery();
                while(resultDesen.next()){
                    String name = resultDesen.getString("name");
                    System.out.println("Studentul de la desen este: " + name);
                }
                selectStatementParams.setString(1,"sport");
                ResultSet resultSport = selectStatementParams.executeQuery();
                while(resultSport.next()){
                    String name=resultSport.getString("name");
                    System.out.println("Studentul de la sport este: " +  name);
                }

                // studentii nascuti dupa un anumit an si de la o un anumit optional
                String selectQueryYearandElective = "select * from students where year_of_birth > ? and electives = ?";
                PreparedStatement selectYearandElectiveStatement = databaseConnection.prepareStatement(selectQueryYearandElective);
                selectYearandElectiveStatement.setString(1,"1986");
                selectYearandElectiveStatement.setString(2,"desen");

                ResultSet resultYearandElective=selectYearandElectiveStatement.executeQuery();
                while (resultYearandElective.next()){
                    String name = resultYearandElective.getString("name");
                    System.out.println("Studentul nascut dupa 86 si de la desen este : " + name);
                }


                //pentru query urile de select (cele care nu modifica structura sau datele din tabele) folosim metoda executeQuery
*/
             //  String deleteQuery = "delete from students";
             //  PreparedStatement deleteStatement = databaseConnection.prepareStatement(deleteQuery);
             //  deleteStatement.executeUpdate();



                String insertQuery = "insert into students(name,surname,year_of_birth,major,address_id) values('Catalin','Cozma',1989,'Info',29),('Marian','Cozma',1987,'Info',29)";
                Statement insertStatement = databaseConnection.createStatement();
                insertStatement.executeUpdate(insertQuery);


                String selectQuery = "select * from students where major = 'Info'";
                PreparedStatement selectStatement = databaseConnection.prepareStatement(selectQuery);
                ResultSet result = selectStatement.executeQuery();

                // parcurgem rezultatele pentru a le afisa
                // result set contine fiecare rand returnat de selectul nostru din baza de date

                while(result.next()){
                    String name = result.getString("name");
                    String firstName = result.getString("surname");
                    String yearOfBirth = result.getString("year_of_birth");

                    System.out.println("Studentul cu optional info este: " + name + " " + firstName + " "  + yearOfBirth);
                }


                //


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


