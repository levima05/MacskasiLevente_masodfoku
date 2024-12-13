package hu.petrik.masodfoku;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField aField;
    @FXML
    private TextField bField;
    @FXML
    private TextField cField;
    @FXML
    private Label x1Label;
    @FXML
    private Label x2Label;
    @FXML
    private Label errorLabel;

    @FXML
    public void calculateRoots() {
        x1Label.setText("x1 = ");
        x2Label.setText("x2 = ");
        errorLabel.setText("");

        try {
            double a = Double.parseDouble(aField.getText());
            double b = Double.parseDouble(bField.getText());
            double c = Double.parseDouble(cField.getText());

            if (aField.getText().isEmpty() || bField.getText().isEmpty() || cField.getText().isEmpty()) {
                errorLabel.setText("Minden mező kitöltése kötelező");
                return;
            }

            double discriminant = b * b - 4 * a * c;

            if (discriminant < 0) {
                errorLabel.setText("Nem oldható meg a valós számok halmazán");
            } else if (discriminant == 0) {
                double x1 = -b / (2 * a);
                x1Label.setText("x1 = " + x1);
                x2Label.setText("x2 = " + x1);
            } else {
                double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                x1Label.setText("x1 = " + x1);
                x2Label.setText("x2 = " + x2);
            }

        } catch (NumberFormatException e) {
            errorLabel.setText("Csak számot adhat meg");
        } catch (Exception e) {
            errorLabel.setText("Hiba történt a számítás közben");
        }
    }
}
