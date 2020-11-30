package edu.ucr.rp.db.ui;

import edu.ucr.rp.db.domain.LineFour;
import edu.ucr.rp.db.domain.LineOne;
import edu.ucr.rp.db.domain.LineThree;
import edu.ucr.rp.db.domain.LineTwo;
import edu.ucr.rp.db.persistance.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;

public class Home {

    @FXML private Pane P_LinePane;
    @FXML private ComboBox cB_LineType;
    @FXML private Button bT_Add;
    @FXML private Button bT_Remove;
    @FXML private TextField tF_Id;
    @FXML private TextField tF_Phone;
    @FXML private TextField tF_Email;
    @FXML private TextField tF_Address;
    @FXML private TextField tF_NumberLine;

    LineOne lineOne;
    LineTwo lineTwo;
    LineThree lineThree;
    LineFour lineFour;
    LinePersistanceOne linePersistanceOne = new LinePersistanceOne();
    LinePersistanceTwo linePersistanceTwo = new LinePersistanceTwo();
    LinePersistanceThree linePersistanceThree = new LinePersistanceThree();
    LinePersistanceFour linePersistanceFour = new LinePersistanceFour();

    @FXML
    public void initialize(){

        cB_LineType.getItems().addAll("Básica", "ADSL", "RDSI");

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

}
