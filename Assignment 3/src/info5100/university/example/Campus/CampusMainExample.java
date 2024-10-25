/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Campus;

import info5100.university.example.CourseCatalog.CourseCatalog;
import info5100.university.example.CourseSchedule.CourseSchedule;
import info5100.university.example.Department.Department;
import info5100.university.example.Persona.Faculty.FacultyDirectory;
import info5100.university.example.Persona.Person;
import info5100.university.example.Persona.StudentDirectory;

/**
 *
 * @author kal bugrara
 */
public class CampusMainExample {

    public static void main(String[] args) {
        // Create a department
        Department department = new Department("Computer Science");

        // Create course catalog
        CourseCatalog courseCatalog = new CourseCatalog(department);

        // Add courses to the catalog
        courseCatalog.newCourse("CS101", "Introduction to Programming", 3);
        courseCatalog.newCourse("CS102", "Data Structures", 4);

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

        // Print out the schedule and assignments
        courseSchedule.displaySchedule();
    }
}
