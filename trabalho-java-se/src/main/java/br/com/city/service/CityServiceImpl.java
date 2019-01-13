package br.com.city.service;

import br.com.city.domain.orm.City;
import br.com.city.domain.repository.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Override
    public City getById(Integer id) {
        City city = cityRepository.findOne(id);
        if(isNull(city)) {
            throw new RuntimeException("City not found!");
        }
        return city;
    }

    @Override
    public City save(City city) {
        return cityRepository.save(city);
    }

    @Override
    public List<String> getCapitals() {
        List<String> capitals = new ArrayList<>();
        cityRepository.findAll().forEach(city -> {
                if ("TRUE".equalsIgnoreCase(city.getCapital())) {
                    capitals.add(city.getName());
                }
        });
        capitals.sort(Comparator.naturalOrder());
        return capitals;
    }

    @Override
    public List<String> getCitiesByState(String uf) {
        List<String> cities = new ArrayList<>();
        cityRepository.findAll().forEach(city -> {
            if (city.getUf().equalsIgnoreCase(uf)) {
                cities.add(city.getName());
            }
        });
        return cities;
    }

    @Override
    public Map<String, Integer> getCountCitiesByState() {
        Map<String, Integer> countCitiesByState = new HashMap<>();
        cityRepository.findAll().forEach(city -> countCitiesByState.merge(city.getUf(), 1, Integer::sum));
        return countCitiesByState;
    }

    @Override
    public Map<String, Integer> getCountSmallerBiggestState() {
        Map<String, Integer> countCitiesByState = new HashMap<>();
        cityRepository.findAll().forEach(city -> countCitiesByState.merge(city.getUf(), 1, Integer::sum));

        Map.Entry<String, Integer> maxByVal = countCitiesByState.entrySet()
                .stream()
                .reduce((curr, nxt) -> curr.getValue() > nxt.getValue() ? curr : nxt)
                .get();

        Map.Entry<String, Integer> minByVal = countCitiesByState.entrySet()
                .stream()
                .reduce((curr, nxt) -> curr.getValue() < nxt.getValue() ? curr : nxt)
                .get();

        Map<String, Integer> smallerBiggestCites = new HashMap<>();
        smallerBiggestCites.put(minByVal.getKey(), countCitiesByState.get(minByVal.getKey()));
        smallerBiggestCites.put(maxByVal.getKey(), countCitiesByState.get(maxByVal.getKey()));

        return smallerBiggestCites;
    }

    @Override
    public List<City> getCitiesByColumnFilter(String column, String filter) {
        List<City> cities = new ArrayList<>();
        if (column != null && filter != null) {
            cityRepository.findAll().forEach(city -> {
                switch (column.toUpperCase()) {
                    case "IBGE_ID":
                        if (filter.equalsIgnoreCase(String.valueOf(city.getId()))) {
                            cities.add(city);
                        }
                        break;
                    case "UF":
                        if (!isNull(city.getUf()) && filter.equalsIgnoreCase(String.valueOf(city.getUf()))) {
                            cities.add(city);
                        }
                        break;
                    case "NAME":
                        if (!isNull(city.getName()) && filter.equalsIgnoreCase(String.valueOf(city.getName()))) {
                            cities.add(city);
                        }
                        break;
                    case "CAPITAL":
                        if (!isNull(city.getCapital()) && filter.equalsIgnoreCase(String.valueOf(city.getCapital()))) {
                            cities.add(city);
                        }
                        break;
                    case "LON":
                        if (Double.compare(Double.valueOf(filter), city.getLon()) == 0) {
                            cities.add(city);
                        }
                        break;
                    case "LAT":
                        if (Double.compare(Double.valueOf(filter), city.getLat()) == 0) {
                            cities.add(city);
                        }
                        break;
                    case "NO_ACCENTS":
                        if (!isNull(city.getNoAccents()) && filter.equalsIgnoreCase(String.valueOf(city.getNoAccents()))) {
                            cities.add(city);
                        }
                        break;
                    case "ALTERNATIVE_NAMES":
                        if (!isNull(city.getAlternativeNames()) && filter.equalsIgnoreCase(String.valueOf(city.getAlternativeNames()))) {
                            cities.add(city);
                        }
                        break;
                    case "MICROREGION":
                        if (!isNull(city.getMicroregion()) && filter.equalsIgnoreCase(String.valueOf(city.getMicroregion()))) {
                            cities.add(city);
                        }
                        break;
                    case "MESOREGION":
                        if (!isNull(city.getMesoregion()) && filter.equalsIgnoreCase(String.valueOf(city.getMesoregion()))) {
                            cities.add(city);
                        }
                        break;
                    default:
                        break;
                }
            });
        }
        return cities;
    }


    @Override
    public long getCountCitiesByColumn(String column) {
        Map<String, Integer> cities = new HashMap<>();

        if (column != null) {
            cityRepository.findAll().forEach(city -> {
                switch (column.toUpperCase()) {
                    case "IBGE_ID":
                        cities.putIfAbsent(String.valueOf(city.getId()), 1);
                        break;
                    case "UF":
                        cities.putIfAbsent(String.valueOf(city.getUf()), 1);
                        break;
                    case "NAME":
                        cities.putIfAbsent(String.valueOf(city.getName()), 1);
                        break;
                    case "CAPITAL":
                        cities.putIfAbsent(String.valueOf(city.getCapital()), 1);
                        break;
                    case "LON":
                        cities.putIfAbsent(String.valueOf(city.getLon()), 1);
                        break;
                    case "LAT":
                        cities.putIfAbsent(String.valueOf(city.getLat()), 1);
                        break;
                    case "NO_ACCENTS":
                        cities.putIfAbsent(String.valueOf(city.getNoAccents()), 1);
                        break;
                    case "ALTERNATIVE_NAMES":
                        cities.putIfAbsent(String.valueOf(city.getAlternativeNames()), 1);
                        break;
                    case "MICROREGION":
                        cities.putIfAbsent(String.valueOf(city.getMicroregion()), 1);
                        break;
                    case "MESOREGION":
                        cities.putIfAbsent(String.valueOf(city.getMesoregion()), 1);
                        break;
                    default:
                        break;
                }
            });
        }
        return cities.size();
    }

    private static final double R = 6372.8; // In kilometers

    private static double haversine(double lat1, double lon1, double lat2, double lon2) {
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        double a = Math.pow(Math.sin(dLat / 2),2) + Math.pow(Math.sin(dLon / 2),2) * Math.cos(lat1) * Math.cos(lat2);
        double c = 2 * Math.asin(Math.sqrt(a));
        return R * c;
    }


    @Override
    public List<City> getMostDistantCities() {
        ArrayList<City> mostDistantCities = new ArrayList<>();
        final double[] actualDistance = new double[1];
        actualDistance[0] = 0.0;

        cityRepository.findAll().forEach(cityA -> cityRepository.findAll().forEach(cityB -> {
            double distance_between = haversine(cityA.getLat(), cityA.getLon(), cityB.getLat(), cityB.getLon());
            if(distance_between > actualDistance[0]) {
                actualDistance[0] = distance_between;
                mostDistantCities.clear();
                mostDistantCities.add(cityA);
                mostDistantCities.add(cityB);
            }
        }));

        return mostDistantCities;
    }

    @Override
    public long countAll() {
        return cityRepository.count();
    }

    @Override
    public void delete(Integer id) {
        cityRepository.delete(id);
    }

    @Override
    public int insert(City city) {
        City ct  = cityRepository.save(city);
        return ct.getId();
    }
}
