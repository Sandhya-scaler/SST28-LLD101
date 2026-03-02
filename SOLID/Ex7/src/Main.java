// public class Main {
//     public static void main(String[] args) {
//         System.out.println("=== Smart Classroom ===");
//         DeviceRegistry reg = new DeviceRegistry();
//         reg.add(new Projector());
//         reg.add(new LightsPanel());
//         reg.add(new AirConditioner());
//         reg.add(new AttendanceScanner());

//         ClassroomController c = new ClassroomController(reg);
//         c.startClass();
//         c.endClass();
//     }
// }

public class Main {

    public static void main(String[] args) {

        DeviceRegistry registry = new DeviceRegistry();

        Projector projector = new Projector();
        projector.connectInput("HDMI-1");

        LightsPanel lights = new LightsPanel();
        AirConditioner ac = new AirConditioner();
        AttendanceScanner scanner = new AttendanceScanner();

        registry.register(projector);
        registry.register(lights);
        registry.register(ac);
        registry.register(scanner);

        SmartClassroomController controller =
                new SmartClassroomController(
                        projector,
                        lights,
                        ac,
                        scanner,
                        lights,
                        ac
                );

        controller.startClassroom();
        controller.shutdown();
    }
}