package t06_objectsAndClasses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class E01AdvertisementMessage {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        Message randomMessage = new Message();
        for (int i = 0; i < n; i++) {
            System.out.println(randomMessage.randomMessage());
        }

    }

}

class Message {
   private String[] phrases =  {"Excellent product.", "Such a great product.", "I always use that product.", "Best product of its category.", "Exceptional product.", "I can’t live without this product."};
   private String[] events  = {"Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!"};
   private String[] authors =  {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
   private String[] cities  = {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};

   private Random random = new Random();

   public String randomMessage(){
       return String.format("%s %s %s - %s",
               this.phrases[random.nextInt(this.phrases.length)],
               this.events[random.nextInt(this.events.length)],
               this.authors[random.nextInt(this.authors.length)],
               this.cities[random.nextInt(this.cities.length)]);
   }

}