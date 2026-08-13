package factory;

public class StudyPollFactory extends PollFactory {
    @Override
    protected String categoryPrefix() {
        return "📚";
    }
}