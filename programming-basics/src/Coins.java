import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Coins {
    public static void main(String[] args) throws IOException {
//        5. Монети
//        Производителите на вендинг машини искали да направят машините си да връщат възможно най-малко
//        монети ресто. Напишете програма, която приема сума - рестото, което трябва да се върне и изчислява с
//        колко най-малко монети може да стане това.

        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
        double change = Double.parseDouble(reader.readLine());

        Integer numberOfCoins = 0;

        while (change > 0){
            numberOfCoins++;
            if (change >= 2.0 ) { change -= 2.0;
            } else if (change >= 1.0) { change -= 1.0;
            } else if (change >= 0.5) { change -= 0.5;
            } else if (change >= 0.2) { change -= 0.2;
            } else if (change >= 0.1) { change -= 0.1;
            } else if (change >= 0.05) { change -= 0.05;
            } else if (change >= 0.02) { change -= 0.02;
            } else if (change >= 0.01) { change -= 0.01;
            }else{ break;
            }
        }
        System.out.print(numberOfCoins);
    }
}
