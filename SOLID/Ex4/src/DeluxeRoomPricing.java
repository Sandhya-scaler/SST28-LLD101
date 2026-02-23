public class DeluxeRoomPricing implements RoomPricing {

    @Override
    public Money monthly() {
        return new Money(16000.0);
    }
}