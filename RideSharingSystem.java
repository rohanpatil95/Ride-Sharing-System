import java.util.*;

abstract class Ride {
    private String driverName;
    private String vehicleNumber;
    private double distance;

    public Ride(String driverName, String vehicleNumber, double distance) {
        this.driverName = driverName;
        this.vehicleNumber = vehicleNumber;
        this.distance = distance;
    }

    public String getDriverName() { return driverName; }
    public String getVehicleNumber() { return vehicleNumber; }
    public double getDistance() { return distance; }

    public abstract double calculateFare();
}

class BikeRide extends Ride {
    public BikeRide(String driverName, String vehicleNumber, double distance) {
        super(driverName, vehicleNumber, distance);
    }
    public double calculateFare() {
        return getDistance() * 10;
    }
}

class CarRide extends Ride {
    public CarRide(String driverName, String vehicleNumber, double distance) {
        super(driverName, vehicleNumber, distance);
    }
    public double calculateFare() {
        return getDistance() * 20;
    }
}

class InvalidRideTypeException extends Exception {
    public InvalidRideTypeException(String message) {
        super(message);
    }
}

public class RideSharingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            String type = sc.nextLine().trim().toLowerCase();
            double distance = Double.parseDouble(sc.nextLine().trim());
            if(distance <= 0) throw new IllegalArgumentException("Distance must be greater than 0");

            Ride ride;
            if(type.equals("bike")) {
                ride = new BikeRide("Amit Sharma", "MH12AB1234", distance);
            } else if(type.equals("car")) {
                ride = new CarRide("Sneha Kulkarni", "MH14XY5678", distance);
            } else {
                throw new InvalidRideTypeException("Invalid ride type: " + type);
            }

            System.out.println("Driver: " + ride.getDriverName());
            System.out.println("Vehicle No: " + ride.getVehicleNumber());
            System.out.println("Distance: " + ride.getDistance() + " km");
            System.out.println("Fare: ₹" + ride.calculateFare());

        } catch (InvalidRideTypeException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
