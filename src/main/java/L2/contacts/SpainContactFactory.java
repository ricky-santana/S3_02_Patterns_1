package L2.contacts;

import L2.addresses.Address;
import L2.addresses.SpainAddress;
import L2.phones.Phone;
import L2.phones.SpainPhone;

public class SpainContactFactory implements ContactFactory{
    private final String street;
    private final int streetNumber;
    private final String city;
    private final String zipCode;
    private final String phoneNumber;

    public SpainContactFactory(String street, int streetNumber, String city, String zipCode, String phoneNumber) {
        this.street = street;
        this.streetNumber = streetNumber;
        this.city = city;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public Address createAddress() {
        return new SpainAddress(street, streetNumber, city, zipCode);
    }

    @Override
    public Phone createPhone() {
        return new SpainPhone(phoneNumber);
    }
}
