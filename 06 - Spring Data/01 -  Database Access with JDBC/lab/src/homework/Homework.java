package homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Properties;


public class Homework {

    private static final String CONNECTION_STRING =
            "jdbc:mysql://localhost:3306/";

    private static final String MINIONS_TABLE_NAME = "minions_db";

    private Connection connection;

    private BufferedReader reader;

    public Homework() {
        this.reader = new BufferedReader( new InputStreamReader( System.in ));
    }

    public void setConnection(String user, String password) throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", user);
        properties.setProperty("password", password);

        connection = DriverManager
                .getConnection(CONNECTION_STRING + MINIONS_TABLE_NAME, properties);

    }

    public void getVillainsNamesEx2() throws SQLException {
        String query = "SELECT v.name, COUNT(mv.minion_id) AS 'count' FROM villains as v " +
                "JOIN minions_villains mv on v.id = mv.villain_id " +
                "GROUP BY v.id " +
                "HAVING `count` > 15 " +
                "ORDER BY `count` DESC;";

        PreparedStatement statement = connection.prepareStatement(query);

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()){
            System.out.printf("%s %d%n", resultSet.getString("name"),
                                         resultSet.getInt(2));
        }
    }

    public void getMinionNamesEx3() throws IOException, SQLException {

        System.out.println("Enter Villain ID: ");
        int villainId = Integer.parseInt(reader.readLine());

        String villainName = getEntityNameById(villainId, "villains");

        if(villainName == null){
            System.out.printf("No villain with %d exists in the database.", villainId);
            return;
        }

        System.out.printf("Villain: %s%n", villainName);

        String query = "SELECT m.name, m.age FROM minions as m " +
                "JOIN minions_villains mv on m.id = mv.minion_id " +
                "WHERE mv.villain_id = ?";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, villainId);

        ResultSet resultSet = statement.executeQuery();

        int counter = 0;
        while (resultSet.next()) {
            System.out.printf("%d. %s %d%n",
                    ++counter, resultSet.getString("name"), resultSet.getInt("age"));
        }
    }

    private String getEntityNameById(int entityId, String tableName) throws SQLException {
        String query = String.format("SELECT name FROM %s WHERE id = ?", tableName);

        PreparedStatement statement = connection.prepareStatement(query);

        statement.setInt(1, entityId);

        ResultSet resultSet = statement.executeQuery();

        return resultSet.next() ? resultSet.getString("name") : null;
    }

    public void addMinionEx4() throws IOException, SQLException {
        System.out.printf("Enter minions info: name, age, town name: ");
        String[] minionInfo = reader.readLine().split(": ")[1].split("\\s+");
        System.out.printf("Enter villain name: ");
        String villainName = reader.readLine().split(": ")[1];

        String minionName = minionInfo[0];
        Integer age = Integer.parseInt(minionInfo[1]);
        String townName = minionInfo[2];

        int townId = getEntityIdByName(townName, "towns" );
        if(townId < 0){
            insertEntityInTowns(townName);
            townId = getEntityIdByName(townName, "towns" );
            System.out.printf("Town %s was added to the database.%n", townName);
        }

        int villainId = getEntityIdByName(villainName, "villains");
        if(villainId < 0){
            insertEntityInVillains(villainName);
            villainId = getEntityIdByName(villainName, "villains");
            System.out.printf("Villain %s was added to the database.%n", villainName);
        }

        int minionId = getEntityIdByName(minionName, "minions");
        if(minionId < 0){
            insertEntityInMinions(minionName, age, townId);
            minionId = getEntityIdByName(minionName, "minions");
            System.out.printf("Minion %s has been added in the database!%n", minionName);
        }
        connectMinionAndVillain(minionId, villainId);
        System.out.printf("Successfully added %s to be minion of %s.%n", minionName, villainName);

    }

    private Boolean connectMinionAndVillain(int minionId, int villainId) throws SQLException {
        String query = "INSERT INTO minions_villains VALUES(?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setInt(1, minionId);
        statement.setInt(2, villainId);
        return statement.execute();
    }

    private void insertEntityInMinions(String minionName, Integer age, int townId) throws SQLException {
        String query = "INSERT INTO minions(name, age, town_id) values(?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setString(1, minionName);
        statement.setInt(2, age);
        statement.setInt(3, townId);
        statement.execute();
    }

    private void insertEntityInVillains(String villainName) throws SQLException {
        String query = "INSERT INTO villains(name, evilness_factor) values(?, 'evil')";
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setString(1, villainName);
        statement.execute();
    }

    private void insertEntityInTowns(String townName) throws SQLException {
        String query = "INSERT INTO towns(name) value(?)";
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setString(1, townName);
        statement.execute();
    }



    private int getEntityIdByName(String entityName, String tableName) throws SQLException {
        String query = String.format("SELECT id FROM %s WHERE name = ?", tableName);

        PreparedStatement statement = connection.prepareStatement(query);

        statement.setString(1, entityName);
        ResultSet resultSet = statement.executeQuery();

        return resultSet.next() ? resultSet.getInt(1) : -1;


    }

    public void changeTownNameCasingEx5() throws IOException, SQLException {
        System.out.println("Enter country name: ");
        String countryName = reader.readLine();

        String query = "UPDATE towns SET name = UPPER(name) WHERE country = ?";
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setString(1, countryName);

        int countTownsAffected = statement.executeUpdate();
        if(countTownsAffected == 0){
            System.out.println("No town names were affected.");
            return;
        }

        System.out.printf("%d town names were affected.",  countTownsAffected);

        String selectTownsQuery = "SELECT name FROM towns WHERE country = ?";
        PreparedStatement selectTownsStatement = connection.prepareStatement(selectTownsQuery);
        selectTownsStatement.setString(1, countryName);

        ResultSet townsAffected = selectTownsStatement.executeQuery();
        String townsCombined = "[";
        while (townsAffected.next()) {
            townsCombined += townsAffected.getString("name") + ", ";
        }
        townsCombined = townsCombined.substring(0, townsCombined.length() -2) + "]";
        System.out.println(townsCombined);
//                "[SOFIA, PLOVDIV, BURGAS]\n");
    }

    public void increaseAgeWithStoredProcedureEx9() throws IOException, SQLException {
        System.out.println("Enter minion id: ");
        int minionId = Integer.parseInt(reader.readLine());

        String query = "CALL usp_get_older(?)";

        CallableStatement callableStatement = connection.prepareCall(query);
        callableStatement.setInt(1, minionId);
        callableStatement.execute();
    }

    public void printAllMinionNamesEx7() throws SQLException {
        String query = "SELECT name FROM minions";
        String queryReversed = "SELECT name FROM minions ORDER BY id DESC";

        PreparedStatement statement = connection.prepareStatement(query);
        PreparedStatement statementReversed = connection.prepareStatement(queryReversed);

        ResultSet resultSet = statement.executeQuery();
        ResultSet resultSetReversed = statementReversed.executeQuery();

        while (resultSet.next() && resultSetReversed.next()){
            System.out.println(resultSet.getString("name"));
            System.out.println(resultSetReversed.getString("name"));
        }
    }

    public void increaseMinionsAgeEx8() throws IOException, SQLException {
        System.out.println("Please, enter minion Ids: ");
        String[] minionIDs = reader.readLine().split("\\s+");

        for (int i = 0; i < minionIDs.length; i++) {
            String query = "UPDATE minions SET age = age + 1, name = LOWER(name) WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, Integer.parseInt(minionIDs[i]));

            statement.execute();
        }

        String querySelect = "SELECT name, age FROM minions";
        PreparedStatement statementSelect = connection.prepareStatement(querySelect);

        ResultSet resultSet = statementSelect.executeQuery();
        while (resultSet.next()){
            System.out.printf("%s %d%n", resultSet.getString("name"), resultSet.getInt("age") );
        }
    }

    public void removeVillainEx6() throws IOException, SQLException {
        System.out.println("Please enter villain id: ");
        int villainId = Integer.parseInt(reader.readLine());

        String villainName = getEntityNameById(villainId, "villains");
        if(villainName == null) {
            System.out.println("No such villain was found");
            return;
        }

        String delMappingQuery = "DELETE FROM minions_villains WHERE villain_id = ?";
        PreparedStatement delStatement = connection.prepareStatement(delMappingQuery);
        delStatement.setInt(1, villainId);
        int releasedMinions = delStatement.executeUpdate();

        String delVillainQuery = "DELETE FROM villains WHERE id = ?";
        PreparedStatement delVillainStatement = connection.prepareStatement(delVillainQuery);
        delVillainStatement.setInt(1, villainId);
        int delVillain = delVillainStatement.executeUpdate();

        System.out.printf("%s was deleted%n" +
                            "%d minions released%n", villainName, releasedMinions);
    }
}
