package design_pattern.factory;

/*
* Factory Design Pattern
*
* Creational Design Pattern : Creation of Object
* Used when we have multiple Sub classes of Super class and based on input we want to return one class instance
* It provide abstraction between implementation & client classes
* Remove the instantiation of client classes from client code
*
*
* Super class can be Interface or Abstract class or basic class
* Factory class has a static method which return the instance of Sub-class based on input
*
* */

abstract class Vehicle {
    public abstract int getWheel();
    public String toString() {
        return String.format("%s has %d wheel%c",this.getClass().getSimpleName(),this.getWheel(),this.getWheel() > 1 ? 's' : ' ');
    }
}

class Car extends Vehicle {
    private int wheel;

    public Car(int wheel) {
        this.wheel = wheel;
    }

    @Override
    public int getWheel() {
        return this.wheel;
    }
}

class Bike extends Vehicle {
    private int wheel;

    public Bike(int wheel) {
        this.wheel = wheel;
    }

    @Override
    public int getWheel() {
        return this.wheel;
    }
}

class VehicleFactory {
    public static Vehicle getInstance(String type,int wheel) {
        if (type.equals("car")) {
            return new Car(wheel);
        }
        if (type.equals("bike")) {
            return new Bike(wheel);
        }
        return null;
    }
}
public class FactoryDemo {
    public static void main(String[] args) {
        Vehicle car = VehicleFactory.getInstance("car",4);
        System.out.println(car);

        Vehicle bike = VehicleFactory.getInstance("bike",2);
        System.out.println(bike);

        Vehicle single = VehicleFactory.getInstance("bike",1);
        System.out.println(single);
    }
}
