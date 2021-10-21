package organizm.zwierze;

import java.awt.Color;
import javax.swing.*;
import dawid.labudda.jpolabotw.Swiat;
import organizm.*;


public class Lew extends Zwierze {
    @Override
    protected Zwierze urodz(int tura, int X, int Y, Swiat S)
    {
        return new Lew(tura, X, Y, S);
    }
    public Lew(int tura, int X, int Y, Swiat S)
    {
        super(tura, X, Y, S);
        sila = 11;
        inicjatywa = 7;
    }
    @Override
    public void rysowanie(JPanel tile)
    {
        tile.setBackground(Color.decode("#ffaa00"));
    }
    @Override
    public String getNazwa()
    {
        return "Lew";
    }
    @Override
    public void obrona(Organizm organizm, InfoWalki info)
    {
        if (organizm.getSila() < 5)
        {
            info.ginieAtakujacy = info.ginieBroniacy = false;
            info.komentarz = "zostaje odstraszony przez";
        }
    }
}
