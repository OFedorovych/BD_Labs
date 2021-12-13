package ua.lviv.iot.controller;

import ua.lviv.iot.DAO.implemantation.CharacteristicDaoImpl;
import ua.lviv.iot.model.Characteristics;

import java.sql.SQLException;
import java.util.List;

public class CharacteristicController {
    public List<Characteristics> findAll() throws SQLException {
        return new CharacteristicDaoImpl().findAll();
    }

    public int create(Characteristics item) throws SQLException{
        return new CharacteristicDaoImpl().create(item);
    }

    public int delete(Characteristics item) throws SQLException {
        return new CharacteristicDaoImpl().delete(item);
    }

    public static Characteristics findByID(String id) throws SQLException{
        return new CharacteristicDaoImpl().findByID(id);
    }

    public int update(Characteristics entity) throws SQLException {
        return new CharacteristicDaoImpl().update(entity);
    }
}
