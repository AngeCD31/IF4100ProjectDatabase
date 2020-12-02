package edu.ucr.rp.db.persistance;

import edu.ucr.rp.db.domain.LineOne;
import edu.ucr.rp.db.domain.View;
import edu.ucr.rp.db.util.ConnectionDB;
import edu.ucr.rp.db.util.LineBuilderOne;
import edu.ucr.rp.db.util.ViewBuilder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ViewPersistance implements Persistance<View, String>{

    private static Connection connection;

    public ViewPersistance() {
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

    @Override
    public void create(View object) throws PersistanceException {

    }

    @Override
    public List<View> read(String key) throws PersistanceException {
        return null;
    }

    @Override
    public ObservableList read() throws PersistanceException {
        ObservableList list = FXCollections.observableArrayList();
        ResultSet resultSet;
        try {
            PreparedStatement statement = connection.prepareStatement("select * from ClientsTop20");
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                View line = new ViewBuilder().build();
                line.setIdCard(resultSet.getInt("IdCard"));
                line.setAddress(resultSet.getString("Address"));
                line.setNumberLine(resultSet.getInt("NumberLine"));
                line.setEmail(resultSet.getString("Email"));
                line.setPointsEarned(resultSet.getInt("PointsEarned"));
                list.add(line);
            }
        } catch (SQLException ex) {
            throw new PersistanceException(ex.getMessage());
        }
        return list;
    }

    @Override
    public void update(View object) throws PersistanceException {

    }

    @Override
    public void delete(View object) throws PersistanceException {

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
