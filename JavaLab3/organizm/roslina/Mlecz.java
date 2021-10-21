package organizm.roslina;

import java.awt.Color;
import javax.swing.*;
import dawid.labudda.jpolabotw.Swiat;


public class Mlecz extends Roslina {
    @Override
    protected Roslina zasiej(int tura, int X, int Y, Swiat S)
    {
        return new Mlecz(tura, X, Y, S);
    }
    public Mlecz(int tura, int X, int Y, Swiat S)
    {
        super(tura, X, Y, S);
        sila = 0;
    }
    @Override
    public void rysowanie(JPanel tile)
    {
        tile.setBackground(Color.decode("#00ee00"));
    }
    @Override
    public String getNazwa()
    {
        return "Mlecz";
    }
    @Override
    public String akcja(int tura)
    {
        for (int i = 0; i < 3; i++)
        {
            super.akcja(tura);
        }

        return null;
    }
}
