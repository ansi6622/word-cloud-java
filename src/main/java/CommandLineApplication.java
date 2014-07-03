import java.io.File;
import java.io.IOException;
import java.util.Map;

public class CommandLineApplication {
    public static void main(String[] args) {
        String filename = args[0];
        File input = new File(filename);

        WordCloudDataParser parser = new JsonParser();

        try {
            Map<String, WordStat> stats = parser.parse(input);
            output(stats);
        } catch (IOException e) {
            System.out.println("Could not read file!");
        }

    }

    private static void output(Map<String, WordStat> stats) {
        stats.entrySet().stream().forEach((entry) -> {
            System.out.println("Word: " + entry.getKey());
            System.out.println("Count: " + entry.getValue().getCount());
            System.out.println("People who said it: " + entry.getValue().getPeople());
            System.out.println("+++++++++++++++++++++++++++");
        });
    }
}
