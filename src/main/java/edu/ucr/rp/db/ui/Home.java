package edu.ucr.rp.db.ui;

import edu.ucr.rp.db.domain.LineFour;
import edu.ucr.rp.db.domain.LineOne;
import edu.ucr.rp.db.domain.LineThree;
import edu.ucr.rp.db.domain.LineTwo;
import edu.ucr.rp.db.persistance.*;
import edu.ucr.rp.db.util.LineBuilderOne;
import edu.ucr.rp.db.util.Utility;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

import javax.swing.JOptionPane;

public class Home {

    @FXML private Pane P_LinePane;
    @FXML private Pane P_LinePaneTwo;
    @FXML private Pane P_LinePaneThree;
    @FXML private ComboBox cB_LineType;
    @FXML private Button bT_Add;
    @FXML private Button bT_Remove;
    @FXML private Button bT_AddTwo;
    @FXML private Button bT_RemoveModify;
    @FXML private Button bT_View;
    @FXML private TextField tF_Id;
    @FXML private TextField tF_Phone;
    @FXML private TextField tF_Email;
    @FXML private TextField tF_Address;
    @FXML private TextField tF_NumberLine;
    @FXML private TableView tV_LinesOne;
    @FXML private TableView tV_LinesTwo;
    @FXML private TableView tV_LinesThree;
    @FXML private TableView tV_LinesFour;
    @FXML private TableColumn tC_idOne = new TableColumn();
    @FXML private TableColumn tC_idTwo = new TableColumn();
    @FXML private TableColumn tC_idThree = new TableColumn();
    @FXML private TableColumn tC_idFour = new TableColumn();
    @FXML private TableColumn tC_Phone = new TableColumn();
    @FXML private TableColumn tC_Email = new TableColumn();
    @FXML private TableColumn tC_Address = new TableColumn();
    @FXML private TableColumn tC_LineType = new TableColumn();
    @FXML private TableColumn tC_NumberLineOne = new TableColumn();
    @FXML private TableColumn tC_NumberLineTwo = new TableColumn();
    @FXML private TableColumn tC_PEarned = new TableColumn();

    LineOne lineOne;
    LineTwo lineTwo;
    LineThree lineThree;
    LineFour lineFour;
    LinePersistanceOne linePersistanceOne = new LinePersistanceOne();
    LinePersistanceTwo linePersistanceTwo = new LinePersistanceTwo();
    LinePersistanceThree linePersistanceThree = new LinePersistanceThree();
    LinePersistanceFour linePersistanceFour = new LinePersistanceFour();
    @FXML
    public void initialize() {

        cB_LineType.getItems().addAll("Básica", "ADSL", "RDSI");

        P_LinePane.setVisible(false);
        P_LinePaneTwo.setVisible(false);
        P_LinePaneThree.setVisible(false);

        tC_idOne = new TableColumn("Cédula");
        tC_idOne.setMinWidth(75);
        tC_idOne.setEditable(true);
        tC_idOne.setCellValueFactory(new PropertyValueFactory<LineOne, String>("idCard"));

        tC_idTwo = new TableColumn("Cédula");
        tC_idTwo.setMinWidth(100);
        tC_idTwo.setEditable(true);
        tC_idTwo.setCellValueFactory(new PropertyValueFactory<LineTwo, String>("idCard"));

        tC_idThree = new TableColumn("Cédula");
        tC_idThree.setMinWidth(100);
        tC_idThree.setEditable(true);
        tC_idThree.setCellValueFactory(new PropertyValueFactory<LineThree, String>("idCard"));

        tC_idFour = new TableColumn("Cédula");
        tC_idFour.setMinWidth(100);
        tC_idFour.setEditable(true);
        tC_idFour.setCellValueFactory(new PropertyValueFactory<LineFour, String>("idCard"));

        tC_Phone = new TableColumn("Número contacto");
        tC_Phone.setMinWidth(120);
        tC_Phone.setEditable(true);
        tC_Phone.setCellValueFactory(new PropertyValueFactory<LineFour, String>("phone"));

        tC_Email = new TableColumn("Correo");
        tC_Email.setMinWidth(263);
        tC_Email.setEditable(true);
        tC_Email.setCellValueFactory(new PropertyValueFactory<LineTwo, String>("email"));

        tC_Address = new TableColumn("Dirección");
        tC_Address.setMinWidth(263);
        tC_Address.setEditable(true);
        tC_Address.setCellValueFactory(new PropertyValueFactory<LineThree, String>("address"));

        tC_LineType = new TableColumn("Tipo de línea");
        tC_LineType.setMinWidth(100);
        tC_LineType.setEditable(true);
        tC_LineType.setCellValueFactory(new PropertyValueFactory<LineOne, String>("lineType"));

        tC_NumberLineOne = new TableColumn("Número de línea");
        tC_NumberLineOne.setMinWidth(100);
        tC_NumberLineOne.setEditable(true);
        tC_NumberLineOne.setCellValueFactory(new PropertyValueFactory<LineOne, String>("numberLine"));

        tC_NumberLineTwo = new TableColumn("Número de línea");
        tC_NumberLineTwo.setMinWidth(142);
        tC_NumberLineTwo.setEditable(true);
        tC_NumberLineTwo.setCellValueFactory(new PropertyValueFactory<LineFour, String>("numberLine"));

        tC_PEarned = new TableColumn("Puntos");
        tC_PEarned.setMinWidth(82);
        tC_PEarned.setEditable(true);
        tC_PEarned.setCellValueFactory(new PropertyValueFactory<LineOne, String>("pointsEarned"));

        tV_LinesOne.getColumns().addAll(tC_idOne, tC_LineType, tC_NumberLineOne, tC_PEarned);

        tV_LinesTwo.getColumns().addAll(tC_idTwo, tC_Email);

        tV_LinesThree.getColumns().addAll(tC_idThree, tC_Address);

        tV_LinesFour.getColumns().addAll(tC_idFour, tC_NumberLineTwo, tC_Phone);

    }

