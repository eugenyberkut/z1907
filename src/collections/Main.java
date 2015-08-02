package collections;


import logic.Student;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    List<Student> students;
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        try {
            students = rearFromTextFileToList("students.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private List<Student> rearFromTextFileToList(String fileName) throws FileNotFoundException {
        List<Student> students = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            int n = Integer.parseInt(reader.readLine());
            for (int i = 0;i<n;i++){
                int id = Integer.parseInt(reader.readLine());
                String firstName = reader.readLine();
                String secondName = reader.readLine();
                String lastName = reader.readLine();
                LocalDate birthday = LocalDate.parse(reader.readLine());
                String address = reader.readLine();
                String phone = reader.readLine();
                String faculty = reader.readLine();
                int year = Integer.parseInt(reader.readLine());
                String group = reader.readLine();
                students.add(new Student(id,firstName,secondName,lastName,birthday,address,phone,faculty,year,group));

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }


}
