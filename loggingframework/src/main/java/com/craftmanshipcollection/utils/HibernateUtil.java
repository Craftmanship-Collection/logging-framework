package com.craftmanshipcollection.utils;

import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import java.util.Properties;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        try {
            // Step 1: Create HikariCP DataSource
            HikariDataSource dataSource = new HikariDataSource();
            dataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/loggingframework");
            dataSource.setUsername("chintu");
            dataSource.setPassword("root");
            dataSource.setMaximumPoolSize(10);
            dataSource.setIdleTimeout(30000);
            dataSource.setPoolName("HibernateHikariCP");

            // Step 2: Set Hibernate properties
            Properties hibernateProps = new Properties();
            hibernateProps.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
            hibernateProps.setProperty("hibernate.hbm2ddl.auto", "update");
            hibernateProps.setProperty("hibernate.show_sql", "true");

            // Step 3: Create Configuration and pass properties
            Configuration configuration = new Configuration();
            configuration.setProperties(hibernateProps);
            configuration.addAnnotatedClass(com.craftmanshipcollection.models.Log.class); // replace with your entity

            // Step 4: Create ServiceRegistry and SessionFactory
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(hibernateProps)
                    .applySetting("hibernate.connection.datasource", dataSource) // IMPORTANT
                    .build();

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
