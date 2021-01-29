import java.sql.SQLException;

public class Main  {
    public static void main(String[] args) throws SQLException {
        System.out.println("ok");

        Homework homework = new Homework();
        homework.setConnection("root", "1234");

        homework.getVillainsNamesEx2();
    }
}
