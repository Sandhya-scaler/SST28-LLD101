// public class ClubConsole {
//     private final BudgetLedger ledger;
//     private final MinutesBook minutes;
//     private final EventPlanner events;

//     public ClubConsole(BudgetLedger ledger, MinutesBook minutes, EventPlanner events) {
//         this.ledger = ledger; this.minutes = minutes; this.events = events;
//     }

//     public void run() {
//         ClubAdminTools treasurer = new TreasurerTool(ledger);
//         ClubAdminTools secretary = new SecretaryTool(minutes);
//         ClubAdminTools lead = new EventLeadTool(events);

//         treasurer.addIncome(5000, "sponsor");
//         secretary.addMinutes("Meeting at 5pm");
//         lead.createEvent("HackNight", 2000);

//         System.out.println("Summary: ledgerBalance=" + ledger.balanceInt() + ", minutes=" + minutes.count() + ", events=" + lead.getEventsCount());
//     }
// }

public class ClubConsole {

    private final BudgetLedger ledger;
    private final MinutesBook minutes;
    private final EventPlanner planner;

    private final FinanceTool treasurer;
    private final MinutesTool secretary;
    private final EventTool lead;

    public ClubConsole(BudgetLedger ledger,
                       MinutesBook minutes,
                       EventPlanner planner) {

        this.ledger = ledger;
        this.minutes = minutes;
        this.planner = planner;

        this.treasurer = new TreasurerTool(ledger);
        this.secretary = new SecretaryTool(minutes);
        this.lead = new EventLeadTool(planner);
    }

    public void run() {

        treasurer.addIncome(5000, "sponsor");
        secretary.addMinutes("Meeting at 5pm");
        lead.createEvent("HackNight", 2000);

        System.out.println("Summary: ledgerBalance="
                + ledger.balanceInt()
                + ", minutes="
                + minutes.count()
                + ", events="
                + lead.getEventsCount());
    }
}