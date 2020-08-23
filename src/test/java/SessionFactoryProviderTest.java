import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import pl.sdacademy.SessionFactoryProvider;

import static org.junit.Assert.*;

public class SessionFactoryProviderTest {

    @Test
    public void shouldCreateSessionFactory(){
        //given
        SessionFactoryProvider sessionFactoryProvider = new SessionFactoryProvider();
        //when
        try {
            SessionFactory result = sessionFactoryProvider.createSessionFactory();
        }catch (AssertionError e){
            System.out.println("AssertionError");
        }



    }


}
