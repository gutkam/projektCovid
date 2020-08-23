package pl.sdacademy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Countries {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String nameShort;
    private Integer population;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Data> data = new ArrayList<>();

    public Countries() {
    }

    public Countries(String name, String nameShort, Integer population) {
        this.name = name;
        this.nameShort = nameShort;
        this.population = population;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameShort() {
        return nameShort;
    }

    public void setNameShort(String nameShort) {
        this.nameShort = nameShort;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public List<Data> getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Countries{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nameShort='" + nameShort + '\'' +
                ", population=" + population +
                '}';
    }
}
