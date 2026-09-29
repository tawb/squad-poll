package flyweight;

public class Icon {
    private final String symbol;

    Icon(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}