import java.util.List;

public class WordStat {
    private List<String> people;

    public WordStat(List<String> people) {
        this.people = people;
    }

    public int getCount() {
        return this.people.size();
    }

    public List<String> getPeople() {
        return this.people;
    }

    @Override
    public boolean equals(Object obj) {
        if (this.getClass() != obj.getClass()) {
            return false;
        }

        WordStat other = (WordStat) obj;
        return this.people.equals(other.people);
    }
}
