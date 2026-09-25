package L2.contacts;
import L2.addresses.Address;
import L2.phones.Phone;

public class Contact {
    private final Address address;
    private final Phone phone;

    public Contact(ContactFactory contactFactory) {
        this.address = contactFactory.createAddress();
        this.phone = contactFactory.createPhone();
    }

    @Override
    public String toString() {
        return address.formatedAddress() + " | " + phone.formatedPhone();
    }
}
