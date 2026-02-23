public interface EligibilityRule {

    // return true if student passes rule
    boolean isSatisfied(StudentProfile s);

    // reason to print if rule fails
    String failureReason();
}