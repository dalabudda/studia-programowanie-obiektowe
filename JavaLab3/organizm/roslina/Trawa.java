package organizm.roslina;

import java.awt.Color;
import javax.swing.*;
import dawid.labudda.jpolabotw.Swiat;


public class Trawa extends Roslina {
    @Override
    protected Roslina zasiej(int tura, int X, int Y, Swiat S)
    {
        return new Trawa(tura, X, Y, S);
    }
    public Trawa(int tura, int X, int Y, Swiat S)
    {
        super(tura, X, Y, S);
        sila = 0;
    }
    @Override
    public void rysowanie(JPanel tile)
    {
        tile.setBackground(Color.decode("#009900"));
    }
    @Override
    public String getNazwa()
    {
        return "Trawa";
    }
}
