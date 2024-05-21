package com.malkinfo.rentalapp;



//interface HomeFeature {
//    String getFeatureName();
//    void setFeatureName(String name);
//}
//class SingleRoom implements HomeFeature {
//    protected String featureName;
//    public SingleRoom(String featureName) {
//        this.featureName = featureName;
//    }
//    @Override
//    public String getFeatureName() {
//        return featureName;
//    }
//    @Override
//    public void setFeatureName(String name) {
//        this.featureName = name;
//    }
//}
//class DoubleRoom implements HomeFeature {
//    protected String featureName;
//    public DoubleRoom(String featureName) {
//        this.featureName = featureName;
//    }
//    @Override
//    public String getFeatureName() {
//        return featureName;
//    }
//    @Override
//    public void setFeatureName(String name) {
//        this.featureName = name;
//    }
//}
interface RoomType {
    String getTypeName();
    void setTypeName(String type);
}
class AcRoom implements RoomType{
    String typeName;
    public AcRoom(String typeName) {
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
class NonAcRoom implements RoomType{
    String typeName;
    public NonAcRoom(String typeName) {
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

abstract class House {
//    protected String house_no;
//    protected HomeFeature homefeature;
    protected RoomType roomType;
//    public String getHouse_no() {
//        return house_no;
//    }
//    public void setApartment_no(String house_no) {
//        this.house_no = house_no;
//    }
    public House(RoomType roomType) {
//        this.house_no =house_no;
//        this.homefeature = homefeature;
        this.roomType=roomType;
    }
    abstract String getHouseDetails();
}
class Flat extends House{
    public Flat(RoomType roomType) {
        super( roomType);
    }
    @Override
    String getHouseDetails(){
        return roomType.getTypeName();
    }
}
class Apartment extends House{
    public Apartment(RoomType roomType) {
        super( roomType);
    }
    @Override
    String getHouseDetails(){
        return roomType.getTypeName();
    }
}

//class HouseAdapter extends Car{
//    private House house;
//    public HouseAdapter(House house) {
//        this.house = house;
//    }
//    @Override
//    public String getCarDetails(){
//        return house.getHouseDetails();
//    }
//}


