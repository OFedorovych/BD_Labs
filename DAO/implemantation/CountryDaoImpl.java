package ua.lviv.iot.DAO.implemantation;

import org.hibernate.Session;
import ua.lviv.iot.DAO.CountryDAO;
import ua.lviv.iot.model.Country;
import ua.lviv.iot.persistant.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountryDaoImpl implements CountryDAO {

    @Override
    public List<Country> findAll() throws SQLException {
        List<Country> items = new ArrayList<>();
            try (Session session = ConnectionManager.getSession()) {
                session.beginTransaction();
                items = session.createQuery("from Country ").getResultList();
                session.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return items;
        }


    @Override
    public Country findByID(String id) throws SQLException{
        Country item = new Country();
        try (Session session = ConnectionManager.getSession()) {
            session.beginTransaction();
            item = session.get(Country.class, Integer.parseInt(id));
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public int create(Country entity) throws SQLException{
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
    public int update(Country entity) throws SQLException{
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
    public int delete(Country entity) throws SQLException{
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
