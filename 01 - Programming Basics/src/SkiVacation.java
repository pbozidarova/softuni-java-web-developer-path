import java.util.Scanner;

public class SkiVacation {
    public static void main(String[] args) {
//        Атанас решава да прекара отпуската си в Банско и да кара ски. Преди да отиде обаче,
//        трябва да резервира хотел и да изчисли колко ще му струва престоя.
//        Съществуват следните видове помещения, със следните цени за престой:
//	"room for one person" – 18.00 лв. за нощувка
//	"apartment" – 25.00 лв. за нощувка
//	"president apartment" – 35.00 лв. за нощувка
//        Според броят на дните, в които ще остане в хотела (пример: 11 дни = 10 нощувки) и
//        видът на помещението, което ще избере, той може да ползва различно намаление. Намаленията са както следва:
//        След престоя, оценката на Атанас за услугите на хотела може да е позитивна (positive) или негативна (negative) . Ако оценката му е позитивна, към цената с вече приспаднатото намаление Атанас добавя 25% от нея. Ако оценката му е негативна приспада от цената 10%.
//        Вход
//        Входът се чете от конзолата и се състои от три реда:
//•	Първи ред - дни за престой - цяло число в интервала [0...365]
//•	Втори ред - вид помещение - "room  for  one  person", "apartment" или "president  apartment"
//•	Трети ред - оценка - "positive"  или "negative"
//        Изход
//        На конзолата трябва да се отпечата един ред:
//•	Цената за престоят му в хотела, форматирана до втория знак след десетичната запетая.

        Scanner scanner = new Scanner(System.in);
        int daysSpent = Integer.parseInt(scanner.nextLine());
        String residence = scanner.nextLine();
        String evaluation = scanner.nextLine();

        Double pricePerNight = 0.0;
        Double discount = 0.0;

        switch (residence){
            case "room for one person":
                pricePerNight = 18.0;
                discount = discountBasedOnDaysSpent(residence, daysSpent);
                break;
            case "apartment":
                pricePerNight = 25.0;
                discount = discountBasedOnDaysSpent(residence, daysSpent);
                break;
            case "president apartment":
                pricePerNight = 35.0;
                discount = discountBasedOnDaysSpent(residence, daysSpent);
                break;
            default:
                break;
        }

        Double priceToPay = (daysSpent-1)*pricePerNight - (daysSpent-1)*pricePerNight*discount;
        if(evaluation.equals("positive")){
            priceToPay += priceToPay*0.25;
        }else {
            priceToPay -= priceToPay*0.11;
        }

        System.out.printf("%.2f", priceToPay);

    }

    private static Double discountBasedOnDaysSpent(String residence, int daysSpent) {
        if(daysSpent < 10){
            if(residence.equals("room for one person")){
                return 0.0;
            }else if(residence.equals("apartment")) {
                return 0.3;
            }else{
                return 0.1;
            }
        }else if(daysSpent >= 10 && daysSpent <= 15){
            if(residence.equals("room for one person")){
                return 0.0;
            }else if(residence.equals("apartment")) {
                return 0.35;
            }else{
                return 0.15;
            }
        }else {
            if(residence.equals("room for one person")){
                return 0.0;
            }else if(residence.equals("apartment")) {
                return 0.5;
            }else{
                return 0.2;
            }
        }
    }
}
