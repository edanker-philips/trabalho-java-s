package br.com.city.domain.orm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class City {

    @Id
    @GeneratedValue
    private Integer id;
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