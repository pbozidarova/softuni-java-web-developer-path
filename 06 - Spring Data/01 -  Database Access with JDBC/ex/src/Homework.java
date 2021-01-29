import java.sql.*;
import java.util.Properties;
import java.util.Set;

public class Homework {

    private static final String CONNECTION_STRING =
            "jdbc:mysql://localhost:3306/";

    private static final String MINIONS_TABLE_NAME = "minions_db";

    private Connection connection;

    public void setConnection(String user, String password) throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", user);
        properties.setProperty("password", password);


        connection = DriverManager
                .getConnection(CONNECTION_STRING + MINIONS_TABLE_NAME, properties);



    }

    public void getVillainsNamesEx2() throws SQLException {
        String query = "Select name FROM minions";

        PreparedStatement statement = connection.prepareStatement(query);

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()){
            System.out.printf("%s%n", resultSet.getString("name"));
        }
    }
}
