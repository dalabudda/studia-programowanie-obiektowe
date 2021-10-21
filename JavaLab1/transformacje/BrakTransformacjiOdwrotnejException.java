package dawid.labudda.lab3.transformacje;

public class BrakTransformacjiOdwrotnejException extends Exception
{
    public BrakTransformacjiOdwrotnejException()
    {
    //Niejawne wywołanie konstruktora klasy nadrzędnej
    //super();
    }
    public BrakTransformacjiOdwrotnejException(String message) {
        super(message);
    }
    public BrakTransformacjiOdwrotnejException(Throwable cause) {
        super(cause);
    }
    public BrakTransformacjiOdwrotnejException(String message, Throwable cause) {
        super(message, cause);
    }
}

