import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

public class JsonParserTest {
    @Test
    public void testParsingOnePerson() throws IOException{
        File input = new File("src/test/resources/multiplePeopleMultipleWords.json");

        WordCloudDataParser parser = new JsonParser();

        Map<String, WordStat> actual = parser.parse(input);

        Set<String> expectedWords = new HashSet<>();
        expectedWords.add("optimize");
        expectedWords.add("web-enabled");
        expectedWords.add("brand");
        expectedWords.add("sexy");
        expectedWords.add("benchmark");
        expectedWords.add("cross-platform");

        /*
        "Ila Huels": [
        "OPTIMIZE WEB-ENABLED",
                "brand sexy"
        ],
        "Cristopher Feest": [
        "BENCHMARK CROSS-PLATFORM",
                "brand sexy"
        ]
          */

        assertEquals(expectedWords, actual.keySet());

        assertEquals(6, actual.values().size());

        List<String> people = new ArrayList<>();
        people.add("Ila Huels");
        people.add("Cristopher Feest");

        assertEquals(new WordStat(people), actual.get("brand"));
    }

}