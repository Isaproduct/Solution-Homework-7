package part2;

import java.util.*;
import java.util.concurrent.*;
public class AirportSimulation {
        public static void main(String[] args) {
                ControlTower tower = new ControlTower();

                List<Aircraft> aircraftList = new ArrayList<>();
                aircraftList.add(new PassengerPlane("A1", 100));
                aircraftList.add(new CargoPlane("C1", 200));
                aircraftList.add(new Helicopter("H1", 50));

                ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
                executorService.scheduleAtFixedRate(() -> {
                        for (Aircraft aircraft : aircraftList) {
                                if (Math.random() > 0.5) {  // Ошибка: самолеты слишком часто отправляют запросы на полосу
                                        aircraft.send("Request Runway", tower);
                                }
                        }
                        tower.manageRunway();
                }, 0, 1, TimeUnit.SECONDS);


                executorService.schedule(() -> {
                        System.out.println("Emergency situation - MAYDAY!");
                        aircraftList.get(0).send("MAYDAY", tower);
                }, 5, TimeUnit.SECONDS);
        }
}
