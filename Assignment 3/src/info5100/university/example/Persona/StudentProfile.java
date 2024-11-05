package info5100.university.example.Persona;

import info5100.university.example.CourseSchedule.CourseLoad;
import info5100.university.example.CourseSchedule.CourseOffer;
import info5100.university.example.CourseSchedule.SeatAssignment;
import info5100.university.example.Persona.EmploymentHistory.EmploymentHistroy;
import info5100.university.example.CourseCatalog.Course;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author kal bugrara
 */
public class StudentProfile {

    private Person person;
    private int studentId;
    private ArrayList<CourseOffer> registeredCourses; // Initialize in both constructors

    private Transcript transcript;
    private EmploymentHistroy employmentHistory;
    private Map<Course, String> coursesAndGrades;
    private double tuitionFees;

    // Constructor without tuition fees
    public StudentProfile(Person person) {
        this.person = person;
        this.transcript = new Transcript(this);
        this.employmentHistory = new EmploymentHistroy();
        this.registeredCourses = new ArrayList<>(); // Initialize registeredCourses here
        this.coursesAndGrades = new HashMap<>();
    }

    // Constructor with tuition fees
    public StudentProfile(Person person, int studentId,double tuitionFees) {
        this.person = person;
        this.tuitionFees = tuitionFees;
        this.studentId = studentId;
        this.transcript = new Transcript(this);
        this.employmentHistory = new EmploymentHistroy();
        this.registeredCourses = new ArrayList<>(); // Initialize registeredCourses here
        this.coursesAndGrades = new HashMap<>();
    }

    // Create 10 students and add them to the student directory

    public Person getPerson() {
        return person;
    }

    public int getStudentId() {
        return studentId;
    }

    // Add a course to the student's registered courses
    public void addCourse(CourseOffer courseOffer) {
        registeredCourses.add(courseOffer);
    }

    public ArrayList<CourseOffer> getRegisteredCourses() {
        return registeredCourses;
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

    // Enroll the student in a course with an initial grade
    public void enrollInCourse(Course course, String grade) {
        coursesAndGrades.put(course, grade); // Add course and grade
    }

    public Map<Course, String> getCoursesAndGrades() {
        return coursesAndGrades;
    }

    public void updateGrade(Course course, String newGrade) {
        if (coursesAndGrades.containsKey(course)) {
            coursesAndGrades.put(course, newGrade);
        } else {
            System.out.println("Course not found for this student.");
        }
    }

    // Calculate GPA based on courses and grades
    public double calculateGPA() {
        double totalPoints = 0.0;
        int numCourses = coursesAndGrades.size();

        Map<String, Double> gradeScale = Map.of(
                "A", 4.0, "A-", 3.7, "B+", 3.3, "B", 3.0, "B-", 2.7,
                "C+", 2.3, "C", 2.0, "C-", 1.7, "D", 1.0, "F", 0.0
        );

        for (Map.Entry<Course, String> entry : coursesAndGrades.entrySet()) {
            String grade = entry.getValue();
            totalPoints += gradeScale.getOrDefault(grade, 0.0);
        }

        double gpa = (numCourses > 0) ? totalPoints / numCourses : 0.0;
        return gpa;
    }


    public double getTuitionFees() {
        return tuitionFees;
    }

}
