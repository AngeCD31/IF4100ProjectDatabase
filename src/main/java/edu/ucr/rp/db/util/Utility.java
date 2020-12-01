package edu.ucr.rp.db.util;

import edu.ucr.rp.db.persistance.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class Utility {

    public static boolean isNumber(char value) {
        return Character.isDigit(value);
    }

    public static ObservableList listOne() throws PersistanceException {
        LinePersistanceOne linePersistanceOne = new LinePersistanceOne();

        List listOne = linePersistanceOne.read();

        ObservableList o = FXCollections.observableArrayList();

        for (int i = 1; i < listOne.size(); i++){
            o.add(listOne.get(i));
            System.out.println(i);
        }

        return o;
    }

    public static ObservableList listThree() throws PersistanceException {
        LinePersistanceThree linePersistanceThree = new LinePersistanceThree();

        List lineThrees = linePersistanceThree.read();

        ObservableList o = FXCollections.observableArrayList();

        for (int i = 1; i < lineThrees.size(); i++){
            o.add(lineThrees.get(i));
            System.out.println(i);
        }

        return o;
    }

    public static ObservableList listTwo() throws PersistanceException {
        LinePersistanceTwo linePersistanceTwo = new LinePersistanceTwo();

        List lineTwo = linePersistanceTwo.read();

        ObservableList o = FXCollections.observableArrayList();

        for (int i = 1; i < lineTwo.size(); i++){
            o.add(lineTwo.get(i));
            System.out.println(i);
        }

        return o;
    }

    public static ObservableList listFour() throws PersistanceException {
        LinePersistanceFour linePersistanceFour = new LinePersistanceFour();

        List lineFour = linePersistanceFour.read();

        ObservableList o = FXCollections.observableArrayList();

        for (int i = 1; i < lineFour.size(); i++){
            o.add(lineFour.get(i));
            System.out.println(i);
        }

        return o;
    }

    //String str = "texto aquí";

//for (int n = 0, n <str.length (); n + +) { char c = str.charAt (n); System.out.println (c); }


}
