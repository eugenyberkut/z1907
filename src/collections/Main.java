package collections;


import logic.Student;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    List<Student> students;
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        try {
            students = rearFromTextFileToList("students.txt");
            System.out.println(students);
            writeStudentsToBinaryFile("students.dat");
            List<Student> students1 = readStudentsFromBinaryFile("students.dat");
            System.out.println("-------");
            print(students1);
            System.out.println("---- sorted ----");
            printSortedByNames(students1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void printSortedByNames(List<Student> students1) {
        students1.stream()
                .sorted(Comparator.comparing(Student::getYear)
                        .thenComparing(Student::getLastName)
                        .thenComparing(Student::getFirstName)
                        .thenComparing(Student::getSecondName)
                        .thenComparing(Student::getId))
                .filter(student -> student.getGroup().endsWith("34"))
                .skip(1)
                .limit(1)
                .forEach(System.out::println);
    }

    private void print(List<Student> students) {
//        for (Student student : students) {
//            System.out.println(student);
//        }
//        students.stream().forEach(s -> System.out.println(s));
        students.stream().sorted().forEach(System.out::println);
    }

    private List<Student> readStudentsFromBinaryFile(String filename) throws FileNotFoundException {
        try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream(filename))){
            Object object = stream.readObject();
            return (List<Student>) object;
        }  catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    private void writeStudentsToBinaryFile(String filename) throws FileNotFoundException {
        try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(filename))) {
            stream.writeObject(students);
        } catch (IOException e) {
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
