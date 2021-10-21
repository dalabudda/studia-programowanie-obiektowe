package organizm.zwierze;

import java.awt.Color;
import javax.swing.*;
import dawid.labudda.jpolabotw.Swiat;


public class Owca extends Zwierze {
    @Override
    protected Zwierze urodz(int tura, int X, int Y, Swiat S)
    {
        return new Owca(tura, X, Y, S);
    }
    public Owca(int tura, int X, int Y, Swiat S)
    {
        super(tura, X, Y, S);
        sila = 4;
        inicjatywa = 4;
    }
    @Override
    public void rysowanie(JPanel tile)
    {
        tile.setBackground(Color.decode("#ffffff"));
    }
    @Override
    public String getNazwa()
    {
        return "Owca";
    }
}
