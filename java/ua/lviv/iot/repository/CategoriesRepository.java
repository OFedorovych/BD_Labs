package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.domain.Categories;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Integer> {
}
