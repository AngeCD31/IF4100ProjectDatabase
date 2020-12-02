package edu.ucr.rp.db.ui;

import edu.ucr.rp.db.domain.*;
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
    @FXML private TableView tV_View;
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
    @FXML private TableColumn tC_CRSOne = new TableColumn();
    @FXML private TableColumn tC_UVSOne = new TableColumn();
    @FXML private TableColumn tC_CRSTwo = new TableColumn();
    @FXML private TableColumn tC_UVSTwo = new TableColumn();
    @FXML private TableColumn tC_CRSThree = new TableColumn();
    @FXML private TableColumn tC_UVSThree = new TableColumn();
    @FXML private TableColumn tC_CRSFour = new TableColumn();
    @FXML private TableColumn tC_UVSFour = new TableColumn();
    @FXML private TableColumn tC_idView = new TableColumn();
    @FXML private TableColumn tC_EmailView = new TableColumn();
    @FXML private TableColumn tC_AddressView = new TableColumn();
    @FXML private TableColumn tC_NumberLineView = new TableColumn();
    @FXML private TableColumn tC_PEarnedView = new TableColumn();

    LineOne lineOne;
    LineTwo lineTwo;
    LineThree lineThree;
    LineFour lineFour;
    LinePersistanceOne linePersistanceOne = new LinePersistanceOne();
    LinePersistanceTwo linePersistanceTwo = new LinePersistanceTwo();
    LinePersistanceThree linePersistanceThree = new LinePersistanceThree();
    LinePersistanceFour linePersistanceFour = new LinePersistanceFour();
    ViewPersistance viewPersistance = new ViewPersistance();
    @FXML
    public void initialize() {

        cB_LineType.getItems().addAll("Básica", "ADSL", "RDSI");
        tV_LinesOne.setEditable(true);
        tV_LinesTwo.setEditable(true);
        tV_LinesThree.setEditable(true);
        tV_LinesFour.setEditable(true);
        tV_View.setEditable(true);

        P_LinePane.setVisible(false);
        P_LinePaneTwo.setVisible(false);
        P_LinePaneThree.setVisible(false);

        tC_idOne = new TableColumn("Cédula");
        tC_idOne.setMinWidth(20);
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
        tC_idFour.setMinWidth(20);
        tC_idFour.setEditable(true);
        tC_idFour.setCellValueFactory(new PropertyValueFactory<LineFour, Integer>("idCard"));
        tC_idFour.setCellFactory(TextFieldTableCell.<LineFour, Integer>forTableColumn(new IntegerStringConverter()));
        tC_idFour.setOnEditCommit(
                (EventHandler<TableColumn.CellEditEvent<LineFour, Integer>>) t -> t.getTableView().getItems().get(
                        t.getTablePosition().getRow()).setIdCard((t.getNewValue()))
        );


        tC_Phone = new TableColumn("Número contacto");
        tC_Phone.setMinWidth(110);
        tC_Phone.setEditable(true);
        tC_Phone.setCellValueFactory(new PropertyValueFactory<LineFour, String>("phone"));
        tC_Phone.setCellFactory(TextFieldTableCell.forTableColumn());
        tC_Phone.setOnEditCommit(
                (EventHandler<TableColumn.CellEditEvent<LineFour, String>>) t -> t.getTableView().getItems().get(
                        t.getTablePosition().getRow()).setPhone((t.getNewValue()))
        );

        tC_Email = new TableColumn("Correo");
        tC_Email.setMinWidth(150);
        tC_Email.setEditable(true);
        tC_Email.setCellValueFactory(new PropertyValueFactory<LineTwo, String>("email"));
        tC_Email.setCellFactory(TextFieldTableCell.forTableColumn());
        tC_Email.setOnEditCommit(
                (EventHandler<TableColumn.CellEditEvent<LineTwo, String>>) t -> t.getTableView().getItems().get(
                        t.getTablePosition().getRow()).setEmail((t.getNewValue()))
        );

        tC_Address = new TableColumn("Dirección");
        tC_Address.setMinWidth(150);
        tC_Address.setEditable(true);
        tC_Address.setCellValueFactory(new PropertyValueFactory<LineThree, String>("address"));
        tC_Address.setCellFactory(TextFieldTableCell.forTableColumn());
        tC_Address.setOnEditCommit(
                (EventHandler<TableColumn.CellEditEvent<LineThree, String>>) t -> t.getTableView().getItems().get(
                        t.getTablePosition().getRow()).setAddress((t.getNewValue()))
        );

        tC_LineType = new TableColumn("Tipo de línea");
        tC_LineType.setMinWidth(50);
        tC_LineType.setEditable(true);
        tC_LineType.setCellValueFactory(new PropertyValueFactory<LineOne, String>("lineType"));
        tC_LineType.setCellFactory(TextFieldTableCell.forTableColumn());
        tC_LineType.setOnEditCommit(
                (EventHandler<TableColumn.CellEditEvent<LineOne, String>>) t -> t.getTableView().getItems().get(
                        t.getTablePosition().getRow()).setLineType((t.getNewValue()))
        );

        tC_NumberLineOne = new TableColumn("Número de línea");
        tC_NumberLineOne.setMinWidth(50);
        tC_NumberLineOne.setEditable(true);
        tC_NumberLineOne.setCellValueFactory(new PropertyValueFactory<LineOne, Integer>("numberLine"));
        tC_NumberLineOne.setCellFactory(TextFieldTableCell.<LineOne, Integer>forTableColumn(new IntegerStringConverter()));
        tC_NumberLineOne.setOnEditCommit(
                (EventHandler<TableColumn.CellEditEvent<LineOne, Integer>>) t -> t.getTableView().getItems().get(
                        t.getTablePosition().getRow()).setNumberLine((t.getNewValue()))
        );

        tC_NumberLineTwo = new TableColumn("Número de línea");
        tC_NumberLineTwo.setMinWidth(100);
        tC_NumberLineTwo.setEditable(true);
        tC_NumberLineTwo.setCellValueFactory(new PropertyValueFactory<LineFour, Integer>("numberLine"));
        tC_NumberLineTwo.setCellFactory(TextFieldTableCell.<LineFour, Integer>forTableColumn(new IntegerStringConverter()));
        tC_NumberLineTwo.setOnEditCommit(
                (EventHandler<TableColumn.CellEditEvent<LineFour, Integer>>) t -> t.getTableView().getItems().get(
                        t.getTablePosition().getRow()).setNumberLine((t.getNewValue()))
        );

        tC_PEarned = new TableColumn("Puntos");
        tC_PEarned.setMinWidth(20);
        tC_PEarned.setEditable(true);
        tC_PEarned.setCellValueFactory(new PropertyValueFactory<LineOne, Integer>("pointsEarned"));
        tC_PEarned.setCellFactory(TextFieldTableCell.<LineOne, Integer>forTableColumn(new IntegerStringConverter()));
        tC_PEarned.setOnEditCommit(
                (EventHandler<TableColumn.CellEditEvent<LineOne, Integer>>) t -> t.getTableView().getItems().get(
                        t.getTablePosition().getRow()).setPointsEarned((t.getNewValue()))
        );

        tC_CRSOne = new TableColumn("Estado RC");
        tC_CRSOne.setMinWidth(50);
        tC_CRSOne.setEditable(true);
        tC_CRSOne.setCellValueFactory(new PropertyValueFactory<LineOne, String>("CRS"));
        tC_CRSOne.setCellFactory(TextFieldTableCell.forTableColumn());
        tC_CRSOne.setOnEditCommit(
                (EventHandler<TableColumn.CellEditEvent<LineOne, String>>) t -> t.getTableView().getItems().get(
                        t.getTablePosition().getRow()).setCRS((t.getNewValue()))
        );

        tC_UVSOne = new TableColumn("Estado RA");
        tC_UVSOne.setMinWidth(50);
        tC_UVSOne.setEditable(true);
        tC_UVSOne.setCellValueFactory(new PropertyValueFactory<LineOne, String>("UVS"));
        tC_UVSOne.setCellFactory(TextFieldTableCell.forTableColumn());
        tC_UVSOne.setOnEditCommit(
                (EventHandler<TableColumn.CellEditEvent<LineOne, String>>) t -> t.getTableView().getItems().get(
                        t.getTablePosition().getRow()).setUVS((t.getNewValue()))
        );

        tC_CRSTwo = new TableColumn("Estado RC");
        tC_CRSTwo.setMinWidth(100);
        tC_CRSTwo.setEditable(true);
        tC_CRSTwo.setCellValueFactory(new PropertyValueFactory<LineTwo, String>("CRS"));
        tC_CRSTwo.setCellFactory(TextFieldTableCell.forTableColumn());
        tC_CRSTwo.setOnEditCommit(
                (EventHandler<TableColumn.CellEditEvent<LineTwo, String>>) t -> t.getTableView().getItems().get(
                        t.getTablePosition().getRow()).setCRS((t.getNewValue()))
        );

        tC_UVSTwo = new TableColumn("Estado RA");
        tC_UVSTwo.setMinWidth(100);
        tC_UVSTwo.setEditable(true);
        tC_UVSTwo.setCellValueFactory(new PropertyValueFactory<LineTwo, String>("UVS"));
        tC_UVSTwo.setCellFactory(TextFieldTableCell.forTableColumn());
        tC_UVSTwo.setOnEditCommit(
                (EventHandler<TableColumn.CellEditEvent<LineTwo, String>>) t -> t.getTableView().getItems().get(
                        t.getTablePosition().getRow()).setUVS((t.getNewValue()))
        );

        tC_CRSThree = new TableColumn("Estado RC");
        tC_CRSThree.setMinWidth(100);
        tC_CRSThree.setEditable(true);
        tC_CRSThree.setCellValueFactory(new PropertyValueFactory<LineThree, String>("CRS"));
        tC_CRSThree.setCellFactory(TextFieldTableCell.forTableColumn());
        tC_CRSThree.setOnEditCommit(
                (EventHandler<TableColumn.CellEditEvent<LineThree, String>>) t -> t.getTableView().getItems().get(
                        t.getTablePosition().getRow()).setCRS((t.getNewValue()))
        );

        tC_UVSThree = new TableColumn("Estado RA");
        tC_UVSThree.setMinWidth(100);
        tC_UVSThree.setEditable(true);
        tC_UVSThree.setCellValueFactory(new PropertyValueFactory<LineThree, String>("UVS"));
        tC_UVSThree.setCellFactory(TextFieldTableCell.forTableColumn());
        tC_UVSThree.setOnEditCommit(
                (EventHandler<TableColumn.CellEditEvent<LineThree, String>>) t -> t.getTableView().getItems().get(
                        t.getTablePosition().getRow()).setUVS((t.getNewValue()))
        );

        tC_CRSFour = new TableColumn("Estado RC");
        tC_CRSFour.setMinWidth(50);
        tC_CRSFour.setEditable(true);
        tC_CRSFour.setCellValueFactory(new PropertyValueFactory<LineFour, String>("CRS"));
        tC_CRSFour.setCellFactory(TextFieldTableCell.forTableColumn());
        tC_CRSFour.setOnEditCommit(
                (EventHandler<TableColumn.CellEditEvent<LineFour, String>>) t -> t.getTableView().getItems().get(
                        t.getTablePosition().getRow()).setCRS((t.getNewValue()))
        );

        tC_UVSFour = new TableColumn("Estado RA");
        tC_UVSFour.setMinWidth(55);
        tC_UVSFour.setEditable(true);
        tC_UVSFour.setCellValueFactory(new PropertyValueFactory<LineFour, String>("UVS"));
        tC_UVSFour.setCellFactory(TextFieldTableCell.forTableColumn());
        tC_UVSFour.setOnEditCommit(
                (EventHandler<TableColumn.CellEditEvent<LineFour, String>>) t -> t.getTableView().getItems().get(
                        t.getTablePosition().getRow()).setUVS((t.getNewValue()))
        );

        tC_idView = new TableColumn("Cédula");
        tC_idView.setMinWidth(100);
        tC_idView.setEditable(true);
        tC_idView.setCellValueFactory(new PropertyValueFactory<View, Integer>("idCard"));
        tC_idView.setCellFactory(TextFieldTableCell.<View, Integer>forTableColumn(new IntegerStringConverter()));
        tC_idView.setOnEditCommit(
                (EventHandler<TableColumn.CellEditEvent<View, Integer>>) t -> t.getTableView().getItems().get(
                        t.getTablePosition().getRow()).setIdCard((t.getNewValue()))
        );

        tC_EmailView = new TableColumn("Correo");
        tC_EmailView.setMinWidth(150);
        tC_EmailView.setEditable(true);
        tC_EmailView.setCellValueFactory(new PropertyValueFactory<View, String>("email"));
        tC_EmailView.setCellFactory(TextFieldTableCell.forTableColumn());
        tC_EmailView.setOnEditCommit(
                (EventHandler<TableColumn.CellEditEvent<View, String>>) t -> t.getTableView().getItems().get(
                        t.getTablePosition().getRow()).setEmail((t.getNewValue()))
        );

        tC_AddressView = new TableColumn("Dirección");
        tC_AddressView.setMinWidth(200);
        tC_AddressView.setEditable(true);
        tC_AddressView.setCellValueFactory(new PropertyValueFactory<View, String>("address"));
        tC_AddressView.setCellFactory(TextFieldTableCell.forTableColumn());
        tC_AddressView.setOnEditCommit(
                (EventHandler<TableColumn.CellEditEvent<View, String>>) t -> t.getTableView().getItems().get(
                        t.getTablePosition().getRow()).setAddress((t.getNewValue()))
        );

        tC_NumberLineView = new TableColumn("Número de línea");
        tC_NumberLineView.setMinWidth(150);
        tC_NumberLineView.setEditable(true);
        tC_NumberLineView.setCellValueFactory(new PropertyValueFactory<View, Integer>("numberLine"));
        tC_NumberLineView.setCellFactory(TextFieldTableCell.<View, Integer>forTableColumn(new IntegerStringConverter()));
        tC_NumberLineView.setOnEditCommit(
                (EventHandler<TableColumn.CellEditEvent<View, Integer>>) t -> t.getTableView().getItems().get(
                        t.getTablePosition().getRow()).setNumberLine((t.getNewValue()))
        );

        tC_PEarnedView = new TableColumn("Puntos");
        tC_PEarnedView.setMinWidth(200);
        tC_PEarnedView.setEditable(true);
        tC_PEarnedView.setCellValueFactory(new PropertyValueFactory<View, Integer>("pointsEarned"));
        tC_PEarnedView.setCellFactory(TextFieldTableCell.<View, Integer>forTableColumn(new IntegerStringConverter()));
        tC_PEarnedView.setOnEditCommit(
                (EventHandler<TableColumn.CellEditEvent<View, Integer>>) t -> t.getTableView().getItems().get(
                        t.getTablePosition().getRow()).setPointsEarned((t.getNewValue()))
        );

        tV_LinesOne.getColumns().addAll(tC_idOne, tC_LineType, tC_NumberLineOne, tC_PEarned, tC_CRSOne, tC_UVSOne);

        tV_LinesTwo.getColumns().addAll(tC_idTwo, tC_Email, tC_CRSTwo, tC_UVSTwo);

        tV_LinesThree.getColumns().addAll(tC_idThree, tC_Address, tC_CRSThree, tC_UVSThree);

        tV_LinesFour.getColumns().addAll(tC_idFour, tC_NumberLineTwo, tC_Phone, tC_CRSFour, tC_UVSFour);

        tV_View.getColumns().addAll(tC_idView, tC_AddressView, tC_EmailView, tC_NumberLineView, tC_PEarnedView);

    }

    @FXML
    private void handleButtonActionAdd(ActionEvent event) throws PersistanceException {

        if(tF_Id.getText().equals("") || tF_Phone.getText().equals("") || tF_Email.getText().equals("") ||
                tF_Address.getText().equals("") || tF_NumberLine.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Algunos datos no han sido ingresados");
        }
        else {
            if (!Utility.isNumber(tF_Id.getText()) || !Utility.isNumber(tF_NumberLine.getText())) {
                JOptionPane.showMessageDialog(null, "Tanto el Id como el Número de línea deben ser completamente numéricos, por favor revise los datos ingresados");
            }
            else {

                lineOne = new LineOne(Integer.parseInt(tF_NumberLine.getText()), cB_LineType.getValue().toString(),
                        0, Integer.parseInt(tF_Id.getText()), "A", "A");
                lineTwo = new LineTwo(Integer.parseInt(tF_Id.getText()), tF_Email.getText(), "A", "A");
                lineThree = new LineThree(Integer.parseInt(tF_Id.getText()), tF_Address.getText(), "A", "A");
                lineFour = new LineFour(Integer.parseInt(tF_NumberLine.getText()), Integer.parseInt(tF_Id.getText()),
                        tF_Phone.getText(), "A", "A");

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
    private void handleButtonActionView (ActionEvent event) throws PersistanceException {

        P_LinePane.setVisible(false);
        P_LinePaneTwo.setVisible(false);
        P_LinePaneThree.setVisible(true);

        tV_View.setItems(viewPersistance.read());

    }


}
