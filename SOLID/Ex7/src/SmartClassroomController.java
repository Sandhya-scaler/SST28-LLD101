// public class ClassroomController {
//     private final DeviceRegistry reg;

//     public ClassroomController(DeviceRegistry reg) { this.reg = reg; }

//     public void startClass() {
//         SmartClassroomDevice pj = reg.getFirstOfType("Projector");
//         pj.powerOn();
//         pj.connectInput("HDMI-1");

//         SmartClassroomDevice lights = reg.getFirstOfType("LightsPanel");
//         lights.setBrightness(60);

//         SmartClassroomDevice ac = reg.getFirstOfType("AirConditioner");
//         ac.setTemperatureC(24);

//         SmartClassroomDevice scan = reg.getFirstOfType("AttendanceScanner");
//         System.out.println("Attendance scanned: present=" + scan.scanAttendance());
//     }

//     public void endClass() {
//         System.out.println("Shutdown sequence:");
//         reg.getFirstOfType("Projector").powerOff();
//         reg.getFirstOfType("LightsPanel").powerOff();
//         reg.getFirstOfType("AirConditioner").powerOff();
//     }
// }


public class SmartClassroomController {

    private final PowerControl projector;
    private final BrightnessControl lights;
    private final TemperatureControl ac;
    private final AttendanceCapable scanner;
    private final PowerControl lightsPower;
    private final PowerControl acPower;

    public SmartClassroomController(
            PowerControl projector,
            BrightnessControl lights,
            TemperatureControl ac,
            AttendanceCapable scanner,
            PowerControl lightsPower,
            PowerControl acPower) {

        this.projector = projector;
        this.lights = lights;
        this.ac = ac;
        this.scanner = scanner;
        this.lightsPower = lightsPower;
        this.acPower = acPower;
    }

    public void startClassroom() {
        System.out.println("=== Smart Classroom ===");

        projector.powerOn();
        lights.setBrightness(60);
        ac.setTemperatureC(24);
        scanner.scanAttendance();
    }

    public void shutdown() {
        System.out.println("Shutdown sequence:");
        projector.powerOff();
        lightsPower.powerOff();
        acPower.powerOff();
    }
}