    @FXML
    private void handleButtonActionAdd(ActionEvent event) throws PersistanceException {

        if(tF_Id.getText().equals("") || tF_Phone.getText().equals("") || tF_Email.getText().equals("") ||
                tF_Address.getText().equals("") || tF_NumberLine.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Algunos datos no han sido ingresados");
        }
        else{

            lineOne = new LineOne(Integer.parseInt(tF_NumberLine.getText()), cB_LineType.getValue().toString(),
                    0, Integer.parseInt(tF_Id.getText()));
            lineTwo = new LineTwo(Integer.parseInt(tF_Id.getText()), tF_Email.getText());
            lineThree = new LineThree(Integer.parseInt(tF_Id.getText()), tF_Address.getText());
            lineFour = new LineFour(Integer.parseInt(tF_NumberLine.getText()), Integer.parseInt(tF_Id.getText()),
                    tF_Phone.getText());

            linePersistanceOne.create(lineOne);
            linePersistanceTwo.create(lineTwo);
            linePersistanceThree.create(lineThree);
            linePersistanceFour.create(lineFour);

            JOptionPane.showMessageDialog(null, "Registro completado");
            tF_NumberLine.setText("");
            tF_Address.setText("");
            tF_Email.setText("");
            tF_Phone.setText("");
            tF_Id.setText("");

        }

    }

    @FXML
    private void handleButtonActionAddTwo (ActionEvent event){

        P_LinePane.setVisible(true);
        P_LinePaneTwo.setVisible(false);
        P_LinePaneThree.setVisible(false);

    }

    @FXML
    private void handleButtonActionEditModify (ActionEvent event) throws PersistanceException {

        P_LinePane.setVisible(false);
        P_LinePaneTwo.setVisible(true);
        P_LinePaneThree.setVisible(false);

        tV_LinesOne.setItems(linePersistanceOne.read());

        tV_LinesTwo.setItems(linePersistanceTwo.read());

        tV_LinesThree.setItems(linePersistanceThree.read());

        tV_LinesFour.setItems(linePersistanceFour.read());

    }

    @FXML
    private void handleButtonActionView (ActionEvent event){

        P_LinePane.setVisible(false);
        P_LinePaneTwo.setVisible(false);
        P_LinePaneThree.setVisible(true);

    }


}
