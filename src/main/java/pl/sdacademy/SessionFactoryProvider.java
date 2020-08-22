package pl.sdacademy;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryProvider {


    public SessionFactory provideSessionFactory(){

        return new Configuration()
                .configure("hibernate-example.cfg.xml")
                .buildSessionFactory();
    }
}
