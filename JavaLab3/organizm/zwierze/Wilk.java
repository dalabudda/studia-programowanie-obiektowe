package organizm.zwierze;

import java.awt.Color;
import javax.swing.*;
import dawid.labudda.jpolabotw.Swiat;


public class Wilk extends Zwierze {
    @Override
    protected Zwierze urodz(int tura, int X, int Y, Swiat S)
    {
        return new Wilk(tura, X, Y, S);
    }
    public Wilk(int tura, int X, int Y, Swiat S)
    {
        super(tura, X, Y, S);
        sila = 9;
        inicjatywa = 5;
    }
    @Override
    public void rysowanie(JPanel tile)
    {
        tile.setBackground(Color.decode("#cccccc"));
    }
    @Override
    public String getNazwa()
    {
        return "Wilk";
    }
}
