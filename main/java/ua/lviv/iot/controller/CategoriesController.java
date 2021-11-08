package ua.lviv.iot.controller;

import ua.lviv.iot.DAO.implemantation.CategoriesDaoImpl;
import ua.lviv.iot.model.CategoryEntity;

import java.sql.SQLException;
import java.util.List;

public class CategoriesController {

    public List<CategoryEntity> findAll() throws SQLException{
        return new CategoriesDaoImpl().findAll();
    }

    public int create(CategoryEntity item) throws SQLException{
        return new CategoriesDaoImpl().create(item);
    }

    public int delete(String id) throws SQLException {
        return new CategoriesDaoImpl().delete(id);
    }

    public CategoryEntity findByID(String id) throws SQLException{
        return new CategoriesDaoImpl().findByID(id);
    }

    public int update(CategoryEntity entity) throws SQLException{
        return new CategoriesDaoImpl().update(entity);
    }
}
