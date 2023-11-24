import java.rmi.server.UnicastRemoteObject;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server{
    public static void main( String[] args) {
        try {

            // Set hostname for the server using JavaProperty
            System.setProperty("java.rmi.server.hostname", "127.0.0.1");


            // Lets  create product object
            Productimpl p1 = new Productimpl("Laptop", "Lenovo laptop", 40000);
            Productimpl p2 = new Productimpl("Mobile", "Samsung", 24000);
            Productimpl p3 = new Productimpl("Car", "Ferari", 2400000);
            Productimpl p4 = new Productimpl("Shoes", "Airforce", 4000);

            // Export p1,p2,p3,p4 object using UnicastRemoteObject class
            Product stub1 = (Product) UnicastRemoteObject.exportObject((Remote) p1,0);
            Product stub2 = (Product) UnicastRemoteObject.exportObject((Remote) p2,0);
            Product stub3 = (Product) UnicastRemoteObject.exportObject((Remote) p3,0);
            Product stub4 = (Product) UnicastRemoteObject.exportObject((Remote) p4,0);

            // Register the exported class in RMI registry with some name
            // Client will use that name to get to the reference of those exported object

            // Get the registry to register the object
            Registry registry = LocateRegistry.getRegistry("127.0.0.1",9100);

            registry.bind("l", stub1);
            registry.bind("m", stub2);
            registry.bind("c", stub3);
            registry.bind("s", stub4);


        } catch(Exception e) {
            System.out.println("Some server error..." + e);
        }
    }
}