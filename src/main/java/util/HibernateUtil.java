package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();

            return configuration.buildSessionFactory(new StandardServiceRegistryBuilder().configure()
                    .applySettings(configuration.getProperties())
                    .build());

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("There was an error building a factory");
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
