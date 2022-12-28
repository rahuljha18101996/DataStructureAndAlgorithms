package design_pattern.builder;


/*
* Builder Design Pattern
*
* Creational Design Pattern : Creation of Object
* Used when we have too many arguments to send in Constructor & it's hard to maintain the order
* When we don't want to send all parameter in Object initialization (Generally we send optional parameter as null)
*
*
* We create a static nested class which contain all the argument of outer class
* As per naming convention, if class name is Vehicle, builder class name should be VehicleBuilder
* Builder class should have a public constructor with all the required parameters.
* Builder class should have method methods for Optional parameters. Methods will return the builder object
* A 'build()' function that will return the final Object.
*
*
* The main class 'Vehicle' has private constructor so to create instance only via Builder class.
* The main class 'Vehicle' has only getters.
*
* */

class Vehicle {
    //Required Parameter
    private String engine;
    private int wheel;
    //Optional Parameter
    private int airbag;

    public String getEngine() {
        return engine;
    }

    public int getWheel() {
        return wheel;
    }

    public int getAirbag() {
        return airbag;
    }

    private Vehicle(VehicleBuilder builder) {
        this.engine = builder.engine;
        this.wheel = builder.wheel;
        this.airbag = builder.airbag;
    }

    public  static class VehicleBuilder {
        private String engine;
        private int wheel;

        private int airbag;

        public VehicleBuilder(String engine, int wheel) {
            this.engine = engine;
            this.wheel = wheel;
        }

        public VehicleBuilder setAirbag(int airbag) {
            this.airbag = airbag;
            return this;
        }

        public Vehicle build() {
            return new Vehicle(this);
        }
    }
    @Override
    public String toString() {
        return String.format("Vehicle has engine '%s' with %d wheels %d airbags",engine,wheel,airbag);
    }
}
public class BuilderDemo {
    public static void main(String[] args) {
        Vehicle car = new Vehicle.VehicleBuilder("1500cc",4).setAirbag(4).build();
        Vehicle bike = new Vehicle.VehicleBuilder("250cc",2).build();

        System.out.println(car);
        System.out.println(bike);
    }
}
