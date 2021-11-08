package ua.lviv.iot.DAO.implemantation;

import ua.lviv.iot.DAO.CountryDAO;
import ua.lviv.iot.model.CountryEntity;
import ua.lviv.iot.model.CountryEntity;
import ua.lviv.iot.model.implementation.CountryEntityImpl;
import ua.lviv.iot.persistant.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountryDaoImpl implements CountryDAO {
    private static final String FIND_ALL = "SELECT * FROM TCountry ORDER BY ID";
    private static final String CREATE = "INSERT TCountry (Country) VALUES (?)";
    private static final String UPDATE = "UPDATE TCountry SET Country=? WHERE ID=?";
    private static final String DELETE = "DELETE FROM TCountry WHERE ID=?";
    private static final String FIND_BY_ID = "SELECT * FROM TCountry WHERE ID=?";

    @Override
    public List<CountryEntity> findAll() throws SQLException {
        List<CountryEntity> items = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try(Statement statement = connection.createStatement()){
            try(ResultSet rs = statement.executeQuery(FIND_ALL)){
                while(rs.next()){
                    CountryEntityImpl item = new CountryEntityImpl();
                    //mapping DB to entity
                    item.setCountryID(rs.getInt("ID"));
                    item.setCountryName(rs.getString("Country"));
                    items.add(item);
                }
            }
        }
        return items;
    }

    @Override
    public CountryEntity findByID(String id) throws SQLException{
        Connection connection = ConnectionManager.getConnection();
        CountryEntityImpl item = new CountryEntityImpl();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setInt(1, Integer.parseInt(id));
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                //mapping DB to entity
                item.setCountryID(rs.getInt("ID"));
                item.setCountryName(rs.getString("Name"));
                break;
            }
        }catch(SQLException e){throw e;}
        return item;
    }

    @Override
    public int create(CountryEntity entity) throws SQLException{
        Connection connection = ConnectionManager.getConnection();
        int n = 0;
        PreparedStatement preparedStatement;
        try{
            preparedStatement = connection.prepareStatement(CREATE);
            preparedStatement.setString(1, entity.getCountryName());
            n = preparedStatement.executeUpdate();
        }catch (SQLException e){throw e;}
        return n;
    }

    @Override
    public int update(CountryEntity entity) throws SQLException{
        Connection connection = ConnectionManager.getConnection();
        int n = 0;
        PreparedStatement preparedStatement;
        try{
            preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, entity.getCountryName());
            preparedStatement.setInt(2, entity.getCountryID());
            n = preparedStatement.executeUpdate();
        }catch (SQLException e){throw e;}
        return n;
    }

    @Override
    public int delete(String id) throws SQLException{
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
