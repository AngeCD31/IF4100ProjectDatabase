package edu.ucr.rp.db.persistance;

import edu.ucr.rp.db.domain.Line;
import edu.ucr.rp.db.util.ConnectionDB;
import edu.ucr.rp.db.util.LineBuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LinePersistance implements Persistance<Line, String>{

    private static Connection connection;

    public LinePersistance() {
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
    public void create(Line line) throws PersistanceException {

        if (connection == null)
            throw new PersistanceException("Error con la conexión");
        try {
            PreparedStatement statement =
                    connection.prepareStatement("insert into TelephoneLine (NumberLine, LineType, PointsEarned, IdCard, Name, LastName, " +
                                                "Email, Address, Phone) values (?,?,?,?,?,?,?,?,?)");
            statement.setString(1, (Integer.toString(line.getNumberLine())));
            statement.setString(2, line.getLineType());
            statement.setString(3, (Integer.toString(line.getPointsEarned())));
            statement.setString(4, (Integer.toString(line.getIdCard())));
            statement.setString(5, line.getName());
            statement.setString(6, line.getLastName());
            statement.setString(7, line.getEmail());
            statement.setString(8, line.getAddress());
            statement.setString(9, line.getPhone());
            statement.executeUpdate();
            System.out.println("Statement excecuted: " + "insert into TelephoneLine (NumberLine, LineType, PointsEarned, IdCard, Name, LastName, " +
                               "Email, Address, Phone) values ("
                    + line.getNumberLine() +", "
                    + line.getLineType() + ", "
                    + line.getPointsEarned() +", "
                    + line.getIdCard() +", "
                    + line.getName() +", "
                    + line.getLastName() +", "
                    + line.getEmail() +", "
                    + line.getAddress() +", "
                    + line.getPhone() +")");
        } catch (SQLException ex) {
            throw new PersistanceException(ex.getMessage());
        }
    }

    //Lee lista de líneas
    @Override
    public List<Line> read(String key) throws PersistanceException {
        return null;
    }

    @Override
    public List<Line> read() throws PersistanceException {
        List<Line> list = new ArrayList<>();
        ResultSet resultSet;
        try {
            PreparedStatement statement = connection.prepareStatement("select * from TelephoneLine");
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Line line = new LineBuilder().build();
                        line.setNumberLine(resultSet.getInt("NumberLine"));
                        line.setLineType(resultSet.getString("LineType"));
                        line.setPointsEarned(resultSet.getInt("PointsEarned"));
                        line.setIdCard(resultSet.getInt("IdCard"));
                        line.setName(resultSet.getString("Name"));
                        line.setLastName(resultSet.getString("LastName"));
                        line.setEmail(resultSet.getString("Email"));
                        line.setAddress(resultSet.getString("Address"));
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
    public void update(Line line) throws PersistanceException {
        if (connection == null)
            throw new PersistanceException("Error con la conexión");
        try {
            PreparedStatement statement =
                    connection.prepareStatement("update TelephoneLine set NumberLine=?, LineType=?, PointsEarned=?, " +
                                                "Name=?, LastName=?, Email=?, Address=?, Phone=? where IdCard=?");
            statement.setString(1, (Integer.toString(line.getNumberLine())));
            statement.setString(2, line.getLineType());
            statement.setString(3, (Integer.toString(line.getPointsEarned())));
            statement.setString(4, line.getName());
            statement.setString(5, line.getLastName());
            statement.setString(6, line.getEmail());
            statement.setString(7, line.getAddress());
            statement.setString(8, line.getPhone());
            statement.setInt(9, line.getIdCard());
            statement.executeUpdate();
            System.out.println("Statement executed: " + "update TelephoneLine set " +
                    "NumberLine = " + line.getNumberLine() + ", LineType= "
                    + line.getLineType() + ", PointsEarned= "
                    + line.getPointsEarned() + ", Name= "
                    + line.getName() + ", LastName= "
                    + line.getLastName() + ", Email= "
                    + line.getEmail() + ", Address= "
                    + line.getAddress() + ", Phone= "
                    + line.getPhone() + "where IdCard="
                    + line.getIdCard() +")");
        } catch (SQLException ex) {
            throw new PersistanceException(ex.getMessage());
        }
    }

    //Elimina un estudiante
    @Override
    public void delete(Line line) throws PersistanceException {

        if (connection == null)
            throw new PersistanceException("Error con la conexión");
        try {
            PreparedStatement statement =
                    connection.prepareStatement("delete from TelephoneLine where IdCard=?");
            statement.setInt(1, line.getIdCard());
            statement.executeUpdate();
            System.out.println("delete from TelephoneLine where IdCard= "
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
