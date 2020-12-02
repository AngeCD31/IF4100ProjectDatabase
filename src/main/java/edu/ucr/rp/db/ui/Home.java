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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.Pane;
import javafx.util.converter.IntegerStringConverter;

import javax.swing.JOptionPane;

public class Home {

    @FXML private Pane P_LinePane;
    @FXML private Pane P_LinePaneTwo;
    @FXML private Pane P_LinePaneThree;
    @FXML private ComboBox cB_LineType;
    @FXML private Button bT_Add;
    @FXML private Button bT_Remove;
    @FXML private Button bT_Modify;
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
        tV_LinesOne.setEditable(true);
        tV_LinesTwo.setEditable(true);
        tV_LinesThree.setEditable(true);
        tV_LinesFour.setEditable(true);

        P_LinePane.setVisible(false);
        P_LinePaneTwo.setVisible(false);
        P_LinePaneThree.setVisible(false);

        tC_idOne = new TableColumn("Cédula");
        tC_idOne.setMinWidth(75);
        tC_idOne.setEditable(true);
        tC_idOne.setCellValueFactory(new PropertyValueFactory<LineOne, Integer>("idCard"));
        tC_idOne.setCellFactory(TextFieldTableCell.<LineOne, Integer>forTableColumn(new IntegerStringConverter()));
        tC_idOne.setOnEditCommit(
                (EventHandler<TableColumn.CellEditEvent<LineOne, Integer>>) t -> t.getTableView().getItems().get(
                        t.getTablePosition().getRow()).setIdCard((t.getNewValue()))
        );

        tC_idTwo = new TableColumn("Cédula");
        tC_idTwo.setMinWidth(100);
        tC_idTwo.setEditable(true);
        tC_idTwo.setCellValueFactory(new PropertyValueFactory<LineTwo, Integer>("idCard"));
        tC_idTwo.setCellFactory(TextFieldTableCell.<LineTwo, Integer>forTableColumn(new IntegerStringConverter()));
        tC_idTwo.setOnEditCommit(
                (EventHandler<TableColumn.CellEditEvent<LineTwo, Integer>>) t -> t.getTableView().getItems().get(
                        t.getTablePosition().getRow()).setIdCard((t.getNewValue()))
        );

        tC_idThree = new TableColumn("Cédula");
        tC_idThree.setMinWidth(100);
        tC_idThree.setEditable(true);
        tC_idThree.setCellValueFactory(new PropertyValueFactory<LineThree, Integer>("idCard"));
        tC_idThree.setCellFactory(TextFieldTableCell.<LineThree, Integer>forTableColumn(new IntegerStringConverter()));
        tC_idThree.setOnEditCommit(
                (EventHandler<TableColumn.CellEditEvent<LineThree, Integer>>) t -> t.getTableView().getItems().get(
                        t.getTablePosition().getRow()).setIdCard((t.getNewValue()))
        );

        tC_idFour = new TableColumn("Cédula");
        tC_idFour.setMinWidth(100);
        tC_idFour.setEditable(true);
        tC_idFour.setCellValueFactory(new PropertyValueFactory<LineFour, Integer>("idCard"));
        tC_idFour.setCellFactory(TextFieldTableCell.<LineFour, Integer>forTableColumn(new IntegerStringConverter()));
        tC_idFour.setOnEditCommit(
                (EventHandler<TableColumn.CellEditEvent<LineFour, Integer>>) t -> t.getTableView().getItems().get(
                        t.getTablePosition().getRow()).setIdCard((t.getNewValue()))
        );


        tC_Phone = new TableColumn("Número contacto");
        tC_Phone.setMinWidth(120);
        tC_Phone.setEditable(true);
        tC_Phone.setCellValueFactory(new PropertyValueFactory<LineFour, String>("phone"));
        tC_Phone.setCellFactory(TextFieldTableCell.forTableColumn());
        tC_Phone.setOnEditCommit(
                (EventHandler<TableColumn.CellEditEvent<LineFour, String>>) t -> t.getTableView().getItems().get(
                        t.getTablePosition().getRow()).setPhone((t.getNewValue()))
        );

        tC_Email = new TableColumn("Correo");
        tC_Email.setMinWidth(263);
        tC_Email.setEditable(true);
        tC_Email.setCellValueFactory(new PropertyValueFactory<LineTwo, String>("email"));
        tC_Email.setCellFactory(TextFieldTableCell.forTableColumn());
        tC_Email.setOnEditCommit(
                (EventHandler<TableColumn.CellEditEvent<LineTwo, String>>) t -> t.getTableView().getItems().get(
                        t.getTablePosition().getRow()).setEmail((t.getNewValue()))
        );

        tC_Address = new TableColumn("Dirección");
        tC_Address.setMinWidth(263);
        tC_Address.setEditable(true);
        tC_Address.setCellValueFactory(new PropertyValueFactory<LineThree, String>("address"));
        tC_Address.setCellFactory(TextFieldTableCell.forTableColumn());
        tC_Address.setOnEditCommit(
                (EventHandler<TableColumn.CellEditEvent<LineThree, String>>) t -> t.getTableView().getItems().get(
                        t.getTablePosition().getRow()).setAddress((t.getNewValue()))
        );

        tC_LineType = new TableColumn("Tipo de línea");
        tC_LineType.setMinWidth(100);
        tC_LineType.setEditable(true);
        tC_LineType.setCellValueFactory(new PropertyValueFactory<LineOne, String>("lineType"));
        tC_LineType.setCellFactory(TextFieldTableCell.forTableColumn());
        tC_LineType.setOnEditCommit(
                (EventHandler<TableColumn.CellEditEvent<LineOne, String>>) t -> t.getTableView().getItems().get(
                        t.getTablePosition().getRow()).setLineType((t.getNewValue()))
        );

