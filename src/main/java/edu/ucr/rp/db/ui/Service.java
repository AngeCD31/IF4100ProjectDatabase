package edu.ucr.rp.db.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;

public class Service {

    App a = new App();

    @FXML
    private TabPane tP_Tables;
    @FXML private Button bT_TableOne;
    @FXML private Button bT_TableTwo;
    @FXML private Button bT_TableThree;
    @FXML private Button bT_TableFour;
    @FXML private Button bT_TableFive;

    @FXML
    private void TableOneAction(ActionEvent event) {

        try {
            a.startTelephoneLine();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void TableTwoAction(ActionEvent event) {

        try {
            a.startService();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void TableThreeAction(ActionEvent event) {

        try {
            a.startClient();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void TableFourAction(ActionEvent event) {



    }

    @FXML
    private void TableFiveAction(ActionEvent event) {



    }

}
