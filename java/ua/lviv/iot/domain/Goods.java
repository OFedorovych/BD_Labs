package ua.lviv.iot.domain;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Goods")
public class Goods {
    private Integer id;
    private String name;
    private Integer categoryId;
    private Integer producerId;
    private Integer warehouseId;
    private Categories categoriesByCategoryId;
    private Producer producerByProducerId;
    private Warehouse warehouseByWarehouseId;
    private Rating ratingById;
    private Set<ua.lviv.iot.domain.Characteristics> goods;

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
    @Column(name = "CategoryID",insertable = false,updatable = false)
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "ProducerID",insertable = false,updatable = false)
    public Integer getProducerId() {
        return producerId;
    }

    public void setProducerId(Integer producerId) {
        this.producerId = producerId;
    }

    @Basic
    @Column(name = "WarehouseID",insertable = false,updatable = false)
    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goods goods = (Goods) o;
        return Objects.equals(id, goods.id) && Objects.equals(name, goods.name) && Objects.equals(categoryId, goods.categoryId) && Objects.equals(producerId, goods.producerId) && Objects.equals(warehouseId, goods.warehouseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, categoryId, producerId, warehouseId);
    }

    @ManyToOne
    @JoinColumn(name = "CategoryID", referencedColumnName = "ID", nullable = false)
    public Categories getCategoriesByCategoryId() {
        return categoriesByCategoryId;
    }

    public void setCategoriesByCategoryId(Categories categoriesByCategoryId) {
        this.categoriesByCategoryId = categoriesByCategoryId;
    }

    @ManyToOne
    @JoinColumn(name = "ProducerID", referencedColumnName = "ID", nullable = false)
    public Producer getProducerByProducerId() {
        return producerByProducerId;
    }

    public void setProducerByProducerId(Producer producerByProducerId) {
        this.producerByProducerId = producerByProducerId;
    }

    @ManyToOne
    @JoinColumn(name = "WarehouseID", referencedColumnName = "ID", nullable = false)
    public Warehouse getWarehouseByWarehouseId() {
        return warehouseByWarehouseId;
    }

    public void setWarehouseByWarehouseId(Warehouse warehouseByWarehouseId) {
        this.warehouseByWarehouseId = warehouseByWarehouseId;
    }

    @OneToOne(mappedBy = "goodsByGoodId")
    public Rating getRatingById() {
        return ratingById;
    }

    public void setRatingById(Rating ratingById) {
        this.ratingById = ratingById;
    }

    @ManyToMany
    @JoinTable(name = "good_char", catalog = "", schema = "lab3", joinColumns = @JoinColumn(name = "GoodID", referencedColumnName = "ID", nullable = false), inverseJoinColumns = @JoinColumn(name = "CharacterID", referencedColumnName = "Char_ID", nullable = false))
    public Set<ua.lviv.iot.domain.Characteristics> getGoods() {
        return goods;
    }

    public void setGoods(Set<ua.lviv.iot.domain.Characteristics> goods) {
        this.goods = goods;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", name='" + name +
                ", categoryId=" + categoryId +
                ", producerId=" + producerId +
                ", warehouseId=" + warehouseId +
//                ", CategoryId=" + categoriesByCategoryId +
//                ", ProducerId=" + producerByProducerId +
//                ", WarehouseId=" + warehouseByWarehouseId +
                ", ratingById=" + ratingById;
    }
}

