package ua.lviv.iot.DTO;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import ua.lviv.iot.domain.Categories;
import ua.lviv.iot.exceptions.NotFound;

public class CategoriesDTO extends RepresentationModel {
    Categories categories;
    public CategoriesDTO(Categories categories, Link selfLink) throws NotFound {
        this.categories = categories;
        add(selfLink);
//        add(linkTo(methodOn(CategoriesController.class).get))
    }
    public Integer getCategoriesId(){ return categories.getId();}
    public  String getCategories(){return categories.getName();}
}
