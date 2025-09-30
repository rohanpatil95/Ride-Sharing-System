This Java program puts together a basic ride-sharing setup. It uses some object-oriented ideas to make it work. There's an abstract class called Ride. That one holds details about the driver and the vehicle. It also has an abstract method for figuring out the fare.

Then you get two subclasses from that. One is BikeRide. The other is CarRide. They both calculate the fare based on how far you go. For bikes its ten rupees per kilometer. Cars come in at twenty rupees per kilometer.

The program takes input from the user. You enter the type of ride and the distance. It checks if those inputs make sense. After that it shows all the ride info. That includes the fare too.

It keeps the driver and vehicle stuff encapsulated. Inheritance handles the different ride types. And for bad ride types it throws a custom exception.
