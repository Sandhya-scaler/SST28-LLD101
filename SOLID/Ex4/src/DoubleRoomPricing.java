public class DoubleRoomPricing implements RoomPricing {

    @Override
    public Money monthly() {
        return new Money(15000.0);
    }
}