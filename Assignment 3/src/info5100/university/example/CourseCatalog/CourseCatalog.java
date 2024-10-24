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

    private Department department;
    private String lastUpdated;
    private ArrayList<Course> courseList;

    public CourseCatalog(Department department) {
        this.department = department;
        this.courseList = new ArrayList<>();
        updateLastUpdated();
    }

    public ArrayList<Course> getCourseList() {
        return courseList;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public Course newCourse(String name, String number, int credits) {
        Course course = new Course(name, number, credits);
        courseList.add(course);
        updateLastUpdated();
        return course;
    }

    public Course getCourseByNumber(String number) {
        for (Course course : courseList) {
            if (course.getCourseNumber().equals(number)) {
                return course;
            }
        }
        return null;
    }

    public boolean removeCourseByNumber(String number) {
        Course course = getCourseByNumber(number);
        if (course != null) {
            courseList.remove(course);
            updateLastUpdated();
            return true;
        }
        return false;
    }

    public void browseCourses() {
        if (courseList.isEmpty()) {
            System.out.println("No courses available in the catalog.");
        } else {
            for (Course course : courseList) {
                System.out.println("Course Number: " + course.getCourseNumber() +
                                   ", Name: " + course.getCourseName() +
                                   ", Credits: " + course.getCredits());
            }
        }
    }

    private void updateLastUpdated() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        lastUpdated = LocalDateTime.now().format(formatter);
    }
}