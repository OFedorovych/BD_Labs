package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.DTO.CharacteristicsDTO;
import ua.lviv.iot.DTO.CountryDTO;
import ua.lviv.iot.domain.Characteristics;
import ua.lviv.iot.domain.Country;
import ua.lviv.iot.exceptions.NotFound;
import ua.lviv.iot.service.CharacteristicsService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(path = "/characteristics")
public class CharacteristicsController {
    @Autowired
    private CharacteristicsService characteristicsService;

    @GetMapping(value = "")
    public ResponseEntity<List<CharacteristicsDTO>> getAllCharacteristics() throws NotFound {
        List<Characteristics> characteristicsList = characteristicsService.getAllCharacteristics();
        Link link = linkTo(methodOn(CharacteristicsController.class).getAllCharacteristics()).withSelfRel();

        List<CharacteristicsDTO> characteristicsDTO = new ArrayList<>();
        for (Characteristics entity : characteristicsList) {
//            Link selfLink = new Link( link.getHref() + "/" + entity.getId()).withSelfRel();
            Link selfLink =  Link.of(link.getHref() + entity.getCharId());
            CharacteristicsDTO dto = new CharacteristicsDTO(entity, selfLink);
            characteristicsDTO.add(dto);
        }
        return new ResponseEntity<>(characteristicsDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CharacteristicsDTO> getCharacteristics(@PathVariable Integer id) throws NotFound {
        Characteristics characteristics;
        try {
            characteristics = characteristicsService.getCharacteristics(id);
        }
        catch (Exception e){
            //LOGGER.error("Can't put(updateAgencyAnimator) an AgencyAnimator with non-existing id: " + id);
            //throw new ItemNotFoundException("Can't put (updateCharacteristics) an Characteristics with non-existing id: " + id);
            //e.getMessage()
            return new ResponseEntity("getCharacteristics : Can't return an characteristics with id: " + id, HttpStatus.NOT_FOUND);
        }
        Link link = linkTo(methodOn(CharacteristicsController.class).getCharacteristics(id)).withSelfRel();
        CharacteristicsDTO characteristicsDTO = new CharacteristicsDTO(characteristics, link);
        return new ResponseEntity<>(characteristicsDTO, HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<CharacteristicsDTO> updateCharacteristics(@PathVariable("id") final int id,
                                                    @Valid @RequestBody final Characteristics characteristics) {

        try {
            characteristicsService.updateCharacteristics(characteristics,id);
        }
        catch (Exception e){
            //LOGGER.error("Can't put(updateAgencyAnimator) an AgencyAnimator with non-existing id: " + id);
            //throw new ItemNotFoundException("Can't put (updateCharacteristics) an Characteristics with non-existing id: " + id);
//            System.out.println("Can't put (updateCharacteristics) an characteristics with non-existing id: " + e);
            System.out.println(e);
            return new ResponseEntity("updateCharacteristics can't update the Characteristics with id: " + e, HttpStatus.NOT_FOUND);
        }
        Link link = linkTo(methodOn(CharacteristicsController.class).updateCharacteristics(id, characteristics)).withSelfRel();
        CharacteristicsDTO characteristicsDTO = new CharacteristicsDTO(characteristics, link);
        characteristics.setCharId(id);
        return new ResponseEntity<>(characteristicsDTO, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<CharacteristicsDTO> addCharacteristics(@RequestBody Characteristics newCharacteristics) throws NotFound {
        characteristicsService.createCharacteristics(newCharacteristics);
        Link link = linkTo(methodOn(CharacteristicsController.class).addCharacteristics(newCharacteristics)).withSelfRel();
        CharacteristicsDTO characteristicsDTO = new CharacteristicsDTO(newCharacteristics, link);
        return new ResponseEntity<>(characteristicsDTO, HttpStatus.CREATED);
    }


    @DeleteMapping(value = "{id}")
    public ResponseEntity<CharacteristicsDTO> deleteCharacteristics(@PathVariable("id") final int id) {
        try {
            characteristicsService.deleteCharacteristics(id);
        }
        catch (Exception e){
            //LOGGER.error("Can't put(updateAgencyAnimator) an AgencyAnimator with non-existing id: " + id);
            //throw new ItemNotFoundException("Can't put (updateCharacteristics) an Characteristics with non-existing id: " + id);
            //e.getMessage()
            return new ResponseEntity("deleteCharacteristics : Can't delete the Characteristics with id: " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity("Deleted Characteristics with id: " + id, HttpStatus.OK);
    }
}
