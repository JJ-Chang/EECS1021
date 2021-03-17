package com.eecs1021.PartC;

import com.eecs1021.DataController;
import com.eecs1021.SerialPortService;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.FormatStringConverter;

import java.text.DateFormat;
import java.util.List;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private static TableView<XYChart.Data<Number, Number>> getTableView() {
        // TODO: Create a `TableView<XYChart.Data<Number, Number>>`.
        //  Refer to the documentation for further details.
        TableView<XYChart.Data<Number, Number>> tableview = new TableView<>();
        TableColumn<XYChart.Data<Number, Number>, Number> timestamp = new TableColumn<>("time");
        timestamp.setCellValueFactory(row -> row.getValue().XValueProperty());
        var value = new TableColumn<XYChart.Data<Number, Number>, Number>("values");
        value.setCellValueFactory(row -> row.getValue().YValueProperty());

        var dateFormat = DateFormat.getTimeInstance();
        FormatStringConverter<Number> converter = new FormatStringConverter<>(dateFormat);
        timestamp.setCellFactory(c -> new TextFieldTableCell<>(converter));

        tableview.getColumns().setAll(List.of(timestamp, value));
        return tableview;
    }

    @Override
    public void start(Stage primaryStage) {
        var serialPort = SerialPortService.getSerialPort("COM4");
        var table = getTableView();
        var controller = new DataController();

        serialPort.addDataListener(controller);
        table.setItems(controller.getDataPoints());

        var vbox = new VBox(table);
        var scene = new Scene(vbox);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}