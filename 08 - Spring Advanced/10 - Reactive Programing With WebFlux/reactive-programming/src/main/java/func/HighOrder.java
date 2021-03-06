package func;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HighOrder {

    public void example(){
        List<String> students = new ArrayList<>();

        students.add("student1");
        students.add("student2");
        students.add("student3");

        students.sort((a, b) -> a.compareTo(b));
        Comparator<String> comp = (a, b) -> a.compareTo(b);

        comp.reversed();
    }

}
