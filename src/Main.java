import domain.Poll;
import factory.*;
import builder.PollBuilder;
import java.util.List;
import prototype.PollPrototype;
import bridge.*;
import composite.*;
import decorator.*;
import flyweight.Icon;
import flyweight.IconFactory;
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
        ////decorator
        PollComponent plainPoll = new PollLeaf(foodPoll);
        PollComponent hotPoll = new HotPollDecorator(plainPoll);
        PollComponent hotAndEndingSoon = new EndingSoonDecorator(hotPoll);

        System.out.println(hotAndEndingSoon.describe());


        // test flyweight wired into factory
        Poll coffeePoll = new CoffeePollFactory().createPoll("Coffee run?", List.of("Starbucks", "Local cafe"));
        System.out.println(coffeePoll.getQuestion());

        // test flyweight wired into decorators
        PollComponent plainFoodPoll = new PollLeaf(foodPoll);
        PollComponent hotFoodPoll = new HotPollDecorator(plainFoodPoll);
        hotAndEndingSoon = new EndingSoonDecorator(hotFoodPoll);
        System.out.println(hotAndEndingSoon.describe());

        // prove the icons are actually shared, not recreated
        Icon fire1 = IconFactory.get("🔥");
        Icon fire2 = IconFactory.get("🔥");
        System.out.println("Same fire icon object? " + (fire1 == fire2));
        System.out.println("Pool size: " + IconFactory.poolSize());
    }
}