package ua.lviv.iot.DAO.implemantation;

import org.hibernate.Session;
import ua.lviv.iot.DAO.CharacteristicDAO;
import ua.lviv.iot.model.Characteristics;
import ua.lviv.iot.persistant.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CharacteristicDaoImpl implements CharacteristicDAO{
    @Override
    public List<Characteristics> findAll() throws SQLException {
        List<Characteristics> items = new ArrayList<>();
        try (Session session = ConnectionManager.getSession()) {
            session.beginTransaction();
            items = session.createQuery("from Characteristics ").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public Characteristics findByID(String id) throws SQLException {
        Characteristics item = new Characteristics();
        try (Session session = ConnectionManager.getSession()) {
            session.beginTransaction();
            item = session.get(Characteristics.class, Integer.parseInt(id));
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public int create(Characteristics entity) throws SQLException {
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
    public int update(Characteristics entity) throws SQLException {
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
    public int delete(Characteristics entity) throws SQLException{
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
