package br.com.city.api.v1;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;

@Data
@EqualsAndHashCode(callSuper = true)
@Relation(value="city", collectionRelation="cities")
class CityResource extends ResourceSupport {

    private String uf;
    private String name;
    private String capital;
    private double lon;
    private double lat;
    private String noAccents;
    private String alternativeNames;
    private String microregion;
    private String mesoregion;
}