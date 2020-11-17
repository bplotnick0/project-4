/**
 *Controller for the review order window (stage2)
 * @Authors Michael Sherbine, Ben Plotnick
 */
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

    /**
     * Updates the price and displays it in the textArea
     */
    @FXML
    public void updatePrice(){
        double totPrice = 0;
        for(int i = 0; i<order.getOrderLines().size(); i++){
            totPrice = totPrice + order.getOrderLines().get(i).getPrice();
        }
        totDisplay.appendText(new DecimalFormat("#.##").format(totPrice));
    }

    /**
     * Displays all accounts in a given order to the window
     * @param ord
     */
    @FXML
    public void display(Order ord){
        order = ord;
        for (int i = 0; i < ord.getOrderLines().size(); i++){

            System.out.println((ord.getOrderLines().get(i)).toString());
            ordList.getItems().add((ord.getOrderLines().get(i)));
        }
        updatePrice();

    }

    /**
     * You select an item in the listview and this methods duplicates it.
     * @param actionEvent
     */
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

    /**
     * Removes an orderLine that you select
     * @param actionEvent
     */
    public void removeOrder(ActionEvent actionEvent) {
        try{
            OrderLine selectedOrder = (OrderLine) ordList.getSelectionModel().getSelectedItem();
            order.remove(selectedOrder);
            ordList.getItems().remove(selectedOrder);

            for(int i = 0; i<order.getOrderLines().size(); i++){
                order.getOrderLines().get(i).setLineNumber(i+1);
            }

            ordList.getItems().clear();
            display(order);

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

    /**
     * Clears the whole order from the review window
     * @param actionEvent
     */
    public void clearOrder(ActionEvent actionEvent){
        order.getOrderLines().clear();
        ordList.getItems().clear();
        order.lineNumber = 1;

        totDisplay.clear();
        updatePrice();



    }

    /**
     * Saves the order to a separate file.
     * @param event
     */
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

    /**
     * Closes the review order window.
     * @param actionEvent
     */
    public void close(ActionEvent actionEvent) {

        Stage stage = (Stage) closeButton2.getScene().getWindow();
        // do what you have to do
        stage.close();
    }



}
