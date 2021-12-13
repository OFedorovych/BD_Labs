package ua.lviv.iot.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Country {
    private Integer id;
    private String country;
    private Collection<Producer> producersById;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country1 = (Country) o;
        return Objects.equals(id, country1.id) && Objects.equals(country, country1.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, country);
    }

    @OneToMany(mappedBy = "countryByCountryId")
    public Collection<Producer> getProducersById() {
        return producersById;
    }

    public void setProducersById(Collection<Producer> producersById) {
        this.producersById = producersById;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", country='" + country + '\'' +
                "} \r\n";
    };

}
