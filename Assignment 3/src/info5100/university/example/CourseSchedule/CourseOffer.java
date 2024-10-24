
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.CourseSchedule;

import info5100.university.example.CourseCatalog.Course;
import info5100.university.example.Persona.Faculty.FacultyProfile;
import java.util.ArrayList;

public class CourseOffer {

    private Course course;
    private ArrayList<Seat> seatlist;
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
            seatlist.add(new Seat(this, i));
        }
    }

    public Seat getEmptySeat() {
        for (Seat s : seatlist) {
            if (!s.isOccupied()) {
                return s;
            }
        }
        return null;
    }

    public SeatAssignment assignEmptySeat(CourseLoad cl) {
        Seat seat = getEmptySeat();
        if (seat == null) {
            return null;
        }
        SeatAssignment sa = seat.newSeatAssignment(cl);
        cl.registerStudent(sa);
        return sa;
    }

    public int getTotalCourseRevenues() {
        int sum = 0;
        for (Seat s : seatlist) {
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
    

}