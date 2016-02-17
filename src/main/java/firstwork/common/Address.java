package firstwork.common;

/**
 * Created by Артем on 17.02.2016.
 */
public class Address {

    private String country;
    private String city;
    private String street;
    private String houseNumber;

    /** Дефолтные значения */
    public Address() {
        this.country = "Российская Федерация";
        this.city = "Пермь";
        this.street = "";
        this.houseNumber = "";
    }

    @Override
    public String toString() {
        return country + "," + city + "," + street + " " + houseNumber;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setCountry(String country) {
        if (country != null) {
            this.country = country;
        }
    }

    public void setCity(String city) {
        if (city != null) {
            this.city = city;
        }
    }

    public void setStreet(String street) {
        if (street != null) {
            this.street = street;
        }
    }

    public void setHouseNumber(String houseNumber) {
        if (houseNumber != null) {
            this.houseNumber = houseNumber;
        }
    }
}
