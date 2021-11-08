package ua.lviv.iot.DAO.implemantation;

import ua.lviv.iot.DAO.CharacteristicDAO;
import ua.lviv.iot.model.CharacteristicEntity;
import ua.lviv.iot.model.implementation.CategoryEntityImpl;
import ua.lviv.iot.model.implementation.CharacteristicEntityImpl;
import ua.lviv.iot.persistant.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CharacteristicDaoImpl implements CharacteristicDAO{
    private static final String FIND_ALL = "SELECT * FROM TCharacteristics ORDER BY ID";
    private static final String CREATE = "INSERT TCharacteristics (Name) VALUES (?)";
    private static final String UPDATE = "UPDATE TCharacteristics SET Name=? WHERE ID=?";
    private static final String DELETE = "DELETE FROM TCharacteristics WHERE ID=?";
    private static final String FIND_BY_ID = "SELECT * FROM TCharacteristics WHERE ID=?";


    @Override
    public List<CharacteristicEntity> findAll() throws SQLException {
        List<CharacteristicEntity> items = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try(Statement statement = connection.createStatement()){
            try(ResultSet rs = statement.executeQuery(FIND_ALL)){
                while(rs.next()){
                    CharacteristicEntityImpl item = new CharacteristicEntityImpl();
                    //mapping DB to entity
                    item.setCharacID(rs.getInt("ID"));
                    item.setCharacName(rs.getString("Name"));
                    items.add(item);
                }
            }
        }
        return items;
    }

    @Override
    public CharacteristicEntity findByID(String id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        CharacteristicEntityImpl item = new CharacteristicEntityImpl();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setInt(1, Integer.parseInt(id));
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                //mapping DB to entity
                item.setCharacID(rs.getInt("ID"));
                item.setCharacName(rs.getString("Name"));
                break;
            }
        }catch(SQLException e){throw e;}
        return item;
    }

    @Override
    public int create(CharacteristicEntity entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        int n = 0;
        PreparedStatement preparedStatement;
        try{
            preparedStatement = connection.prepareStatement(CREATE);
            preparedStatement.setString(1, entity.getCharacName());
            n = preparedStatement.executeUpdate();
        }catch (SQLException e){throw e;}
        return n;
    }

    @Override
    public int update(CharacteristicEntity entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        int n = 0;
        PreparedStatement preparedStatement;
        try{
            preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, entity.getCharacName());
            preparedStatement.setInt(2, entity.getCharacID());
            n = preparedStatement.executeUpdate();
        }catch (SQLException e){throw e;}
        return n;
    }

    @Override
    public int delete(String id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        int n = 0;
        PreparedStatement preparedStatement;
        try{
            preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, Integer.parseInt(id));
            n = preparedStatement.executeUpdate();
        }catch (SQLException e){throw e;}
        return n;
    }
}
