package part1;

import java.util.List;
import java.util.ArrayList;

public class Season implements Iterable<Episode> {
    List<Episode> episodes;

    public Season() {
        episodes = new ArrayList<Episode>(); // Указание типа
    }

    void addEpisode(Episode e) {
        episodes.add(e);
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    @Override
    public Iterator<Episode> iterator() {
        return new SeasonIterator(this); // Возвращаем правильный итератор
    }
}
