import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Volleyball {
    public static void main(String[] args) throws IOException {
//        Влади е студент, живее в София и си ходи от време на време до родния град.
//        Той е много запален по волейбола, но е зает през работните дни и играе волейбол само през уикендите и в празничните дни.
//        Влади играе в София всяка събота, когато не е на работа и не си пътува до родния град, както и в 2/3 от празничните дни.
//        Той пътува до родния си град h пъти в годината, където играе волейбол със старите си приятели в неделя.
//        Влади не е на работа 3/4 от уикендите, в които е в София.
//        Отделно, през високосните години Влади играе с 15% повече волейбол от нормалното.
//        Приемаме, че годината има точно 48 уикенда, подходящи за волейбол.
//        Напишете програма, която изчислява колко пъти Влади е играл волейбол през годината.
//        Закръглете резултата надолу до най-близкото цяло число (например 2.15  2; 9.95  9).
//        Входните данни се въвеждат от потребителя, в следния вид:
//•	Първият ред съдържа думата "leap" (високосна година) или "normal" (невисокосна).
//•	Вторият ред съдържа цялото число p – брой празници в годината (които не са събота и неделя).
//•	Третият ред съдържа цялото число h – брой уикенди, в които Влади си пътува до родния град.
        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
        String year = reader.readLine();
        Integer p = Integer.valueOf(reader.readLine());
        Integer h = Integer.valueOf(reader.readLine());
        Integer weekends = 48;
        Double totalGamesPlayed = 0.0;

        Double gamesInSofiaSaturdays = (weekends - h) * 3.0 / 4;
        Double gamesOnHolidaysInSofia = p * 2.0 / 3;
        Double gamesInHometown = h * 1.0;

        totalGamesPlayed = gamesInSofiaSaturdays + gamesOnHolidaysInSofia + gamesInHometown;

        if(year.equals("leap")){
            totalGamesPlayed += totalGamesPlayed*0.15;
        }
        System.out.print(Math.floor(totalGamesPlayed));
    }
}
