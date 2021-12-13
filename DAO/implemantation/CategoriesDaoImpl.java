package ua.lviv.iot.DAO.implemantation;

import org.hibernate.Session;
import ua.lviv.iot.DAO.CategoriesDAO;
import ua.lviv.iot.model.Categories;
import ua.lviv.iot.persistant.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriesDaoImpl implements CategoriesDAO {
    @Override
    public List<Categories> findAll() throws SQLException{
        List<Categories> items = new ArrayList<>();
        try (Session session = ConnectionManager.getSession()) {
            session.beginTransaction();
            items = session.createQuery("from Categories ").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public Categories findByID(String id) throws SQLException{
        Categories item = new Categories();
        try (Session session = ConnectionManager.getSession()) {
            session.beginTransaction();
            item = session.get(Categories.class, Integer.parseInt(id));
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public int create(Categories entity) throws SQLException{
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
    public int update(Categories entity) throws SQLException{
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
    public int delete(Categories entity) throws SQLException{
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
