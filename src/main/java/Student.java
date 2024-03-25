import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Student extends Account {
    private List<Course> courses;
    private String house;

    public Student(String name, String house) {
        super(name, "password");
        this.house = house;
        courses = new ArrayList<>();
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void addScore(Course course, int score) {
        // Implementation for adding score to a course
    }

    public void displayProfile() {
        System.out.println("Student: " + getName());
        System.out.println("House: " + house);
        System.out.println("Courses: ");
        for (Course course : courses) {
            System.out.println("- " + course.getTitle());
        }
    }

    public String getHouse() {
        return house;
    }

    public void viewWeeklySchedule() {
        System.out.println("Weekly Schedule for " + getName() + ":");
        for (Course course : courses) {
            System.out.println(course.getTitle());
        }
    }
}
