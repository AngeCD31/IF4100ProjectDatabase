package edu.ucr.rp.db.persistance;

import edu.ucr.rp.db.domain.LineOne;
import edu.ucr.rp.db.util.ConnectionDB;
import edu.ucr.rp.db.util.LineBuilderOne;
import javafx.collections.FXCollections;
import javafx.collections.FXCollections.*;
import javafx.collections.ObservableList;
import javafx.collections.ObservableList.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LinePersistanceOne implements Persistance<LineOne, String>{

    private static Connection connection;

    public LinePersistanceOne() {
        try {
            refreshConnection();
        } catch (PersistanceException ignored) {

        }
    }

    private void refreshConnection() throws PersistanceException {
        try {
            connection = ConnectionDB.getConnection();
            if (connection == null)
                throw new PersistanceException("Error de conexión");
            System.out.println("Conexión activa...");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new PersistanceException(ex.getMessage());
        }
    }

    //Inserta nueva línea
    @Override
    public void create(LineOne line) throws PersistanceException {

        if (connection == null)
            throw new PersistanceException("Error con la conexión");
        try {
            PreparedStatement statement =
                    connection.prepareStatement("insert into LineOne (NumberLine, LineType, PointsEarned, IdCard" +
                                                ") values (?,?,?,?)");
            statement.setString(1, (Integer.toString(line.getNumberLine())));
            statement.setString(2, line.getLineType());
            statement.setString(3, (Integer.toString(line.getPointsEarned())));
            statement.setString(4, (Integer.toString(line.getIdCard())));
            statement.executeUpdate();
            System.out.println("Statement excecuted: " + "insert into LineOne (NumberLine, LineType, PointsEarned, IdCard" +
                               ") values ("
                    + line.getNumberLine() +", "
                    + line.getLineType() + ", "
                    + line.getPointsEarned() +", "
                    + line.getIdCard() +")");
        } catch (SQLException ex) {
            throw new PersistanceException(ex.getMessage());
        }
    }

    //Lee lista de líneas
    @Override
    public List<LineOne> read(String key) throws PersistanceException {
        return null;
    }

    @Override
    public ObservableList read() throws PersistanceException {
        ObservableList list = FXCollections.observableArrayList();
        ResultSet resultSet;
        try {
            PreparedStatement statement = connection.prepareStatement("select * from LineOne");
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                LineOne line = new LineBuilderOne().build();
                        line.setNumberLine(resultSet.getInt("NumberLine"));
                        line.setLineType(resultSet.getString("LineType"));
                        line.setPointsEarned(resultSet.getInt("PointsEarned"));
                        line.setIdCard(resultSet.getInt("IdCard"));
                list.add(line);
            }
        } catch (SQLException ex) {
            throw new PersistanceException(ex.getMessage());
        }
        return list;
    }

    //Actualiza los valores de una línea
    @Override
    public void update(LineOne line) throws PersistanceException {
        if (connection == null)
            throw new PersistanceException("Error con la conexión");
        try {
            PreparedStatement statement =
                    connection.prepareStatement("update LineOne set NumberLine=?, LineType=?, PointsEarned=?, " +
                                                "where IdCard=?");
            statement.setString(1, (Integer.toString(line.getNumberLine())));
            statement.setString(2, line.getLineType());
            statement.setString(3, (Integer.toString(line.getPointsEarned())));
            statement.setInt(4, line.getIdCard());
            statement.executeUpdate();
            System.out.println("Statement executed: " + "update LineOne set " +
                    "NumberLine = " + line.getNumberLine() + ", LineType= "
                    + line.getLineType() + ", PointsEarned= "
                    + line.getPointsEarned() + "where IdCard="
                    + line.getIdCard() +")");
        } catch (SQLException ex) {
            throw new PersistanceException(ex.getMessage());
        }
    }

    //Elimina un estudiante
    @Override
    public void delete(LineOne line) throws PersistanceException {

        if (connection == null)
            throw new PersistanceException("Error con la conexión");
        try {
            PreparedStatement statement =
                    connection.prepareStatement("delete from LineOne where IdCard=?");
            statement.setInt(1, line.getIdCard());
            statement.executeUpdate();
            System.out.println("delete from LineOne where IdCard= "
                    + line.getIdCard() +")");
        } catch (SQLException ex) {
            throw new PersistanceException(ex.getMessage());
        }

    }

    @Override
    public boolean isConnected() {
        return connection != null;
    }

    public ResultSet execute(String statement) throws PersistanceException {
        if (connection == null)
            throw new PersistanceException("Error con la conexión");

        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try {
            preparedStatement = connection.prepareStatement(statement);
            resultSet = preparedStatement.executeQuery();
            System.out.println("Statement excecuted: " + statement);
            return resultSet;
        } catch (Exception e) {
            throw new PersistanceException(e.getMessage());
        }
    }
}
