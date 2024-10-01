package tasks.Task5;
import java.util.*;
public class t1 {
 
        public static void main(String[] args) {
            // Creating services
            EnrollmentService enrollmentService = new EnrollmentServiceImpl();
            CourseService courseService = new CourseServiceImpl();
    
            // Creating students
            Student student1 = new UndergraduateStudent("Alice", 1);
            Student student2 = new GraduateStudent("Bob", 2);
    
            // Creating courses
            Course course1 = new Course("CS101", "Intro to Computer Science");
            Course course2 = new Course("CS102", "Data Structures");
    
            // Enroll students in courses
            enrollmentService.enrollStudentInCourse(student1, course1);
            enrollmentService.enrollStudentInCourse(student2, course1);
            enrollmentService.enrollStudentInCourse(student1, course2);
    
            // Retrieve and display enrolled students
            List<Student> studentsInCourse1 = courseService.getEnrolledStudents(course1);
            System.out.println("Students in " + course1.getCourseName() + ":");
            for (Student student : studentsInCourse1) {
                System.out.println(student.getName());
            }
    
            List<Student> studentsInCourse2 = courseService.getEnrolledStudents(course2);
            System.out.println("Students in " + course2.getCourseName() + ":");
            for (Student student : studentsInCourse2) {
                System.out.println(student.getName());
            }
        }
    }
    



 class Student {
    private String name;
    private int id;
    private List<Course> courses;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void enrollInCourse(Course course) {
        courses.add(course);
    }

    public List<Course> getCourses() {
        return courses;
    }
}


 class Course {
    private String courseId;
    private String courseName;
    private List<Student> students;

    public Course(String courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.students = new ArrayList<>();
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void enrollStudent(Student student) {
        students.add(student);
    }

    public List<Student> getEnrolledStudents() {
        return students;
    }
}
 interface EnrollmentService {
    void enrollStudentInCourse(Student student, Course course);
}

 class EnrollmentServiceImpl implements EnrollmentService {
    @Override
    public void enrollStudentInCourse(Student student, Course course) {
        student.enrollInCourse(course);
        course.enrollStudent(student);
    }
}

 class GraduateStudent extends Student {
    public GraduateStudent(String name, int id) {
        super(name, id);
    }

    // Graduate student-specific behavior
}

 class UndergraduateStudent extends Student {
    public UndergraduateStudent(String name, int id) {
        super(name, id);
    }

    // Undergraduate student-specific behavior
}
 interface CourseService {
    List<Student> getEnrolledStudents(Course course);
}
 class CourseServiceImpl implements CourseService {
    @Override
    public List<Student> getEnrolledStudents(Course course) {
        return course.getEnrolledStudents();
    }
}
