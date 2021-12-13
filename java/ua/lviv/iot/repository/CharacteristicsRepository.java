package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.domain.Characteristics;

@Repository
public interface CharacteristicsRepository extends JpaRepository<Characteristics, Integer> {
}
