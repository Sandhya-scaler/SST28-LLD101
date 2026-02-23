public class AttendanceRule implements EligibilityRule {

    @Override
    public boolean isSatisfied(StudentProfile s) {
        return s.attendancePct >= 75;
    }

    @Override
    public String failureReason() {
        return "attendance below 75";
    }
}