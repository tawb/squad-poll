package uifactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsolePrompter implements PollPrompter {
    @Override
    public List<String> promptForOptions() {
        System.out.println("Enter options, one per line, blank line to finish:");
        Scanner scanner = new Scanner(System.in);
        List<String> options = new ArrayList<>();
        String line;
        while (!(line = scanner.nextLine()).isEmpty()) {
            options.add(line);
        }
        return options;
    }
}