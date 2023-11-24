import java.rmi.RemoteException;


public class Productimpl{
    // Attributes of product

    public String name;
    public String description;
    public double price;

    // Methods defined for the product
    public Productimpl (String newName, String newDescription, double newPrice) throws RemoteException{
        this.name = newName;
        this.description = newDescription;
        this.price = newPrice;
    }

    public String getName() throws RemoteException {
        return this.name;
    }
    public String getDescription() throws RemoteException {
        return this.description;

    }
    public double getPrice() throws RemoteException {
        return this.price;
    }
}
