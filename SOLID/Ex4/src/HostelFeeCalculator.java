import java.util.*;

public class HostelFeeCalculator {

    private final FakeBookingRepo repo;

    public HostelFeeCalculator(FakeBookingRepo repo) {
        this.repo = repo;
    }

    public void process(BookingRequest req) {

        RoomPricing roomPricing = RoomPricingFactory.from(req.roomType);

        Money monthly = roomPricing.monthly();

        for (AddOn a : req.addOns) {
            monthly = monthly.plus(a.monthly());
        }

        Money deposit = new Money(5000.00);

        ReceiptPrinter.print(req, monthly, deposit);

        String bookingId = "H-" + (7000 + new Random(1).nextInt(1000));

        repo.save(bookingId, req, monthly, deposit);
    }
}