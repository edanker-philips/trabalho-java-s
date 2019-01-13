package br.com.city.api.v1;

import br.com.city.domain.orm.City;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class CityResourceAssembler extends ResourceAssemblerSupport<City, CityResource> {

    public CityResourceAssembler() {
        super(CityRestService.class, CityResource.class);
    }

    @Override
    public CityResource toResource(City city) {
        CityResource cityResource = createResourceWithId(city.getId(), city);
        cityResource.setUf(city.getUf());
        cityResource.setName(city.getName());
        cityResource.setCapital(city.getCapital());
        cityResource.setLon(city.getLon());
        cityResource.setLat(city.getLat());
        cityResource.setNoAccents(city.getNoAccents());
        cityResource.setAlternativeNames(city.getAlternativeNames());
        cityResource.setMicroregion(city.getMicroregion());
        cityResource.setMesoregion(city.getMesoregion());
        addLinks(cityResource);
        return cityResource;
    }

    public City toDomain(CityResource cityResource) {
        return City.builder()
                .uf(cityResource.getUf())
                .name(cityResource.getName())
                .capital(cityResource.getCapital())
                .lon(cityResource.getLon())
                .lat(cityResource.getLat())
                .noAccents(cityResource.getNoAccents())
                .alternativeNames(cityResource.getAlternativeNames())
                .microregion(cityResource.getMicroregion())
                .mesoregion(cityResource.getMesoregion())
                .build();
    }

    private void addLinks(CityResource cityResource) {
        //Links de exemplo você pode usar o linkTo(methodOn()) e apontar diretamente para seus serviços rest
        //cityResource.add(new Link("http://localhost:8080/v1/foo", "foo"));
        //cityResource.add(new Link("http://localhost:8080/v1/bar", "bar"));
    }
}
