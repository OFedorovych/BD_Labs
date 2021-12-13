package ua.lviv.iot.controller;


import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.DTO.CountryDTO;
import ua.lviv.iot.domain.Country;
import ua.lviv.iot.exceptions.NotFound;
import ua.lviv.iot.service.CountryService;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/country")
public class CountryController {
    @Autowired
    private CountryService countryService;

    @GetMapping(value = "")
    public ResponseEntity<List<CountryDTO>> getAllCountry() throws NotFound {
        List<Country> countryList = countryService.getAllCountry();
        Link link = linkTo(methodOn(CountryController.class).getAllCountry()).withSelfRel();

        List<CountryDTO> countryDTO = new ArrayList<>();
        for (Country entity : countryList) {
//            Link selfLink = new Link( link.getHref() + "/" + entity.getId()).withSelfRel();
            Link selfLink =  Link.of(link.getHref() + entity.getId());
            CountryDTO dto = new CountryDTO(entity, selfLink);
            countryDTO.add(dto);
        }
        return new ResponseEntity<>(countryDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CountryDTO> getCountry(@PathVariable Integer id) throws NotFound {
        Country country;
        try {
            country = countryService.getCountry(id);
        }
        catch (Exception e){
            //LOGGER.error("Can't put(updateAgencyAnimator) an AgencyAnimator with non-existing id: " + id);
            //throw new ItemNotFoundException("Can't put (updateCountry) an Country with non-existing id: " + id);
            //e.getMessage()
            return new ResponseEntity("getCountry : Can't return an country with id: " + id, HttpStatus.NOT_FOUND);
        }
        Link link = linkTo(methodOn(CountryController.class).getCountry(id)).withSelfRel();
        CountryDTO countryDTO = new CountryDTO(country, link);
        return new ResponseEntity<>(countryDTO, HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<CountryDTO> updateCountry(@PathVariable("id") final int id,
                                                    @Valid @RequestBody final Country country) {

        try {
            countryService.updateCountry(country,id);
        }
        catch (Exception e){
            //LOGGER.error("Can't put(updateAgencyAnimator) an AgencyAnimator with non-existing id: " + id);
            //throw new ItemNotFoundException("Can't put (updateCountry) an Country with non-existing id: " + id);
            System.out.println("Can't put (updateCountry) an Country with non-existing id: " + id);
            return new ResponseEntity("updateCountry can't update the country with id: " + id, HttpStatus.NOT_FOUND);
        }
        Link link = linkTo(methodOn(CountryController.class).updateCountry(id, country)).withSelfRel();
        CountryDTO countryDTO = new CountryDTO(country, link);
        country.setId(id);
        return new ResponseEntity<>(countryDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CountryDTO> addCountry(@RequestBody Country newCountry) throws NotFound {
        countryService.createCountry(newCountry);
        Link link = linkTo(methodOn(CountryController.class).addCountry(newCountry)).withSelfRel();
        CountryDTO countryDTO = new CountryDTO(newCountry, link);
        return new ResponseEntity<>(countryDTO, HttpStatus.CREATED);
    }


    @DeleteMapping(value = "{id}")
    public ResponseEntity<CountryDTO> deleteCountry(@PathVariable("id") final int id) {
        try {
            countryService.deleteCountry(id);
        }
        catch (Exception e){
            //LOGGER.error("Can't put(updateAgencyAnimator) an AgencyAnimator with non-existing id: " + id);
            //throw new ItemNotFoundException("Can't put (updateCountry) an Country with non-existing id: " + id);
            //e.getMessage()
            return new ResponseEntity("deleteCountry : Can't delete the country with id: " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity("Deleted country with id: " + id, HttpStatus.OK);
    }
}











