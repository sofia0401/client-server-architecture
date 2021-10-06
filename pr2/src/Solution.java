import java.io.Serializable;

public class Solution implements Serializable {

    public double x1, x2;
    public int f;
    public Solution(double x1, int f) {
        this.x1=x1;
        this.f=f;
    }
    public Solution(double x1, double x2, int f) {
        this.x1=x1;
        this.x2=x2;
        this.f=f;
    }
}
