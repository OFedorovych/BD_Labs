package ua.lviv.iot.DTO;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import ua.lviv.iot.domain.Characteristics;
import ua.lviv.iot.exceptions.NotFound;

public class CharacteristicsDTO extends RepresentationModel {
    Characteristics characteristics;
    public CharacteristicsDTO(Characteristics characteristics, Link selfLink) throws NotFound {
        this.characteristics = characteristics;
        add(selfLink);
//        add(linkTo(methodOn(CharacteristicsController.class).get))
    }
    public Integer getCharacteristicsId(){ return characteristics.getCharId();}
    public Double getCharacteristicsValue(){return characteristics.getValue();}
    public String getCharacteristicsName(){return characteristics.getName();}
}
