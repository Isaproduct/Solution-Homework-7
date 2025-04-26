package part1;
import java.util.Iterator;


import java.util.List;

public class BingeIterator implements Iterator<Episode> {  // Убедитесь, что BingeIterator реализует Iterator<Episode>
    private List<Season> seasons;
    private int seasonIndex = 0;
    private Iterator<Episode> currentIterator;  // Используем Iterator<Episode>, а не EpisodeIterator

    public BingeIterator(List<Season> seasons) {
        this.seasons = seasons;
        if (seasons.size() > 0) {
            this.currentIterator = new SeasonIterator(seasons.get(0));  // Инициализация итератора для первого сезона
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
