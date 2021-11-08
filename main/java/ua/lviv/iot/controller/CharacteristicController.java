package ua.lviv.iot.controller;

import ua.lviv.iot.DAO.implemantation.CharacteristicDaoImpl;
import ua.lviv.iot.model.CharacteristicEntity;

import java.sql.SQLException;
import java.util.List;

public class CharacteristicController {
    public List<CharacteristicEntity> findAll() throws SQLException {
        return new CharacteristicDaoImpl().findAll();
    }

    public int create(CharacteristicEntity item) throws SQLException{
        return new CharacteristicDaoImpl().create(item);
    }

    public int delete(String id) throws SQLException {
        return new CharacteristicDaoImpl().delete(id);
    }

    public CharacteristicEntity findByID(String id) throws SQLException{
        return new CharacteristicDaoImpl().findByID(id);
    }

    public int update(CharacteristicEntity entity) throws SQLException {
        return new CharacteristicDaoImpl().update(entity);
    }
}
