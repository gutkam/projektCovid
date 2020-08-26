package pl.sdacademy.credentials;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.*;


public class InMemoryUserRepository implements UserRepository {

    private ArrayList<User> userArrayList = new ArrayList<>();

    public InMemoryUserRepository() {
        UserListInitialization();
    }

    @Override
    public User readById(int id) {
        Optional<User> user = userArrayList.stream()
                .filter(u -> u.Id() == id)
                .findFirst();

        if (user.isPresent())
            return user.get();
        else
            return null;
    }

    @Override
    public ArrayList<User> readAll() {
        return userArrayList;
    }


    @Override
    public int create(String firstName, String lastName, LocalDate dateOfBirth, Boolean admin) {
        User user = new User(getLastID() + 1, firstName, lastName, dateOfBirth, admin);
        userArrayList.add(user);
        return user.Id();
    }

    @Override
    public boolean update(int id, String firstName, String lastName, LocalDate dateOfBirth, Boolean admin) {
        User user = readById(id);

        if (user == null)
            return false;
        else {
            user.FirstName(firstName);
            user.LastName(lastName);
            user.DateOfBirth(dateOfBirth);
            user.Admin(admin);

            int indexOfUser = userArrayList.indexOf(user);
            userArrayList.set(indexOfUser, user);
            return true;
        }


    }


    @Override
    public boolean delete(int id) {
        User user = readById(id);
        if (user == null)
            return false;
        else {
            return userArrayList.remove(user);
        }

    }

    private void UserListInitialization() {
        User u1 = new User(1, "Michał", "Kowal", LocalDate.of(1984, 12, 19), true);
        User u2 = new User(2, "Bartek", "Markowski", LocalDate.of(1976, 05, 9), false);
        User u3 = new User(3, "Kamil", "Kapoor", LocalDate.of(1999, 8, 12), false);

        userArrayList.add(u1);
        userArrayList.add(u2);
        userArrayList.add(u3);

    }

    private int getLastID() {
        Optional<User> user = userArrayList
                .stream()
                .max(Comparator.comparing(User::Id));

        if (user.isPresent())
            return user.get().Id();
        else
            return 0;
    }
}
