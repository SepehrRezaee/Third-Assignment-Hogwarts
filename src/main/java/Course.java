import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public class Course {
    private String title;
    private UUID courseID;
    private List<Student> students;
    private Teacher teacher;

    public Course(String title, Teacher teacher) {
        this.title = title;
        this.courseID = UUID.randomUUID();
        this.students = new ArrayList<>();
        this.teacher = teacher;
        teacher.addCourse(this); // Add the course to the teacher's list
    }

    public String getTitle() {
        return title;
    }

    public UUID getCourseID() {
        return courseID;
    }

    public List<Student> getStudents() {
        return students;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void addStudent(Student student) {
        students.add(student);
        student.addCourse(this);
    }

    public void sortStudentsByName() {
        Collections.sort(students, Comparator.comparing(Account::getName));
    }
}
