import java.rmi.RemoteException;

public class CalculatorServer implements Calculator{

    @Override
    public Solution solve(int a, int b, int c) throws RemoteException {
        Solution solution;

        double d = Math.pow(b,2) - 4*a*c;

        if (d>0.0) {
            double x1 = (b * (-1) - Math.sqrt(d)) / (2 * a);
            double x2 = (b * (-1) + Math.sqrt(d)) / (2 * a);

            solution = new Solution(x1,x2,1);
            return solution;
        }
        else {
            if (d==0.0) {
                double x1 = b * (-1)  / (2 * a);

                solution = new Solution(x1,0);
                return solution;
            }
            else
                return null;
        }
    }
}
