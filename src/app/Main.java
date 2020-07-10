package app;
	
import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.control.*;
import javafx.geometry.*;
//import javafx.event.EventHandler;
//import javafx.event.ActionEvent;

//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
public class Main extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}

	Stage window1, window2;
	Scene scene1, scene2;
	VBox entryVbox;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			// scene 1
			window1 = primaryStage;
			BorderPane pane = new BorderPane();
			scene1 = new Scene(pane, 800, 500);
			
			// h box top
			HBox hboxTop = new HBox(10);
			hboxTop.setPadding(new Insets(10, 200, 10, 200));
			Label title = new Label("Eggplant Database");
			hboxTop.getChildren().add(title);			
			
//			Button entryBtn = new Button("Make an Entry");
//			Button reportBtn = new Button("Send Report");
//			entryBtn.setMaxWidth(Double.MAX_VALUE);
//			reportBtn.setMaxWidth(Double.MAX_VALUE);
//			leftMenu.getChildren().addAll(entryBtn, reportBtn);
//			
//			entryBtn.setOnAction(e -> window.setScene(scene2));
			
			// center menu
			Label studentLbl = new Label("Students");
			Label teacherLbl = new Label("Teachers");
			Label janitorLbl = new Label("Janitors");
			
			// person columns
			TableColumn nameCol = new TableColumn("Name");
			TableColumn dobCol = new TableColumn("Date of Birth");
			TableColumn addressCol = new TableColumn("Address");
			TableColumn genderCol = new TableColumn("Gender");
			TableColumn smokerCol = new TableColumn("Smoker Status");
			
			// student columns
			TableView<Person> studentTable = new TableView<Person>();
			TableColumn majorCol = new TableColumn("Major");
			TableColumn gpaCol = new TableColumn("GPA");
			TableColumn creditsCol = new TableColumn("Credits Completed");
			studentTable.getColumns().addAll(nameCol, dobCol, addressCol, genderCol, majorCol, gpaCol, creditsCol, smokerCol);
			
			// teacher columns
			TableView teacherTable = new TableView();
			TableColumn subjectCol = new TableColumn("Subject");
			TableColumn classesCol = new TableColumn("Number of Classes");
			TableColumn officeNumCol = new TableColumn("Office Number");
			teacherTable.getColumns().addAll(nameCol, dobCol, addressCol, genderCol, subjectCol, classesCol, officeNumCol, smokerCol);
			
			// janitor columns
			TableView janitorTable = new TableView();
			TableColumn yrsWorkedCol = new TableColumn("Years of Service");
			TableColumn payCol = new TableColumn("Rate of Pay");
			janitorTable.getColumns().addAll(nameCol, dobCol, addressCol, genderCol, yrsWorkedCol, payCol, smokerCol);
			
			// table layouts
			VBox studentVbox = new VBox(10);
			studentVbox.getChildren().addAll(studentLbl, studentTable);
			
			VBox teacherVbox = new VBox(10);
			teacherVbox.getChildren().addAll(teacherLbl, teacherTable);
			
			VBox janitorVbox = new VBox(10);
			janitorVbox.getChildren().addAll(janitorLbl, janitorTable);
			
