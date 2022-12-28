package design_pattern.prototype;

/*
* Prototype Design Pattern
*
* Creational Design Pattern : Creation of Object
* Used when you want to avoid multiple Object creation of same instance; instead you copy the object to new object & then we can modify as per our need
*
* Object which we are copying should provide copying feature by implementing the Cloneable Interface
* We can override clone() method to implement as per our need
*
* */

import java.util.ArrayList;
import java.util.List;

class Vehicle implements Cloneable{
    private List<String> vehicleList;

    public Vehicle() {
        this.vehicleList = new ArrayList<>();
    }

    public Vehicle(List<String> vehicleList) {
        this.vehicleList = vehicleList;
    }
    public void insertData() {
        vehicleList.add("Honda Amaze");
        vehicleList.add("Audi A4");
        vehicleList.add("Hyundai Creta");
        vehicleList.add("Maruti Baleno");
        vehicleList.add("Renault Duster");
    }

    public List<String> getVehicleList() {
        return vehicleList;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        List<String> tempList = new ArrayList<>(this.getVehicleList());
        return new Vehicle(tempList);
    }
}

public class PrototypeDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Vehicle a = new Vehicle();
        a.insertData();

        Vehicle b = (Vehicle) a.clone();
        List<String> list = b.getVehicleList();
        list.add("Londa Amaze");
        System.out.println(a.getVehicleList());
        System.out.println(list);
        b.getVehicleList().remove("Audi A4");
        System.out.println(list);
    }
}
