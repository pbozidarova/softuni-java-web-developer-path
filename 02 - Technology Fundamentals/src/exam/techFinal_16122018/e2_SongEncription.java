package techFinal_16122018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class e2_SongEncription {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));

        String regex = "^([A-Z][a-z\\s']+):([A-Z\\s]+)$";
        Pattern pattern = Pattern.compile(regex);

        String artistAndSong = "";
        String artistAndSongEncripted = "";

        while (!"End".equals(artistAndSong = reader.readLine())){
            Matcher matcher = pattern.matcher(artistAndSong);
            if(matcher.find()){
                int key = artistAndSong.split(":")[0].length();

                for (int i = 0; i < artistAndSong.length(); i++) {
                    if( artistAndSong.charAt(i) == ':') {
                        artistAndSongEncripted += '@';
                    } else if(artistAndSong.charAt(i) == ' ' || artistAndSong.charAt(i) == '\''){
                        artistAndSongEncripted += String.valueOf(Character.toChars(artistAndSong.charAt(i)));
                    }else {
                        int encriptValue = artistAndSong.charAt(i) + key;
                        if(artistAndSong.charAt(i) <= 90 && encriptValue > 90 ){
                            encriptValue = 65 + encriptValue - 90 -1;
                        } else if( artistAndSong.charAt(i) <= 122 && encriptValue > 122 ) {
                            encriptValue = 97 + encriptValue - 122-1;
                        }
                        artistAndSongEncripted += String.valueOf(Character.toChars(encriptValue));
                    }
                }
                System.out.println("Successful encryption: " + artistAndSongEncripted);
                artistAndSongEncripted ="";
            }else{
                System.out.println("Invalid input!");
            }
        }
    }
}
