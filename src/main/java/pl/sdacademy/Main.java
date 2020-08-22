package pl.sdacademy;

public class Main {
    public static void main(String[] args) {
        SessionFactoryProvider sessionFactoryProvider = new SessionFactoryProvider();
        sessionFactoryProvider.provideSessionFactory();
    }
}
