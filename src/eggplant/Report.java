package eggplant;

import java.io.*;

import eggplant.Dialogs.UserErrors;
import eggplant.People.Janitor;
import eggplant.People.Student;
import eggplant.People.Teacher;

import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Report {
	
	private String reportType;
	
	public String chooseReport(String personType) {
		
		try {
			Stage stage = new Stage();
			VBox vbox1 = new VBox(15);
			vbox1.setAlignment(Pos.CENTER);
			Scene scene1 = new Scene(vbox1, 250, 200);
			Label label1 = new Label("Please Choose a Report Type");
			Button confirmBtn = new Button("Confirm");
			
			
			
			if (personType.equals("Student")) {
				ToggleGroup radioGroup = new ToggleGroup();
				RadioButton gpaReportBtn = new RadioButton("GPA Report");
				RadioButton creditsReportBtn = new RadioButton("Credits Report");
				
				gpaReportBtn.setToggleGroup(radioGroup);
				creditsReportBtn.setToggleGroup(radioGroup);

				confirmBtn.setOnAction(e -> {
					if (gpaReportBtn.isSelected()) {
						reportType = gpaReportBtn.getText();
						stage.close();
					} else if (creditsReportBtn.isSelected()) {
						reportType = creditsReportBtn.getText();
						stage.close();
					} else {
						UserErrors.userErrors("Please Make a Selection", 250, 150);
					}			
				});
				
				vbox1.getChildren().addAll(label1, gpaReportBtn, creditsReportBtn, confirmBtn);
				
			} else if (personType.equals("Teacher")) {
				ToggleGroup radioGroup = new ToggleGroup();
				RadioButton classesReportBtn = new RadioButton("Classes Taught Report");
				RadioButton smokerReportBtn = new RadioButton("Smoker Status Report");
				
				classesReportBtn.setToggleGroup(radioGroup);
				smokerReportBtn.setToggleGroup(radioGroup);
				
				confirmBtn.setOnAction(e -> {
					if (classesReportBtn.isSelected()) {
						reportType = classesReportBtn.getText();
						stage.close();
					} else if (smokerReportBtn.isSelected()) {
						reportType = smokerReportBtn.getText();
						stage.close();
					} else {
						UserErrors.userErrors("Please Make a Selection", 250, 150);
					}
				});
				
				vbox1.getChildren().addAll(label1, classesReportBtn, smokerReportBtn, confirmBtn);
				
			} else if (personType.equals("Janitor")) {
				ToggleGroup radioGroup = new ToggleGroup();
				RadioButton yearsReportBtn = new RadioButton("Years of Service Report");
				RadioButton payReportBtn = new RadioButton("Rate of Pay Report");
				
				yearsReportBtn.setToggleGroup(radioGroup);
				payReportBtn.setToggleGroup(radioGroup);
				
				confirmBtn.setOnAction(e -> {
					if (yearsReportBtn.isSelected()) {
						reportType = yearsReportBtn.getText();
						stage.close();
					} else if (payReportBtn.isSelected()) {
						reportType = payReportBtn.getText();
						stage.close();
					} else {
						UserErrors.userErrors("Please Make a Selection", 250, 150);
					}
				});
				
				vbox1.getChildren().addAll(label1, yearsReportBtn, payReportBtn, confirmBtn);
				
			}
					
			stage.setTitle("Report");
			stage.setScene(scene1);
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.showAndWait();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return reportType;
	}
	
	public void createStudentReport(ObservableList<Student> list) {

		try {
			String type = chooseReport("Student");
			
			Stage stage = new Stage();
			VBox vbox = new VBox(15);
			vbox.setAlignment(Pos.CENTER);
			Scene scene = new Scene(vbox, 350, 300);
			
			TextArea text = new TextArea();
			text.setEditable(false);
			
			Button sendBtn = new Button("Send Report to Text File");
			
			// GPA Report
			if (type.equals("GPA Report")) {
				Label label = new Label("GPA Report");
				
				Student highestGpa = new Student();
				highestGpa.setGpa(0);			
				for (int i = 0; i < list.size(); i++) {
					if (highestGpa.equals(list.get(i), "gpa")) {
						highestGpa = list.get(i);
					}
				}
				
				Student lowestGpa = new Student();
				lowestGpa.setGpa(5);
				for (int i = 0; i < list.size(); i++) {
					if (!lowestGpa.equals(list.get(i), "gpa")) {
						lowestGpa = list.get(i);
					}
				}	
				
				double avgGpa = 0;
				int counter = 0;
				for (Student item : list) {
					avgGpa += item.getGpa();
					counter++;
				}
				avgGpa = avgGpa / counter;
				
				text.setText("Student GPA Report\n\nHighest GPA: " + highestGpa.getName() + " - " + highestGpa.getGpa() + "\n\nLowest GPA: " + lowestGpa.getName() + " - " + lowestGpa.getGpa() + "\n\nAverage GPA: " + avgGpa);
				
				vbox.getChildren().addAll(label, text, sendBtn);
				stage.setTitle("GPA Report");
			
				sendBtn.setOnAction(e -> {
					sendReport(text.getText(), "gpa");
					stage.close();
				});
				
			// Credits Report
			} else {
				Label label = new Label("Credits Report");
				
				Student highestCredits = new Student();
				highestCredits.setCredits(0);
				for (int i = 0; i < list.size(); i++) {
					if (highestCredits.equals(list.get(i), "credits")) {
						highestCredits = list.get(i);
					}
				}
				
				Student lowestCredits = new Student();
				lowestCredits.setCredits(Integer.MAX_VALUE);
				for (int i = 0; i < list.size(); i++) {
					if (!lowestCredits.equals(list.get(i), "credits")) {
						lowestCredits = list.get(i);
					}
				}
				
				double avgCredits = 0;
				int counter = 0;
				for (Student item : list) {
					avgCredits += item.getCredits();
					counter++;
				}
				avgCredits = avgCredits / counter;
				
				text.setText("Student Credits Report\n\nHighest Number of Credits: " + highestCredits.getName() + " - " + highestCredits.getCredits() + "\n\nLowest Number of Credits: " + lowestCredits.getName() +  
							 " - " + lowestCredits.getCredits() + "\n\nAverage Number of Credits: " + avgCredits);
				
				vbox.getChildren().addAll(label, text, sendBtn);
				stage.setTitle("Credits Report");
				
				sendReport(text.getText(), "credits");
			}
			
			stage.setScene(scene);
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void createTeacherReport(ObservableList<Teacher> list) {
		
		try {
			Stage stage = new Stage();
			VBox vbox = new VBox(15);
			vbox.setAlignment(Pos.CENTER);
			Scene scene = new Scene(vbox, 500, 300);
			
			Label label = new Label("Classes Taught Report");
			TextArea text = new TextArea();
			Button sendBtn = new Button("Send Report to Text File");
			
			Teacher mostClasses = new Teacher();
			mostClasses.setNumOfClasses(0);			
			for (int i = 0; i < list.size(); i++) {
				if (mostClasses.equals(list.get(i))) {
					mostClasses = list.get(i);
				}
			}
			
			Teacher leastClasses = new Teacher();
			leastClasses.setNumOfClasses(5);
			for (int i = 0; i < list.size(); i++) {
				if (!leastClasses.equals(list.get(i))) {
					leastClasses = list.get(i);
				}
			}	
			
			double avgNumOfClasses = 0;
			int counter = 0;
			for (Teacher item : list) {
				avgNumOfClasses += item.getNumOfClasses();
				counter++;
			}
			avgNumOfClasses = avgNumOfClasses / counter;
			
			text.setText("Teacher Number of Classes Taught Report\n\nMost Classes: " + mostClasses.getName() + " - " + mostClasses.getNumOfClasses() + "\n\nLeast Classes: " + leastClasses.getName() + 
						 " - " + leastClasses.getNumOfClasses() + "\n\nAverage Number of Classes: " + avgNumOfClasses);
			
			vbox.getChildren().addAll(label, text, sendBtn);
			stage.setTitle("Teacher Report");
		
			sendBtn.setOnAction(e -> {
				sendReport(text.getText(), "classes");
				stage.close();
			});
			
			stage.setScene(scene);
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void createJanitorReport(ObservableList<Janitor> list) {

		try {
			String type = chooseReport("Janitor");
			
			Stage stage = new Stage();
			VBox vbox = new VBox(15);
			vbox.setAlignment(Pos.CENTER);
			Scene scene = new Scene(vbox, 500, 300);
			
			TextArea text = new TextArea();
			Button sendBtn = new Button("Send Report to Text File");
			
			if (type.equals("Years of Service Report")) {
				
				Label label = new Label("Years of Service Report");
				
				Janitor mostYears = new Janitor();
				mostYears.setYearsOfService(0);			
				for (int i = 0; i < list.size(); i++) {
					if (mostYears.equals(list.get(i), "years")) {
						mostYears = list.get(i);
					}
				}
				
				Janitor leastYears = new Janitor();
				leastYears.setYearsOfService(Integer.MAX_VALUE);
				for (int i = 0; i < list.size(); i++) {
					if (!leastYears.equals(list.get(i), "years")) {
						leastYears = list.get(i);
					}
				}	
				
				double avgYearsOfService = 0;
				int counter = 0;
				for (Janitor item : list) {
					avgYearsOfService += item.getYearsOfService();
					counter++;
				}
				avgYearsOfService = avgYearsOfService / counter;
				
				text.setText("Janitor Years of Service Report\n\nMost Years: " + mostYears.getName() + " - " + mostYears.getYearsOfService() + "\n\nLeast Years: " + leastYears.getName() + 
						 	 " - " + leastYears.getYearsOfService() + "\n\nAverage Years of Service: " + avgYearsOfService);
				
				vbox.getChildren().addAll(label, text, sendBtn);
				stage.setTitle("Janitor Report");
			
				sendBtn.setOnAction(e -> {
					sendReport(text.getText(), "years");
					stage.close();
				});
				
				stage.setScene(scene);
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.show();
				
			} else {
				
				Label label = new Label("Rate of Pay Report");
				
				Janitor mostPay = new Janitor();
				mostPay.setHourlyWage(10);			
				for (int i = 0; i < list.size(); i++) {
					if (mostPay.equals(list.get(i), "pay")) {
						mostPay = list.get(i);
					}
				}
				
				Janitor leastPay = new Janitor();
				leastPay.setHourlyWage(25);
				for (int i = 0; i < list.size(); i++) {
					if (!leastPay.equals(list.get(i), "pay")) {
						leastPay = list.get(i);
					}
				}	
				
				double avgPay = 0;
				int counter = 0;
				for (Janitor item : list) {
					avgPay += item.getPayNumeric();
					counter++;
				}
				avgPay = avgPay / counter;
				
				text.setText("Janitor Hourly Wage Report\n\nMost Pay: " + mostPay.getName() + " - " + mostPay.getHourlyWage() + "\n\nLeast Pay: " + leastPay.getName() + 
						 	 " - " + leastPay.getHourlyWage() + "\n\nAverage Pay: $" + avgPay + "/hr");
				
				vbox.getChildren().addAll(label, text, sendBtn);
				stage.setTitle("Janitor Report");
			
				sendBtn.setOnAction(e -> {
					sendReport(text.getText(), "pay");
					stage.close();
				});
				
				stage.setScene(scene);
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.show();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void sendReport(String text, String type) {
		
		if (type.equals("gpa")) {		
			try {
				File file = new File("C:\\Users\\Christian\\eclipse-workspace\\EggplantJavaFX\\GPA_Report.txt");
				FileWriter writer = new FileWriter(file);
				
				writer.write(text);
				writer.close();
					
			} catch (Exception e) {
				e.printStackTrace();
			}
	
		} else if (type.equals("credits")) {
			try {
				File file = new File("C:\\Users\\Christian\\eclipse-workspace\\EggplantJavaFX\\Credits_Report.txt");
				FileWriter writer = new FileWriter(file);
				
				writer.write(text);
				writer.close();
					
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if (type.equals("classes")) {
			try {
				File file = new File("C:\\Users\\Christian\\eclipse-workspace\\EggplantJavaFX\\Classes_Report.txt");
				FileWriter writer = new FileWriter(file);
				
				writer.write(text);
				writer.close();
					
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if (type.equals("years")) {
			try {
				File file = new File("C:\\Users\\Christian\\eclipse-workspace\\EggplantJavaFX\\Years_Report.txt");
				FileWriter writer = new FileWriter(file);
				
				writer.write(text);
				writer.close();
					
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if (type.equals("pay")) {
			try {
				File file = new File("C:\\Users\\Christian\\eclipse-workspace\\EggplantJavaFX\\Pay_Report.txt");
				FileWriter writer = new FileWriter(file);
				
				writer.write(text);
				writer.close();
					
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}		
	}
}


















