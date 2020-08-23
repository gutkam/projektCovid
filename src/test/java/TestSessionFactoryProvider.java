import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestSessionFactoryProvider {

    public SessionFactory createSessionFactory(){

        return new Configuration()
                .configure("hibernateTest.cfg.xml")
                .buildSessionFactory();
    }

}
