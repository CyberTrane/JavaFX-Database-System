package eggplant.Dialogs;

import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class UserErrors {
	
	public static void userErrors(String errorMessage, int width, int length) {
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		VBox vbox = new VBox(10);
		Scene scene = new Scene(vbox, width, length);
		
		Label label = new Label("User Error");
		
		Label text = new Label(errorMessage);
		
		Button closeBtn = new Button("Close");
		closeBtn.setOnAction(e -> {
			stage.close();
		});
		
		vbox.setAlignment(Pos.CENTER);
		vbox.getChildren().addAll(label, text, closeBtn);
		
		stage.setTitle("User Error");
		stage.setScene(scene);
		stage.show();
	}
	
}
