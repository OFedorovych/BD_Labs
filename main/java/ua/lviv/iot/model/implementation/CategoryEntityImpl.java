package ua.lviv.iot.model.implementation;

import ua.lviv.iot.model.CategoryEntity;

public class CategoryEntityImpl implements CategoryEntity {
    private int catID;
    private String catName;

    public String getCatName(){
        return catName;
    }

    public void setCatName(String catName){
        this.catName = catName;
    }

    public int getCatID() {
        return catID;
    }

    public void setCatID(int catID) {
        this.catID = catID;
    }

    public CategoryEntityImpl() {
    }

    public CategoryEntityImpl(int catID, String catName) {
        this.catID = catID;
        this.catName = catName;
    }

    @Override
    public String toString() {
        return String.format("%3s %-12s", catID, catName);
    }
}
