package L2;

import L2.contacts.Contact;
import L2.contacts.SpainContactFactory;
import L2.contacts.USAContactFactory;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactTest {
    public Contact contactSpain;
    public Contact contactUsa;
    public SpainContactFactory spainContactFactory;
    public USAContactFactory usaContactFactory;

    @BeforeEach
    void init() {
        spainContactFactory = new SpainContactFactory("Carrer Major", 34, "Barcelona",
                "08001", "623456789");
        contactSpain = new Contact(spainContactFactory);

        usaContactFactory = new USAContactFactory("5th Avenue", 154, "New York",
                "NY 10001", "0987654321");
        contactUsa = new Contact(usaContactFactory);

    }

    @Test
    void shouldReturnTheCorrectFormat (){
        assertEquals("Address: Carrer Major 34, 08001 Barcelona | Phone: +34 623 45 67 89",
                contactSpain.toString());
        assertEquals("Address: 154 5th Avenue, New York, NY 10001 | Phone: +1 (098) 765-4321",
                contactUsa.toString());

    }
}
