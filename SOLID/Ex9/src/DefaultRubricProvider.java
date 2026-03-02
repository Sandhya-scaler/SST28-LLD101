public class DefaultRubricProvider implements IRubricProvider {

    @Override
    public Rubric getRubric() {
        return new Rubric();
    }
}