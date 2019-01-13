package br.com.city.service;

import br.com.city.domain.orm.City;

import java.util.List;
import java.util.Map;

public interface CityService {

    City getById(Integer id);
    City save(City city);

    List<String> getCapitals();
    List<String> getCitiesByState(String uf);
    Map<String, Integer> getCountCitiesByState();
    Map<String, Integer> getCountSmallerBiggestState();
    List<City> getCitiesByColumnFilter(String column, String filter);
    long getCountCitiesByColumn(String column);
    List<City> getMostDistantCities();
    long countAll();
    void delete(Integer id);
    int insert(City city);

}
