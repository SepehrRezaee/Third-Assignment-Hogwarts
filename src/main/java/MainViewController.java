import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

public class MainViewController {
    private Hogwarts hogwarts;

    @FXML
    private ListView<String> teachersListView;

    @FXML
    private ListView<String> studentsListView;

    @FXML
    private ListView<String> coursesListView;

    @FXML
    private TextArea teacherDetailsTextArea;

    @FXML
    private TextArea studentDetailsTextArea;

    public void setHogwarts(Hogwarts hogwarts) {
        this.hogwarts = hogwarts;
        populateListViews();
    }

    private void populateListViews() {
        teachersListView.getItems().clear();
        studentsListView.getItems().clear();
        coursesListView.getItems().clear();

        for (Teacher teacher : hogwarts.getTeachers()) {
            teachersListView.getItems().add(teacher.getName());
        }

        for (Student student : hogwarts.getStudents()) {
            studentsListView.getItems().add(student.getName());
        }

        for (Course course : hogwarts.getCourses()) {
            coursesListView.getItems().add(course.getTitle());
        }
    }

    @FXML
    private void sortStudentsByName() {
        int selectedIndex = coursesListView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            Course selectedCourse = hogwarts.getCourses().get(selectedIndex);
            selectedCourse.sortStudentsByName();
            populateListViews();
        } else {
            showAlert("Please select a course first.");
        }
    }

    @FXML
    private void viewWeeklySchedule() {
        int selectedIndex = studentsListView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            Student selectedStudent = hogwarts.getStudents().get(selectedIndex);
            selectedStudent.viewWeeklySchedule();
        } else {
            showAlert("Please select a student first.");
        }
    }

    @FXML
    private void showTeacherDetails() {
        int selectedIndex = teachersListView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            Teacher selectedTeacher = hogwarts.getTeachers().get(selectedIndex);
            StringBuilder sb = new StringBuilder();
            sb.append("Name: ").append(selectedTeacher.getName()).append("\n");
            sb.append("Subject: ").append(selectedTeacher.getSubject()).append("\n");
            sb.append("Courses:");
            for (Course course : selectedTeacher.getCourses()) {
                sb.append("\n- ").append(course.getTitle());
            }
            teacherDetailsTextArea.setText(sb.toString());
        } else {
            showAlert("Please select a teacher first.");
        }
    }

    @FXML
    private void showStudentDetails() {
        int selectedIndex = studentsListView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            Student selectedStudent = hogwarts.getStudents().get(selectedIndex);
            StringBuilder sb = new StringBuilder();
            sb.append("Name: ").append(selectedStudent.getName()).append("\n");
            sb.append("House: ").append(selectedStudent.getHouse()).append("\n");
            sb.append("Courses:");
            for (Course course : selectedStudent.getCourses()) {
                sb.append("\n- ").append(course.getTitle());
            }
            studentDetailsTextArea.setText(sb.toString());
        } else {
            showAlert("Please select a student first.");
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
