package part1;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.NoSuchElementException;

public class ShuffleSeasonIterator implements EpisodeIterator {
    private Season season;
    private List<Episode> shuffledEpisodes;
    private int currentIndex = 0;

    public ShuffleSeasonIterator(Season season, long seed) {
        this.season = season;
        shuffledEpisodes = new ArrayList<Episode>(season.getEpisodes());
        Collections.shuffle(shuffledEpisodes, new Random(seed));
    }

    @Override
    public boolean hasNext() {
        return currentIndex < shuffledEpisodes.size();
    }

    @Override
    public Episode next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more episodes to iterate");
        }
        return shuffledEpisodes.get(currentIndex++);
    }
}
