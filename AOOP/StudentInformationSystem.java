package AOOP;
import java.util.ArrayList;
import java.util.List;


// Main Class
public class StudentInformationSystem {
    public static void main(String[] args) {
        StudentManagement management = new StudentManagement();

        // Adding Students
        management.addStudent("Alice", 1);
        management.addStudent("Bob", 2);

        // Adding Courses
        management.addCourse(101, "Mathematics");
        management.addCourse(102, "Physics");

        // Enrolling Students
        management.enrollStudentInCourse(1, 101); // Alice enrolls in Mathematics
        management.enrollStudentInCourse(2, 102); // Bob enrolls in Physics
        management.enrollStudentInCourse(1, 102); // Alice enrolls in Physics

        // Withdrawing Students
        management.withdrawStudentFromCourse(1, 102); // Alice withdraws from Physics

        // Removing Student
        management.removeStudent(2); // Remove Bob

        // Attempting to enroll a removed student
        management.enrollStudentInCourse(2, 101); // Should fail
    }
}

// Student Class
class Student {
    private String name;
    private int id;
    private List<Course> enrolledCourses;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        this.enrolledCourses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void enrollInCourse(Course course) {
        if (!enrolledCourses.contains(course)) {
            enrolledCourses.add(course);
            course.addStudent(this);
            System.out.println(name + " has been enrolled in " + course.getCourseName());
        } else {
            System.out.println(name + " is already enrolled in " + course.getCourseName());
        }
    }

    public void withdrawFromCourse(Course course) {
        if (enrolledCourses.contains(course)) {
            enrolledCourses.remove(course);
            course.removeStudent(this);
            System.out.println(name + " has been withdrawn from " + course.getCourseName());
        } else {
            System.out.println(name + " is not enrolled in " + course.getCourseName());
        }
    }
}

// Course Class
class Course {
    private int courseCode;
    private String courseName;
    private List<Student> enrolledStudents;

    public Course(int courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.enrolledStudents = new ArrayList<>();
    }

    public int getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    protected void addStudent(Student student) {
        if (!enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
        }
    }

    protected void removeStudent(Student student) {
        enrolledStudents.remove(student);
    }
}

// Student Management Class
class StudentManagement {
    private List<Student> students;
    private List<Course> courses;

    public StudentManagement() {
        students = new ArrayList<>();
        courses = new ArrayList<>();
    }

    public void addStudent(String name, int id) {
        Student newStudent = new Student(name, id);
        students.add(newStudent);
        System.out.println("Added student: " + name);
    }

    public void removeStudent(int id) {
        Student studentToRemove = findStudentById(id);
        if (studentToRemove != null) {
            // Remove student from all courses they are enrolled in
            for (Course course : studentToRemove.getEnrolledCourses()) {
                course.removeStudent(studentToRemove);
            }
            students.remove(studentToRemove);
            System.out.println("Removed student with ID: " + id);
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    public void addCourse(int courseCode, String courseName) {
        Course newCourse = new Course(courseCode, courseName);
        courses.add(newCourse);
        System.out.println("Added course: " + courseName);
    }

    public void enrollStudentInCourse(int studentId, int courseCode) {
        Student student = findStudentById(studentId);
        Course course = findCourseByCode(courseCode);
        if (student != null && course != null) {
            student.enrollInCourse(course);
        } else {
            System.out.println("Enrollment failed: Invalid student ID or course code.");
        }
    }

    public void withdrawStudentFromCourse(int studentId, int courseCode) {
        Student student = findStudentById(studentId);
        Course course = findCourseByCode(courseCode);
        if (student != null && course != null) {
            student.withdrawFromCourse(course);
        } else {
            System.out.println("Withdrawal failed: Invalid student ID or course code.");
        }
    }

    private Student findStudentById(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    private Course findCourseByCode(int code) {
        for (Course c : courses) {
            if (c.getCourseCode() == code) {
                return c;
            }
        }
        return null;
    }
}

