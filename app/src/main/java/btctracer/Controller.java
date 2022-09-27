package btctracer;


import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class Controller {
  @FXML private TextField addressInput;
  @FXML private ComboBox<Integer> depthInput;
  @FXML private Button submitButton;
  @FXML private TextArea tf1;


  @FXML protected void onButtonAction(ActionEvent e) {
    // String searchString = addressInput.getText();
    // Investigation i = new Investigation(new Search(searchString));
    // i.flagTransactions();
    // i.nextLayer();
    // i.printAll();

    int depth = 1;
    if (depthInput.getValue() > 1) {
      depth = depthInput.getValue();
    }

    if (addressInput.getText().length() > 10) {
      new Handler(addressInput.getText(), depth);
      tf1.setText(Handler.output);
    } else {
      tf1.setText("error: input address too short");
    }

    
  }

  @FXML public void initialize() {
    depthInput.setItems(
      FXCollections.observableArrayList(1,2,3,4)
    );
  }
}