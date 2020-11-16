package sample;


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
    RadioButton sameOrd, remOrd, cleOrd, savOrd;
    @FXML
    ListView ordList;
    @FXML
    TextArea totDisplay;
    Order order = new Order();


    @FXML
    public void display(OrderLine orderline){
        ordList.getItems().add(orderline);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }






    public void exportFile(ActionEvent event){
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open Target File for the Export");
        chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", ".txt"),
                new FileChooser.ExtensionFilter("All Files", ".*"));
        Stage stage = new Stage();
        File targeFile = chooser.showSaveDialog(stage);

        try {
            FileWriter out = new FileWriter(targeFile);
            out.write();
            out.close();

        } catch (IOException e) {
            ordDisplay.appendText(e.getMessage());
        }

    }


}
