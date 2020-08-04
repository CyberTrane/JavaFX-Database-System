package eggplant;

import eggplant.People.Student;
import eggplant.People.Teacher;
import eggplant.People.Info.Address;
import eggplant.People.Info.Name;
import eggplant.People.Info.State;
import eggplant.People.Janitor;
import eggplant.People.Person;
import eggplant.Dialogs.UserErrors;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Edit {

	private Stage window;
	private Scene scene;
	
	private Person newPerson;
	private Student student;
	private Teacher teacher;
	private Janitor janitor;
	
	private TextField fnField, miField, lnField, addressField, cityField, zipField, subjectField, 
					  classesField, officeNumField, majorField, gpaField, creditsField, yearsField, payField;
	
	private String addressNum, addressName, addressType;
	
	private RadioButton smokerBtn1, smokerBtn2;
	private ComboBox<String> genderCombo, stateCombo;
	private DatePicker birthDate;
	
	private List<String> stateList;
	
	public Person editEntry(Person person) {
		
		try {
			// create array list of states
			stateList = new ArrayList<String>();
			stateList.add("Alabama");stateList.add("Alaska");stateList.add("Arizona");stateList.add("Arkansas");stateList.add("California");stateList.add("Colorado");stateList.add("Connecticut");stateList.add("Delaware");
			stateList.add("Florida");stateList.add("Georgia");stateList.add("Hawaii");stateList.add("Idaho");stateList.add("Indiana");stateList.add("Iowa");stateList.add("Kansas");stateList.add("Kentucky");stateList.add("Louisiana");
			stateList.add("Maine");stateList.add("Maryland");stateList.add("Massachusetts");stateList.add("Michigan");stateList.add("Minnesota");stateList.add("Mississippi");stateList.add("Missouri");stateList.add("Montana");
			stateList.add("Nebraska");stateList.add("Nevada");stateList.add("New Hampshire");stateList.add("New Jersey");stateList.add("New Mexico");stateList.add("New York");stateList.add("North Carolina");stateList.add("North Dakota");
			stateList.add("Ohio");stateList.add("Oklahoma");stateList.add("Pennsylvania");stateList.add("Rhode Island");stateList.add("South Carolina");stateList.add("South Dakota");stateList.add("Texas");stateList.add("Utah");
			stateList.add("Vermont");stateList.add("Virginia");stateList.add("Washington");stateList.add("West Virginia");stateList.add("Wisconsin");stateList.add("Wyoming");
			
			// Layouts
			BorderPane pane = new BorderPane();
			
			GridPane grid = new GridPane();
			grid.setPadding(new Insets(5,10,10,10));
			grid.setHgap(15);
			grid.setVgap(15);
			grid.setAlignment(Pos.CENTER);
			
			VBox titleBox = new VBox();
			
			// First Name
			Label fnLabel = new Label("First Name:");
			GridPane.setConstraints(fnLabel, 0, 0);
			
			fnField = new TextField();
			fnField.setPromptText("First Name");
			GridPane.setConstraints(fnField, 1, 0);
			
			fnField.setText(person.getName().getFirstName());
			
			// Middle Initial
			Label miLabel = new Label("Middle Initial:");
			GridPane.setConstraints(miLabel, 2, 0);
			
			miField = new TextField();
			miField.setMaxWidth(30);
			GridPane.setConstraints(miField, 3, 0);
			
			miField.setText(person.getName().getMiddleInitial());
			
			// Last Name
			Label lnLabel = new Label("Last Name:");
			GridPane.setConstraints(lnLabel, 0, 1);
			
			lnField = new TextField();
			lnField.setPromptText("Last Name");
			GridPane.setConstraints(lnField, 1, 1);
			
			lnField.setText(person.getName().getLastName());
			
			// Gender
			Label genderLabel = new Label("Gender:");
			GridPane.setConstraints(genderLabel, 2, 1); 
			
			genderCombo = new ComboBox<String>();                
			genderCombo.getItems().addAll("M","F","O","U");        
			genderCombo.setValue("N/A");         
			GridPane.setConstraints(genderCombo, 3, 1);
			
			genderCombo.setValue(person.getGender());
			
			// Date of Birth
			Label dobLabel = new Label("Date of Birth:");
			GridPane.setConstraints(dobLabel, 0, 2); 
												
			birthDate =  new DatePicker();
			birthDate.setPromptText("Date of Birth");
			GridPane.setConstraints(birthDate, 1, 2);
			
			String[] dobArray = person.getDob().split("-");
			birthDate.setValue(LocalDate.of(Integer.parseInt(dobArray[0]), Integer.parseInt(dobArray[1]), Integer.parseInt(dobArray[2])));
			
			// Address
		  	Label addressLabel = new Label("Address:");
		  	GridPane.setConstraints(addressLabel, 0, 3); 
		  										
		  	addressField =  new TextField();
		  	addressField.setPromptText("1234 Example St");
		  	GridPane.setConstraints(addressField, 1, 3);
		  	
		  	addressField.setText(person.getAddress().addressString());
			
		  	// City
		  	Label cityLabel = new Label("City:");
		  	GridPane.setConstraints(cityLabel, 0, 4); 
		  	
		  	cityField =  new  TextField();
		  	cityField.setPromptText("City");
		  	GridPane.setConstraints(cityField, 1, 4);
		  	
		  	cityField.setText(person.getAddress().getCity());
			
		  	// State
			Label stateLabel = new Label("State:");
		  	GridPane.setConstraints(stateLabel, 2, 3);
		  	
			stateCombo = new ComboBox<String>();
			stateCombo.setValue("N/A");
			stateCombo.getItems().addAll(stateList);
			GridPane.setConstraints(stateCombo, 3, 3);
			
			stateCombo.setValue(person.getAddress().getState().getStateCode());
			
			// ZIP Code
		  	Label zipLabel = new Label("Zip Code:");
		  	GridPane.setConstraints(zipLabel, 2, 4); 
		  	
		  	zipField =  new  TextField();
		  	zipField.setPromptText("Zip Code");
		  	zipField.setMaxWidth(70);
		  	GridPane.setConstraints(zipField, 3, 4);
		  	
		  	zipField.setText(Integer.toString(person.getAddress().getZipCode()));
			
			// smoker
			Label smokerLabel = new Label("Smoker Status:");
			GridPane.setConstraints(smokerLabel, 2, 5);
			
			VBox radioVbox = new VBox(10);
			ToggleGroup smokerGroup = new ToggleGroup();
			smokerBtn1 = new RadioButton("Smoker");
			smokerBtn1.setToggleGroup(smokerGroup);
			smokerBtn2 = new RadioButton("Non-Smoker");
			smokerBtn2.setToggleGroup(smokerGroup);
			radioVbox.getChildren().addAll(smokerBtn1, smokerBtn2);
			GridPane.setConstraints(radioVbox, 3, 5);
			
			if (person.isSmoker()) {
				smokerBtn1.setSelected(true);
			} else {
				smokerBtn2.setSelected(true);
			}
			
			// Submit Button
			Button updateBtn = new Button("Update");
			VBox updateBox = new VBox();
			updateBox.getChildren().add(updateBtn);
			updateBox.setPadding(new Insets(0, 0, 14, 0));
			updateBox.setAlignment(Pos.CENTER);
			
			// if student entry
			if (person instanceof Student) {
				
				person = (Student) person;
				
				// Entry Title
				Label entryLabel =  new Label("Edit Student Entry");
				entryLabel.setFont(Font.font("Helvetica", FontWeight.BOLD, 18));
				titleBox.getChildren().addAll(entryLabel);
				titleBox.setPadding(new Insets(10,10,5,10));
				titleBox.setAlignment(Pos.CENTER);
				
				// Major
				Label majorLabel = new Label("Major:");
				GridPane.setConstraints(majorLabel, 0, 5);
				
				majorField = new TextField();
				majorField.setPromptText("Major");
				GridPane.setConstraints(majorField, 1, 5);
				
				majorField.setText(((Student) person).getMajor());
				
				// GPA
				Label gpaLabel = new Label("GPA:");
				GridPane.setConstraints(gpaLabel, 0, 6);
				
				gpaField = new TextField();
				gpaField.setMaxWidth(60);
				gpaField.setPromptText("GPA");
				GridPane.setConstraints(gpaField, 1, 6);
				
				gpaField.setText(Double.toString(((Student) person).getGpa()));
				
				// Credits Earned
				Label creditsLabel = new Label("Credits Completed:");
				GridPane.setConstraints(creditsLabel, 2, 6);
				
				creditsField = new TextField();
				creditsField.setMaxWidth(60);
				creditsField.setPromptText("Credits");
				GridPane.setConstraints(creditsField, 3, 6);
				
				creditsField.setText(Integer.toString(((Student) person).getCredits()));
				
				grid.getChildren().addAll(titleBox, fnLabel, fnField, miLabel, miField, lnLabel, lnField, dobLabel, birthDate, genderLabel, genderCombo, 
										  addressLabel, addressField, cityLabel, cityField, stateLabel, stateCombo, zipLabel, zipField, majorLabel, 
										  majorField, gpaLabel, gpaField, creditsLabel, creditsField, smokerLabel, radioVbox, updateBox);
				
				updateBtn.setOnAction(e -> {
					boolean noErrors = checkSubmission("Student");
					if (noErrors) {
						newPerson = createPerson("Student");
						Database.sendToDatabase(student);
						window.close();
					}
				});
				
			} else if (person instanceof Teacher) {
				
				person = (Teacher) person;
				
				// Entry Title
				Label entryLabel =  new Label("Edit Teacher Entry");
				entryLabel.setFont(Font.font("Helvetica", FontWeight.BOLD, 18));
				titleBox.getChildren().addAll(entryLabel);
				titleBox.setPadding(new Insets(10,10,5,10));
				titleBox.setAlignment(Pos.CENTER);
				
				// Subject
				Label subjectLabel = new Label("Subject:");
				GridPane.setConstraints(subjectLabel, 0, 5);
				
				subjectField = new TextField();
				subjectField.setPromptText("Subject");
				GridPane.setConstraints(subjectField, 1, 5);
				
				subjectField.setText(((Teacher) person).getSubject());
				
				// Classes
				Label classesLabel = new Label("Number of Classes\nBeing Taught:");
				GridPane.setConstraints(classesLabel, 0, 6);
				
				classesField = new TextField();
				classesField.setMaxWidth(40);
				GridPane.setConstraints(classesField, 1, 6);
				
				classesField.setText(Integer.toString(((Teacher) person).getNumOfClasses()));
				
				// Office Number
				Label officeNumLabel = new Label("Office Number:");
				GridPane.setConstraints(officeNumLabel, 2, 6);
				
				officeNumField = new TextField();
				officeNumField.setMaxWidth(110);
				officeNumField.setPromptText("Office Number");
				GridPane.setConstraints(officeNumField, 3, 6);
				
				officeNumField.setText(((Teacher) person).getOfficeNum());
				
				grid.getChildren().addAll(titleBox, fnLabel, fnField, miLabel, miField, lnLabel, lnField, dobLabel, birthDate, genderLabel, genderCombo, 
										  addressLabel, addressField, cityLabel, cityField, stateLabel, stateCombo, zipLabel, zipField, subjectLabel, 
										  subjectField, classesLabel, classesField, officeNumLabel, officeNumField, smokerLabel, radioVbox, updateBox);
				
					updateBtn.setOnAction(e -> {
						boolean noErrors = checkSubmission("Teacher");
						if (noErrors) {
							newPerson = createPerson("Teacher");
							Database.sendToDatabase(teacher);
							window.close();
						}
					});
				
			} else if (person instanceof Janitor) {
				
				person = (Janitor) person;
				
				// Entry Title
				Label entryLabel =  new Label("Edit Janitor Entry");
				entryLabel.setFont(Font.font("Helvetica", FontWeight.BOLD, 18));
				titleBox.getChildren().addAll(entryLabel);
				titleBox.setPadding(new Insets(10,10,5,10));
				titleBox.setAlignment(Pos.CENTER);
				
				// Years of Service
				Label yearsLabel = new Label("Years of Service:");
				GridPane.setConstraints(yearsLabel, 0, 5);
				
				yearsField = new TextField();
				yearsField.setMaxWidth(50);
				GridPane.setConstraints(yearsField, 1, 5);
				
				yearsField.setText(Integer.toString(((Janitor) person).getYearsOfService()));
				
				// Hourly Pay Rate
				Label payLabel = new Label("Hourly Rate of Pay:");
				GridPane.setConstraints(payLabel, 0, 6);
				
				payField = new TextField();
				payField.setMaxWidth(50);
				GridPane.setConstraints(payField, 1, 6);
				
				payField.setText(Double.toString(((Janitor) person).getPayNumeric()));
				
				grid.getChildren().addAll(titleBox, fnLabel, fnField, miLabel, miField, lnLabel, lnField, dobLabel, birthDate, genderLabel, genderCombo,
										  addressLabel, addressField, cityLabel, cityField, stateLabel, stateCombo, zipLabel, zipField, yearsLabel,
										  yearsField, payLabel, payField, smokerLabel, radioVbox, updateBox);
				
					updateBtn.setOnAction(e -> {
						boolean noErrors = checkSubmission("Janitor");
						if (noErrors) {
							newPerson = createPerson("Janitor");
							Database.sendToDatabase(janitor);
							window.close();
						}
					});	
			}
			
			pane.setTop(titleBox);
			pane.setCenter(grid);
			pane.setBottom(updateBox);
			scene = new Scene(pane, 650, 420);
			window = new Stage();
			window.setTitle("Edit Entry");
			window.setScene(scene);
			window.initModality(Modality.APPLICATION_MODAL);
			window.showAndWait();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return newPerson;
	}
	
	public Person createPerson(String thePerson) {
		if (thePerson.equals("Student")) {
			student = new Student();
			setPerson(student);
			setStudent(student);
			return student;
		} else if (thePerson.equals("Teacher")) {
			teacher = new Teacher();
			setPerson(teacher);
			setTeacher(teacher);
			return teacher;
		} else {
			janitor = new Janitor();
			setPerson(janitor);
			setJanitor(janitor);
			return janitor;
		}
	}
	
	public void setPerson(Person person) {
		Name name = new Name();
		name.setFirstName(fnField.getText());
		name.setMiddleInitial(miField.getText());
		name.setLastName(lnField.getText());
		
		State state = new State();
		state.setStateCode(stateCombo.getValue().toString());
		
		Address address = new Address();
		address.setStreetNum(Integer.parseInt(addressNum));
		address.setStreetName(addressName);
		address.setStreetType(addressType);
		address.setCity(cityField.getText());
		address.setState(state);
		address.setZipCode(Integer.parseInt(zipField.getText()));
		
		person.setName(name);
		person.setGender(genderCombo.getValue().toString());
		person.setDob(birthDate.getValue().toString());
		person.setAddress(address);
		if (smokerBtn1.isSelected()) {
			person.setSmoker(true);
		} else {
			person.setSmoker(false);
		}
	}
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		student.setMajor(majorField.getText());
		student.setGpa(Double.parseDouble(gpaField.getText()));
		student.setCredits(Integer.parseInt(creditsField.getText()));
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		teacher.setSubject(subjectField.getText());
		teacher.setNumOfClasses(Integer.parseInt(classesField.getText()));
		teacher.setOfficeNum(officeNumField.getText());
	}

	public Janitor getJanitor() {
		return janitor;
	}

	public void setJanitor(Janitor janitor) {
		janitor.setYearsOfService(Integer.parseInt(yearsField.getText()));
		janitor.setHourlyWage(Double.parseDouble(payField.getText()));
	}
	
	private String errorText;
	
	public boolean checkSubmission(String table) {
		errorText = new String("");
		
		if (fnField.getText().equals("")) {
			errorText += "- First Name is Empty\n";
		}
		if (lnField.getText().equals("")) {
			errorText += "- Last Name is Empty\n";
		}
		if (miField.getText().length() > 1) {
			errorText += "- Middle Initial is Only One Letter\n";
		}
		if (genderCombo.getSelectionModel().isEmpty()) {
			errorText += "- Must Choose a Gender\n";
		}
		if (stateCombo.getSelectionModel().isEmpty()) {
			errorText += "- Must Choose a State\n";
		}
		if (addressField.getText().equals("")) {
			errorText += "- Address is Empty\n";
		} else {
			String[] addressArray = addressField.getText().trim().split(" ");
			
			if (addressArray.length < 3) {
				errorText += "- Address is Incomplete\n";
			} else {
				addressNum = addressArray[0];
				
				addressName = "";
				for (int i = 1; i < addressArray.length - 1; i++) {
					 addressName += addressArray[i];
				}
				
				addressType = addressArray[addressArray.length - 1];
				
				if (!isNumeric(addressNum)) {
					errorText += "- Street Number Must Be a Number\n";
				}
			}
		}
		if (cityField.getText().equals("")) {
			errorText += "- City is Empty\n";
		}
		if (zipField.getText().equals("")) {
			errorText += "- Zip Code is Empty\n";
		} else if (!isNumeric(zipField.getText())) {
			errorText += "- Zip Code Must be a Number\n";
		}
		if (!smokerBtn1.isSelected() && !smokerBtn2.isSelected()) {
			errorText += "- Please Select Smoker Status\n";
		}
		
		if (table.equals("Student")) {
			if (majorField.getText().equals("")) {
				errorText += "- Major is Empty\n";
			}
			if (gpaField.getText().equals("")) {
				errorText += "- GPA is Empty\n";
			} else if (!isNumeric(gpaField.getText())) {
				errorText += "- GPA Must be a Number\n";
			} else if (Double.parseDouble(gpaField.getText()) < 0 || Double.parseDouble(gpaField.getText()) > 5) {
				errorText += "GPA Must be Between 0 and 5";
			}
			if (creditsField.getText().equals("")) {
				errorText += "- Credits Completed is Empty\n";
			} else if (!isNumeric(creditsField.getText())) {
				errorText += "- Credits Completed Must be a Number\n";
			}
		} else if (table.equals("Teacher")) {
			if (subjectField.getText().equals("")) {
				errorText += "- Subject is Empty\n";
			}
			if (classesField.getText().equals("")) {
				errorText += "- Number of Classes is Empty\n";
			} else if (!isNumeric(classesField.getText())) {
				errorText += "- Number of Classes Must be a Number\n";
			}
			if (officeNumField.getText().equals("")) {
				errorText += "- Office Number is Empty\n";
			} else if (!isNumeric(officeNumField.getText())) {
				errorText += "- Office Number Must be a Number\n";
			}
		} else if (table.equals("Janitor")) {
			if (yearsField.getText().equals("")) {
				errorText += "- Years of Service is Empty\n";
			} else if (!isNumeric(yearsField.getText())) {
				errorText += "- Years of Service Must be a Number\n";
			}
			if (payField.getText().equals("")) {
				errorText += "- Rate of Pay is Empty\n";
			} else if (!isNumeric(payField.getText())) {
				errorText += "- Rate of Pay Must be a Number\n";
			} else if (Double.parseDouble(payField.getText()) > 25 || Double.parseDouble(payField.getText()) < 10) {
				errorText += "- Rate of Pay Must be Between $10.00 and $25.00";
			}
		}
		
		if (!errorText.isEmpty()) {
			UserErrors.userErrors(errorText, 300, 325);
			return false;
		} 

		return true;
	}
	
	public boolean isNumeric(String str) {
	    try {
	        int i = Integer.parseInt(str);
	    } catch (Exception e) {
	    	try {
	    		double j = Double.parseDouble(str);
	    	} catch (Exception ex) {
	    		return false;
	    	}
	    	return true;
	    }
	    return true;
	}
	
}
