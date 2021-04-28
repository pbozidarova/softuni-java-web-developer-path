package t05_lists_arrays_advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class E04ListOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        System.in
                ));

        List<String> elements = Arrays.stream(reader.readLine().split("\\s+"))
                .collect(Collectors.toList());

        String input = "";
        while(!"End".equals(input = reader.readLine())){
            String[] data = input.split("\\s+");
            String command = data[0];

            switch (command){
                case "Add":
                    elements.add(data[1]);
                    break;
                case "Insert":
                    String number = data[1];
                    int position = Integer.parseInt(data[2]);
                    if(position >=0 && position <= elements.size()) {
                        elements.add(position, number);
                    }else{
                        System.out.println("Invalid index");
                    }
                    break;
                case "Remove":
                    int indextToRemove = Integer.parseInt(data[1]);
                    if(indextToRemove >=0 && indextToRemove <= elements.size()) {
                        elements.remove(indextToRemove);
                    }else{
                        System.out.println("Invalid index");
                    }

                    break;
                case "Shift":
                    int count = Integer.parseInt(data[2]);
                    if (elements.size() > 0) {
                        if (data[1].equals("left")) {
                            for (int i = 0; i < count % elements.size() ; i++) {
                                elements.add(elements.get(0));
                                elements.remove(0);
                            }
                        } else {
                            for (int i = 0; i < count % elements.size() ; i++) {
                                elements.add(0, elements.get(elements.size()-1));
                                elements.remove(elements.size()-1);
                            }
                        }
                        break;

                    }


            }
        }
        System.out.println(elements.toString().replaceAll("[\\[,\\]]",""));
    }
}
