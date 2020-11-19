package edu.ucr.rp.db.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class Home {

    @FXML private TabPane tP_Tables;
    @FXML private Button bT_TableOne;
    @FXML private Button bT_TableTwo;
    @FXML private Button bT_TableThree;
    @FXML private Button bT_TableFour;
    @FXML private Button bT_TableFive;
    @FXML private Pane P_LinePane;
    @FXML private Pane P_ServicePane;
    @FXML private ComboBox cB_LineType;
    @FXML private TextField tF_PhoneNumber;
    @FXML private Button bT_Add;
    @FXML private Button bT_Remove;

    @FXML
    public void initialize(){

        P_LinePane.setVisible(false);
        P_ServicePane.setVisible(false);
        cB_LineType.getItems().addAll("Básica", "ADSL", "RDSI");

    }

    @FXML
    private void TableOneAction(ActionEvent event) {

        P_LinePane.setVisible(true);
        P_ServicePane.setVisible(false);


    }

    @FXML
    private void TableTwoAction(ActionEvent event) {

        P_ServicePane.setVisible(true);
        P_LinePane.setVisible(false);

    }

    @FXML
    private void TableThreeAction(ActionEvent event) {



    }

    @FXML
    private void TableFourAction(ActionEvent event) {



    }

    @FXML
    private void TableFiveAction(ActionEvent event) {



    }


}
