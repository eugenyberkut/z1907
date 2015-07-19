package logic;

import java.io.*;
import java.time.LocalDate;
import java.util.Arrays;

/**
 * Created by Eugeny on 19.07.2015.
 */
public class Main {

    private Student[] students = {
            new Student(1,"Иван", "Иванович", "Иванов", LocalDate.of(1998, 5, 12), "б/а", "1232", "КН", 1, "1234"),
            new Student(2,"Петр", "Петрович", "Петрик", LocalDate.of(1996,6,11), "б/а", "1222", "НК", 2, "2234"),
            new Student(3,"Юлиан", "Остапович", "Ковалев", LocalDate.of(1995,1,1), "б/а", "1123", "КН", 3, "3234")
    };

    private String[] faculties = {"КН", "НК", "ПС"};

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        System.out.println("--- 1 ---");
        System.out.println(Arrays.asList(studentsByFaculty(students, "КН")));
        System.out.println("---------");
        System.out.println("--- 2 ---");
        for (String faculty : faculties) {
            System.out.println(faculty);
            System.out.println(Arrays.asList(studentsByFaculty(students, faculty)));
        }
        System.out.println("---------");
        writeStudentsToTextFile(students);
    }

    private Student[] readStudentsFromTextFile(String fileName) {
        Student[] result = null;
        try {
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            int count = Integer.parseInt(in.readLine());
            result = new Student[count];
            for (int i = 0; i < result.length; i++) {
                int id = Integer.parseInt(in.readLine());
                String firstName = in.readLine();
                String secondName = in.readLine();
                String lastName = in.readLine();
                LocalDate birthday = LocalDate.parse(in.readLine());
                String address = in.readLine();
                String phone = in.readLine();
                String faculty = in.readLine();
                int year = Integer.parseInt(in.readLine());
                String group = in.readLine();
                result[i] = new Student(id, firstName, secondName, lastName, birthday, address, phone, faculty, year, group);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private void writeStudentsToTextFile(Student[] students) {
        try {
            PrintWriter out = new PrintWriter("students.txt");
            out.println(students.length);
            for (Student student : students) {
                out.println(student.getId());
                out.println(student.getFirstName());
                out.println(student.getSecondName());
                out.println(student.getLastName());
                out.println(student.getBirthday());
                out.println(student.getAddress());
                out.println(student.getPhone());
                out.println(student.getFaculty());
                out.println(student.getYear());
                out.println(student.getGroup());
            }
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Student[] studentsByFaculty(Student[] students, String faculty) {
        int count = countStudentsByFaculty(students, faculty);
        Student[] result = new Student[count];
        int selected = 0;
        for (Student student : students) {
            if (faculty.equals(student.getFaculty())) {
                result[selected++] = student;
            }
        }
        return result;
    }

    public int countStudentsByFaculty(Student[] students, String faculty) {
        int result = 0;
        for (Student student : students) {
            if (faculty.equals(student.getFaculty())) {
                result++;
            }
        }
        return result;
    }

    public Student[] studentsAfterYear(Student[] students, int year) {
        int count = countStudentsAfterYear(students, year);
        Student[] result = new Student[count];
        int selected = 0;
        LocalDate startDate = LocalDate.of(year, 12, 31);
        for (Student student : students) {
            if (startDate.isBefore(student.getBirthday())) {
                result[selected++] = student;
            }
        }
        return result;
    }

    public int countStudentsAfterYear(Student[] students, int year) {
        int result = 0;
        LocalDate startDate = LocalDate.of(year, 12, 31);
        for (Student student : students) {
            if (startDate.isBefore(student.getBirthday())) {
                result++;
            }
        }
        return result;
    }

    public Student[] studentsByGroup(Student[] students, String group) {
        int count = countStudentsByGroup(students, group);
        Student[] result = new Student[count];
        int selected = 0;
        for (Student student : students) {
            if (group.equals(student.getGroup())) {
                result[selected++] = student;
            }
        }
        return result;
    }

    public int countStudentsByGroup(Student[] students, String group) {
        int result = 0;
        for (Student student : students) {
            if (group.equals(student.getGroup())) {
                result++;
            }
        }
        return result;
    }
}
