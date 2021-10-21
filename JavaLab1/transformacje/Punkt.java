package dawid.labudda.lab3.transformacje;

public class Punkt {
    private final double x,y;
    public Punkt(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Punkt)
        {
            Punkt other = (Punkt)obj;
            return x == other.x && y == other.y;
        }
        return false;
    }
    @Override
    public int hashCode() {
        return 17 * Double.hashCode(x) + 13 * Double.hashCode(y) + 7;
    }
    @Override
    public String toString() {
        return "("+x+","+y+")";
    }
    public static final Punkt O = new Punkt(0, 0);
    public static final Punkt E_X = new Punkt(1, 0);
    public static final Punkt E_Y = new Punkt(0, 1);
}
