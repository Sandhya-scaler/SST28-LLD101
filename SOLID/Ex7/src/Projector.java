// public class Projector implements SmartClassroomDevice {
//     private boolean on;

//     @Override public void powerOn() { on = true; }
//     @Override public void powerOff() { on = false; System.out.println("Projector OFF"); }

//     @Override public void setBrightness(int pct) { /* irrelevant */ }
//     @Override public void setTemperatureC(int c) { /* irrelevant */ }
//     @Override public int scanAttendance() { return 0; } // dummy
//     @Override public void connectInput(String port) { if (on) System.out.println("Projector ON (" + port + ")"); }
// }

public class Projector implements PowerControl, InputConnectable {

    private String inputPort;

    @Override
    public void powerOn() {
        System.out.println("Projector ON (" + inputPort + ")");
    }

    @Override
    public void powerOff() {
        System.out.println("Projector OFF");
    }

    @Override
    public void connectInput(String port) {
        this.inputPort = port;
    }
}