//			VBox centerMenu = new VBox(10);
//			centerMenu.setPadding(new Insets(25, 150, 0, 150));
//			Button teacherBtn = new Button("Teachers");
//			Button studentBtn = new Button("Students");
//			Button janitorBtn = new Button("Janitors");
//			teacherBtn.setMaxWidth(Double.MAX_VALUE);
//			studentBtn.setMaxWidth(Double.MAX_VALUE);
//			janitorBtn.setMaxWidth(Double.MAX_VALUE);
//			centerMenu.getChildren().addAll(teacherBtn, studentBtn, janitorBtn);
			
			// left menu
			VBox leftMenu = new VBox(10);
			leftMenu.setPadding(new Insets(25, 10, 0, 10));
			
			Button viewStudentBtn = new Button("View Student Table");
			viewStudentBtn.setMaxWidth(Double.MAX_VALUE);
			viewStudentBtn.setOnAction(e -> pane.setCenter(studentVbox));
			
			Button viewTeacherBtn = new Button("View Teacher Table");
			viewTeacherBtn.setMaxWidth(Double.MAX_VALUE);
			viewTeacherBtn.setOnAction(e -> pane.setCenter(teacherVbox));
			
			Button viewJanitorBtn = new Button("View Janitor Table");
			viewJanitorBtn.setMaxWidth(Double.MAX_VALUE);
			viewJanitorBtn.setOnAction(e -> pane.setCenter(janitorVbox));
			
			leftMenu.getChildren().addAll(viewStudentBtn, viewTeacherBtn, viewJanitorBtn);
			
			// h box bottom
			HBox hboxBottom = new HBox(10);
			hboxBottom.setPadding(new Insets(10, 200, 10, 200));
			
			Button createBtn = new Button("Create");
			createBtn.setMaxWidth(Double.MAX_VALUE);
			createBtn.setOnAction(e -> {
				if (pane.getCenter() == studentVbox) {
					createEntry("Student");
				} else if (pane.getCenter() == teacherVbox) {
					createEntry("Teacher");
				} else if (pane.getCenter() == janitorVbox) {
					createEntry("Janitor");
				} else {
					error();
				}
				
//				entryVbox = new VBox(10);
//				scene2 = new Scene(entryVbox, 400, 600);
//				window2 = new Stage();
//				window2.setTitle("Create Entry");
//				window2.setScene(scene2);
//				window2.initModality(Modality.APPLICATION_MODAL);
//				window2.show();
			});
			
			Button editBtn = new Button("Edit");
			editBtn.setMaxWidth(Double.MAX_VALUE);
			Button deleteBtn = new Button("Delete");
			deleteBtn.setMaxWidth(Double.MAX_VALUE);
			hboxBottom.getChildren().addAll(createBtn, editBtn, deleteBtn);
			
			// scene 2
			VBox entryMenu = new VBox(10);
			entryMenu.setPadding(new Insets(0, 200, 0, 200));
			scene2 = new Scene(entryMenu, 500, 400);
			
			Label label1 = new Label("Entry");
			label1.setMaxWidth(Double.MAX_VALUE);
			label1.setAlignment(Pos.CENTER);
			
			Label fnLabel = new Label("Enter First Name");
			fnLabel.setMaxWidth(Double.MAX_VALUE);
			fnLabel.setAlignment(Pos.CENTER);
			
			TextField fnField = new TextField();
			fnField.setMaxWidth(Double.MAX_VALUE);
			fnField.setAlignment(Pos.CENTER);
			fnField.setPromptText("First Name");
			
			Label lnLabel = new Label("Enter Last Name");
			lnLabel.setMaxWidth(Double.MAX_VALUE);
			lnLabel.setAlignment(Pos.CENTER);
			
			TextField lnField = new TextField();
			lnField.setMaxWidth(Double.MAX_VALUE);
			lnField.setAlignment(Pos.CENTER);
			lnField.setPromptText("Last Name");
			
			Button submit = new Button("Submit");
			submit.setMaxWidth(Double.MAX_VALUE);
			submit.setAlignment(Pos.CENTER);
			submit.setOnAction(e -> {
				boolean bool = submit(fnField, lnField, fnField.getText(), lnField.getText());
				if (bool) {
					System.out.println("First Name: " + fnField.getText());
					System.out.println("Last Name: " + lnField.getText());
				} else {
					System.out.println("Error: Letters Only");
				}
			});
			
			Button backBtn = new Button("Back");
			backBtn.setMaxWidth(Double.MAX_VALUE);
			backBtn.setAlignment(Pos.CENTER);
			backBtn.setOnAction(e -> window1.setScene(scene1));
			
			entryMenu.getChildren().addAll(label1, fnLabel, fnField, lnLabel, lnField, submit, backBtn);
			
				
			
			
//			window.setOnCloseRequest(e -> {
//				e.consume();
//				closeWindow();
//			});
			
			// initial scene set
			pane.setTop(hboxTop);
			pane.setLeft(leftMenu);
