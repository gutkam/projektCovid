package pl.sdacademy.credentials;


import java.time.LocalDate;
import java.util.ArrayList;

public interface UserRepository {

    public User readById(int id);

    public ArrayList<User> readAll();

    public int create(String firstName, String lastName, LocalDate dateOfBirth, Boolean admin);

    public boolean update(int id, String firstName, String lastName, LocalDate dateOfBirth, Boolean admin);

    public boolean delete(int id);


}
