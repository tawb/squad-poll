import domain.Poll;
import factory.FoodPollFactory;
import builder.PollBuilder;
import java.util.List;
import prototype.PollPrototype;
import bridge.*;
import composite.*;
//////testing
public class Main {
    public static void main(String[] args) {
        Poll foodPoll = new FoodPollFactory().createPoll("Where to eat?", List.of("Pizza", "Sushi", "Tacos"));

        System.out.println(foodPoll.getQuestion());
        for (var option : foodPoll.getOptions()) {
            System.out.println(" - " + option.getLabel());
        }
        Poll moviePoll = new PollBuilder()
                .question("Movie night?")
                .addOption("Dune 3")
                .addOption("Barbie 2")
                .build();

        System.out.println(moviePoll.getQuestion());
        for (var option : moviePoll.getOptions()) {
            System.out.println(" - " + option.getLabel());
        }
        Poll clonedPoll = PollPrototype.cloneAsTemplate(foodPoll);
        System.out.println(clonedPoll.getQuestion());
        System.out.println("Original id: " + foodPoll.getId());
        System.out.println("Clone id: " + clonedPoll.getId());

        ///////bridge test
        PollDisplay simpleConsole = new SimplePollDisplay(new ConsoleRenderer());
        simpleConsole.show(foodPoll);

        PollDisplay detailedDiscord = new DetailedPollDisplay(new DiscordRenderer());
        detailedDiscord.show(foodPoll);

        ///composite
        PollGroup weekendPlans = new PollGroup("Weekend Plans");
        weekendPlans.add(new PollLeaf(foodPoll));
        weekendPlans.add(new PollLeaf(moviePoll));

        System.out.println(weekendPlans.describe());
        System.out.println("Fully closed? " + weekendPlans.isFullyClosed());
        PollComponent foodComponent = new PollLeaf(foodPoll);
        System.out.println(foodComponent.describe());
        System.out.println("Fully closed? " + foodComponent.isFullyClosed());
    }
}