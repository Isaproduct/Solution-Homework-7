package part2;
abstract class Aircraft {
    protected String id;
    protected int fuelLevel;

    public Aircraft(String id, int fuelLevel) {
        this.id = id;
        this.fuelLevel = fuelLevel;
    }

    public int getFuelLevel() {
        return fuelLevel;
    }

    public abstract void receive(String msg);

    public void send(String msg, TowerMediator m) {
        m.broadcast(msg, this);
    }
}
