package part1;
import java.util.Iterator;
public class SeasonIterator implements Iterator<Episode> {
    private Season season;
    private int currentIndex = 0;

    public SeasonIterator(Season season) {
        this.season = season;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < season.getEpisodes().size();
    }

    @Override
    public Episode next() {
        return season.getEpisodes().get(currentIndex++);

    }

}
