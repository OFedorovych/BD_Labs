package ua.lviv.iot.controller;

import ua.lviv.iot.DAO.implemantation.CountryDaoImpl;
import ua.lviv.iot.model.CountryEntity;

import java.sql.SQLException;
import java.util.List;

public class CountryController {
    public List<CountryEntity> findAll() throws SQLException {
        return new CountryDaoImpl().findAll();
    }

    public int create(CountryEntity item) throws SQLException{
        return new CountryDaoImpl().create(item);
    }

    public int delete(String id) throws SQLException {
        return new CountryDaoImpl().delete(id);
    }

    public CountryEntity findByID(String id) throws SQLException{
        return new CountryDaoImpl().findByID(id);
    }

    public int update(CountryEntity entity) throws SQLException{
        return new CountryDaoImpl().update(entity);
    }
}
