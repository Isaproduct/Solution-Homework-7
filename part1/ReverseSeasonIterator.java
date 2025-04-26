package part1;

public class ReverseSeasonIterator implements EpisodeIterator {
    private Season season;
    private int currentIndex;

    public ReverseSeasonIterator(Season season) {
        this.season = season;
        this.currentIndex = season.getEpisodes().size() - 1;
    }

    @Override
    public boolean hasNext() {
        return currentIndex >= 0;
    }

    @Override
    public Episode next() {
        return season.getEpisodes().get(currentIndex--);
    }
}
