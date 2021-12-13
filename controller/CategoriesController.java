package ua.lviv.iot.controller;

import ua.lviv.iot.DAO.implemantation.CategoriesDaoImpl;
import ua.lviv.iot.model.Categories;

import java.sql.SQLException;
import java.util.List;

public class CategoriesController {

    public List<Categories> findAll() throws SQLException{
        return new CategoriesDaoImpl().findAll();
    }

    public int create(Categories item) throws SQLException{
        return new CategoriesDaoImpl().create(item);
    }

    public int delete(Categories item) throws SQLException {
        return new CategoriesDaoImpl().delete(item);
    }

    public static Categories findByID(String id) throws SQLException{
        return new CategoriesDaoImpl().findByID(id);
    }

    public int update(Categories entity) throws SQLException{
        return new CategoriesDaoImpl().update(entity);
    }
}
