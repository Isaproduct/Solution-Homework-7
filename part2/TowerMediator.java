package part2;

interface TowerMediator {
    void broadcast(String msg, Aircraft sender);
    boolean requestRunway(Aircraft a);
}
