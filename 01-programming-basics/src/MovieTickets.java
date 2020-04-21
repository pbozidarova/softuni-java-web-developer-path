import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MovieTickets {
    public static void main(String[] args) throws IOException {
//        7. Билети за кино
//        Вашата задача е да напишете програма, която да изчислява процента на билетите за всеки тип от
//        продадените билети: студентски(student), стандартен(standard) и детски(kid), за всички прожекции. Трябва
//        да изчислите и колко процента от залата е запълнена за всяка една прожекция.
//                Вход
//        Входът е поредица от цели числа и текст:
// На първия ред до получаване на командата Finish - име на филма – текст
// На втори ред – свободните места в салона за всяка прожекция – цяло число [1 … 100]
// За всеки филм, се чете по един ред до изчерпване на свободните места в залата или до получаване на командата End:
//        o Типа на закупения билет - текст (student, standard, kid)
//        Изход
//        На конзолата трябва да се печатат следните редове:
// След всеки филм да се отпечата, колко процента от кино залата е пълна {името на филма} - {процент запълненост на залата}% full.;
// При получаване на командата &quot;Finish&quot; да се отпечатат четири реда:
//        o Total tickets: {общият брой закупени билети за всички филми};
//        o {процент на студентските билети}% student tickets.;
//        o {процент на стандартните билети}% standard tickets.;
//        o {процент на детските билети}% kids tickets.;
//
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Integer studentTickets = 0;
        Integer standardTickets = 0;
        Integer kidsTickets = 0;
        StringBuilder output = new StringBuilder();

        String movieTitle = reader.readLine();
        while (!movieTitle.equals("Finish")) {
            Integer freePlaces = Integer.parseInt(reader.readLine());
            Integer occupiedPlaces = 0;

            String ticket = reader.readLine();
            while (!ticket.equals("End")) {
                occupiedPlaces++;
                switch (ticket) {
                    case "student":
                        studentTickets++;
                        break;
                    case "standard":
                        standardTickets++;
                        break;
                    case "kid":
                        kidsTickets++;
                        break;
                    default:
                        break;
                }
                if (occupiedPlaces >= freePlaces) break;
                ticket = reader.readLine();
            }
            output.append(String.format("%s - %.2f%% full.", movieTitle, occupiedPlaces * 100.0 / freePlaces));
            output.append(System.lineSeparator());

            movieTitle = reader.readLine();
        }
        output.append(String.format(
                "Total tickets: %d\n" +
                        "%.2f%% student tickets.\n" +
                        "%.2f%% standard tickets.\n" +
                        "%.2f%% kids tickets.",
                studentTickets + standardTickets + kidsTickets,
                studentTickets * 100.0 / (studentTickets + standardTickets + kidsTickets),
                standardTickets * 100.0 / (studentTickets + standardTickets + kidsTickets),
                kidsTickets * 100.0 / (studentTickets + standardTickets + kidsTickets)));

        System.out.println(output);
    }
}
