import org.hibernate.Session;
import ua.lviv.iot.model.Country;
import ua.lviv.iot.persistant.ConnectionManager;
import ua.lviv.iot.view.MyView;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(final String[] args) throws Exception {
        final Session session = ConnectionManager.getSession();
        new MyView().showMenu();


        try {
////            System.out.println("querying all the managed entities...");
            //final Metamodel metamodel = session.getSessionFactory().getMetamodel();
            List<Country> country = new ArrayList<>();

                session.beginTransaction();

                Country c1 = new Country();
                //c1= session.get(Country.class,1);
                //System.out.println(c1);
                c1.setId(11);
                //c1.setCountry("aaaaaaaaa");
                //session.save (c1);
                //session.update(c1);
                //session.delete(c1);
                //session.getTransaction().commit();



                //session.beginTransaction();
                country = session.createQuery("from Country ").getResultList();
                System.out.println(country);
                session.getTransaction().commit();



////            for (EntityType<?> entityType : metamodel.getEntities()) {
////                final String entityName = entityType.getName();
////                final Query query = session.createQuery("from " + entityName);
////                System.out.println("executing: " + query.getQueryString());
////                for (Object o : query.list()) {
////                    System.out.println("  " + o);
////                }

        } finally {
            session.close();
        }

    }
}