package ua.lviv.iot.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Categories")
public class Categories {
    private Integer id;
    private String name;
    private Collection<Goods> goodsById;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categories that = (Categories) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @OneToMany(mappedBy = "categoriesByCategoryId")
    public Collection<Goods> getGoodsById() {
        return goodsById;
    }

    public void setGoodsById(Collection<Goods> goodsById) {
        this.goodsById = goodsById;
    }

    @Override
    public String toString() {
        return String.format("%3s %-12s", id, name);

    }
}


