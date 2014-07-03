import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class WordStatTest {
    @Test
    public void testCountIsLengthOfPeople() {
        List<String> twoPeople = new ArrayList<>();
        twoPeople.add("Sue");
        twoPeople.add("Bob");

        WordStat stat = new WordStat(twoPeople);

        assertEquals(2, stat.getCount());
    }

    @Test
    public void testEquals() throws Exception {
        List<String> onePerson = new ArrayList<>();
        onePerson.add("Bob");

        List<String> twoPeople = new ArrayList<>();
        twoPeople.add("Sue");
        twoPeople.add("Bob");

        List<String> anotherTwoPeople = new ArrayList<>();
        anotherTwoPeople.add("Sue");
        anotherTwoPeople.add("Bob");


        WordStat stat1 = new WordStat(onePerson);
        WordStat stat2 = new WordStat(twoPeople);
        WordStat stat3 = new WordStat(anotherTwoPeople);

        assertFalse(stat2.equals(new Object()));
        assertTrue(stat2.equals(stat3));
        assertFalse(stat1.equals(stat2));
    }
}