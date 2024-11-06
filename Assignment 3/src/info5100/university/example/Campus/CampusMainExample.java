package info5100.university.example.Campus;

import java.util.List;
import java.util.ArrayList;
import info5100.university.example.CourseCatalog.CourseCatalog;
import info5100.university.example.CourseSchedule.CourseOffer;
import info5100.university.example.CourseSchedule.CourseSchedule;
import info5100.university.example.Department.Department;
import info5100.university.example.Persona.Faculty.FacultyDirectory;
import info5100.university.example.Persona.Faculty.FacultyProfile;
import info5100.university.example.Persona.Person;
import info5100.university.example.Persona.StudentDirectory;
import info5100.university.example.Persona.StudentProfile;

public class CampusMainExample {

    public static void main(String[] args) {
        // Create a department
        Department department = new Department("Computer Science");
        //System.out.println(department);

        // Create course catalog and add courses
        CourseCatalog courseCatalog = new CourseCatalog(department);
        courseCatalog.newCourse("Introduction to Programming", "CS101", 3);
        courseCatalog.newCourse("Data Structures", "CS102", 4);
        courseCatalog.newCourse("Web Design", "CS103", 4);
        courseCatalog.newCourse("Databases", "CS104", 3);
        courseCatalog.newCourse("Operating Systems", "CS105", 4);
        courseCatalog.newCourse("Artificial Intelligence", "CS106", 3);
        courseCatalog.browseCourses();

        // Create course schedule for the semester
        CourseSchedule courseSchedule = new CourseSchedule("Fall2024", courseCatalog);

        // Schedule 10 course offers
        for (int i = 0; i < 10; i++) {
            String courseCode = "CS10" + ((i % 6) + 1); // Cycles through CS101 to CS106
            CourseOffer courseOffer = courseSchedule.newCourseOffer(courseCode);
            courseOffer.generateSeats(5); // Generate 5 seats per course offer
        }

        // Create faculty directory and add faculty members
        FacultyDirectory facultyDirectory = new FacultyDirectory(department);
        facultyDirectory.newFacultyProfile(new Person("001", "Dr. Smith"));
        facultyDirectory.newFacultyProfile(new Person("002", "Dr. Johnson"));
        facultyDirectory.newFacultyProfile(new Person("003", "Dr. Lee"));
        facultyDirectory.newFacultyProfile(new Person("004", "Dr. Patel"));
        facultyDirectory.newFacultyProfile(new Person("005", "Dr. Brown"));

        // Assign professors to each course offer in a round-robin manner
        int professorIndex = 0;
        List<FacultyProfile> facultyList = facultyDirectory.getFacultyList();
        for (CourseOffer courseOffer : courseSchedule.getSchedule()) {
            FacultyProfile professor = facultyList.get(professorIndex % facultyList.size());
            courseOffer.setProfessor(professor); // Directly set the professor for each offer
            professorIndex++;
        }

        // Initialize student directory and create 10 students
        StudentDirectory studentDirectory = new StudentDirectory(department);
        List<StudentProfile> students = new ArrayList<>();
        String[] studentNames = {
                "Alice Johnson", "Bob Smith", "Carol Williams", "David Brown",
                "Emma Garcia", "Frank Martinez", "Grace Rodriguez", "Henry Lee",
                "Isabella Perez", "Jack Kim"
        };
        for (int i = 0; i < studentNames.length; i++) {
            Person studentPerson = new Person(String.format("S%03d", i + 1), studentNames[i]);
            StudentProfile student = new StudentProfile(studentPerson, i + 1, 300.0);
            students.add(student);
            studentDirectory.addStudent(student);
        }

        // Grades array to assign different grades to each course registration
        String[] grades = {"A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D", "F"};

        // Register students across courses with different grades
        // Register students across courses with different grades
        int studentIndex = 0;
        int gradeIndex = 0; // Track grade independently to vary for each course
        for (CourseOffer courseOffer : courseSchedule.getSchedule()) {
            for (int j = 0; j < 2; j++) { // Register 2 students per course offer
                StudentProfile student = students.get(studentIndex % students.size());
                if (courseOffer.getEmptySeat() != null) {
                    courseOffer.registerStudent(student);

                    // Assign a different grade to each registration using the grades array
                    String grade = grades[gradeIndex % grades.length];
                    student.enrollInCourse(courseOffer.getCourse(), grade);

                    // Update gradeIndex for next registration to vary grades
                    gradeIndex++;
                }
                studentIndex++;
            }
        }


        // Display course schedule and assignments
        courseSchedule.displaySchedule();

        // Display registered students for each course
        for (CourseOffer courseOffer : courseSchedule.getSchedule()) {
            System.out.println("Registered students for " + courseOffer.getCourse().getCourseNumber() + ":");
            for (StudentProfile student : courseOffer.getRegisteredStudents()) {
                System.out.println("Student ID: " + student.getStudentId() + ", Name: " + student.getPerson().getName());
            }
        }

        // Generate and print semester report
        courseSchedule.printSemesterReport();
    }
}