        tC_NumberLineOne = new TableColumn("Número de línea");
        tC_NumberLineOne.setMinWidth(100);
        tC_NumberLineOne.setEditable(true);
        tC_NumberLineOne.setCellValueFactory(new PropertyValueFactory<LineOne, Integer>("numberLine"));
        tC_NumberLineOne.setCellFactory(TextFieldTableCell.<LineOne, Integer>forTableColumn(new IntegerStringConverter()));
        tC_NumberLineOne.setOnEditCommit(
                (EventHandler<TableColumn.CellEditEvent<LineOne, Integer>>) t -> t.getTableView().getItems().get(
                        t.getTablePosition().getRow()).setNumberLine((t.getNewValue()))
        );

        tC_NumberLineTwo = new TableColumn("Número de línea");
        tC_NumberLineTwo.setMinWidth(142);
        tC_NumberLineTwo.setEditable(true);
        tC_NumberLineTwo.setCellValueFactory(new PropertyValueFactory<LineFour, Integer>("numberLine"));
        tC_NumberLineTwo.setCellFactory(TextFieldTableCell.<LineFour, Integer>forTableColumn(new IntegerStringConverter()));
        tC_NumberLineTwo.setOnEditCommit(
                (EventHandler<TableColumn.CellEditEvent<LineFour, Integer>>) t -> t.getTableView().getItems().get(
                        t.getTablePosition().getRow()).setNumberLine((t.getNewValue()))
        );

        tC_PEarned = new TableColumn("Puntos");
        tC_PEarned.setMinWidth(82);
        tC_PEarned.setEditable(true);
        tC_PEarned.setCellValueFactory(new PropertyValueFactory<LineOne, Integer>("pointsEarned"));
        tC_PEarned.setCellFactory(TextFieldTableCell.<LineOne, Integer>forTableColumn(new IntegerStringConverter()));
        tC_PEarned.setOnEditCommit(
                (EventHandler<TableColumn.CellEditEvent<LineOne, Integer>>) t -> t.getTableView().getItems().get(
                        t.getTablePosition().getRow()).setPointsEarned((t.getNewValue()))
        );

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
    private void handleButtonActionEditDelete (ActionEvent event) throws PersistanceException {

        P_LinePane.setVisible(false);
        P_LinePaneTwo.setVisible(true);
        P_LinePaneThree.setVisible(false);

        tV_LinesOne.setItems(linePersistanceOne.read());

        tV_LinesTwo.setItems(linePersistanceTwo.read());

        tV_LinesThree.setItems(linePersistanceThree.read());

        tV_LinesFour.setItems(linePersistanceFour.read());

    }

    @FXML
    private void handleButtonActionModify (ActionEvent event) throws PersistanceException {


            if(tV_LinesOne.getSelectionModel().getSelectedIndex() > -1){

                LineOne line = (LineOne) tV_LinesOne.getSelectionModel().getSelectedItem();
                linePersistanceOne.update(line);

            }
            else{
                if(tV_LinesTwo.getSelectionModel().getSelectedIndex() > -1){

                    LineTwo line = (LineTwo) tV_LinesTwo.getSelectionModel().getSelectedItem();
                    linePersistanceTwo.update(line);

                }
                else{
                    if(tV_LinesThree.getSelectionModel().getSelectedIndex() > -1){

                        LineThree line = (LineThree) tV_LinesThree.getSelectionModel().getSelectedItem();
                        linePersistanceThree.update(line);

                    }
                    else{
                        if(tV_LinesFour.getSelectionModel().getSelectedIndex() > -1){

                            LineFour line = (LineFour) tV_LinesFour.getSelectionModel().getSelectedItem();
                            linePersistanceFour.update(line);

                        }
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "Datos modificados, recargue la ventana");

    }

    @FXML
    private void handleButtonActionDelete (ActionEvent event) throws PersistanceException {

        int dialogButton = JOptionPane.showConfirmDialog (null, "Al borrar una de las filas de esta tabla se borrarán todas las filas relacionadas en otras tablas, ¿Está seguro de querer eliminarla?","ADVERTENCIA",JOptionPane.YES_NO_OPTION);

        if(dialogButton == JOptionPane.YES_OPTION) {


       if(tV_LinesOne.getSelectionModel().getSelectedIndex() > -1){

            LineOne line = (LineOne) tV_LinesOne.getSelectionModel().getSelectedItem();
            linePersistanceOne.delete(line);

       }
       else{
           if(tV_LinesTwo.getSelectionModel().getSelectedIndex() > -1){

               LineTwo line = (LineTwo) tV_LinesTwo.getSelectionModel().getSelectedItem();
               linePersistanceTwo.delete(line);

           }
           else{
               if(tV_LinesThree.getSelectionModel().getSelectedIndex() > -1){

                   LineThree line = (LineThree) tV_LinesThree.getSelectionModel().getSelectedItem();
                   linePersistanceThree.delete(line);

               }
               else{
                   if(tV_LinesFour.getSelectionModel().getSelectedIndex() > -1){

                       LineFour line = (LineFour) tV_LinesFour.getSelectionModel().getSelectedItem();
                       linePersistanceFour.delete(line);

                   }
               }
           }
       }
            JOptionPane.showMessageDialog(null, "Datos eliminados, recargue la ventana");
        }
        else {
           JOptionPane.showMessageDialog(null, "No se ha eliminado ningún dato");
        }

    }

    @FXML
    private void handleButtonActionView (ActionEvent event){

        P_LinePane.setVisible(false);
        P_LinePaneTwo.setVisible(false);
        P_LinePaneThree.setVisible(true);

    }


}
