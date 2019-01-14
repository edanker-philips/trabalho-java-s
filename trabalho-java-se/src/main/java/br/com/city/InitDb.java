package br.com.city;

import br.com.city.domain.repository.CityRepository;
import br.com.city.service.CityServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@AllArgsConstructor
public class InitDb implements CommandLineRunner {

    private CityRepository cityRepository;

    //private CityServiceImpl citiServiceImpl;

    @Override
    public void run(String... strings) throws Exception {
       /* System.out.println("Inicio Run");
        cityRepository.save(City.builder()
                .ibge(1100015)
                .uf("RO")
                .name("Alta Floresta D'Oeste")
                .capital(null)
                .lon(-61.9998238963)
                .lat(-11.9355403048)
                .noAccents("Alta Floresta D'Oeste")
                .alternativeNames(null)
                .microregion("Cacoal")
                .mesoregion("Leste Rondoniense")
                .build());
        City city = cityRepository.findOne(1);
        System.out.println(city.getName());*/

        /*City city = cityRepository.findOne(1100049);
        System.out.println(city.getName());
        Iterable<City> allCities = cityRepository.findAll();*/

        //Map<String, Integer> cities = citiServiceImpl.getCountSmallerBiggestState();
    }
}
