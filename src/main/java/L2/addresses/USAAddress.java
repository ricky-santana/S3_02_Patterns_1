package L2.addresses;

public class USAAddress implements Address{
    private final String street;
    private final int streetNumber;
    private final String city;
    private final String zipCode;

    public USAAddress(String street, int streetNumber, String city, String zipCode) {
        this.street = street;
        this.streetNumber = streetNumber;
        this.city = city;
        this.zipCode = zipCode;
    }
    @Override
    public String formatedAddress() {
        return "Address: " + streetNumber + " " + street + ", " +
                city +", " + zipCode;
    }
}
