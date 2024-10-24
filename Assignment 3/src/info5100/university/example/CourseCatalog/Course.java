/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.CourseCatalog;

/**
 *
 * @author kal bugrara
 */

public class Course {
    
    private String number;  // Course number (e.g., "CS101")
    private String name;    // Course name (e.g., "Data Structures")
    private int credits;    // Number of credits
    private int pricePerCredit = 1500; // Price per credit hour

    // Constructor
    public Course(String name, String number, int credits) {
        this.name = name;
        this.number = number;
        this.credits = credits;
    }

    // Getters for course attributes
    public String getCourseNumber() {
        return number;
    }

    public String getCourseName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    // Calculate total price for the course based on credits
    public int getCoursePrice() {
        return pricePerCredit * credits;
    }

    // Override toString() method to provide a readable course description
    @Override
    public String toString() {
        return "Course: " + name + " (" + number + "), Credits: " + credits + ", Price: $" + getCoursePrice();
    }
}
