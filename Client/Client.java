package Client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main (String[] args){
        try {
            // Locate registry
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);

            // Get the reference of exported object from RMI Registry
            Product Laptop = (Product) registry.lookup("l");
            Product Mobile = (Product) registry.lookup("m");
            Product Car = (Product) registry.lookup("c");
            Product Shoes = (Product) registry.lookup("s");

            // we can now invoke the method of the referenced objects
            System.out.println("The name of the laptop is " + Laptop.getname());
            System.out.println("The  description is " + Laptop.getDescription());
            System.out.println("The price is " + Laptop.getPrice());

            System.out.println(Mobile.getname());
            System.out.println(Car.getname());
            System.out.println(Shoes.getname());





        } catch(Exception e) {
            System.out.println("Client side error..." + e);

        }
    }
}
