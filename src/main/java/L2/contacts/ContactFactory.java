package L2.contacts;

import L2.addresses.Address;
import L2.phones.Phone;

public interface ContactFactory {
    Address createAddress();
    Phone createPhone();
}
