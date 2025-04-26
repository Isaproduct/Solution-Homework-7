package part2;
class CargoPlane extends Aircraft {
    public CargoPlane(String id, int fuelLevel) {
        super(id, fuelLevel); // Передаем id и fuelLevel в конструктор родительского класса
    }

    @Override
    public void receive(String msg) {
        System.out.println("CargoPlane " + id + " received: " + msg);
    }
}
