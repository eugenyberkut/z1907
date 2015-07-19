package logic;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

/**
 * Created by Eugeny on 19.07.2015.
 */
public class MainTest {

    private Student[] students;

    @Before
    public void setUp() throws Exception {
        students = new Student[] {
                new Student(1,"Иван", "Иванович", "Иванов", LocalDate.of(1998,5,12), "б/а", "1232", "КН", 1, "1234"),
                new Student(2,"Петр", "Петрович", "Петрик", LocalDate.of(1996,6,11), "б/а", "1222", "НК", 2, "2234"),
                new Student(3,"Юлиан", "Остапович", "Ковалев", LocalDate.of(1995,1,1), "б/а", "1123", "КН", 3, "3234")
        };
    }

    @Test
    public void testStudentsByFaculty() throws Exception {
        Main main = new Main();
        String faculty = "КН";
        Student[] expectedResult = {
                new Student(1,"Иван", "Иванович", "Иванов", LocalDate.of(1998,5,12), "б/а", "1232", "КН", 1, "1234"),
                new Student(3,"Юлиан", "Остапович", "Ковалев", LocalDate.of(1995,1,1), "б/а", "1123", "КН", 3, "3234")
        };
        Student[] result = main.studentsByFaculty(this.students, faculty);
        assertArrayEquals(expectedResult, result);
    }

    @Test
    public void testCountStudentsByFaculty() throws Exception {
        Main main = new Main();
        String faculty = "КН";
        int expectedResult = 2;
        int result = main.countStudentsByFaculty(students, faculty);
        assertEquals(expectedResult, result);
    }

    @Test
    public void testCountStudentsAfterYear() throws Exception {
        Main main = new Main();
        int year = 1995;
        int expectedResult = 2;
        int result = main.countStudentsAfterYear(students, year);
        assertEquals(expectedResult, result);
    }

    @Test
    public void testStudentsAfterYear() throws Exception {
        Main main = new Main();
        int year = 1995;
        Student[] expectedResult = {
                new Student(1,"Иван", "Иванович", "Иванов", LocalDate.of(1998,5,12), "б/а", "1232", "КН", 1, "1234"),
                new Student(2,"Петр", "Петрович", "Петрик", LocalDate.of(1996,6,11), "б/а", "1222", "НК", 2, "2234")
        };
        Student[] result = main.studentsAfterYear(students, year);
        assertArrayEquals(expectedResult, result);
    }

    @Test
    public void testCountStudentsByGroup() throws Exception {
        Main main = new Main();
        String group = "2234";
        int expectedResult = 1;
        int result = main.countStudentsByGroup(students, group);
        assertEquals(expectedResult, result);
    }

    @Test
    public void testStudentsByGroup() throws Exception {
        Main main = new Main();
        String group = "2234";
        Student[] expectedResult = {
                new Student(2,"Петр", "Петрович", "Петрик", LocalDate.of(1996,6,11), "б/а", "1222", "НК", 2, "2234")
        };
        Student[] result = main.studentsByGroup(students, group);
        assertArrayEquals(expectedResult, result);
    }
}