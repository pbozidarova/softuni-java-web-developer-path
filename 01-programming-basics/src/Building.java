import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Building {
    public static void main(String[] args) throws IOException {
//        6. Сграда
//        Напишете програма, която извежда на конзолата номерата на стаите в една сграда (в низходящ ред), като са
//        изпълнени следните условия:
// На всеки четен етаж има само офиси
// На всеки нечетен етаж има само апартаменти
// Всеки апартамент се означава по следния начин : А{номер на етажа}{номер на апартамента},
//        номерата на апартаментите започват от 0.
// Всеки офис се означава по следния начин : О{номер на етажа}{номер на офиса}, номерата на
//        офисите също започват от 0.
// На последният етаж винаги има апартаменти и те са по-големи от останалите, за това пред номера
//        им пише L;, вместо A;. Ако има само един етаж, то има само големи апартаменти!
//                От конзолата се прочитат две цели числа - броят на етажите и броят на стаите за един етаж.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Integer floors = Integer.parseInt(reader.readLine());
        Integer rooms = Integer.parseInt(reader.readLine());
        StringBuilder buildingOutput = new StringBuilder();

        for (int i = floors; i >= 1; i--) {
            for (int j = 0; j < rooms; j++) {
                if (i == floors) {
                    buildingOutput.append("L");
                } else {
                    if (i % 2 == 0) {
                        buildingOutput.append("O");
                    } else {
                        buildingOutput.append("A");
                    }
                }
                buildingOutput.append(i).append(j + " ");
            }
            buildingOutput.append(System.lineSeparator());
        }
        System.out.print(buildingOutput);
    }
}
