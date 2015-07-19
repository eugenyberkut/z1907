package logic;

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
