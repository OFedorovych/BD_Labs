package ua.lviv.iot.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Characteristics {
    private Integer charId;
    private Double value;
    private String name;
    private Set<Goods> chars;

    @Id
    @Column(name = "Char_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getCharId() {
        return charId;
    }

    public void setCharId(Integer charId) {
        this.charId = charId;
    }

    @Basic
    @Column(name = "Value")
    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
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
        Characteristics that = (Characteristics) o;
        return Objects.equals(charId, that.charId) && Objects.equals(value, that.value) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(charId, value, name);
    }

    @ManyToMany(mappedBy = "goods")
    public Set<Goods> getChars() {
        return chars;
    }

    public void setChars(Set<Goods> chars) {
        this.chars = chars;
    }

    @Override
    public String toString() {
        return String.format("%3s %-20s %-12s", charId, name, value);
    }
}
