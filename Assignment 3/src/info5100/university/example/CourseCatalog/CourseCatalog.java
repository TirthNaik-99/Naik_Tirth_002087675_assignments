
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.CourseCatalog;

import info5100.university.example.Department.Department;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author kal bugrara
 */

public class CourseCatalog {

    private Department department;   // The department offering the courses
    private String lastUpdated;      // Tracks the last time the catalog was updated
    private ArrayList<Course> courseList; // List of courses in the catalog

    // Constructor
    public CourseCatalog(Department department) {
        this.department = department;
        this.courseList = new ArrayList<>();
        updateLastUpdated();
    }

    // Getters and setters
    public ArrayList<Course> getCourseList() {
        return courseList;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    // Method to add a new course to the catalog
    public Course newCourse(String name, String number, int credits) {
        Course course = new Course(name, number, credits);
        courseList.add(course);
        updateLastUpdated();
        return course;
    }

    // Method to find a course by its number
    public Course getCourseByNumber(String number) {
        for (Course course : courseList) {
            if (course.getCourseNumber().equals(number)) {
                return course;
            }
        }
        return null;  // Return null if course not found
    }

    // Method to remove a course by its number
    public boolean removeCourseByNumber(String number) {
        Course course = getCourseByNumber(number);
        if (course != null) {
            courseList.remove(course);
            updateLastUpdated();
            return true;
        }
        return false;  // Course not found
    }

    // Method to browse all available courses in the catalog
    public void browseCourses() {
        if (courseList.isEmpty()) {
            System.out.println("No courses available in the catalog.");
        } else {
            for (Course course : courseList) {
                System.out.println(course);
            }
        }
    }

    // Private method to update the timestamp whenever the catalog is modified
    private void updateLastUpdated() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        lastUpdated = LocalDateTime.now().format(formatter);
    }
}
