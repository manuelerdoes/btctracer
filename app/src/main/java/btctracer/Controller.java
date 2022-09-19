package btctracer;


import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import javafx.scene.control.TextField;


public class Controller {
  @FXML private TextField textInput;
  @FXML private ComboBox<Integer> depthInput;
  @FXML private Button submitButton;

  @FXML protected void onButtonAction(ActionEvent e) {
    System.out.println("pressed");
  }

  @FXML public void initialize() {
    depthInput.setItems(
      FXCollections.observableArrayList(1,2,3,4,5)
    );
  }
}