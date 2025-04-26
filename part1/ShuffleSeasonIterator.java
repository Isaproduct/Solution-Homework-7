package part1;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ShuffleSeasonIterator implements EpisodeIterator {
    private Season season;
    private List<Episode> shuffledEpisodes;
    private int currentIndex = 0;

    public ShuffleSeasonIterator(Season season, long seed) {
        this.season = season;
        shuffledEpisodes = new ArrayList(season.getEpisodes()); // Ошибка: можно было бы использовать ArrayList<Episode> явно
        Collections.shuffle(shuffledEpisodes, new Random(seed)); // Ошибка: может не работать, если seed неправильно задан
    }

    @Override
    public boolean hasNext() {
        return currentIndex < shuffledEpisodes.size();
    }

    @Override
    public Episode next() {
        return shuffledEpisodes.get(currentIndex++);
    }
}
