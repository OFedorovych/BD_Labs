package ua.lviv.iot.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Warehouse {
    private Integer id;
    private String warehouse;
    private Integer employees;
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
    @Column(name = "Warehouse")
    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    @Basic
    @Column(name = "Employees")
    public Integer getEmployees() {
        return employees;
    }

    public void setEmployees(Integer employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Warehouse warehouse1 = (Warehouse) o;
        return Objects.equals(id, warehouse1.id) && Objects.equals(warehouse, warehouse1.warehouse) && Objects.equals(employees, warehouse1.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, warehouse, employees);
    }

    @OneToMany(mappedBy = "warehouseByWarehouseId")
    public Collection<Goods> getGoodsById() {
        return goodsById;
    }

    public void setGoodsById(Collection<Goods> goodsById) {
        this.goodsById = goodsById;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "id=" + id +
                ", warehouse='" + warehouse + '\'' +
                ", employees=" + employees +
                '}';
    }
}
