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
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller2 implements Initializable {


    @FXML
    ListView ordList;
    @FXML
    TextArea totDisplay;
    Order order;


    @FXML
    public void display(Order ord){
        order = ord;
        for (int i = 0; i < ord.getOrderLines().size(); i++){

            System.out.println((ord.getOrderLines().get(i)).toString());
            ordList.getItems().add((ord.getOrderLines().get(i)));
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }

    public void copyOrder(ActionEvent actionEvent) {
        OrderLine selectedOrder = (OrderLine)ordList.getSelectionModel().getSelectedItem();
        OrderLine copy = new OrderLine(order.lineNumber, selectedOrder.getSandwich(),selectedOrder.getPrice());
        order.add(copy);
        ordList.getItems().add(order.getOrderLines().get(order.lineNumber - 1));
        order.lineNumber++;


    }

    public void removeOrder(ActionEvent actionEvent){
        OrderLine selectedOrder = (OrderLine)ordList.getSelectionModel().getSelectedItem();
        order.remove(selectedOrder);
        ordList.getItems().remove(selectedOrder);

    }

    public void clearOrder(ActionEvent actionEvent){
        for(int i =0; i < order.getOrderLines().size(); i++){
            order.remove(order.getOrderLines().get(i));

        }
        ordList.getItems().clear();


    }


//    public void exportFile(ActionEvent event){
//        FileChooser chooser = new FileChooser();
//        chooser.setTitle("Open Target File for the Export");
//        chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", ".txt"),
//                new FileChooser.ExtensionFilter("All Files", ".*"));
//        Stage stage = new Stage();
//        File targeFile = chooser.showSaveDialog(stage);
//
//        try {
//            FileWriter out = new FileWriter(targeFile);
//            out.write();
//            out.close();
//
//        } catch (IOException e) {
//            ordDisplay.appendText(e.getMessage());
//        }
//
//    }


}
