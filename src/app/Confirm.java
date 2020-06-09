package app;

import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class Confirm {

	static boolean answer;
	
	public static boolean confirm(String title, String message) {
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		VBox vbox = new VBox(10);
		Scene scene = new Scene(vbox, 235, 125);

		Button yesBtn = new Button("Yes");
		Button noBtn = new Button("No");
		
		vbox.setAlignment(Pos.CENTER);
		
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
		vbox.getChildren().addAll(confirm, yesBtn, noBtn);
		
		stage.setScene(scene);
		stage.showAndWait();
		
		return answer;
		
	}
}