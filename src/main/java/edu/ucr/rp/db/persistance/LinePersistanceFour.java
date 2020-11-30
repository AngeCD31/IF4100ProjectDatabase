package edu.ucr.rp.db.persistance;

import edu.ucr.rp.db.domain.LineFour;
import edu.ucr.rp.db.util.ConnectionDB;
import edu.ucr.rp.db.util.LineBuilderFour;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LinePersistanceFour implements Persistance<LineFour, String>{

    private static Connection connection;

    public LinePersistanceFour() {
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
    public void create(LineFour line) throws PersistanceException {

        if (connection == null)
            throw new PersistanceException("Error con la conexión");
        try {
            PreparedStatement statement =
                    connection.prepareStatement("insert into LineFour (NumberLine, IdCard, Phone) values (?,?,?)");
            statement.setString(1, (Integer.toString(line.getNumberLine())));
            statement.setString(2, (Integer.toString(line.getIdCard())));
            statement.setString(3, line.getPhone());
            statement.executeUpdate();
            System.out.println("Statement excecuted: " + "insert into LineFour (NumberLine, IdCard, Phone) values ("
                    + line.getNumberLine() +", "
                    + line.getIdCard() +", "
                    + line.getPhone() +")");
        } catch (SQLException ex) {
            throw new PersistanceException(ex.getMessage());
        }
    }

    //Lee lista de líneas
    @Override
    public List<LineFour> read(String key) throws PersistanceException {
        return null;
    }

    @Override
    public List<LineFour> read() throws PersistanceException {
        List<LineFour> list = new ArrayList<>();
        ResultSet resultSet;
        try {
            PreparedStatement statement = connection.prepareStatement("select * from LineFour");
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                LineFour line = new LineBuilderFour().build();
                        line.setNumberLine(resultSet.getInt("NumberLine"));
                        line.setIdCard(resultSet.getInt("IdCard"));
                        line.setPhone(resultSet.getString("Phone"));
                list.add(line);
            }
        } catch (SQLException ex) {
            throw new PersistanceException(ex.getMessage());
        }
        return list;
    }

    //Actualiza los valores de una línea
    @Override
    public void update(LineFour line) throws PersistanceException {
        if (connection == null)
            throw new PersistanceException("Error con la conexión");
        try {
            PreparedStatement statement =
                    connection.prepareStatement("update LineFour set NumberLine=?, Phone=? where IdCard=?");
            statement.setString(1, (Integer.toString(line.getNumberLine())));
            statement.setString(2, line.getPhone());
            statement.setInt(3, line.getIdCard());
            statement.executeUpdate();
            System.out.println("Statement executed: " + "update LineFour set " +
                    "NumberLine = " + line.getNumberLine() + ", Phone= "
                    + line.getPhone() + "where IdCard="
                    + line.getIdCard() +")");
        } catch (SQLException ex) {
            throw new PersistanceException(ex.getMessage());
        }
    }

    @Override
    public void delete(LineFour line) throws PersistanceException {

        if (connection == null)
            throw new PersistanceException("Error con la conexión");
        try {
            PreparedStatement statement =
                    connection.prepareStatement("delete from LineFour where IdCard=?");
            statement.setInt(1, line.getIdCard());
            statement.executeUpdate();
            System.out.println("delete from LineFour where IdCard= "
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
