package edu.ucr.rp.db.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class TelephoneLine {

    @FXML
    private TabPane tP_Tables;
    @FXML private Tab tb_TableOne;
    @FXML private Tab tb_TableTwo;
    @FXML private Tab tb_TableThree;
    @FXML private Tab tb_TableFour;
    @FXML private Tab tb_TableFive;
    @FXML private ComboBox cB_LineType;
    @FXML private TextField tF_PhoneNumber;
    @FXML private Button bT_Add;
    @FXML private Button bT_Remove;

    @FXML
    private void TableOneAction(ActionEvent event) {



    }

    @FXML
    private void TableTwoAction(ActionEvent event) {



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

    @FXML
    private void Add(ActionEvent event) {



    }

    @FXML
    private void Remove(ActionEvent event) {



    }

    public void initialize(URL location, ResourceBundle resources) {

        cB_LineType.getItems().addAll("Básica", "ADSL", "RDSI");

    }



}
