import java.util.ArrayList;
import java.util.List;

public abstract class Teacher extends Account {
    private String subject;
    private List<Course> courses;
    private List<Integer> ratings;
    private List<String> comments;

    public Teacher(String name, String subject) {
        super(name, "password");
        this.subject = subject;
        this.courses = new ArrayList<>();
        this.ratings = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void addRating(int rating, String comment) {
        ratings.add(rating);
        comments.add(comment);
    }
}
