public class CreditsRule implements EligibilityRule {

    @Override
    public boolean isSatisfied(StudentProfile s) {
        return s.earnedCredits >= 20;
    }

    @Override
    public String failureReason() {
        return "credits below 20";
    }
}