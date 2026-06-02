package hust.soict.dsai.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;

    // Injected RadioButtons from Scene Builder
    @FXML
    private RadioButton penRadioButton;

    @FXML
    private RadioButton eraserRadioButton;

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        // Default settings for the Pen
        Color brushColor = Color.BLACK;
        double brushRadius = 4.0;

        // If the Eraser option is selected, switch to white ink to blend with the canvas
        if (eraserRadioButton != null && eraserRadioButton.isSelected()) {
            brushColor = Color.WHITE;
            brushRadius = 8.0; // Tip: A slightly larger radius makes erasing much smoother!
        }

        // Create and paint the circle marker
        Circle newCircle = new Circle(event.getX(), event.getY(), brushRadius, brushColor);
        drawingAreaPane.getChildren().add(newCircle);
    }

}