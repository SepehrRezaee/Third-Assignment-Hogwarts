import java.util.*;

public class Hogwarts {

   // Define Attributes
   private List<Teacher> teachers;
   private List<Student> students;
   private List<Course> courses;
   private List<Admin> admins;
   private Map<String, List<Student>> houseStudents;

   public Hogwarts() {
       teachers = new ArrayList<>();
       students = new ArrayList<>();
       courses = new ArrayList<>();
       admins = new ArrayList<>();
       houseStudents = new HashMap<>();
   }

   // Define Functionalities
   public void addTeacher(Teacher teacher) {
       teachers.add(teacher);
   }

   public void addStudent(Student student) {
       students.add(student);
       String house = student.getHouse();
       if (!houseStudents.containsKey(house)) {
           houseStudents.put(house, new ArrayList<>());
       }
       houseStudents.get(house).add(student);
   }

   public void addCourse(Course course) {
       courses.add(course);
   }

   public void addAdmin(Admin admin) {
       admins.add(admin);
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
           if (course.getUuid().equals(uuid)) {
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
           System.out.println(course.getName());
       }
   }
}
