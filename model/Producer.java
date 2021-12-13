package ua.lviv.iot.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Producer {
    private Integer id;
    private String name;
    private Integer countryId;
    private Collection<Goods> goodsById;
    private Country countryByCountryId;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "CountryID", insertable = false,updatable = false)
    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public void addCountry(Integer countryId) {
        this.countryId = countryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producer producer = (Producer) o;
        return Objects.equals(id, producer.id) && Objects.equals(name, producer.name) && Objects.equals(countryId, producer.countryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, countryId);
    }

    @OneToMany(mappedBy = "producerByProducerId")
    public Collection<Goods> getGoodsById() {
        return goodsById;
    }

    public void setGoodsById(Collection<Goods> goodsById) {
        this.goodsById = goodsById;
    }

    @ManyToOne
    @JoinColumn(name = "CountryID", referencedColumnName = "ID", nullable = false)
    public Country getCountryByCountryId() {
        return countryByCountryId;
    }

    public void setCountryByCountryId(Country countryByCountryId) {
        this.countryByCountryId = countryByCountryId;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", name='" + name + '\'' +
                ", countryByCountryId=" + countryByCountryId ;
    }
}
