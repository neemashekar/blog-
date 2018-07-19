package com.ex.config;

import com.ex.models.Creator;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class HibernateConfigUtil {
    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
//        Configuration cfg = new Configuration();
//        Properties props =new Properties();
//
//        props.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
//        props.setProperty("hibernate.connection.url", "jdbc:postgresql://study-topics.cy0du1iivwoh.us-east-1.rds.amazonaws.com:5432/studytopics");
//        props.setProperty("hibernate.connection.username", "august_duet");
//        props.setProperty("hibernate.connection.password", "adminpassword");
//        props.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL9Dialect");
//        props.setProperty("hibernate.hbm2ddl.auto", "create");
//
//        cfg.setProperties(props);


        if(sessionFactory == null) {
            try {
                //create the session factory

                //registry
                registry = new StandardServiceRegistryBuilder()
                        .configure()
                        .build();

//                //Create the metadatasources
                MetadataSources sources = new MetadataSources(registry);

                Metadata metadata = sources.getMetadataBuilder().build();

                //create the factory
                sessionFactory = metadata.getSessionFactoryBuilder().build();
            } catch(Exception e) {
                e.printStackTrace();
                shutdown();
            }
        }
        return sessionFactory;
    }

    public static void shutdown() {
        if(registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
