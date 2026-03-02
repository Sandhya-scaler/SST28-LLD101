// public class DriverAllocator {
//     public String allocate(String studentId) {
//         // fake deterministic driver
//         return "DRV-17";
//     }
// }


public class DriverAllocator implements DriverService {

    @Override
    public String allocate(String studentId) {
        return "DRV-17";
    }
}
