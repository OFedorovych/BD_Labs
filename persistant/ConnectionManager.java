package ua.lviv.iot.persistant;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static final String url = "jdbc:mysql://localhost:3306/lab3";
    private static final String user = "root";
    private static final String password = "asdQWE_123";

    private static Connection connection = null;

    private static final SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            sessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return sessionFactory.openSession();
    }
    // ------- TODO - Delete following code
    private ConnectionManager(){ };

    public static Connection getConnection() {
        if (connection == null){
            try{
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException e){
                System.out.println("SQLEx: " + e.getMessage());
            }
        }
        return connection;
    }

    public static void closeConnection(){
        if (connection != null){
            try{
                connection.close();
            }catch(SQLException e){
                System.out.println("SQLEx: " + e.getMessage());
            }
        }
    }

}
