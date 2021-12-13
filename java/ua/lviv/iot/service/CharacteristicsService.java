package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.Characteristics;
import ua.lviv.iot.exceptions.NotFound;
import ua.lviv.iot.repository.CharacteristicsRepository;
import ua.lviv.iot.repository.GoodsRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CharacteristicsService {
    @Autowired
    CharacteristicsRepository characteristicsRepository;
    
    @Autowired
    GoodsRepository goodsRepository;

    public List<Characteristics> getAllCharacteristics(){
        return characteristicsRepository.findAll();
    }

    public Characteristics getCharacteristics(Integer characteristics_id) throws NotFound {
        Characteristics characteristics = characteristicsRepository.findById(characteristics_id).get();
        return characteristics;
    }

    @Transactional
    public void createCharacteristics(Characteristics characteristics){
        characteristicsRepository.save(characteristics);
    }

    @Transactional
    public void updateCharacteristics(Characteristics uCharacteristics, Integer characteristics_id) throws NotFound {
        Characteristics characteristics = characteristicsRepository.findById(characteristics_id).get();
        characteristics.setName(uCharacteristics.getName());
        characteristics.setValue(uCharacteristics.getValue());
        characteristicsRepository.save(characteristics);
    }

    @Transactional
    public Characteristics deleteCharacteristics(Integer characteristics_id) throws NotFound {
        Characteristics characteristics = characteristicsRepository.findById(characteristics_id).get();
        characteristicsRepository.delete(characteristics);
        return characteristics;
    }
}
