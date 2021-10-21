package organizm.zwierze;

import java.awt.Color;
import javax.swing.*;
import dawid.labudda.jpolabotw.Swiat;
import organizm.*;


public class Zmija extends Zwierze {
    @Override
    protected Zwierze urodz(int tura, int X, int Y, Swiat S)
    {
        return new Zmija(tura, X, Y, S);
    }
    public Zmija(int tura, int X, int Y, Swiat S)
    {
        super(tura, X, Y, S);
        sila = 2;
        inicjatywa = 3;
    }
    @Override
    public void rysowanie(JPanel tile)
    {
        tile.setBackground(Color.decode("#ff44cc"));
    }
    @Override
    public String getNazwa()
    {
        return "Zmija";
    }
    @Override
    public void obrona(Organizm organizm, InfoWalki info)
    {
        info.ginieAtakujacy = true;
        if (info.ginieBroniacy)
        {
            info.komentarz = "wygrywa ale zostaje zatruty przez";
        }
        else
        {
            info.komentarz = "zostaje zatruty przez";
        }
    }
    @Override
    protected String atak(Organizm organizm)
    {
        InfoWalki info = new InfoWalki();
        info.ginieAtakujacy = false;
        info.ginieBroniacy = true;
        info.komentarz = "zatruwa";

        if (sila < organizm.getSila())
        {
            info.ginieAtakujacy = true;
            info.komentarz = "przegrywa ale zatruwa";
        }

        organizm.obrona(this, info);

        String komentarz = getNazwa() + " " + info.komentarz + " " + organizm.getNazwa();

        if (info.ginieBroniacy)
        {
            int X = organizm.getX();
            int Y = organizm.getY();
            swiat.usunOrganizm(X, Y);
            if (!info.ginieAtakujacy)
            {
                przemiesc(X, Y);
            }
        }
        if (info.ginieAtakujacy)
        {
            swiat.usunOrganizm(x, y);
        }

        return komentarz;
    }
}
