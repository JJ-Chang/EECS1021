package eecs1021.PartB;

import eecs1021.SerialPortService;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        var sp = SerialPortService.getSerialPort("COM4");
        var outputStream = sp.getOutputStream();

        var pane = new BorderPane();

        var slider = new Slider();
        slider.setMin(0.0);
        slider.setMax(100.0);

        var label = new Label();
        label.textProperty().bind(slider.valueProperty().asString(".0f"));

        var button = new Button("Button");
        button.setOnMouseReleased(value -> {
            try {
                outputStream.write(0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        button.setOnMousePressed(value -> {
            try{
                outputStream.write(255);
            }catch (IOException e){
                e.printStackTrace();
            }
        });

        // TODO: Add a 'listener' to the {@code valueProperty} of the slider. The listener
        //  should write the {@code byteValue()} of the new slider value to the output stream.

        slider.valueProperty().addListener((observableValue, oldValue, newValue) -> {
            try {
                outputStream.write(newValue.byteValue());
            }catch (IOException e){
                e.printStackTrace();
            }
        });

        pane.setCenter(slider);
        pane.setBottom(label);
        pane.setTop(button);
        pane.setPadding(new Insets(0, 20, 0, 20));

        var scene = new Scene(pane, 400, 200);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
