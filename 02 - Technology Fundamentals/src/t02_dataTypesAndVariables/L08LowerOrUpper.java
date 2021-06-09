    package t02_dataTypesAndVariables;

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;

    public class L08LowerOrUpper {

        public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader (
                    new InputStreamReader(
                            System.in
                    )
            );

            char c = reader.readLine().charAt(0);

            if( c >= 65 && c <= 90 ){
                System.out.println("upper-case");
            }else {
                System.out.println("lower-case");
            }
        }

    }
