package bridge;

public class ConsoleRenderer implements DisplayRenderer {
    @Override
    public void writeLine(String line) {
        System.out.println(line);
    }
}