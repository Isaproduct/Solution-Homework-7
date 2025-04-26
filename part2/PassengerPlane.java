package part2;
class PassengerPlane extends Aircraft {
    public void fuelCheck() {
        System.out.println("Checking fuel level...");
    }

    @Override
    public void receive(String msg) {
        System.out.println("PassengerPlane " + id + " received: " + msg);
    }
}

