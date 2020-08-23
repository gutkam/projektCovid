package pl.sdacademy.jasonexample;

public class CountryCases {
    String country;
    Integer cases;

    public CountryCases(String country, Integer cases) {
        this.country = country;
        this.cases = cases;
    }

    @Override
    public String toString() {
        return "CountryCases{" +
                "country='" + country + '\'' +
                ", cases=" + cases +
                '}';
    }
}
