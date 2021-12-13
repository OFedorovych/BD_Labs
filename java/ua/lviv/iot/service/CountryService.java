package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.Country;
import ua.lviv.iot.exceptions.NotFound;
import ua.lviv.iot.repository.CountryRepository;
import ua.lviv.iot.repository.ProducerRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CountryService {
    @Autowired
    CountryRepository countryRepository;
    // private boolean ascending;

    @Autowired
    ProducerRepository producerRepository;

    public List<Country> getAllCountry(){
        return countryRepository.findAll();
    }

    public Country getCountry(Integer country_id) throws NotFound {
        Country country = countryRepository.findById(country_id).get();
        return country;
    }

    @Transactional
    public void createCountry(Country country){
        countryRepository.save(country);
    }

    @Transactional
    public void updateCountry(Country uCountry, Integer country_id) throws NotFound {
        Country country = countryRepository.findById(country_id).get();
        country.setCountry(uCountry.getCountry());
        countryRepository.save(country);
    }

    @Transactional
    public Country deleteCountry(Integer country_id) throws NotFound {
        Country country = countryRepository.findById(country_id).get();
        countryRepository.delete(country);
        return country;
    }

}
