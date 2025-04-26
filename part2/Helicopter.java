package part2;

class Helicopter extends Aircraft {
    public Helicopter(String id, int fuelLevel) {
        super(id, fuelLevel); // Передаем id и fuelLevel в конструктор родительского класса
    }

    @Override
    public void receive(String msg) {
        System.out.println("Helicopter " + id + " received: " + msg);
    }
}
