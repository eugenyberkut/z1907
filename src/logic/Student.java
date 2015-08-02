package logic;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by Eugeny on 19.07.2015.
 */
public class Student implements Serializable, Comparable<Student> {
    private int id;
    private String firstName;
    private String secondName;
    private String lastName;
    private LocalDate birthday;
    private String address;
    private String phone;
    private String faculty;
    private int year;
    private String group;

    public Student(int id, String firstName, String secondName, String lastName, LocalDate birthday, String address, String phone, String faculty, int year, String group) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.address = address;
        this.phone = phone;
        this.faculty = faculty;
        this.year = year;
        this.group = group;
    }

    public Student(int id, String firstName, String secondName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "logic.Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", faculty='" + faculty + '\'' +
                ", year=" + year +
                ", group='" + group + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (id != student.id) return false;
        if (year != student.year) return false;
        if (!firstName.equals(student.firstName)) return false;
        if (!secondName.equals(student.secondName)) return false;
        if (!lastName.equals(student.lastName)) return false;
        if (birthday != null ? !birthday.equals(student.birthday) : student.birthday != null) return false;
        if (address != null ? !address.equals(student.address) : student.address != null) return false;
        if (phone != null ? !phone.equals(student.phone) : student.phone != null) return false;
        if (faculty != null ? !faculty.equals(student.faculty) : student.faculty != null) return false;
        return !(group != null ? !group.equals(student.group) : student.group != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + firstName.hashCode();
        result = 31 * result + secondName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (faculty != null ? faculty.hashCode() : 0);
        result = 31 * result + year;
        result = 31 * result + (group != null ? group.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Student o) {
        int val = this.lastName.compareTo(o.lastName);
        if (val!=0) return val;
        return Integer.compare(this.id, o.id);
    }
}
