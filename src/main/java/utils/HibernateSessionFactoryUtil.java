package utils;

import models.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(DailyReport.class);
                configuration.addAnnotatedClass(DailyReportHasProduct.class);
                configuration.addAnnotatedClass(Location.class);
                configuration.addAnnotatedClass(Manufacturer.class);
                configuration.addAnnotatedClass(Mechanic.class);
                configuration.addAnnotatedClass(Menu.class);
                configuration.addAnnotatedClass(Product.class);
                configuration.addAnnotatedClass(VendingMachine.class);
                configuration.addAnnotatedClass(VendingMachineHasMenu.class);
                configuration.addAnnotatedClass(VendingMachineHasProduct.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                System.out.println("Exception!" + e);
            }
        }
        return sessionFactory;
    }
}