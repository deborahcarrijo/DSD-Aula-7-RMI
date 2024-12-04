import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            Conversor conversor = (Conversor) registry.lookup("Conversor");

            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite a coordenada x: ");
            double x = scanner.nextDouble();
            System.out.print("Digite a coordenada y: ");
            double y = scanner.nextDouble();

            double[] resultado = conversor.converterParaPolares(x, y);

            System.out.println("Coordenadas Polares:");
            System.out.println("r = " + resultado[0]);
            System.out.println("θ = " + resultado[1] + " radianos");
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
