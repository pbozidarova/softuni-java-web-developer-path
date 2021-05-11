package t08_associativeArrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.TreeMap;

public class E08CompanyUsers {
//    Write a program which keeps information about companies and their employees.
//    You will receive company name and employee's id, until you receive the command "End".
//    Add each employee to the given company. Keep in mind that a company cannot have two employees with
//    the same id.
//    When you finish reading data, order the companies by the name in ascending order.
//    Print the company name and each employee's id in the following format:
//    {companyName}
//-- {id1}
//-- {id2}
//-- {idN}

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
        Map<String, LinkedHashSet<String>> collection = new TreeMap<>();

        String input = "";

        while (!"End".equals(input = reader.readLine())){
            String[] data = input.split(" -> ");
            String companyName = data[0];
            String id = data[1];

            collection.putIfAbsent(companyName, new LinkedHashSet<>());
            collection.get(companyName).add(id);
        }


        for (Map.Entry<String, LinkedHashSet<String>> kvp : collection.entrySet()) {
            System.out.println(String.format("%s", kvp.getKey()));
            kvp.getValue().stream().forEach(e -> System.out.println(String.format("-- %s", e)));
        }

        //   collection.entrySet()
        //           .stream()
        //           .forEach(e -> {
        //               System.out.println(e.getKey());
        //               e.getValue().stream()
        //                       .distinct()
        //                       .forEach(d -> {
        //                   System.out.println("-- " + d);
        //               });
        //           });
    }
}
