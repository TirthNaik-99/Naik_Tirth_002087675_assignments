
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.CourseSchedule;

import info5100.university.example.CourseCatalog.Course;
import info5100.university.example.Persona.Faculty.FacultyProfile;
import info5100.university.example.Persona.StudentProfile;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;


/**
 *
 * @author kal bugrara
 */
public class CourseOffer {

    private List<StudentProfile> registeredStudents = new ArrayList<>();
    private Map<StudentProfile, String> studentGrades = new HashMap<>(); // Map to store grades for each student

    public List<StudentProfile> getRegisteredStudents() {
        return registeredStudents;
    }


    private Course course;
    private ArrayList<CourseSeat> seatlist;
    private FacultyProfile professor;

    public CourseOffer(Course course) {
        this.course = course;
        this.seatlist = new ArrayList<>();
        this.professor = null; // Initially no professor assigned
    }

    public Course getCourse() {
        return course;
    }

    public FacultyProfile getProfessor() {
        return professor;
    }

    public void setProfessor(FacultyProfile professor) {
        this.professor = professor;
    }

    public void generateSeats(int n) {
        for (int i = 0; i < n; i++) {
            seatlist.add(new CourseSeat(this, i));
        }
    }

    public CourseSeat getEmptySeat() {
        for (CourseSeat s : seatlist) {
            if (!s.isOccupied()) {
                return s;
            }
        }
        return null;
    }

    public SeatAssignment assignEmptySeat(CourseLoad cl) {
        CourseSeat seat = getEmptySeat();
        if (seat == null) {
            return null;
        }
        SeatAssignment sa = seat.newSeatAssignment(cl);
        cl.registerStudent(sa);
        return sa;
    }

    public int getTotalCourseRevenues() {
        int sum = 0;
        for (CourseSeat s : seatlist) {
            if (s.isOccupied()) {
                sum += course.getCoursePrice();
            }
        }
        return sum;
    }

    public int getCreditHours() {
        return course.getCredits();
    }
    
    public Course getSubjectCourse() {
        return course;
    }
    
    public String getCourseNumber() {
        return course.getCourseNumber();
    }

    public String getGradeForStudent(StudentProfile student) {
        return studentGrades.getOrDefault(student, "N/A"); // Return grade or "N/A" if not found
    }
}