import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class RmiClient {
    public static final String UNIQUE_NAME = "calc.server"; //remote object name
    public static void main(String[] args) throws RemoteException, NotBoundException {
        final Registry registry = LocateRegistry.getRegistry(4041);
        Calculator calculator = (Calculator) registry.lookup(UNIQUE_NAME);

        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();


        Solution solution = calculator.solve(a,b,c);
        if (solution == null)
            System.out.println("D<0: no roots"); // 2 6 9
        else {
            if (solution.f == 1)
                System.out.println("D>0: x1=" + solution.x1 + "\nx2=" + solution.x2); //2 4 1 //4 7 2
            else
                System.out.println("D=0: x="+solution.x1); //1 2 1
        }

    }
}
