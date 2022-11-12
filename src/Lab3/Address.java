package Lab3;

public class Address {

    int streetNum;
    String street;
    String suburb;
    String city;

    //constructor
    public Address(int streetNum, String street, String suburb, String city) {
        this.streetNum = streetNum;
        this.street = street;
        this.suburb = suburb;
        this.city = city;
    }
    //getter and setter
    public int getStreetNum() { return streetNum; }
    public void setStreetNum(int streetNum) { this.streetNum = streetNum; }
    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }
    public String getSuburb() { return suburb; }
    public void setSuburb(String suburb) { this.suburb = suburb; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    //toString() method
    public String toString() {
        return " |Street Num" + streetNum + " |Street: " + street + " Suburb: " + suburb + " |City: " + city;
    }
}
