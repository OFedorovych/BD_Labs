package ua.lviv.iot.DAO.implemantation;

import org.hibernate.Session;
import ua.lviv.iot.DAO.WarehouseDAO;
import ua.lviv.iot.model.Warehouse;
import ua.lviv.iot.persistant.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WarehouseDaoImpl implements WarehouseDAO {

    @Override
    public List<Warehouse> findAll() throws SQLException{
        List<Warehouse> items = new ArrayList<>();
        try (Session session = ConnectionManager.getSession()) {
            session.beginTransaction();
            items = session.createQuery("from Warehouse ").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public Warehouse findByID(String id) throws SQLException{
        Warehouse item = new Warehouse();
        try (Session session = ConnectionManager.getSession()) {
            session.beginTransaction();
            item = session.get(Warehouse.class, Integer.parseInt(id));
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public int create(Warehouse entity) throws SQLException{
        try (Session session = ConnectionManager.getSession()) {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public int update(Warehouse entity) throws SQLException{
        try (Session session = ConnectionManager.getSession()) {
            session.beginTransaction();
            session.update(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public int delete(Warehouse entity) throws SQLException{
        try (Session session = ConnectionManager.getSession()) {
            session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        };
        return 1;
    }

}
