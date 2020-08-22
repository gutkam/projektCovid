package pl.sdacademy;

public class City {
    private City city;

    public City(City city) {
        this.city = city;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
