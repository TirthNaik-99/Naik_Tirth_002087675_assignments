/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Campus;


import java.util.Scanner;
import info5100.university.example.CourseCatalog.CourseCatalog;
import info5100.university.example.CourseSchedule.CourseSchedule;
import info5100.university.example.Department.Department;
import info5100.university.example.Persona.Faculty.FacultyDirectory;
import info5100.university.example.Persona.Person;
import info5100.university.example.Persona.PersonDirectory;
import info5100.university.example.Persona.StudentDirectory;

/**
 *
 * @author kal bugrara
 */
public class CampusMainExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a department
        Department department = new Department("Computer Science");

        // Create course catalog
        CourseCatalog courseCatalog = new CourseCatalog(department);

        // Add courses to the catalog
//        System.out.print("How many courses do you want to add? ");
//        int numberOfCourses=scanner.nextInt();
//
//        scanner.nextLine();
//
//        for (int i = 0; i < numberOfCourses; i++) {
//            System.out.print("Enter course name: ");
//            String courseName = scanner.nextLine();
//            System.out.print("Enter course code: ");
//            String courseCode = scanner.nextLine();
//            System.out.print("Enter course credits: ");
//            int courseCredits = scanner.nextInt();
//            scanner.nextLine(); // Consume newline
//
//            courseCatalog.newCourse(courseName, courseCode, courseCredits);
//        }
        courseCatalog.newCourse("Introduction to Programming","CS101",  3);
        courseCatalog.newCourse("Data Structures","CS102",  4);
        courseCatalog.newCourse("Web Design","CS103",  4);
        courseCatalog.browseCourses();

        /*
         * Manage the course schedule:
         * Create course schedule for a new semester, add course offers for courses, and assign teachers.
         */

        // Create course schedule for a semester
        CourseSchedule courseSchedule = new CourseSchedule("Fall2024", courseCatalog);

        // Schedule courses
        courseSchedule.newCourseOffer("CS101");
        courseSchedule.newCourseOffer("CS102");

        // Create faculty directory
        FacultyDirectory facultyDirectory = new FacultyDirectory(department);

        // Add faculty members
        facultyDirectory.newFacultyProfile(new Person("001", "Dr. Smith"));
        facultyDirectory.newFacultyProfile(new Person("002", "Dr. Johnson"));

        // Assign professors to courses
        courseSchedule.assignProfessorToCourse("CS101", facultyDirectory.findTeachingFaculty("001"));
        courseSchedule.assignProfessorToCourse("CS102", facultyDirectory.findTeachingFaculty("002"));

        // Create student directory
        StudentDirectory studentDirectory = new StudentDirectory(department);

        // Add students and register for courses
        studentDirectory.newStudentProfile(new Person("S001", "Alice"));
        studentDirectory.newStudentProfile(new Person("S002", "Bob"));
        courseSchedule.displayStudent();

        // Print out the schedule and assignments
        courseSchedule.displaySchedule();
    }
}
