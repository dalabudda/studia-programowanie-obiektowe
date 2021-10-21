package organizm.roslina;

import java.awt.Color;
import javax.swing.*;
import dawid.labudda.jpolabotw.Swiat;
import organizm.*;


public class Guarana extends Roslina {
    @Override
    protected Roslina zasiej(int tura, int X, int Y, Swiat S)
    {
        return new Guarana(tura, X, Y, S);
    }
    public Guarana(int tura, int X, int Y, Swiat S)
    {
        super(tura, X, Y, S);
        sila = 0;
    }
    @Override
    public void rysowanie(JPanel tile)
    {
        tile.setBackground(Color.decode("#cc1100"));
    }
    @Override
    public String getNazwa()
    {
        return "Guarana";
    }
    @Override
    public void obrona(Organizm organizm, InfoWalki info)
    {
        organizm.setSila(organizm.getSila() + 3);
        info.komentarz = "zyskuje +3 do sily bo zjada";
    }
}
