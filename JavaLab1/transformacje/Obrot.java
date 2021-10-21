package dawid.labudda.lab3.transformacje;

public class Obrot implements Transformacja{
    private final double angle;
    public Obrot(double angle) {
        this.angle = angle % 360;
    }
    @Override
    public Transformacja getTransformacjaOdwrotna() {
        return new Obrot(360 - angle);
    }
    @Override
    public Punkt transformuj(Punkt p) { 
        return new Punkt(
            p.getX() * Math.cos(Math.toRadians(angle)) - p.getY() * Math.sin(Math.toRadians(angle)),
            p.getX() * Math.sin(Math.toRadians(angle)) + p.getY() * Math.cos(Math.toRadians(angle))
        );
    }
    public double getAngle() {
        return angle;
    }
    @Override
    public String toString() {
        return "Obrot "+angle+" stopni";
    }
}
