package L2.phones;

public class SpainPhone implements Phone {
    private static final String PREFIX = "+34";
    private final String phoneNumber;

    public SpainPhone(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    //Phone: +34 623 45 67 89
    @Override
    public String formatedPhone() {
        return "Phone: " + PREFIX + " "
                + phoneNumber.substring(0, 3) + " "
                + phoneNumber.substring(3, 5) + " "
                + phoneNumber.substring(5, 7) + " "
                + phoneNumber.substring(7, 9);
    }
}
