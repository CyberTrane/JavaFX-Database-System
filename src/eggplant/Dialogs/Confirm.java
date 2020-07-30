package eggplant.Dialogs;

import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Alert.AlertType;

public class Confirm {

	private static boolean answer;
//	private static Alert alert;
	
	public static boolean confirm(String title, String message) {
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		VBox vbox = new VBox(10);
		HBox hbox = new HBox(10);
		Scene scene = new Scene(vbox, 260, 125);

		Button yesBtn = new Button("Close");
		Button noBtn = new Button("Cancel");
		
		vbox.setAlignment(Pos.CENTER);
		hbox.setAlignment(Pos.CENTER);
		
		yesBtn.setOnAction(e -> {
			answer = true;
			stage.close();
		});
		
		noBtn.setOnAction(e -> {
			answer = false;
			stage.close();
		});
		
		stage.setTitle(title);
		Label confirm = new Label(message);
		hbox.getChildren().addAll(yesBtn, noBtn);
		vbox.getChildren().addAll(confirm, hbox);
		
		stage.setScene(scene);
		stage.showAndWait();
		
		return answer;
	}
	
}