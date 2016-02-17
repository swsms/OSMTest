package firstwork.common;

/**
 * Created by Артем on 17.02.2016.
 */
public class Attraction {
    private String name;
    private Address address;

    public Attraction(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return name + "\n" + address.toString();
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }
}
