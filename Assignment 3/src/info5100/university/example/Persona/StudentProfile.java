
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
/**
 *
 * @author kal bugrara
 */
public class StudentProfile {

    private Person person;
    private Transcript transcript;
    private EmploymentHistroy employmentHistory;

    public StudentProfile(Person person) {
        this.person = person;
        this.transcript = new Transcript(this);
        this.employmentHistory = new EmploymentHistroy();
    }

    public boolean isMatch(String id) {
        return person.getPersonId().equals(id);
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
}