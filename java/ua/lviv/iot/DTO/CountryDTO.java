//package ua.lviv.iot.DTO;
//
//import ua.lviv.iot.domain.Country;
//
//public class CountryDTO {
//    private Country country;
//
//    public CountryDTO (Country country) {
//        this.country = country;
//    }
//
//    public Integer getId() {
//        return Country.getId();
//    }
//
//    public String getCountryName() {
//        return Country.getCountry();
//    }
//}
package ua.lviv.iot.DTO;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
//import org.springframework.hateoas.ResourceSupport;
import ua.lviv.iot.controller.CountryController;
import ua.lviv.iot.domain.Country;
import ua.lviv.iot.exceptions.NotFound;

//import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
//import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class CountryDTO extends RepresentationModel {
    Country country;
    public CountryDTO(Country country, Link selfLink) throws NotFound{
        this.country = country;
        add(selfLink);
//        add(linkTo(methodOn(CountryController.class).get))
    }
    public Integer getCountryId(){ return country.getId();}
    public  String getCountry(){return country.getCountry();}

}