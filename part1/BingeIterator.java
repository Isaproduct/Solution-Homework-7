package part1;

import java.util.List;

public class BingeIterator implements EpisodeIterator {
    private List<Season> seasons;
    private int seasonIndex = 0;
    private EpisodeIterator currentIterator;

    public BingeIterator(List<Season> seasons) {
        this.seasons = seasons;
        if (seasons.size() > 0) {
            this.currentIterator = new SeasonIterator(seasons.get(0)); // Убедитесь, что SeasonIterator реализует EpisodeIterator
        }
    }

    @Override
    public boolean hasNext() {
        if (currentIterator.hasNext()) {
            return true;
        } else if (seasonIndex < seasons.size() - 1) {
            seasonIndex++;
            currentIterator = new SeasonIterator(seasons.get(seasonIndex)); // Убедитесь, что SeasonIterator реализует EpisodeIterator
            return currentIterator.hasNext();
        }
        return false;
    }

    @Override
    public Episode next() {
        return currentIterator.next();
    }
}
