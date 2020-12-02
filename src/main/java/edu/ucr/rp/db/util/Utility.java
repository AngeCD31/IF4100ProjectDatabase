package edu.ucr.rp.db.util;

import edu.ucr.rp.db.persistance.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class Utility {

    public static boolean isNumber(String value) {

        for (int n = 0; n < value.length (); n++) {
            char c = value.charAt (n);
            boolean out = Character.isDigit(c);
                if(out==false){
                    return false;
                }
        }

        return true;
    }






}
