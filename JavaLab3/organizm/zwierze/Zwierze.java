package organizm.zwierze;

import java.util.Random;
import organizm.*;
import dawid.labudda.jpolabotw.Swiat;


public abstract class Zwierze extends Organizm {
    protected abstract Zwierze urodz(int tura, int X, int Y, Swiat S);
    protected boolean rozmnazaj(int tura)
    {
        if (swiat.czyWolneMiejsceWOkolicyXY(x, y))
        {
            Random rand = new Random();
            int X, Y;
            do
            {
                X = rand.nextInt(3) + x - 1;
                Y = rand.nextInt(3) + y - 1;
            }
            while(swiat.czyXYnalezyDoSwiata(X, Y) == false || swiat.getOrganizm(X, Y) != null);
            swiat.setOrganizm(X, Y, urodz(tura, X, Y, swiat));

            return true;
        }

        return false;
    }
    protected void przemiesc(int X, int Y)
    {
        swiat.setOrganizm(x, y, null);
        x = X;
        y = Y;
        swiat.setOrganizm(x, y, this);
    }
    protected String atak(Organizm organizm)
    {
        InfoWalki info = new InfoWalki();
        info.ginieAtakujacy = false;
        info.ginieBroniacy = false;
        info.komentarz = null;

        if (sila >= organizm.getSila())
        {
            info.ginieBroniacy = true;
            info.komentarz = "wygrywa z";
        }
        else
        {
            info.ginieAtakujacy = true;
            info.komentarz = "przegrywa z";
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
    public Zwierze(int tura, int X, int Y, Swiat S)
    {
        super(tura, X, Y, S);
    }
    @Override
    public String akcja(int tura)
    {
        Random rand = new Random();
        int X, Y;
        do
        {
            X = rand.nextInt(3) + x - 1;
            Y = rand.nextInt(3) + y - 1;
        }
        while(!swiat.czyXYnalezyDoSwiata(X, Y) || (X == x && Y == y));
        if (swiat.getOrganizm(X, Y) != null)
        {
            return kolizja(tura, swiat.getOrganizm(X, Y));
        }
        else
        {
            przemiesc(X, Y);
        }

        return null;
    }
    @Override
    public String kolizja(int tura, Organizm organizm)
    {
        if (getNazwa() == organizm.getNazwa())
        {
            if (rozmnazaj(tura))
            {
                String komentarz = getNazwa() + " rozmnaza sie z " + organizm.getNazwa();
                return komentarz;
            }

            return null;
        }
        else
        {
            return atak(organizm);
        }
    }
    @Override
    public void obrona(Organizm organizm, InfoWalki info) {}
    @Override
    public abstract String getNazwa();
    @Override
    public Organizm nowy(int tura, int X, int Y, Swiat S)
    {
        return urodz(tura, X, Y, S);
    }
}
