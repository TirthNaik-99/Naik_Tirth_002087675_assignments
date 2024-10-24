/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.CourseSchedule;

import info5100.university.example.CourseCatalog.Course;
import info5100.university.example.CourseCatalog.CourseCatalog;
import info5100.university.example.Persona.Faculty.FacultyProfile;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class CourseSchedule {

    private CourseCatalog courseCatalog;
    private ArrayList<CourseOffer> schedule;
    private String semester;

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
}