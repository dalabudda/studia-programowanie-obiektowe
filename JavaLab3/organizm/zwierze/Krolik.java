package organizm.zwierze;

import java.awt.Color;
import javax.swing.*;
import dawid.labudda.jpolabotw.Swiat;
import organizm.Organizm;


public class Krolik extends Zwierze {
    @Override
    protected Zwierze urodz(int tura, int X, int Y, Swiat S)
    {
        return new Krolik(tura, X, Y, S);
    }
    public Krolik(int tura, int X, int Y, Swiat S)
    {
        super(tura, X, Y, S);
        sila = 1;
        inicjatywa = 4;
    }
    @Override
    public void rysowanie(JPanel tile)
    {
        tile.setBackground(Color.decode("#994422"));
    }
    @Override
    public String getNazwa()
    {
        return "Krolik";
    }
    @Override
    public String kolizja(int tura, Organizm organizm)
    {
        if (getNazwa() == organizm.getNazwa())
        {
            int mlode = 0;
            if (rozmnazaj(tura)) mlode++;
            if (rozmnazaj(tura)) mlode++;
            if (mlode == 1)
            {
                String komentarz = getNazwa() + " rozmnaza sie z " + organizm.getNazwa();
                return komentarz;
            }
            else if (mlode == 2)
            {
                String komentarz = getNazwa() + " ma 2 mlode z " + organizm.getNazwa();
                return komentarz;
            }

            return null;
        }
        else
        {
            return atak(organizm);
        }
    }
}
