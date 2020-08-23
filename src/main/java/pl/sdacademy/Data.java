package pl.sdacademy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Data {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate date;
    private String country;
    private Integer deaths;
    private Integer newCases;
    private Integer recovered;
    private Integer allCases;
    private Integer allDeaths;

    public Data(){
    }

    public Data(LocalDate date, String country, Integer deaths, Integer newCases, Integer recovered, Integer allCases, Integer allDeaths) {
        this.date = date;
        this.country = country;
        this.deaths = deaths;
        this.newCases = newCases;
        this.recovered = recovered;
        this.allCases = allCases;
        this.allDeaths = allDeaths;
    }

    public Integer getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getDeaths() {
        return deaths;
    }

    public void setDeaths(Integer deaths) {
        this.deaths = deaths;
    }

    public Integer getNewCases() {
        return newCases;
    }

    public void setNewCases(Integer newCases) {
        this.newCases = newCases;
    }

    public Integer getRecovered() {
        return recovered;
    }

    public void setRecovered(Integer recovered) {
        this.recovered = recovered;
    }

    public Integer getAllCases() {
        return allCases;
    }

    public void setAllCases(Integer allCases) {
        this.allCases = allCases;
    }

    public Integer getAllDeaths() {
        return allDeaths;
    }

    public void setAllDeaths(Integer allDeaths) {
        this.allDeaths = allDeaths;
    }

    @Override
    public String toString() {
        return "Dates{" +
                "id=" + id +
                ", date=" + date +
                ", country='" + country + '\'' +
                ", deaths=" + deaths +
                ", newCases=" + newCases +
                ", recovered=" + recovered +
                ", allCases=" + allCases +
                ", allDeaths=" + allDeaths +
                '}';
    }
}
