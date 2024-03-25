import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Hogwarts {
    private List<Teacher> teachers;
    private List<Student> students;
    private List<Course> courses;
    private List<Assistant> assistants;
    private List<Admin> admins;
    private Map<String, List<Student>> houseStudents;

    public Hogwarts() {
        teachers = new ArrayList<>();
        students = new ArrayList<>();
        courses = new ArrayList<>();
        assistants = new ArrayList<>();
        admins = new ArrayList<>();
        houseStudents = new HashMap<>();

        // Add some dummy data for demonstration
        Teacher teacher1 = new Teacher("Severus Snape", "Potions");
        Teacher teacher2 = new Teacher("Minerva McGonagall", "Transfiguration");
        teachers.add(teacher1);
        teachers.add(teacher2);

        Student student1 = new Student("Harry Potter", "Gryffindor");
        Student student2 = new Student("Hermione Granger", "Gryffindor");
        students.add(student1);
        students.add(student2);

        Course course1 = new Course("Potions", teacher1);
        Course course2 = new Course("Transfiguration", teacher2);
        course1.addStudent(student1);
        course1.addStudent(student2);
        course2.addStudent(student1);
        courses.add(course1);
        courses.add(course2);

        Assistant assistant1 = new Assistant("Albus Dumbledore");
        assistants.add(assistant1);

        Admin admin1 = new Admin("Minerva McGonagall");
        admins.add(admin1);

        addStudent(student1);
        addStudent(student2);
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public List<Assistant> getAssistants() {
        return assistants;
    }

    public List<Admin> getAdmins() {
        return admins;
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public void removeTeacher(Teacher teacher) {
        teachers.remove(teacher);
    }

    public void addStudent(Student student) {
        students.add(student);
        String house = student.getHouse();
        if (!houseStudents.containsKey(house)) {
            houseStudents.put(house, new ArrayList<>());
        }
        houseStudents.get(house).add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
        String house = student.getHouse();
        houseStudents.get(house).remove(student);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void removeCourse(Course course) {
        courses.remove(course);
    }

    public void addAdmin(Admin admin) {
        admins.add(admin);
    }

    public void removeAdmin(Admin admin) {
        admins.remove(admin);
    }

    public void rateTeacher(Teacher teacher, int rating, String comment) {
        teacher.addRating(rating, comment);
    }

    public void viewStudentProfile(Student student) {
        student.displayProfile();
    }

    public void requestCourse(Student student, Course course) {
        student.addCourse(course);
    }

    public void submitScore(Student student, Course course, int score) {
        student.addScore(course, score);
    }

    public void teacherRequestCourse(Teacher teacher, Course course) {
        teacher.addCourse(course);
    }

    public void studentRateTeacher(Student student, Teacher teacher, int rating, String comment) {
        teacher.addRating(rating, comment);
    }

    public Course getCourseByUUID(UUID uuid) {
        for (Course course : courses) {
            if (course.getCourseID().equals(uuid)) {
                return course;
            }
        }
        return null;
    }

    public void viewAllTeachers() {
        System.out.println("All Teachers:");
        for (Teacher teacher : teachers) {
            System.out.println(teacher.getName());
        }
    }

    public void viewAllStudents() {
        System.out.println("All Students:");
        for (Student student : students) {
            System.out.println(student.getName());
        }
    }

    public void viewAllCourses() {
        System.out.println("All Courses:");
        for (Course course : courses) {
            System.out.println(course.getTitle());
        }
    }
}
