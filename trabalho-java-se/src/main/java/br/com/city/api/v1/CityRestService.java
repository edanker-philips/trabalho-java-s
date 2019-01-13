package br.com.city.api.v1;

import br.com.city.domain.orm.City;
import br.com.city.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("v1/cities")
public class CityRestService {

    private final CityService cityService;
    private final CityResourceAssembler cityResourceAssembler;

    // Testes Resource
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public CityResource save(@RequestBody CityResource cityResource) {
        return cityResourceAssembler.toResource(cityService.save(cityResourceAssembler.toDomain(cityResource)));
    }

    // Item 2
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/capitals", method = RequestMethod.GET)
    public List<String> getCapitals() {
        return cityService.getCapitals();
    }

    // Item 3
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/count-smaller-biggest-state", method = RequestMethod.GET)
    public Map<String, Integer> getCountSmallerBiggestState() {
        return cityService.getCountSmallerBiggestState();
    }

    // Item 4
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/count-cities-by-state", method = RequestMethod.GET)
    public Map<String, Integer> getCountCitiesByState() {
        return cityService.getCountCitiesByState();
    }

    // Item 5
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/city-by-id/{id}", method = RequestMethod.GET)
    public CityResource getById(@PathVariable Integer id) {
        return cityResourceAssembler.toResource(cityService.getById(id));
    }

    // Item 6
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/cities-by-state/{state}", method = RequestMethod.GET)
    public List<String> getCapitals(@PathVariable String state) {
        return cityService.getCitiesByState(state);
    }

    // Item 7
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public int insert(@RequestBody City city) {
        cityService.insert(city);
        return city.getId();
    }

    // Item 8
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public void delete(@PathVariable Integer id) {
        cityService.delete(id);
    }

    // Item 9
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/cities-by-column-filter/{column}/{filter}/", method = RequestMethod.GET)
    public List<City> getCitiesByColumnFilter(@PathVariable String column,@PathVariable String filter) {
        return cityService.getCitiesByColumnFilter(column, filter);
    }

    // Item 10
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/count-cities-by-column/{column}", method = RequestMethod.GET)
    public long getCountCitiesByColumn(@PathVariable String column) {
        return cityService.getCountCitiesByColumn(column);
    }

    // Item 11
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/count-all", method = RequestMethod.GET)
    public long countAll() {
        return cityService.countAll();
    }

    // Item 12
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/most-distant-cities", method = RequestMethod.GET)
    public List<City> getMostDistantCities() {
        return cityService.getMostDistantCities();
    }
}