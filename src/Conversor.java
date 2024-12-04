import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Conversor extends Remote {
    double[] converterParaPolares(double x, double y) throws RemoteException;
}