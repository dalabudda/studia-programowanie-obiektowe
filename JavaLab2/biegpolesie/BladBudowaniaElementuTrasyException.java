package pl.edu.pg.eti.ksg.po.lab2.biegpolesie;

public class BladBudowaniaElementuTrasyException extends Exception
{
    public BladBudowaniaElementuTrasyException()
    {
    //Niejawne wywołanie konstruktora klasy nadrzędnej
    //super();
    }
    public BladBudowaniaElementuTrasyException(String message) {
        super(message);
    }
    public BladBudowaniaElementuTrasyException(Throwable cause) {
        super(cause);
    }
    public BladBudowaniaElementuTrasyException(String message, Throwable cause) {
        super(message, cause);
    }
}

