package com.groundanchor;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AreaCalculator extends Application {
    //declare and instantiate instance members
    private TextField length = new TextField();
    private TextField breadth = new TextField();
    private TextField area = new TextField();

    //blank constructor for now - jvm will do this automatically.
    //super constructor for Application called as this class extends Application
    public AreaCalculator() {
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //declare local vars
        Label breadthL, lengthL, areaText, errorBox;
        Text sceneTitle;
        Button calculate;
        Stage window;

        try {
            window = primaryStage;
            window.setTitle("Area Calculator");
            //create layout
            GridPane layout = new GridPane();
            //set padding for the objects on the grid pane
            layout.setHgap(5);
            layout.setVgap(10);
            layout.setPadding(new Insets(0, 10, 0, 10));

            //create instances of our objects, labels and fields
            breadthL = new Label("Breadth");
            lengthL = new Label("Length");
            sceneTitle = new Text("Enter length and breadth and press Calculate Area");
            areaText = new Label();
            calculate = new Button("Calculate Area");
            errorBox = new Label();

            //now we can add them to the pane
            layout.add(sceneTitle, 0, 0, 4, 1);
            layout.add(lengthL, 0, 1);
            layout.add(this.length, 1, 1);
            layout.add(breadthL, 2, 1);
            layout.add(this.breadth, 3, 1);
            layout.add(calculate, 0, 4, 4, 1);

            //we need to un anchor the max button size to allow it to span columns
            calculate.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            //set horizontal alignment on one specific node - sceneTitle (instructions)
            GridPane.setHalignment(sceneTitle, HPos.CENTER);
            //deal with button action
            calculate.setOnAction((ActionEvent event) -> {
                //if user has entered a second set of data we need to remove nodes first or error thrown
                layout.getChildren().removeAll(this.area, areaText, errorBox);
                String formLength = this.length.getText();
                String formBreadth = this.breadth.getText();
                double length;
                double breadth;
                double areaDbl;
                try {
                    length = Integer.parseInt(formLength);
                    breadth = Integer.parseInt(formBreadth);
                    areaDbl = length * breadth;
                    this.area.setText(String.valueOf(areaDbl));
                    areaText.setText("Rectangle area is ");
                    layout.add(areaText, 0, 3, 3, 1);
                    layout.add(this.area, 3, 3);
                } catch (Exception e) {
                    String errorField = "Please enter valid numbers!";
                    errorBox.setText(errorField);
                    layout.add(errorBox, 0, 3, 4, 1);
                    GridPane.setHalignment(errorBox, HPos.CENTER);
                }
            });
            //create scene and attach layout to scene and provide dimensions
            Scene scene = new Scene(layout, 400, 150);
            //attach scene to window
            window.setScene(scene);
            window.show();
        } catch (Exception e) {
            System.out.println("App failed to bootstrap...");
        }
    }
}
