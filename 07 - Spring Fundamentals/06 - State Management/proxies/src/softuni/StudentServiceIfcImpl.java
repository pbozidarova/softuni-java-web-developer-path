package softuni;

import java.util.List;

public class StudentServiceIfcImpl implements StudentServiceIfc {

    @Override
    @Cachable("students")
    public List<Student> getAllStudents() {
        System.out.println("DOING SOME HARD WORK TO RETRIEVE THE STUDENTS!");

        Student pesho = new Student("Pesho", 22);
        Student anna = new Student("Anna", 22);

        return List.of(pesho, anna);
    }
}
