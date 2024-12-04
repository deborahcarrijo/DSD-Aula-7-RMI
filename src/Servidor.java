import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

class Servidor extends UnicastRemoteObject implements Conversor {
    protected Servidor() throws RemoteException {
        super();
    }

    @Override
    public double[] converterParaPolares(double x, double y) throws RemoteException {
        double r = Math.sqrt(x * x + y * y);
        double theta = Math.atan2(y, x);
        return new double[] { r, theta };
    }

    public static void main(String[] args) {
        try {
            Servidor servidor = new Servidor();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("Conversor", servidor);
            System.out.println("Servidor RMI pronto!");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}