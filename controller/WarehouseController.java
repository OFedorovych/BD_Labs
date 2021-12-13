package ua.lviv.iot.controller;

import ua.lviv.iot.DAO.implemantation.WarehouseDaoImpl;
import ua.lviv.iot.model.Warehouse;

import java.sql.SQLException;
import java.util.List;

public class WarehouseController {
    public List<Warehouse> findAll() throws SQLException {
        return new WarehouseDaoImpl().findAll();
    }
    public static Warehouse findByID(String id) throws SQLException{
        return new WarehouseDaoImpl().findByID(id);
    }

    public int create(Warehouse item) throws SQLException{
        return new WarehouseDaoImpl().create(item);
    }
    public int update(Warehouse item) throws SQLException{
        return new WarehouseDaoImpl().update(item);
    }
    public int delete(Warehouse item) throws SQLException{
        return new WarehouseDaoImpl().delete(item);
    }
}