//			pane.setCenter(studentTable);
			pane.setBottom(hboxBottom);
			window1.setTitle("EggplantDB");
			window1.setScene(scene1);
			window1.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void createEntry(String table) {
		ScrollBar scroll = new ScrollBar();
		entryVbox = new VBox(10);
		
		Label label1 = new Label("Entry");
		label1.setMaxWidth(Double.MAX_VALUE);
		label1.setAlignment(Pos.CENTER);
		
		// first name
		Label fnLabel = new Label("First Name:");
		fnLabel.setMaxWidth(Double.MAX_VALUE);
		fnLabel.setAlignment(Pos.CENTER);
		TextField fnField = new TextField();
		fnField.setMaxWidth(Double.MAX_VALUE);
		fnField.setAlignment(Pos.CENTER);
		fnField.setPromptText("First Name");
		
		// middle initial
		Label miLabel = new Label("Middle Initial:");
		miLabel.setMaxWidth(Double.MAX_VALUE);
		miLabel.setAlignment(Pos.CENTER);
		TextField miField = new TextField();
		miField.setMaxWidth(Double.MAX_VALUE);
		miField.setAlignment(Pos.CENTER);
		miField.setPromptText("Middle Initial");
		
		// last name
		Label lnLabel = new Label("Enter Last Name:");
		lnLabel.setMaxWidth(Double.MAX_VALUE);
		lnLabel.setAlignment(Pos.CENTER);
		TextField lnField = new TextField();
		lnField.setMaxWidth(Double.MAX_VALUE);
		lnField.setAlignment(Pos.CENTER);
		lnField.setPromptText("Last Name");
		
		// date of birth
		Label dobLabel = new Label("Date of Birth:");
		dobLabel.setMaxWidth(Double.MAX_VALUE);
		dobLabel.setAlignment(Pos.CENTER);
		TextField dobField = new TextField();
		dobField.setMaxWidth(Double.MAX_VALUE);
		dobField.setAlignment(Pos.CENTER);
		dobField.setPromptText("Date of Birth");
		
		// gender
		Label genderLabel = new Label("Gender:");
		genderLabel.setMaxWidth(Double.MAX_VALUE);
		genderLabel.setAlignment(Pos.CENTER);
		TextField genderField = new TextField();
		genderField.setMaxWidth(Double.MAX_VALUE);
		genderField.setAlignment(Pos.CENTER);
		genderField.setPromptText("Gender");
		
		// address
		Label streetNumLabel = new Label("Street Number:");
		streetNumLabel.setMaxWidth(Double.MAX_VALUE);
		streetNumLabel.setAlignment(Pos.CENTER);
		TextField streetNumField = new TextField();
		streetNumField.setMaxWidth(Double.MAX_VALUE);
		streetNumField.setAlignment(Pos.CENTER);
		streetNumField.setPromptText("Street Number");
		
		Label streetNameLabel = new Label("Street Name:");
		streetNameLabel.setMaxWidth(Double.MAX_VALUE);
		streetNameLabel.setAlignment(Pos.CENTER);
		TextField streetNameField = new TextField();
		streetNameField.setMaxWidth(Double.MAX_VALUE);
		streetNameField.setAlignment(Pos.CENTER);
		streetNameField.setPromptText("Street Name");
		
		Label streetTypeLabel = new Label("Street Field:");
		streetTypeLabel.setMaxWidth(Double.MAX_VALUE);
		streetTypeLabel.setAlignment(Pos.CENTER);
		TextField streetTypeField = new TextField();
		streetTypeField.setMaxWidth(Double.MAX_VALUE);
		streetTypeField.setAlignment(Pos.CENTER);
		streetTypeField.setPromptText("Street Field");
		
		Label cityLabel = new Label("City:");
		cityLabel.setMaxWidth(Double.MAX_VALUE);
		cityLabel.setAlignment(Pos.CENTER);
		TextField cityField = new TextField();
		cityField.setMaxWidth(Double.MAX_VALUE);
		cityField.setAlignment(Pos.CENTER);
		cityField.setPromptText("City");
		
		Label stateLabel = new Label("State:");
		stateLabel.setMaxWidth(Double.MAX_VALUE);
		stateLabel.setAlignment(Pos.CENTER);
		TextField stateField = new TextField();
		stateField.setMaxWidth(Double.MAX_VALUE);
		stateField.setAlignment(Pos.CENTER);
		stateField.setPromptText("State");
		
		Label zipLabel = new Label("Zip Code:");
		zipLabel.setMaxWidth(Double.MAX_VALUE);
		zipLabel.setAlignment(Pos.CENTER);
		TextField zipField = new TextField();
		zipField.setMaxWidth(Double.MAX_VALUE);
		zipField.setAlignment(Pos.CENTER);
		zipField.setPromptText("Zip Code");
		
		Label smokerLabel = new Label("Smoker Status:");
		smokerLabel.setMaxWidth(Double.MAX_VALUE);
		smokerLabel.setAlignment(Pos.CENTER);
		TextField smokerField = new TextField();
		smokerField.setMaxWidth(Double.MAX_VALUE);
		smokerField.setAlignment(Pos.CENTER);
		smokerField.setPromptText("Smoker Status");
		
		if (table.equals("Student")) {
			Label majorLabel = new Label("Major:");
			majorLabel.setMaxWidth(Double.MAX_VALUE);
			majorLabel.setAlignment(Pos.CENTER);
			TextField majorField = new TextField();
			majorField.setMaxWidth(Double.MAX_VALUE);
			majorField.setAlignment(Pos.CENTER);
			majorField.setPromptText("Major");
			
			Label gpaLabel = new Label("GPA:");
			gpaLabel.setMaxWidth(Double.MAX_VALUE);
			gpaLabel.setAlignment(Pos.CENTER);
			TextField gpaField = new TextField();
			gpaField.setMaxWidth(Double.MAX_VALUE);
			gpaField.setAlignment(Pos.CENTER);
			gpaField.setPromptText("GPA");
			
			Label creditsLabel = new Label("Credits Completed:");
			creditsLabel.setMaxWidth(Double.MAX_VALUE);
			creditsLabel.setAlignment(Pos.CENTER);
			TextField creditsField = new TextField();
			creditsField.setMaxWidth(Double.MAX_VALUE);
			creditsField.setAlignment(Pos.CENTER);
			creditsField.setPromptText("Credits Completed");
			
			entryVbox.getChildren().addAll(label1, fnLabel, fnField, miLabel, miField, lnLabel, lnField, dobLabel, dobField, genderLabel, genderField, 
					streetNumLabel, streetNumField, streetTypeLabel, streetTypeField, cityLabel, cityField, stateLabel, stateField, zipLabel, zipField,
					majorLabel, majorField, gpaLabel, gpaField, creditsLabel, creditsField, smokerLabel, smokerField);
		}
		
		
		
		scene2 = new Scene(entryVbox, 500, 400);
		window2 = new Stage();
		window2.setTitle("Create Entry");
		window2.setScene(scene2);
		window2.initModality(Modality.APPLICATION_MODAL);
		window2.show();
	}
	
	private boolean submit(TextField input1, TextField input2, String text1, String text2) {
		boolean result;
		
		try {
			Integer.parseInt(text1);
			Integer.parseInt(text2);

			Double.parseDouble(text1);
			Double.parseDouble(text2);
			
			System.out.println("Error: Letters Only");
			result = false;
		} catch (Exception e) {
			result = true;
		}
		
		return result;
	}

	public void closeWindow() {
		boolean answer = Confirm.confirm("Close", "Are you sure you want to close program?");
		if (answer) {
			window1.close();
		}
	}
	
	public void error() {
		Label message = new Label("ERROR:\nPlease Select a Table");
		message.setFont(new Font("Helvetica", 24));
		StackPane stack = new StackPane();
		stack.getChildren().add(message);
		scene2 = new Scene(stack, 250, 100);
		window2 = new Stage();
		window2.initModality(Modality.APPLICATION_MODAL);
		window2.setTitle("ERROR");
		window2.setScene(scene2);
		window2.show();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
