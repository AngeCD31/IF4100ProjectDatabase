package edu.ucr.rp.db.persistance;

import edu.ucr.rp.db.domain.LineThree;
import edu.ucr.rp.db.util.ConnectionDB;
import edu.ucr.rp.db.util.LineBuilderThree;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LinePersistanceThree implements Persistance<LineThree, String>{

    private static Connection connection;

    public LinePersistanceThree() {
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
    public void create(LineThree line) throws PersistanceException {

        if (connection == null)
            throw new PersistanceException("Error con la conexión");
        try {
            PreparedStatement statement =
                    connection.prepareStatement("insert into LineThree (IdCard, Address, Creation_Records_Status, Update_Records_Status) values (?,?,?,?)");
            statement.setString(1, (Integer.toString(line.getIdCard())));
            statement.setString(2, line.getAddress());
            statement.setString(3, (line.getCRS()));
            statement.setString(4, (line.getUVS()));
            statement.executeUpdate();
            System.out.println("Statement excecuted: " + "insert into LineThree (IdCard, Address) values ("
                    + line.getIdCard() +", "
                    + line.getAddress() +")");
        } catch (SQLException ex) {
            throw new PersistanceException(ex.getMessage());
        }
    }

    //Lee lista de líneas
    @Override
    public List<LineThree> read(String key) throws PersistanceException {
        return null;
    }

    @Override
    public ObservableList read() throws PersistanceException {
        ObservableList list = FXCollections.observableArrayList();
        ResultSet resultSet;
        try {
            PreparedStatement statement = connection.prepareStatement("select * from LineThree");
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                LineThree line = new LineBuilderThree().build();
                        line.setIdCard(resultSet.getInt("IdCard"));
                        line.setAddress(resultSet.getString("Address"));
                        line.setCRS(resultSet.getString("Creation_Records_Status"));
                        line.setUVS(resultSet.getString("Update_Records_Status"));
                list.add(line);
            }
        } catch (SQLException ex) {
            throw new PersistanceException(ex.getMessage());
        }
        return list;
    }

    //Actualiza los valores de una línea
    @Override
    public void update(LineThree line) throws PersistanceException {
        if (connection == null)
            throw new PersistanceException("Error con la conexión");
        try {
            PreparedStatement statement =
                    connection.prepareStatement("update LineThree set Address=?,  Creation_Records_Status=?, Update_Records_Status=? where IdCard=?");
            statement.setString(1, line.getAddress());
            statement.setInt(4, line.getIdCard());
            statement.setString(2, line.getCRS());
            statement.setString(3, line.getUVS());
            statement.executeUpdate();
            System.out.println("Statement executed: " + "update LineThree set " +
                    "Address= "
                    + line.getAddress() + "where IdCard="
                    + line.getIdCard() +")");
        } catch (SQLException ex) {
            throw new PersistanceException(ex.getMessage());
        }
    }

    @Override
    public void delete(LineThree line) throws PersistanceException {

        if (connection == null)
            throw new PersistanceException("Error con la conexión");
        try {
            PreparedStatement statement =
                    connection.prepareStatement("delete from LineThree where IdCard=?");
            statement.setInt(1, line.getIdCard());
            statement.executeUpdate();
            System.out.println("delete from LineThree where IdCard= "
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
