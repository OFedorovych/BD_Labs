package ua.lviv.iot.DAO.implemantation;

import ua.lviv.iot.DAO.CategoriesDAO;
import ua.lviv.iot.model.CategoryEntity;
import ua.lviv.iot.model.implementation.CategoryEntityImpl;
import ua.lviv.iot.persistant.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriesDaoImpl implements CategoriesDAO {
    private static final String FIND_ALL = "SELECT * FROM TCategories ORDER BY ID";
    private static final String CREATE = "INSERT TCategories (Name) VALUES (?)";
    private static final String UPDATE = "UPDATE TCategories SET Name=? WHERE ID=?";
    private static final String DELETE = "DELETE FROM TCategories WHERE ID=?";
    private static final String FIND_BY_ID = "SELECT * FROM TCategories WHERE ID=?";

    @Override
    public List<CategoryEntity> findAll() throws SQLException{
        List<CategoryEntity> items = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try(Statement statement = connection.createStatement()){
            try(ResultSet rs = statement.executeQuery(FIND_ALL)){
                while(rs.next()){
                    CategoryEntityImpl item = new CategoryEntityImpl();
                    //mapping DB to entity
                    item.setCatID(rs.getInt("ID"));
                    item.setCatName(rs.getString("Name"));
                    items.add(item);
                }
            }
        }
        return items;
    }

    @Override
    public CategoryEntity findByID(String id) throws SQLException{
        Connection connection = ConnectionManager.getConnection();
        CategoryEntityImpl item = new CategoryEntityImpl();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setInt(1, Integer.parseInt(id));
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                //mapping DB to entity
                item.setCatID(rs.getInt("ID"));
                item.setCatName(rs.getString("Name"));
                break;
            }
        }catch(SQLException e){throw e;}
        return item;
    }

    @Override
    public int create(CategoryEntity entity) throws SQLException{
        Connection connection = ConnectionManager.getConnection();
        int n = 0;
        PreparedStatement preparedStatement;
        try{
            preparedStatement = connection.prepareStatement(CREATE);
            preparedStatement.setString(1, entity.getCatName());
            n = preparedStatement.executeUpdate();
        }catch (SQLException e){throw e;}
        return n;
    }

    @Override
    public int update(CategoryEntity entity) throws SQLException{
        Connection connection = ConnectionManager.getConnection();
        int n = 0;
        PreparedStatement preparedStatement;
        try{
            preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, entity.getCatName());
            preparedStatement.setInt(2, entity.getCatID());
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
