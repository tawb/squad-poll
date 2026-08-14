package strategy;

public class VotingStrategyFactory {
    public static VotingStrategy getStrategy(String type) {
        switch (type) {
            case "majority": return new MajorityVotingStrategy();
            case "ranked": return new RankedChoiceVotingStrategy();
            default: throw new IllegalArgumentException("Unknown strategy: " + type);
        }
    }
}