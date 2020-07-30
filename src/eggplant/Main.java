package eggplant;
	
import eggplant.People.Janitor;
import eggplant.People.Person;
import eggplant.People.Student;
import eggplant.People.Teacher;
import eggplant.People.Info.Address;
import eggplant.People.Info.Name;
import eggplant.Dialogs.Confirm;
import eggplant.Dialogs.UserErrors;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.*;

import java.io.FileInputStream;
import java.util.*;

public class Main extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}

	private Stage window;
	private Scene scene;

	private Student student;
	private TableView<Student> studentTable;
	private ObservableList<Student> studentList;
	
	private Teacher teacher;
	private TableView<Teacher> teacherTable;
	private ObservableList<Teacher> teacherList;
	
	private Janitor janitor;
	private TableView<Janitor> janitorTable;
	private ObservableList<Janitor> janitorList;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage primaryStage) {
		try {
			// scene 1
			window = primaryStage;
			BorderPane pane = new BorderPane();
			scene = new Scene(pane, 1025, 620);
			
			// Observable Lists Initialized
			studentList = FXCollections.observableArrayList();
			teacherList = FXCollections.observableArrayList();
			janitorList = FXCollections.observableArrayList();
			
			// V Box Top Section
			VBox vboxTop = new VBox(10);
			vboxTop.setPadding(new Insets(10, 200, 10, 200));
			vboxTop.setAlignment(Pos.CENTER);
			
			// Program Title
			Label title = new Label("Eggplant University Database");
			title.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));			
			
			// Student Title
			Label studentLabel = new Label("Students");
			studentLabel.setFont(Font.font("Helvetica", FontWeight.NORMAL, 16));
			
			vboxTop.getChildren().addAll(title, studentLabel);
			
			// Teacher Title
			Label teacherLabel = new Label("Teachers");
			teacherLabel.setAlignment(Pos.CENTER);
			teacherLabel.setFont(Font.font("Helvetica", FontWeight.NORMAL, 16));
			
			// Janitor Title
			Label janitorLabel = new Label("Janitors");
			janitorLabel.setAlignment(Pos.CENTER);
			janitorLabel.setFont(Font.font("Helvetica", FontWeight.NORMAL, 16));

			// Student Table & Columns
			studentTable = new TableView<Student>();
			studentTable.setMaxSize(745, 500);
			
			TableColumn<Student, String> majorCol = new TableColumn<Student, String>("Major");
			majorCol.setPrefWidth(125);
			majorCol.setResizable(false);
			majorCol.setCellValueFactory(new PropertyValueFactory<Student, String>("major"));

			TableColumn<Student, Double> gpaCol = new TableColumn<Student, Double>("GPA");
			gpaCol.setPrefWidth(40);
			gpaCol.setResizable(false);
			gpaCol.setCellValueFactory(new PropertyValueFactory<Student, Double>("gpa"));

			TableColumn<Student, Integer> creditsCol = new TableColumn<Student, Integer>("Credits\nCompleted");
			creditsCol.setPrefWidth(80);
			creditsCol.setResizable(false);
			creditsCol.setCellValueFactory(new PropertyValueFactory<Student, Integer>("credits"));

			TableColumn<Student, Name> nameCol = new TableColumn<Student, Name>("Name");
			nameCol.setPrefWidth(140);
			nameCol.setResizable(false);
			nameCol.setCellValueFactory(new PropertyValueFactory<Student, Name>("name"));
			
			TableColumn<Student, String> dobCol = new TableColumn<Student, String>("Date of Birth");
			dobCol.setPrefWidth(85);
			dobCol.setResizable(false);
			dobCol.setCellValueFactory(new PropertyValueFactory<Student, String>("dob"));

			TableColumn<Student, Address> addressCol = new TableColumn<Student, Address>("Address");
			addressCol.setPrefWidth(160);
			addressCol.setResizable(false);
			addressCol.setCellValueFactory(new PropertyValueFactory<Student, Address>("address"));

			TableColumn<Student, String> genderCol = new TableColumn<Student, String>("Gender");
			genderCol.setPrefWidth(55);
			genderCol.setResizable(false);
			genderCol.setCellValueFactory(new PropertyValueFactory<Student, String>("gender"));

			TableColumn<Student, Boolean> smokerCol = new TableColumn<Student, Boolean>("Smoker");
			smokerCol.setPrefWidth(60);
			smokerCol.setResizable(false);
			smokerCol.setCellValueFactory(new PropertyValueFactory<Student, Boolean>("smoker"));

			studentTable.getColumns().addAll(nameCol, dobCol, addressCol, genderCol, majorCol, gpaCol, creditsCol, smokerCol);
			
			
			
			// Teacher Table & Columns
			teacherTable = new TableView<Teacher>();
			teacherTable.setMaxSize(780, 500);
			
			TableColumn<Teacher, String> subjectCol = new TableColumn<Teacher, String>("Subject");
			subjectCol.setPrefWidth(100);
			subjectCol.setResizable(false);
			subjectCol.setCellValueFactory(new PropertyValueFactory<Teacher, String>("subject"));

			TableColumn<Teacher, String> classesCol = new TableColumn<Teacher, String>("Number of\nClasses");
			classesCol.setPrefWidth(80);
			classesCol.setResizable(false);
			classesCol.setCellValueFactory(new PropertyValueFactory<Teacher, String>("numOfClasses"));

			TableColumn<Teacher, String> officeNumCol = new TableColumn<Teacher, String>("Office Number");
			officeNumCol.setPrefWidth(100);
			officeNumCol.setResizable(false);
			officeNumCol.setCellValueFactory(new PropertyValueFactory<Teacher, String>("officeNum"));

			TableColumn<Teacher, Name> nameCol2 = new TableColumn<Teacher, Name>("Name");
			nameCol2.setPrefWidth(140);
			nameCol2.setResizable(false);
			nameCol2.setCellValueFactory(new PropertyValueFactory<Teacher, Name>("name"));
			
			TableColumn<Teacher, String> dobCol2 = new TableColumn<Teacher, String>("Date of Birth");
			dobCol2.setPrefWidth(85);
			dobCol2.setResizable(false);
			dobCol2.setCellValueFactory(new PropertyValueFactory<Teacher, String>("dob"));

			TableColumn<Teacher, Address> addressCol2 = new TableColumn<Teacher, Address>("Address");
			addressCol2.setPrefWidth(160);
			addressCol2.setResizable(false);
			addressCol2.setCellValueFactory(new PropertyValueFactory<Teacher, Address>("address"));

			TableColumn<Teacher, String> genderCol2 = new TableColumn<Teacher, String>("Gender");
			genderCol2.setPrefWidth(55);
			genderCol2.setResizable(false);
			genderCol2.setCellValueFactory(new PropertyValueFactory<Teacher, String>("gender"));

			TableColumn<Teacher, Boolean> smokerCol2 = new TableColumn<Teacher, Boolean>("Smoker");
			smokerCol2.setPrefWidth(60);
			smokerCol2.setResizable(false);
			smokerCol2.setCellValueFactory(new PropertyValueFactory<Teacher, Boolean>("smoker"));
			
			teacherTable.getColumns().addAll(nameCol2, dobCol2, addressCol2, genderCol2, subjectCol, classesCol, officeNumCol, smokerCol2);
			
			
			
			// Janitor Table & Columns
			janitorTable = new TableView<Janitor>();
			janitorTable.setMaxSize(650, 500);
			
			TableColumn<Janitor, String> yrsWorkedCol = new TableColumn<Janitor, String>("Years of\nService");
			yrsWorkedCol.setPrefWidth(70);
			yrsWorkedCol.setResizable(false);
			yrsWorkedCol.setCellValueFactory(new PropertyValueFactory<Janitor, String>("yearsOfService"));

			TableColumn<Janitor, String> payCol = new TableColumn<Janitor, String>("Rate of Pay");
			payCol.setPrefWidth(80);
			payCol.setResizable(false);
			payCol.setCellValueFactory(new PropertyValueFactory<Janitor, String>("hourlyWage"));

			TableColumn<Janitor, Name> nameCol3 = new TableColumn<Janitor, Name>("Name");
			nameCol3.setPrefWidth(140);
			nameCol3.setResizable(false);
			nameCol3.setCellValueFactory(new PropertyValueFactory<Janitor, Name>("name"));
			
			TableColumn<Janitor, String> dobCol3 = new TableColumn<Janitor, String>("Date of Birth");
			dobCol3.setPrefWidth(85);
			dobCol3.setResizable(false);
			dobCol3.setCellValueFactory(new PropertyValueFactory<Janitor, String>("dob"));

			TableColumn<Janitor, Address> addressCol3 = new TableColumn<Janitor, Address>("Address");
			addressCol3.setPrefWidth(160);
			addressCol3.setResizable(false);
			addressCol3.setCellValueFactory(new PropertyValueFactory<Janitor, Address>("address"));

			TableColumn<Janitor, String> genderCol3 = new TableColumn<Janitor, String>("Gender");
			genderCol3.setPrefWidth(55);
			genderCol3.setResizable(false);
			genderCol3.setCellValueFactory(new PropertyValueFactory<Janitor, String>("gender"));

			TableColumn<Janitor, Boolean> smokerCol3 = new TableColumn<Janitor, Boolean>("Smoker");
			smokerCol3.setPrefWidth(60);
			smokerCol3.setResizable(false);
			smokerCol3.setCellValueFactory(new PropertyValueFactory<Janitor, Boolean>("smoker"));
			
			janitorTable.getColumns().addAll(nameCol3, dobCol3, addressCol3, genderCol3, yrsWorkedCol, payCol, smokerCol3);
			
			// H Box Bottom Section
			HBox hboxBottom = new HBox(10);
			hboxBottom.setPadding(new Insets(10, 200, 10, 200));
			
			// Create Button
			Button createBtn = new Button("Create Student Entry");
			createBtn.setMaxWidth(Double.MAX_VALUE);
			createBtn.setOnAction(e -> {
				if (pane.getCenter() == studentTable) {
					Entry st = new Entry();
					student = (Student) st.createEntry("Student");
					if (!(student == null)) {
						studentList.add(student);
						studentTable.setItems(studentList);
					}
				} else if (pane.getCenter() == teacherTable) {
					Entry te = new Entry();
					te.createEntry("Teacher");
					teacher = (Teacher) te.getTeacher();
					if (!(teacher == null)) {
						teacherList.add(teacher);
						teacherTable.setItems(teacherList);
					}
				} else if (pane.getCenter() == janitorTable) {
					Entry ja = new Entry();
					ja.createEntry("Janitor");
					janitor = (Janitor) ja.getJanitor();
					if (!(janitor == null)) {
						janitorList.add(janitor);
						janitorTable.setItems(janitorList);
					}
				}
			});

			// Edit Button
			Button editBtn = new Button("Edit Student Entry");
			editBtn.setMaxWidth(Double.MAX_VALUE);
			editBtn.setOnAction(e -> {
				if (pane.getCenter() == studentTable) {
					if (studentTable.getSelectionModel().getSelectedItem() == null) {
						UserErrors.userErrors("Must Select an Entry to Edit", 200, 100);
					} else {
						Edit editStudent = new Edit();
						int index = studentTable.getSelectionModel().getSelectedIndex();
						student = studentTable.getSelectionModel().getSelectedItem();	
						student = (Student) editStudent.editEntry(student);
						studentList.set(index, student);							
						studentTable.setItems(studentList);
					}
				} else if (pane.getCenter() == teacherTable) {
					if (teacherTable.getSelectionModel().getSelectedItem() == null) {
						UserErrors.userErrors("Must Select an Entry to Edit", 200, 100);
					} else {
						Edit editTeacher = new Edit();
						int index = teacherTable.getSelectionModel().getSelectedIndex();
						teacher = teacherTable.getSelectionModel().getSelectedItem();	
						teacher = (Teacher) editTeacher.editEntry(teacher);
						teacherList.set(index, teacher);
						teacherTable.setItems(teacherList);
					}
				} else if (pane.getCenter() == janitorTable) {
					if (janitorTable.getSelectionModel().getSelectedItem() == null) {
						UserErrors.userErrors("Must Select an Entry to Edit", 200, 100);
					} else {
						Edit editJanitor = new Edit();
						int index = janitorTable.getSelectionModel().getSelectedIndex();
						janitor = janitorTable.getSelectionModel().getSelectedItem();	
						janitor = (Janitor) editJanitor.editEntry(janitor);
						janitorList.set(index, janitor);
						janitorTable.setItems(janitorList);
					}
				}
			});
			
			// Delete Button
			Button deleteBtn = new Button("Delete Student Entry");
			deleteBtn.setMaxWidth(Double.MAX_VALUE);
			deleteBtn.setOnAction(e -> {
				if (pane.getCenter() == studentTable) {
					if (studentTable.getSelectionModel().getSelectedItem() == null) {
						UserErrors.userErrors("Must Select an Entry to Delete", 200, 100);
					} else {
						studentTable.getItems().remove(studentTable.getSelectionModel().getSelectedItem());
					}
				} else if (pane.getCenter() == teacherTable) {
					if (teacherTable.getSelectionModel().getSelectedItem() == null) {
						UserErrors.userErrors("Must Select an Entry to Delete", 200, 100);
					} else {
						teacherTable.getItems().remove(teacherTable.getSelectionModel().getSelectedItem());
					}
				} else if (pane.getCenter() == janitorTable) {
					if (janitorTable.getSelectionModel().getSelectedItem() == null) {
						UserErrors.userErrors("Must Select an Entry to Delete", 200, 100);
					} else {
						janitorTable.getItems().remove(janitorTable.getSelectionModel().getSelectedItem());
					}
				}
			});
			
			// Create Report Button
			Button reportBtn = new Button("Create Student Report");
			reportBtn.setMaxWidth(Double.MAX_VALUE);
			reportBtn.setOnAction(e -> {
				if (pane.getCenter() == studentTable) {
					Report studentReport = new Report();
					studentReport.createStudentReport(studentList);
				} else if (pane.getCenter() == teacherTable) {
					Report teacherReport = new Report();
					teacherReport.createTeacherReport(teacherList);
				} else if (pane.getCenter() == janitorTable) {
					Report janitorReport = new Report();
					janitorReport.createJanitorReport(janitorList);
				}
			});
			
			hboxBottom.getChildren().addAll(createBtn, editBtn, deleteBtn, reportBtn);
			
			// Left Menu
			VBox leftMenu = new VBox(10);
			leftMenu.setPadding(new Insets(25, 10, 0, 10));
			
			// View Student Table Button
			Button viewStudentBtn = new Button("View Student Table");
			viewStudentBtn.setMaxWidth(Double.MAX_VALUE);
			viewStudentBtn.setOnAction(e -> {
				vboxTop.getChildren().clear();
				vboxTop.getChildren().addAll(title, studentLabel);
				pane.setCenter(studentTable);
				createBtn.setText("Create Student Entry");
				editBtn.setText("Edit Student Entry");
				deleteBtn.setText("Delete Student Entry");
				reportBtn.setText("Create Student Report");
			});
			
			// View Teacher Table Button
			Button viewTeacherBtn = new Button("View Teacher Table");
			viewTeacherBtn.setMaxWidth(Double.MAX_VALUE);
			viewTeacherBtn.setOnAction(e -> {
				vboxTop.getChildren().clear();
				vboxTop.getChildren().addAll(title, teacherLabel);
				pane.setCenter(teacherTable);
				createBtn.setText("Create Teacher Entry");
				editBtn.setText("Edit Teacher Entry");
				deleteBtn.setText("Delete Teacher Entry");
				reportBtn.setText("Create Teacher Report");
			});
			
			// View Janitor Table Button
			Button viewJanitorBtn = new Button("View Janitor Table");
			viewJanitorBtn.setMaxWidth(Double.MAX_VALUE);
			viewJanitorBtn.setOnAction(e -> {
				vboxTop.getChildren().clear();
				vboxTop.getChildren().addAll(title, janitorLabel);
				pane.setCenter(janitorTable);
				createBtn.setText("Create Janitor Entry");
				editBtn.setText("Edit Janitor Entry");
				deleteBtn.setText("Delete Janitor Entry");
				reportBtn.setText("Create Janitor Entry");
			});
	
			ImageView studentImg = new ImageView("https://pbs.twimg.com/profile_images/1082504730809532416/50eYmHlJ_400x400.jpg");		
			studentImg.setFitHeight(200); 
			studentImg.setFitWidth(200); 
			
			leftMenu.getChildren().addAll(viewStudentBtn, viewTeacherBtn, viewJanitorBtn, studentImg);
			
			window.setOnCloseRequest(e -> {
				e.consume();
				boolean answer = Confirm.confirm("Close", "Are you sure you want to close program?");
				if (answer) {
					window.close();
				}
			});
			
			// initial scene set
			pane.setTop(vboxTop);
			pane.setLeft(leftMenu);
			pane.setCenter(studentTable);
			pane.setBottom(hboxBottom);
			window.setTitle("EggplantDB");
			window.setScene(scene);
			window.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}	
	
}
