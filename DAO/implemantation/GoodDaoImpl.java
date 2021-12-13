package ua.lviv.iot.DAO.implemantation;

import org.hibernate.Session;
import ua.lviv.iot.DAO.GoodDAO;
import ua.lviv.iot.model.Goods;
import ua.lviv.iot.persistant.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GoodDaoImpl implements GoodDAO {

    @Override
    public List<Goods> findAll() throws SQLException{
        List<Goods> items = new ArrayList<>();
        try (Session session = ConnectionManager.getSession()) {
            session.beginTransaction();
            items = session.createQuery("from Goods ").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public Goods findByID(String id) throws SQLException{
        Goods item = new Goods();
        try (Session session = ConnectionManager.getSession()) {
            session.beginTransaction();
            item = session.get(Goods.class, Integer.parseInt(id));
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public int create(Goods entity) throws SQLException{
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
    public int update(Goods entity) throws SQLException{
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
    public int delete(Goods entity) throws SQLException{
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
