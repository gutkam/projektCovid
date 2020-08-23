package pl.sdacademy.json;

public class Country {
    private Country country;

    public Country(Country country) {
        this.country = country;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
