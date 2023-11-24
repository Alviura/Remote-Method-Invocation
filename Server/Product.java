import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Product extends Remote {
    // Lets defin API
    public String getname() throws RemoteException;
    public  String getDescription() throws RemoteException;
    public double getPrice() throws RemoteException;

}
