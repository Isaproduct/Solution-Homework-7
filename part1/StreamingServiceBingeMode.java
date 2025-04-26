package part1;

import java.util.List;
import java.util.ArrayList;

public class StreamingServiceBingeMode {

    public static void main(String[] args) {
        Season season1 = new Season();
        season1.addEpisode(new Episode("Episode 1", 1200));
        season1.addEpisode(new Episode("Episode 2", 1100));
        season1.addEpisode(new Episode("Episode 3", 1300));

        Season season2 = new Season();
        season2.addEpisode(new Episode("Episode 1", 1400));
        season2.addEpisode(new Episode("Episode 2", 1250));

        List<Season> series = new ArrayList<>();
        series.add(season1);
        series.add(season2);

        BingeIterator bingeIterator = new BingeIterator(series);

        while (bingeIterator.hasNext()) {
            System.out.println(bingeIterator.next().getTitle());
        }
    }
}
