import java.io.File;
import java.io.IOException;
import java.util.Map;

@FunctionalInterface
public interface WordCloudDataParser {
    public Map<String, WordStat> parse(File json) throws IOException;
}
