package factory;

public class MoviePollFactory extends PollFactory{
    @Override
    protected String categoryPrefix() {
        return "🎬";
    }
}
