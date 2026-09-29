package bridge;

public class DiscordRenderer implements DisplayRenderer {
    @Override
    public void writeLine(String line) {
        System.out.println("[Discord] Sending message: \"" + line + "\"");
    }
}