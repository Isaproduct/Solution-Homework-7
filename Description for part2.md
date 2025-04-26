
TowerMediator Interface:

The TowerMediator interface defines the communication contract between the aircraft and the control tower. It includes two primary methods:

broadcast(String msg, Aircraft sender): This method allows aircraft to send messages to the tower and other aircraft.

requestRunway(Aircraft a): This method enables aircraft to request access to the runway, and it returns true when access is granted.

Aircraft Abstract Class:

The Aircraft class serves as the base class for different types of aircraft. Each aircraft has an id and the ability to send and receive messages.

receive(String msg): This method is overridden by subclasses (like PassengerPlane, CargoPlane, and Helicopter) to define how each type of aircraft reacts to messages from the tower.

send(String msg, TowerMediator m): This method allows an aircraft to send a message to the control tower.

Concrete Aircraft Classes:

PassengerPlane, CargoPlane, and Helicopter: These classes extend the Aircraft class and implement the receive method. Each subclass reacts to messages in its own way, simulating different aircraft behaviors.

ControlTower (Concrete Mediator):

The ControlTower class implements the TowerMediator interface. It manages the flow of communication between aircraft and the runway.

Runway Queues: The control tower uses two queues:

Landing Queue: Aircraft waiting to land.

Takeoff Queue: Aircraft waiting to take off.

broadcast(): This method handles communication between the tower and the aircraft. It can also handle emergencies, such as when an aircraft sends a "MAYDAY" message.

requestRunway(): Aircraft request runway access here. Emergency aircraft (such as those sending "MAYDAY") are prioritized and granted immediate landing access.

Emergency Handling: When an emergency occurs (e.g., low fuel or "MAYDAY"), the tower clears the runway and prioritizes the emergency aircraft.

manageRunway(): This method processes aircraft waiting to land or take off, and it handles the runway requests according to the queues.

AirportSimulation (Simulation Driver):

The AirportSimulation class simulates the entire system, including the creation of different aircraft (such as passenger planes, cargo planes, and helicopters).

It uses the ScheduledExecutorService to simulate the passage of time, sending runway requests every second.

After a specified delay, an emergency situation is simulated (e.g., an aircraft sends "MAYDAY").

Key Features of the Implementation:
Mediator Pattern: The central ControlTower acts as a mediator that controls the communication between multiple aircraft, ensuring that they do not directly interact with each other. Instead, they communicate only with the tower.

Emergency Protocol: The mediator (control tower) handles emergencies by clearing the runway and prioritizing emergency aircraft, ensuring that critical situations are handled efficiently.

Simulation: The simulation spawns multiple aircraft with random fuel levels and uses a scheduled executor to simulate real-time communication between the aircraft and the control tower.

Why Mediator is Used Over Direct Aircraft Communication:
Decoupling: By using the mediator, the aircraft are decoupled from each other. Instead of each aircraft needing to know about the others, they only need to communicate with the control tower. This reduces complexity and ensures that each aircraft is independent and unaware of other aircraft's internal states.

Centralized Control: The mediator allows for centralized control of the entire system, making it easier to manage complex coordination, such as emergency protocols, runway scheduling, and queue management.

Flexibility: If the communication logic or handling of emergency situations changes, these modifications can be made in the mediator without affecting the aircraft classes, ensuring maintainability and scalability.

Stretch Goal (For Honors Credit):
Strategy Pattern: As an additional enhancement, the runway allocation logic could be refactored into a RunwayScheduler strategy, allowing the control tower to swap between different scheduling strategies (e.g., prioritizing by fuel level, VIP aircraft, etc.) at runtime.
