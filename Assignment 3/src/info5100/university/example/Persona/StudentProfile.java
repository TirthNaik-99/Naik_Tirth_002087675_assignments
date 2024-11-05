
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Persona;

import info5100.university.example.CourseSchedule.CourseLoad;
import info5100.university.example.CourseSchedule.SeatAssignment;
import info5100.university.example.Persona.EmploymentHistory.EmploymentHistroy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import info5100.university.example.CourseCatalog.CourseCatalog;
import info5100.university.example.CourseCatalog.Course;
/**
 *
 * @author kal bugrara
 */
public class StudentProfile {

    private Person person;

    public Person getPerson() {
        return person;
    }


    private Transcript transcript;
    private EmploymentHistroy employmentHistory;

    public  StudentProfile(Person person) {
        this.person = person;
        this.transcript = new Transcript(this);
        this.employmentHistory = new EmploymentHistroy();
    }

    public boolean isMatch(String id) {
        return person.getpersonId().equals(id);
    }

    public Transcript getTranscript() {
        return transcript;
    }

    public CourseLoad getCourseLoadBySemester(String semester) {
        return transcript.getCourseLoadBySemester(semester);
    }

    public CourseLoad getCurrentCourseLoad() {
        return transcript.getCurrentCourseLoad();
    }

    public CourseLoad newCourseLoad(String semester) {
        return transcript.newCourseLoad(semester);
    }

    public ArrayList<SeatAssignment> getCourseList() {
        return transcript.getCourseList();
    }

    private Map<Course, String> coursesAndGrades = new HashMap<>();
    private double tuitionFees;

    public StudentProfile(Person person, double tuitionFees) {
        this.person = person;
        this.tuitionFees = tuitionFees;
    }


    public void enrollInCourse(Course course, String grade) {
        coursesAndGrades.put(course, grade); // Add course and grade
    }

    public Map<Course, String> getCoursesAndGrades() {
        return coursesAndGrades;
    }

    public double calculateGPA() {
        double totalPoints = 0.0;
        int numCourses = coursesAndGrades.size();

        // Example grading scale (you can adjust as needed)
        Map<String, Double> gradeScale = Map.of(
                "A", 4.0, "A-", 3.7, "B+", 3.3, "B", 3.0, "B-", 2.7,
                "C+", 2.3, "C", 2.0, "C-", 1.7, "D", 1.0, "F", 0.0
        );

        for (String grade : coursesAndGrades.values()) {
            totalPoints += gradeScale.getOrDefault(grade, 0.0); // Default to 0.0 if grade not found
        }

        return (numCourses > 0) ? totalPoints / numCourses : 0.0;
    }

    public double getTuitionFees() {
        return tuitionFees;
    }
}
