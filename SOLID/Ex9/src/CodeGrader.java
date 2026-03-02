// public class CodeGrader {
//     public int grade(Submission s, Rubric r) {
//         // fake scoring (but deterministic)
//         int base = Math.min(80, 50 + s.code.length() % 40);
//         return base + r.bonus;
//     }
// }

public class CodeGrader implements ICodeGrader {

    @Override
    public int grade(Submission s, Rubric r) {
        int base = Math.min(80, 50 + s.code.length() % 40);
        return base + r.bonus;
    }
}
