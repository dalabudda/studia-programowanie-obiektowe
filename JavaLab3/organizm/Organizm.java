package organizm;

import java.util.Random;
import javax.swing.*;
import dawid.labudda.jpolabotw.Swiat;
import java.io.*;


public abstract class Organizm {
    private int starszenstwo;
    protected int x, y, sila, inicjatywa;
    protected Swiat swiat;
    public abstract Organizm nowy(int tura, int X, int Y, Swiat S);
    public Organizm(int tura, int X, int Y, Swiat S)
    {
        starszenstwo = tura;
        x = X;
        y = Y;
        swiat = S;
    }
    public abstract String akcja(int tura);
    public abstract String kolizja(int tura, Organizm organizm);
    public abstract void obrona(Organizm organizm, InfoWalki info);
    public abstract void rysowanie(JPanel tile);
    public int getInicjatywa()
    {
        return inicjatywa;
    }
    public int getStarszenstwo()
    {
        return starszenstwo;
    }
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public int getSila()
    {
        return sila;
    }
    public void setSila(int Sila)
    {
        sila = Sila;
    }
    public void setInicjatywa(int Inicjatywa)
    {
        inicjatywa = Inicjatywa;
    }
    public boolean szybszyOd(Organizm organizm)
    {
        return  (inicjatywa > organizm.inicjatywa) ||
            (inicjatywa == organizm.inicjatywa && starszenstwo < organizm.starszenstwo);
    }
    public abstract String getNazwa();
    public void wygenerujNOrganizmow(int N)
    {
        for (int i = 0; i < N; i++)
        {
            Random rand = new Random();
            int x, y;
            do
            {
                x = rand.nextInt(swiat.getN());
                y = rand.nextInt(swiat.getN());
            }
            while (swiat.getOrganizm(x, y) != null);
            swiat.setOrganizm(x, y, nowy(starszenstwo, x, y, swiat));
        }
    }
    public void zapisz(FileWriter writer) throws IOException
    {
        writer.write(getNazwa()+' '+String.valueOf(x)+' '+String.valueOf(y)+' '+String.valueOf(starszenstwo)+' '+String.valueOf(sila)+' '+String.valueOf(inicjatywa)+'\n');
    }
}
