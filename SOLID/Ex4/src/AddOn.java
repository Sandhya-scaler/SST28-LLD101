public enum AddOn {

    MESS(1000.0),
    LAUNDRY(500.0),
    GYM(300.0);

    private final double monthlyCharge;

    AddOn(double monthlyCharge) {
        this.monthlyCharge = monthlyCharge;
    }

    public Money monthly() {
        return new Money(monthlyCharge);
    }
}