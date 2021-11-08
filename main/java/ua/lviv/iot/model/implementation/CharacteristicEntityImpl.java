package ua.lviv.iot.model.implementation;

import ua.lviv.iot.model.CharacteristicEntity;

public class CharacteristicEntityImpl implements CharacteristicEntity {
    private int characID;
    private String characName;

    public String getCharacName(){
        return characName;
    }

    public void setCharacName(String characName){
        this.characName = characName;
    }

    public int getCharacID() {
        return characID;
    }

    public void setCharacID(int characID){
        this.characID = characID;
    }

    public CharacteristicEntityImpl() {}

    public CharacteristicEntityImpl(int characID, String characName) {
        this.characID = characID;
        this.characName = characName;
    }

    @Override
    public String toString() {
        return String.format("%3s %-12s", characID, characName);
    }
}
