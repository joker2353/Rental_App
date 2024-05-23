package com.malkinfo.rentalapp;

/**
 * The FeatureType interface represents the type of features available for a house.
 */
interface FeatureType {
    String getTypeName();
    void setTypeName(String type);
}

/**
 * The ac class represents an air-conditioned feature type.
 */
class ac implements FeatureType{
    String typeName;

    public ac(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public void setTypeName(String type){
        this.typeName=type;
    }

    @Override
    public String getTypeName(){
        return typeName;
    }
}

/**
 * The nonac class represents a non-air-conditioned feature type.
 */
class nonac implements FeatureType{
    String typeName;

    public nonac(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public void setTypeName(String type){
        this.typeName=type;
    }

    @Override
    public String getTypeName(){
        return typeName;
    }
}

/**
 * The sound class represents a sound-related feature type.
 */
class sound implements FeatureType{
    String t;

    public sound(String typeName) {
        this.t = typeName;
    }

    @Override
    public void setTypeName(String type){
        this.t=type;
    }

    @Override
    public String getTypeName(){
        return t;
    }
}

/**
 * The House abstract class represents a generic house.
 */
abstract class House {
    protected FeatureType roomType;

    /**
     * Constructs a house object with the specified room type.
     * @param roomType The room type of the house.
     */
    public House(FeatureType roomType) {
        this.roomType=roomType;
    }

    /**
     * Retrieves the details of the house.
     * @return The details of the house.
     */
    abstract String getHouseDetails();
}

/**
 * The Flat class represents a flat type of house.
 */
class Flat extends House{
    public Flat(FeatureType roomType) {
        super( roomType);
    }

    @Override
    String getHouseDetails(){
        return "Flat with " + roomType.getTypeName();
    }
}

/**
 * The Apartment class represents an apartment type of house.
 */
class Apartment extends House{
    public Apartment(FeatureType roomType) {
        super( roomType);
    }

    @Override
    String getHouseDetails(){
        return "Apartment with " + roomType.getTypeName();
    }
}

/**
 * The FeatureFactory class provides a method to create instances of FeatureType objects based on the feature type.
 */
class FeatureFactory {
    /**
     * Creates an instance of FeatureType based on the given feature type.
     * @param fType The feature type.
     * @return An instance of FeatureType corresponding to the feature type.
     */
    public static FeatureType getfeature(String fType){
        if(fType == null){
            return null;
        }

        if(fType.equalsIgnoreCase("AC")){
            return new ac("AC");

        } else if(fType.equalsIgnoreCase("Non AC")){
            return new nonac("Non AC");
        }
        else if(fType.equalsIgnoreCase("Window Side")){
            return new nonac("Window Side");
        }

        return null;
    }
}

/**
 * The HouseFactory class provides a method to create instances of House objects based on the house type.
 */
class HouseFactory {
    /**
     * Creates an instance of House based on the given house type and feature type.
     * @param hType The house type.
     * @param f The feature type of the house.
     * @return An instance of House corresponding to the house type.
     */
    public static House gethouseType(String hType,FeatureType f){
        if(hType == null){
            return null;
        }

        if(hType.equalsIgnoreCase("Flat")){
            return new Flat(f);

        } else if(hType.equalsIgnoreCase("Apartment")){
            return new Apartment(f);
        }

        return null;
    }
}
