import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


public class RmiServer {
    public static final String UNIQUE_NAME = "calc.server"; //remote object name

    public static void main(String[] args) throws RemoteException, AlreadyBoundException, InterruptedException {
        final CalculatorServer server = new CalculatorServer();
        final Registry registry = LocateRegistry.createRegistry(4041); //port

        Remote stub = UnicastRemoteObject.exportObject(server, 0); //stub
        registry.bind(UNIQUE_NAME, stub); //registration of the stub under remote object name


        Thread.sleep(Integer.MAX_VALUE);

    }
}
