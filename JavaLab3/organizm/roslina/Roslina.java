package organizm.roslina;

import java.util.Random;
import organizm.*;
import dawid.labudda.jpolabotw.Swiat;


public abstract class Roslina extends Organizm {
    protected abstract Roslina zasiej(int tura, int X, int Y, Swiat S);
    public Roslina(int tura, int X, int Y, Swiat S)
    {
        super(tura, X, Y, S);
        inicjatywa = 0;
    }
    @Override
    public String akcja(int tura)
    {
        Random rand = new Random();
        if (rand.nextInt(5) == 1 && swiat.czyWolneMiejsceWOkolicyXY(x, y))
        {
            int X, Y;
            do
            {
                X = rand.nextInt(3) + x - 1;
                Y = rand.nextInt(3) + y - 1;
            }
            while(swiat.czyXYnalezyDoSwiata(X, Y) == false || swiat.getOrganizm(X, Y) != null);
            swiat.setOrganizm(X, Y, zasiej(tura, X, Y, swiat));
        }

        return null;
    }
    @Override
    public String kolizja(int tura, Organizm organizm)
    {
        return null;
    }
    @Override
    public void obrona(Organizm organizm, InfoWalki info) {}
    @Override
    public abstract String getNazwa();
    @Override
    public Organizm nowy(int tura, int X, int Y, Swiat S)
    {
        return zasiej(tura, X, Y, S);
    }
}
