// public class Main {
//     public static void main(String[] args) {
//         System.out.println("=== Transport Booking ===");
//         TripRequest req = new TripRequest("23BCS1010", new GeoPoint(12.97, 77.59), new GeoPoint(12.93, 77.62));
//         TransportBookingService svc = new TransportBookingService();
//         svc.book(req);
//     }
// }


public class Main {

    public static void main(String[] args) {

        System.out.println("=== Transport Booking ===");

        DistanceService distanceService = new DistanceCalculator();
        DriverService driverService = new DriverAllocator();
        PaymentService paymentService = new PaymentGateway();

        TransportBookingService service =
                new TransportBookingService(
                        distanceService,
                        driverService,
                        paymentService
                );

        TripRequest req = new TripRequest(
                "23BCS1010",
                new GeoPoint(12.97, 77.59),
                new GeoPoint(12.93, 77.62)
        );

        service.book(req);
    }
}