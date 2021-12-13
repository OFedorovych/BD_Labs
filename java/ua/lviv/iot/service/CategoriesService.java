package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.Categories;
import ua.lviv.iot.exceptions.NotFound;
import ua.lviv.iot.repository.CategoriesRepository;
import ua.lviv.iot.repository.GoodsRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CategoriesService {
    @Autowired
    CategoriesRepository categoriesRepository;


    @Autowired
    GoodsRepository goodsRepository;

    public List<Categories> getAllCategories(){
        return categoriesRepository.findAll();
    }

    public Categories getCategories(Integer сategories_id) throws NotFound {
        Categories categories = categoriesRepository.findById(сategories_id).get();
        return categories;
    }

    @Transactional
    public void createCategories(Categories categories){
        categoriesRepository.save(categories);
    }

    @Transactional
    public void updateCategories(Categories uCategories, Integer сategories_id) throws NotFound {
        Categories categories = categoriesRepository.findById(сategories_id).get();
        categories.setName(uCategories.getName());
        categoriesRepository.save(categories);
    }

    @Transactional
    public Categories deleteCategories(Integer сategories_id) throws NotFound {
        Categories categories = categoriesRepository.findById(сategories_id).get();
        categoriesRepository.delete(categories);
        return categories;
    }

}
