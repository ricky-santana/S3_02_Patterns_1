package L2.addresses;

public class SpainAddress implements Address{
    private final String street;
    private final int streetNumber;
    private final String city;
    private final String zipCode;

    public SpainAddress(String street, int streetNumber, String city, String zipCode) {
        this.street = street;
        this.streetNumber = streetNumber;
        this.city = city;
        this.zipCode = zipCode;
    }

    @Override
    public String formatedAddress() {
        return "Address: " + street + " " + streetNumber +
                ", " + zipCode + " " + city;
    }
}
