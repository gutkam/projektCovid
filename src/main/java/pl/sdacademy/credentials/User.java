package pl.sdacademy.credentials;


import java.time.LocalDate;

public class User {
    public int Id() {
        return id;
    }

    public void Id(int id) {
        this.id = id;
    }

    public String FirstName() {
        return firstName;
    }

    public void FirstName(String firstName) {
        this.firstName = firstName;
    }

    public String LastName() {
        return lastName;
    }

    public void LastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate DateOfBirth() {
        return dateOfBirth;
    }

    public void DateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Boolean Admin() {
        return admin;
    }

    public void Admin(Boolean admin) {
        this.admin = admin;
    }

    private int id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Boolean admin;

    public User(int id, String firstName, String lastName, LocalDate dateOfBirth, Boolean admin) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.admin = admin;
    }
}
