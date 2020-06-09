package app;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
//import javafx.event.EventHandler;
//import javafx.event.ActionEvent;

//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
public class Main extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}

	Stage window;
	Scene scene1, scene2;

	
	@Override
	public void start(Stage primaryStage) {
		try {
			// scene 1
			window = primaryStage;
			BorderPane pane = new BorderPane();
			scene1 = new Scene(pane, 500, 400);
			
			// h box top
			HBox hbox = new HBox(10);
			hbox.setPadding(new Insets(10, 200, 0, 200));
			Label title = new Label("Eggplant Database");
			hbox.getChildren().add(title);
			
			// left menu
			VBox leftMenu = new VBox(10);
			leftMenu.setPadding(new Insets(25, 0, 0, 10));
			Button entryBtn = new Button("Make an Entry");
			Button reportBtn = new Button("Send Report");
			entryBtn.setMaxWidth(Double.MAX_VALUE);
			reportBtn.setMaxWidth(Double.MAX_VALUE);
			leftMenu.getChildren().addAll(entryBtn, reportBtn);
			
			// center menu
			VBox centerMenu = new VBox(10);
			centerMenu.setPadding(new Insets(25, 150, 0, 150));
			Button teacherBtn = new Button("Teachers");
			Button studentBtn = new Button("Students");
			Button janitorBtn = new Button("Janitors");
			teacherBtn.setMaxWidth(Double.MAX_VALUE);
			studentBtn.setMaxWidth(Double.MAX_VALUE);
			janitorBtn.setMaxWidth(Double.MAX_VALUE);
			centerMenu.getChildren().addAll(teacherBtn, studentBtn, janitorBtn);
			
			
			// scene 2
			VBox vbox2 = new VBox(10);
			vbox2.setPadding(new Insets(0, 200, 0, 200));
			
			Label label1 = new Label("Entry");
			label1.setMaxWidth(Double.MAX_VALUE);
			label1.setAlignment(Pos.CENTER);
			
			Label label2 = new Label("Enter First Name");
			label2.setMaxWidth(Double.MAX_VALUE);
			label2.setAlignment(Pos.CENTER);
			
			TextField fnField = new TextField();
			fnField.setMaxWidth(Double.MAX_VALUE);
			fnField.setAlignment(Pos.CENTER);
			
			Label label3 = new Label("Enter Last Name");
			label3.setMaxWidth(Double.MAX_VALUE);
			label3.setAlignment(Pos.CENTER);
			
			TextField lnField = new TextField();
			lnField.setMaxWidth(Double.MAX_VALUE);
			lnField.setAlignment(Pos.CENTER);
			
			Button backBtn = new Button("Back");
			backBtn.setMaxWidth(Double.MAX_VALUE);
			backBtn.setAlignment(Pos.CENTER);
			
			vbox2.getChildren().addAll(label1, label2, fnField, label3, lnField, backBtn);
			Scene scene2 = new Scene(vbox2, 500, 400);
			
			entryBtn.setOnAction(e -> window.setScene(scene2));
			backBtn.setOnAction(e -> window.setScene(scene1));
			
			window.setOnCloseRequest(e -> {
				e.consume();
				closeWindow();
			});
			
			// initial scene set
			pane.setTop(hbox);
			pane.setLeft(leftMenu);
			pane.setCenter(centerMenu);
			window.setTitle("EggplantDB");
			window.setScene(scene1);
			window.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void closeWindow() {
		boolean answer = Confirm.confirm("Close", "Are you sure you want to close program?");
		if (answer == true) {
			window.close();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
