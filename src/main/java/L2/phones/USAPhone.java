package L2.phones;

public class USAPhone implements Phone{
    private static final String PREFIX = "+1";
    private final String phoneNumber;

    public USAPhone(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String formatedPhone() {
        return "Phone: " + PREFIX + " ("
                + phoneNumber.substring(0, 3) + ") "
                + phoneNumber.substring(3, 6) + "-"
                + phoneNumber.substring(6, 10);
    }


}
