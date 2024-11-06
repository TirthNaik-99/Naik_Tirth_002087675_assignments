/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.CourseSchedule;

import info5100.university.example.CourseCatalog.Course;
import info5100.university.example.CourseCatalog.CourseCatalog;
import info5100.university.example.Persona.Faculty.FacultyProfile;
import info5100.university.example.Persona.Person;
import info5100.university.example.Persona.StudentProfile;

import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class CourseSchedule {

    private CourseCatalog courseCatalog;
    private ArrayList<CourseOffer> schedule;
    private String semester;

    public ArrayList<CourseOffer> getSchedule() {
        return schedule;
    }


    public CourseSchedule(String semester, CourseCatalog courseCatalog) {
        this.semester = semester;
        this.courseCatalog = courseCatalog;
        this.schedule = new ArrayList<>();
    }

    public CourseOffer newCourseOffer(String courseNumber) {
        Course course = courseCatalog.getCourseByNumber(courseNumber);
        if (course == null) return null;
        CourseOffer courseOffer = new CourseOffer(course);
        schedule.add(courseOffer);
        return courseOffer;
    }

    public CourseOffer getCourseOfferByNumber(String courseNumber) {
        for (CourseOffer courseOffer : schedule) {
            if (courseOffer.getCourse().getCourseNumber().equals(courseNumber)) {
                return courseOffer;
            }
        }
        return null;
    }

    public int calculateTotalRevenues() {
        int sum = 0;
        for (CourseOffer courseOffer : schedule) {
            sum += courseOffer.getTotalCourseRevenues();
        }
        return sum;
    }

    public void assignProfessorToCourse(String courseNumber, FacultyProfile professor) {
        CourseOffer courseOffer = getCourseOfferByNumber(courseNumber);
        if (courseOffer != null) {
            courseOffer.setProfessor(professor);
        }
    }

    public void displaySchedule() {
        System.out.println("Course Schedule for Semester: " + semester);
        for (CourseOffer offer : schedule) {
            System.out.println("Course: " + offer.getCourse().getCourseName() +
                               ", Professor: " + (offer.getProfessor() != null ? offer.getProfessor().getName() : "Not Assigned"));
        }
    }
    public void displayStudent() {
        System.out.println("Course Schedule for Semester: " + semester);

        for (CourseOffer courseOffer : schedule) {
            System.out.println("Course: " + courseOffer.getCourse().getCourseName() +
                    " (Code: " + courseOffer.getCourse().getCourseNumber() + ")");

            System.out.println("Instructor: " + courseOffer.getProfessor().getName());

            System.out.println("Registered Students:");
            if (courseOffer.getRegisteredStudents().isEmpty()) {
                System.out.println("   No students registered yet.");
            } else {
                for (StudentProfile student : courseOffer.getRegisteredStudents()) {
                    System.out.println("   - " + student.getPerson().getName());
                }
            }

            System.out.println("---------------------------------------------------");
        }
    }

    public void printSemesterReport() {
        System.out.println("---------------------------------------------------");
        System.out.println("Semester Report for " + semester);
        System.out.println("---------------------------------------------------");

        // Loop through each course offer in the schedule
        for (CourseOffer courseOffer : schedule) {
            System.out.println("Course: " + courseOffer.getCourse().getCourseName() +
                    " (Code: " + courseOffer.getCourse().getCourseNumber() + ")");

            // Print professor information
            System.out.println("Professor: " + courseOffer.getProfessor().getName());

            // Loop through registered students
            for (StudentProfile student : courseOffer.getRegisteredStudents()) {
                System.out.println("Student: " + student.getPerson().getName());

                // Print the grade for the student in this course
                String grade = student.getGradeForCourse(courseOffer.getCourse());
                System.out.println("   Grade: " + grade);

                // Print all courses and grades for the student
                System.out.println("   Courses and Grades:");
                student.getCoursesAndGrades().forEach((course, courseGrade) ->
                        System.out.println("      " + course.getCourseName() + " - Grade: " + courseGrade)
                );

                // Print GPA for the semester
                System.out.println("   GPA for Semester: " + student.calculateGPA());

                // Print tuition fees paid for the semester
                System.out.println("   Tuition Fees Paid: $" + student.getTuitionFees());

                System.out.println("---------------------------------------------------");
            }
        }
    }


//    public void testPrintSemesterReport() {
//        // Set up a semester name
//        this.semester = "Fall 2024";
//
//        // Create a Course and CourseOffer
//        Course course = new Course("Intro to Programming","CS101", 3);
//        CourseOffer courseOffer = new CourseOffer(course);
//
//        // Create a professor and assign to CourseOffer
//        FacultyProfile professor = new FacultyProfile("Prof. John Doe");
//        courseOffer.setProfessor(professor);
//
//        // Create a student and register them in the course
//        StudentProfile student = new StudentProfile(new Person("1","gg"));
//        student.enrollInCourse(course, "A"); // Register with grade "A"
//        courseOffer.getRegisteredStudents().add(student);
//
//        // Add CourseOffer to schedule
//        this.schedule = new ArrayList<>();
//        this.schedule.add(courseOffer);
//
//        // Now call printSemesterReport

//    }

}