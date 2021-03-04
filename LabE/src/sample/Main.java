package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

public class Main extends Application {
    /* Graph demo
    @Override public void start(Stage stage) {
        stage.setTitle("The Digits in my Student ID");
        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("# of digits in my student ID");
        yAxis.setLabel("Digit value");

        //creating the chart
        final LineChart<Number,Number> lineChart =
                new LineChart<Number,Number>(xAxis,yAxis);

        lineChart.setTitle("My student ID is 218016790");

        //defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName("My portfolio");

        //populating the series with data
        series.getData().add(new XYChart.Data(1, 2));
        series.getData().add(new XYChart.Data(2, 1));
        series.getData().add(new XYChart.Data(3, 8));
        series.getData().add(new XYChart.Data(4, 0));
        series.getData().add(new XYChart.Data(5, 1));
        series.getData().add(new XYChart.Data(6, 6));
        series.getData().add(new XYChart.Data(7, 7));
        series.getData().add(new XYChart.Data(8, 9));
        series.getData().add(new XYChart.Data(9, 0));

        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().add(series);

        stage.setScene(scene);
        stage.show();
    }
*/

    /* Button demo
    public void start(Stage s)
    {
        // set title for the stage
        s.setTitle("This is my button");

        // create a button
        Button b = new Button("Jada's button");

        // create a stack pane
        TilePane r = new TilePane();

        // create a label
        Label l = new Label("button not pressed");

        // action event
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                l.setText("button pressed");
            }
        };

        // when button is pressed
        b.setOnAction(event);

        // add button
        r.getChildren().add(b);
        r.getChildren().add(l);

        // create a scene
        Scene sc = new Scene(r, 200, 200);

        // set the scene
        s.setScene(sc);

        s.show();
    }
    */

    public static void main(String[] args) {
        launch(args);
    }
}