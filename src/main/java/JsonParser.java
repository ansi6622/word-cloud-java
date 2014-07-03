import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class JsonParser implements WordCloudDataParser {

    @Override
    public Map<String, WordStat> parse(File jsonFile) throws IOException {
        Map<String, WordStat> retVal = new HashMap<>();

        Stream<WordEntry> wordEntries = getWordsFromPhrases(getPhrases(jsonFile));

        Map<String, List<WordEntry>> groupedByWord = wordEntries.collect(groupingBy(WordEntry::getWord));

        groupedByWord.entrySet().stream().forEach((entry) -> {
            List<String> people = entry.getValue().stream().map((wordEntry) -> wordEntry.getName()).collect(toList());
            retVal.put(entry.getKey(), new WordStat(people));

        });

        return retVal;
    }

    private Map<String, List<String>> getPhrases(File jsonFile) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonFile, new TypeReference<Map<String, List<String>>>() {
        });
    }

    private Stream<WordEntry> getWordsFromPhrases(Map<String, List<String>> phrases) {
        return phrases.entrySet().stream().flatMap((entry) -> entry.getValue().stream().flatMap((phrase) -> {
            String[] words = phrase.split(" ");
            return Arrays.asList(words).stream().map((word) -> new WordEntry(word.toLowerCase(), entry.getKey()));
        }));
    }
}
