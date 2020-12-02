package edu.ucr.rp.db.persistance;

import edu.ucr.rp.db.domain.LineTwo;
import edu.ucr.rp.db.util.ConnectionDB;
import edu.ucr.rp.db.util.LineBuilderTwo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LinePersistanceTwo implements Persistance<LineTwo, String>{

    private static Connection connection;

    public LinePersistanceTwo() {
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
    public void create(LineTwo line) throws PersistanceException {

        if (connection == null)
            throw new PersistanceException("Error con la conexión");
        try {
            PreparedStatement statement =
                    connection.prepareStatement("insert into LineTwo (IdCard, " +
                                                "Email) values (?,?)");
            statement.setString(1, (Integer.toString(line.getIdCard())));
            statement.setString(2, line.getEmail());
            statement.executeUpdate();
            System.out.println("Statement excecuted: " + "insert into LineTwo (IdCard, " +
                               "Email) values ("
                    + line.getIdCard() +", "
                    + line.getEmail() +")");
        } catch (SQLException ex) {
            throw new PersistanceException(ex.getMessage());
        }
    }

    //Lee lista de líneas
    @Override
    public List<LineTwo> read(String key) throws PersistanceException {
        return null;
    }

    @Override
    public ObservableList read() throws PersistanceException {
        ObservableList list = FXCollections.observableArrayList();
        ResultSet resultSet;
        try {
            PreparedStatement statement = connection.prepareStatement("select * from LineTwo");
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                LineTwo line = new LineBuilderTwo().build();
                        line.setIdCard(resultSet.getInt("IdCard"));
                        line.setEmail(resultSet.getString("Email"));
                list.add(line);
            }
        } catch (SQLException ex) {
            throw new PersistanceException(ex.getMessage());
        }
        return list;
    }

    //Actualiza los valores de una línea
    @Override
    public void update(LineTwo line) throws PersistanceException {
        if (connection == null)
            throw new PersistanceException("Error con la conexión");
        try {
            PreparedStatement statement =
                    connection.prepareStatement("update LineTwo set Email=? where IdCard=?");
            statement.setInt(2, line.getIdCard());
            statement.setString(1, line.getEmail());
            statement.executeUpdate();
            System.out.println("Statement executed: " + "update LineTwo set "
                    + ", Email= " + "where IdCard="
                    + line.getIdCard() +")");
        } catch (SQLException ex) {
            throw new PersistanceException(ex.getMessage());
        }
    }

    //Elimina un estudiante
    @Override
    public void delete(LineTwo line) throws PersistanceException {

        if (connection == null)
            throw new PersistanceException("Error con la conexión");
        try {
            PreparedStatement statement =
                    connection.prepareStatement("delete from LineTwo where IdCard=?");
            statement.setInt(1, line.getIdCard());
            statement.executeUpdate();
            System.out.println("delete from LineTwo where IdCard= "
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
