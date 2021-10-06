import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculator extends Remote {
    Solution solve(int a, int b, int c) throws RemoteException;
}
