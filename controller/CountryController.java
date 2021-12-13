package ua.lviv.iot.controller;

import ua.lviv.iot.DAO.implemantation.CountryDaoImpl;
import ua.lviv.iot.model.Country;

import java.sql.SQLException;
import java.util.List;

public class CountryController {
    public List<Country> findAll() throws SQLException {
        return new CountryDaoImpl().findAll();
    }

    public int create(Country item) throws SQLException{
        return new CountryDaoImpl().create(item);
    }

    public int delete(Country item) throws SQLException {
        return new CountryDaoImpl().delete(item);
    }

    public static Country findByID(String id) throws SQLException{
        return new CountryDaoImpl().findByID(id);
    }

    public int update(Country entity) throws SQLException{
        return new CountryDaoImpl().update(entity);
    }
}
