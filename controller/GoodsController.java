package ua.lviv.iot.controller;

import ua.lviv.iot.DAO.implemantation.GoodDaoImpl;
import ua.lviv.iot.model.Goods;

import java.sql.SQLException;
import java.util.List;

public class GoodsController {
    public List<Goods> findAll() throws SQLException {
        return new GoodDaoImpl().findAll();
    }
    public int create(Goods item) throws SQLException{
        return new GoodDaoImpl().create(item);
    }

    public int delete(Goods item) throws SQLException {
        return new GoodDaoImpl().delete(item);
    }

    public static Goods findByID(String id) throws SQLException{
        return new GoodDaoImpl().findByID(id);
    }

    public int update(Goods entity) throws SQLException {
        return new GoodDaoImpl().update(entity);
    }
}
