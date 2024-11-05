package info5100.university.example.Persona;

import info5100.university.example.Department.Department;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class StudentDirectory {

    Department department;
    ArrayList<StudentProfile> studentList;

    public StudentDirectory(Department department) {
        this.department = department;
        this.studentList = new ArrayList<>();
    }

    // Method to add a student profile to the directory
    public void addStudent(StudentProfile student) {
        studentList.add(student);
    }

    // Method to retrieve the list of students
    public ArrayList<StudentProfile> getStudentList() {
        return studentList;
    }

    public StudentProfile newStudentProfile(Person p) {
        StudentProfile sp = new StudentProfile(p);
        studentList.add(sp);
        return sp;
    }

    public StudentProfile findStudent(String id) {
        for (StudentProfile sp : studentList) {
            if (sp.isMatch(id)) {
                return sp;
            }
        }
        return null; // not found after going through the whole list
    }
}
