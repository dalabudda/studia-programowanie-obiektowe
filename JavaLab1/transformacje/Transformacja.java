package dawid.labudda.lab3.transformacje;

public interface Transformacja{
    Punkt transformuj(Punkt p);
    Transformacja getTransformacjaOdwrotna()
        throws BrakTransformacjiOdwrotnejException;
}