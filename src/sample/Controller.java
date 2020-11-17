/**
 * Controller class for sample.fxml
 * @author Ben Plotnick, Michael Sherbine
 */
package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    ComboBox selectSandwhich;
    @FXML
    CheckBox Lettuce;
    @FXML
    ListView extraOptions;
    @FXML
    ListView extraSelected;
    @FXML
    ImageView sandwichImage;
    @FXML
    TextArea includedIngredients;
    @FXML
    TextArea orderPrice;


    Sandwhich sandwhich;
    Order order;
    ObservableList<Extra> extras = FXCollections.observableArrayList(Extra.values());


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)  {
        selectSandwhich.getItems().addAll("Chicken", "Beef", "Fish");
        selectSandwhich.setValue("Chicken");
        extraOptions.setItems(extras);
        extraOptions.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        includedIngredients.appendText("Fried Chicken\nSpicy Sauce\nPickles");
        orderPrice.appendText("$8.99");
        sandwhich = new Chicken();
        order = new Order();




    }


    /**
     * Called when a sandwich is selected
     */
    public void pickSandwhich() {
        includedIngredients.clear();
        if(selectSandwhich.getValue().equals("Chicken")){
            includedIngredients.appendText("Fried Chicken\nSpicy Sauce\nPickles");
            sandwhich = new Chicken();

        }

        if(selectSandwhich.getValue().equals("Fish")){
            includedIngredients.appendText("Grilled Snapper\nCilantro\nLime");
            sandwhich = new Fish();
        }

        if(selectSandwhich.getValue().equals("Beef")){
            includedIngredients.appendText("Roast Beef\nProvolone Cheese\nMustard");
            sandwhich = new Beef();
        }
        orderPrice.clear();
        String price = new DecimalFormat("#.##").format(sandwhich.price());
        orderPrice.appendText("$"+price);
    }

    /**
     *adds extras to sandwich's extras list and to listview when user clicks add button
     */

    public void addExtras() {
        ObservableList<Extra> selected = extraOptions.getSelectionModel().getSelectedItems();
        if(extraSelected.getItems().size() > 5 || selected.size() > 6){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning!!");
            alert.setHeaderText("No more than 6 toppings allowed!");
            alert.setContentText("Please select 6 or less toppings.");
            alert.showAndWait();
        } else {
            sandwhich.add(selected);
            extraSelected.getItems().addAll(selected);
            extraOptions.getItems().removeAll(selected);
            orderPrice.clear();
            String price = new DecimalFormat("#.##").format(sandwhich.price());
            orderPrice.appendText("$"+price);
        }
    }

    /**
     *removes extras from sandwich's extra list and from listview when user presses remove button
     */
    public void removeExtras() {
        Object selected = extraSelected.getSelectionModel().getSelectedItem();
        sandwhich.remove(selected);
        orderPrice.clear();
        String price = new DecimalFormat("#.##").format(sandwhich.price());
        orderPrice.appendText("$"+price);
        extraSelected.getItems().remove(selected);
        extraOptions.getItems().add(selected);
    }

    /**
     * clears extras from sandwich's extras list and from listview
     */
    public void clearSelected() {
        ObservableList<Extra> selected = extraSelected.getItems();
        for(int i =0; i < selected.size(); i++){
            sandwhich.remove(selected.get(i));
        }
        orderPrice.clear();
        String price = new DecimalFormat("#.##").format(sandwhich.price());
        orderPrice.appendText("$"+price);
        extraOptions.getItems().addAll(selected);
        extraSelected.getItems().removeAll(selected);


    }

    /**
     * adds sandwich to order
     */
    public void addToOrder() {
        OrderLine orderLine = new OrderLine(order.lineNumber++, sandwhich, sandwhich.price());
        order.add(orderLine);
        ObservableList<Extra> selected = extraSelected.getItems();
        orderPrice.clear();
        String price = new DecimalFormat("#.##").format(sandwhich.price());
        orderPrice.appendText("$"+price);
        extraOptions.getItems().addAll(selected);
        extraSelected.getItems().removeAll(selected);
        pickSandwhich();



    }

    /**
     *
     * opens second window and calls display method to show sandwiches on order.
     * @throws IOException if window cannot open
     */
    public void showOrder() throws IOException {

        Stage newStage = new Stage();

        Parent root;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("stage2.fxml"));
        root = loader.load();
        Controller2 controller = loader.getController();
        controller.display(order);


        Scene sceneNewDate = new Scene(root);
        newStage.setScene(sceneNewDate);
        newStage.show();


    }


}



