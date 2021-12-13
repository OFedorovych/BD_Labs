package ua.lviv.iot.controller;

import ua.lviv.iot.DAO.implemantation.ProducerDaoImpl;
import ua.lviv.iot.model.Producer;

import java.sql.SQLException;
import java.util.List;

public class ProducerController {
    public List<Producer> findAll() throws SQLException {
        return new ProducerDaoImpl().findAll();
    }
    public static Producer findByID(String id) throws SQLException{
        return new ProducerDaoImpl().findByID(id);
    }

    public int create(Producer item) throws SQLException{
        return new ProducerDaoImpl().create(item);
    }
    public int update(Producer entity) throws SQLException{
        return new ProducerDaoImpl().update(entity);
    }
    public int delete(Producer entity) throws SQLException{
        return new ProducerDaoImpl().delete(entity);
    }
}
