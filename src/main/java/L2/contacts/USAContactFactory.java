package L2.contacts;

import L2.addresses.Address;
import L2.addresses.USAAddress;
import L2.phones.Phone;
import L2.phones.USAPhone;

public class USAContactFactory implements ContactFactory{
    private final String street;
    private final int streetNumber;
    private final String city;
    private final String zipCode;
    private final String phoneNumber;

    public USAContactFactory(String street, int streetNumber, String city, String zipCode, String phoneNumber) {
        this.street = street;
        this.streetNumber = streetNumber;
        this.city = city;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public Address createAddress() {
        return new USAAddress(street, streetNumber, city, zipCode);
    }

    @Override
    public Phone createPhone() {
        return new USAPhone(phoneNumber);
    }
}
