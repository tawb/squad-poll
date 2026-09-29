import domain.Poll;
import facade.PollService;
import factory.FoodPollFactory;
import factory.MoviePollFactory;
import adapter.OldSurveyForm;
import adapter.SurveyFormAdapter;
import java.util.List;
import composite.PollComponent;
import composite.PollLeaf;
import composite.PollGroup;
import flyweight.Icon;
import flyweight.IconFactory;
import registry.PollRegistry;
import decorator.HotPollDecorator;
import decorator.EndingSoonDecorator;
public class Main {
    public static void main(String[] args) {
        PollService service = new PollService();
        Poll foodPoll = service.createPoll(new FoodPollFactory(), "Where to eat?",
                List.of("Pizza", "Sushi", "Tacos"));
        System.out.println("Created: " + foodPoll.getQuestion());
        Poll hangoutPoll = service.createFreeformPoll("Random hangout idea?", "Bowling", "Arcade", "Beach");
        System.out.println("Created freeform: " + hangoutPoll.getQuestion());
        System.out.println("\n--- Results before voting ---");
        service.showResults(foodPoll.getId());
        Poll clonedPoll = service.cloneAsTemplate(foodPoll.getId());
        System.out.println("\nCloned poll: " + clonedPoll.getQuestion() + " (id: " + clonedPoll.getId() + ")");
        service.close(foodPoll.getId());
        System.out.println("\n--- Detailed view after closing ---");
        service.showDetailed(foodPoll.getId());
        System.out.println("\n--- Adapter: importing a legacy survey ---");
        OldSurveyForm legacySurvey = new OldSurveyForm("Best snack?", "Chips;Popcorn;Pretzels");
        Poll importedPoll = service.createPollFromLegacy(new SurveyFormAdapter(legacySurvey));
        System.out.println("Imported: " + importedPoll.getQuestion());
        System.out.println("\n--- Composite: bundling polls into a group ---");
        Poll moviePoll = service.createPoll(new MoviePollFactory(), "Movie night?", List.of("Dune 3", "Barbie 2"));
        PollGroup weekendPlans = new PollGroup("Weekend Plans");
        weekendPlans.add(new PollLeaf(hangoutPoll));
        weekendPlans.add(new PollLeaf(moviePoll));
        System.out.println(weekendPlans.describe());
        System.out.println("Fully closed? " + weekendPlans.isFullyClosed());
        System.out.println("\n--- Flyweight: proving icons are shared ---");
        Icon fire1 = IconFactory.get("🔥");
        Icon fire2 = IconFactory.get("🔥");
        System.out.println("Same object? " + (fire1 == fire2) + ", pool size: " + IconFactory.poolSize());
        System.out.println("\n--- Singleton: same registry everywhere ---");
        System.out.println("Same registry instance? " + (PollRegistry.getInstance() == PollRegistry.getInstance()));
        System.out.println("\n--- Voting (pending Aysha's State/Strategy/Observer work) ---");
        // service.vote(foodPoll.getId(), "Ahmad", "opt0");
        // service.vote(foodPoll.getId(), "Sara", "opt0");
        // service.showResults(foodPoll.getId());
        System.out.println("\n--- Decorator: tagging a poll ---");
        PollComponent taggedMoviePoll = new EndingSoonDecorator(new HotPollDecorator(new PollLeaf(moviePoll)));
        System.out.println(taggedMoviePoll.describe());
    }
}