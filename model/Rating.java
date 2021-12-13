package ua.lviv.iot.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Rating {
    private Integer goodId;
    private Integer fiveStars;
    private Integer fourStars;
    private Integer threeStars;
    private Integer twoStars;
    private Integer oneStar;
    private Goods goodsByGoodId;

    @Id
    @Column(name = "GoodID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    @Basic
    @Column(name = "FiveStars")
    public Integer getFiveStars() {
        return fiveStars;
    }

    public void setFiveStars(Integer fiveStars) {
        this.fiveStars = fiveStars;
    }

    @Basic
    @Column(name = "FourStars")
    public Integer getFourStars() {
        return fourStars;
    }

    public void setFourStars(Integer fourStars) {
        this.fourStars = fourStars;
    }

    @Basic
    @Column(name = "ThreeStars")
    public Integer getThreeStars() {
        return threeStars;
    }

    public void setThreeStars(Integer threeStars) {
        this.threeStars = threeStars;
    }

    @Basic
    @Column(name = "TwoStars")
    public Integer getTwoStars() {
        return twoStars;
    }

    public void setTwoStars(Integer twoStars) {
        this.twoStars = twoStars;
    }

    @Basic
    @Column(name = "OneStar")
    public Integer getOneStar() {
        return oneStar;
    }

    public void setOneStar(Integer oneStar) {
        this.oneStar = oneStar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rating rating = (Rating) o;
        return Objects.equals(goodId, rating.goodId) && Objects.equals(fiveStars, rating.fiveStars) && Objects.equals(fourStars, rating.fourStars) && Objects.equals(threeStars, rating.threeStars) && Objects.equals(twoStars, rating.twoStars) && Objects.equals(oneStar, rating.oneStar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(goodId, fiveStars, fourStars, threeStars, twoStars, oneStar);
    }

    @OneToOne
    @JoinColumn(name = "GoodID", referencedColumnName = "ID", nullable = false)
    public Goods getGoodsByGoodId() {
        return goodsByGoodId;
    }

    public void setGoodsByGoodId(Goods goodsByGoodId) {
        this.goodsByGoodId = goodsByGoodId;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "goodId=" + goodId +
                ", fiveStars=" + fiveStars +
                ", fourStars=" + fourStars +
                ", threeStars=" + threeStars +
                ", twoStars=" + twoStars +
                ", oneStar=" + oneStar +
                '}';
    }
}
