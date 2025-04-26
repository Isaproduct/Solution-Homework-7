package part2;
interface RunwayScheduler {
    int compare(Aircraft a, Aircraft b);
}

class FuelPriorityScheduler implements RunwayScheduler {
    @Override
    public int compare(Aircraft a, Aircraft b) {
        return Integer.compare(a.getFuelLevel(), b.getFuelLevel());
    }
}
