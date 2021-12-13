package ua.lviv.iot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.DTO.CategoriesDTO;
import ua.lviv.iot.DTO.CountryDTO;
import ua.lviv.iot.domain.Categories;
import ua.lviv.iot.domain.Country;
import ua.lviv.iot.exceptions.NotFound;
import ua.lviv.iot.service.CategoriesService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(path = "/categories")
public class CategoriesController {
    @Autowired
    private CategoriesService categoriesService;

    @GetMapping(value = "")
    public ResponseEntity<List<CategoriesDTO>> getAllCategories() throws NotFound {
        List<Categories> categoriesList = categoriesService.getAllCategories();
        Link link = linkTo(methodOn(CategoriesController.class).getAllCategories()).withSelfRel();

        List<CategoriesDTO> categoriesDTO = new ArrayList<>();
        for (Categories entity : categoriesList) {
//          Link selfLink = new Link( link.getHref() + "/" + entity.getId()).withSelfRel();
            Link selfLink =  Link.of(link.getHref() + entity.getId());
            CategoriesDTO dto = new CategoriesDTO(entity, selfLink);
            categoriesDTO.add(dto);
        }
        return new ResponseEntity<>(categoriesDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoriesDTO> getCategories(@PathVariable Integer id) throws NotFound {
        Categories categories;
        try {
            categories = categoriesService.getCategories(id);
        }
        catch (Exception e){
            //LOGGER.error("Can't put(updateAgencyAnimator) an AgencyAnimator with non-existing id: " + id);
            //throw new ItemNotFoundException("Can't put (updateCategories) an Categories with non-existing id: " + id);
            //e.getMessage()
            return new ResponseEntity("getCategories : Can't return an categories with id: " + id, HttpStatus.NOT_FOUND);
        }
        Link link = linkTo(methodOn(CategoriesController.class).getCategories(id)).withSelfRel();
        CategoriesDTO categoriesDTO = new CategoriesDTO(categories, link);
        return new ResponseEntity<>(categoriesDTO, HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<CategoriesDTO> updateCategories(@PathVariable("id") final int id,
                                                    @Valid @RequestBody final Categories categories) {

        try {
            categoriesService.updateCategories(categories,id);
        }
        catch (Exception e){
            //LOGGER.error("Can't put(updateAgencyAnimator) an AgencyAnimator with non-existing id: " + id);
            //throw new ItemNotFoundException("Can't put (updateCategories) an Categories with non-existing id: " + id);
            System.out.println("Can't put (updateCategories) an Categories with non-existing id: " + e);
            return new ResponseEntity("updateCategories can't update the Categories with id: " + e, HttpStatus.NOT_FOUND);
        }
        Link link = linkTo(methodOn(CategoriesController.class).updateCategories(id, categories)).withSelfRel();
        CategoriesDTO categoriesDTO = new CategoriesDTO(categories, link);
        categories.setId(id);
        return new ResponseEntity<>(categoriesDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CategoriesDTO> addCategories(@RequestBody Categories newCategories) throws NotFound {
        categoriesService.createCategories(newCategories);
        Link link = linkTo(methodOn(CategoriesController.class).addCategories(newCategories)).withSelfRel();
        CategoriesDTO categoriesDTO = new CategoriesDTO(newCategories, link);
        return new ResponseEntity<>(categoriesDTO, HttpStatus.CREATED);
    }


    @DeleteMapping(value = "{id}")
    public ResponseEntity<CategoriesDTO> deleteCategories(@PathVariable("id") final int id) {
        try {
            categoriesService.deleteCategories(id);
        }
        catch (Exception e){
            return new ResponseEntity("deleteCategories : Can't delete the ctegories with id: " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity("Deleted categories with id: " + id, HttpStatus.OK);
    }
}
