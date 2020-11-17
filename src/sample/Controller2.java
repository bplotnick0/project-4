package sample;


import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.control.*;



//import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.text.*;

public class Controller2 {


    @FXML
    ListView ordList;
    @FXML
    TextArea totDisplay;
    @FXML
    Button closeButton2;

    Order order;

    @FXML
    public void updatePrice(){
        double totPrice = 0;
        for(int i = 0; i<order.getOrderLines().size(); i++){
            totPrice = totPrice + order.getOrderLines().get(i).getPrice();
        }
        totDisplay.appendText(new DecimalFormat("#.##").format(totPrice));
    }


    @FXML
    public void display(Order ord){
        order = ord;
        for (int i = 0; i < ord.getOrderLines().size(); i++){

            System.out.println((ord.getOrderLines().get(i)).toString());
            ordList.getItems().add((ord.getOrderLines().get(i)));
        }
        updatePrice();

    }


    public void copyOrder(ActionEvent actionEvent) {
        try {
            OrderLine selectedOrder = (OrderLine) ordList.getSelectionModel().getSelectedItem();
            OrderLine copy = new OrderLine(order.lineNumber, selectedOrder.getSandwich(), selectedOrder.getPrice());
            order.add(copy);
            ordList.getItems().add(order.getOrderLines().get(order.lineNumber - 1));
            order.lineNumber++;

            totDisplay.clear();
            updatePrice();
        }catch (NullPointerException e){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning!!");
            alert.setHeaderText("You must select an order to duplicate!");
            alert.setContentText("Please select an order to duplicate.");
            alert.showAndWait();
        }


    }

    public void removeOrder(ActionEvent actionEvent) {
        try{
            OrderLine selectedOrder = (OrderLine) ordList.getSelectionModel().getSelectedItem();
            order.remove(selectedOrder);
            ordList.getItems().remove(selectedOrder);

            totDisplay.clear();
            updatePrice();
        }catch (NullPointerException e){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning!!");
            alert.setHeaderText("You must select an order to remove!");
            alert.setContentText("Please select an order to remove.");
            alert.showAndWait();
        }

    }

    public void clearOrder(ActionEvent actionEvent){
        order.getOrderLines().clear();
        ordList.getItems().clear();
        order.lineNumber = 1;

        totDisplay.clear();
        updatePrice();



    }


    public void exportFile(ActionEvent event){

        double totPrice = 0;
        for(int i = 0; i<order.getOrderLines().size(); i++){
            totPrice = totPrice + order.getOrderLines().get(i).getPrice();
        }

        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open Target File for the Export");
        chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", ".txt"),
                new FileChooser.ExtensionFilter("All Files", ".*"));
        Stage stage = new Stage();
        File targetFile = chooser.showSaveDialog(stage);

        try {
            BufferedWriter out = new  BufferedWriter(new FileWriter(targetFile));

            for (int i = 0; i < order.getOrderLines().size(); i++){
                out.write(order.getOrderLines().get(i).toString());
                out.newLine();

            }
            out.write("Total Price = " + new DecimalFormat("#.##").format(totPrice));
            out.close();

        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning!!");
            alert.setHeaderText("You must select an order to remove!");
            alert.setContentText("Please select an order to remove.");
            alert.showAndWait();
        }

    }

    public void close(ActionEvent actionEvent) {

        Stage stage = (Stage) closeButton2.getScene().getWindow();
        // do what you have to do
        stage.close();
    }



}
