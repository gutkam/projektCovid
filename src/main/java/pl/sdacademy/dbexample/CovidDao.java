package pl.sdacademy.dbexample;

import java.time.LocalDate;
import java.util.List;

public interface CovidDao {

    List<Countries> getCountries();
    List<Data> getDataByCountryAndDateRange(Integer id, LocalDate from, LocalDate to);
    Data getCurrentDataByCountry(Integer countryId);
    List<Data> getCurrentWorldData();
    void storeData(List<Countries> countriesList);


}
