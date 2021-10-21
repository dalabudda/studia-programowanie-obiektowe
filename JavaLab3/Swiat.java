package dawid.labudda.jpolabotw;

import java.io.*;
import java.util.Scanner;
import java.awt.Color;
import javax.swing.*;
import organizm.Organizm;
import organizm.roslina.*;
import organizm.zwierze.*;


public class Swiat {
    private int n = 20;
    private int tura = 0;
    private Organizm organizmy[][];
    private Organizm kolejnosc[];
    private Organizm wzorce[];
    private int liczba_wzorcow;
    private String wydarzenia[];
    public int getN()
    {
        return n;
    }
    public Swiat(int N)
    {
        n = N;
        organizmy = new Organizm[n][n];
        for (int y = 0; y < n; y++)
        {
            for (int x = 0; x < n; x++)
            {
                organizmy[y][x] = null;
            }
        }
        kolejnosc = new Organizm[n*n];
        kolejnosc[0] = null;
        wydarzenia = new String[n*n];
        wydarzenia[0] = null;
        liczba_wzorcow = 8;
        wzorce = new Organizm[liczba_wzorcow];
        wzorce[0] = new Trawa(tura, -1, -1, this);
        wzorce[1] = new Mlecz(tura, -1, -1, this);
        wzorce[2] = new Guarana(tura, -1, -1, this);
        wzorce[3] = new Wilk(tura, -1, -1, this);
        wzorce[4] = new Owca(tura, -1, -1, this);
        wzorce[5] = new Lew(tura, -1, -1, this);
        wzorce[6] = new Zmija(tura, -1, -1, this);
        wzorce[7] = new Krolik(tura, -1, -1, this);
        wzorce[0].wygenerujNOrganizmow(25);
        wzorce[1].wygenerujNOrganizmow(2);
        wzorce[2].wygenerujNOrganizmow(6);
        wzorce[3].wygenerujNOrganizmow(8);
        wzorce[4].wygenerujNOrganizmow(9);
        wzorce[5].wygenerujNOrganizmow(4);
        wzorce[6].wygenerujNOrganizmow(6);
        wzorce[7].wygenerujNOrganizmow(6);
    } 
    public void wykonajTure()
    {
        int i = 0;
        for (int y = 0; y < n; y++)
        {
            for (int x = 0; x < n; x++)
            {
                if (organizmy[y][x] != null)
                {
                    kolejnosc[i] = organizmy[y][x];
                    i++;
                }
            }
        }
        int liczba_organizmow = i;
        for (int j = liczba_organizmow; j > 1; j--)
        {
            for (i = j-1; i > 0; i--)
            {
                if (kolejnosc[i].szybszyOd(kolejnosc[i-1]))
                {
                    Organizm temp = kolejnosc[i];
                    kolejnosc[i] = kolejnosc[i-1];
                    kolejnosc[i-1] = temp;
                }
            }
        }
        int nr_wydarzenia = 0;
        for (i = 0; i < liczba_organizmow; i++)
        {
            if (kolejnosc[i] != null)
            {
                wydarzenia[nr_wydarzenia] = kolejnosc[i].akcja(tura);
                if (wydarzenia[nr_wydarzenia] != null)
                {
                    nr_wydarzenia++;
                }
            }
        }
        for (i = nr_wydarzenia; i < n*n; i++)
        {
            wydarzenia[i] = null;
        }

        tura++;
    }
    public void rysujSwiat(JPanel tiles[][], JLabel licznik_tur, JLabel zdarzenia[])
    {
        for (int y = 0; y < n; y++)
        {
            for (int x = 0; x < n; x++)
            {
                if (organizmy[y][x] == null)
                {
                    tiles[y][x].setBackground(Color.black);
                }
                else
                {
                    organizmy[y][x].rysowanie(tiles[y][x]);
                }
            }
        }
        
        licznik_tur.setText("Tura: "+tura);
        
        for (int i = 0; i < n-1; i++)
        {
            zdarzenia[i].setText(wydarzenia[i]);
        }
        if (wydarzenia[n-1] != null)
        {
            zdarzenia[n-1].setText(". . .");
        }
        else
        {
            zdarzenia[n-1].setText("");
        }
    }
    public boolean czyXYnalezyDoSwiata(int x, int y)
    {
        return (x >= 0 && x < n && y >= 0 && y < n);
    }
    public boolean czyWolneMiejsceWOkolicyXY(int x, int y)
    {
        for (int Y = y - 1; Y <= y + 1; Y++)
        {
            for (int X = x - 1; X <= x + 1; X++)
            {
                if (czyXYnalezyDoSwiata(X, Y) && organizmy[Y][X] == null)
                {
                    return true;
                }
            }
        }
        return false;
    }
    public Organizm getOrganizm(int x, int y)
    {
        return organizmy[y][x];
    }
    public void setOrganizm(int x, int y, Organizm organizm)
    {
        organizmy[y][x] = organizm;
    }
    public int getTura()
    {
        return tura;
    }
    public void usunOrganizm(int x, int y)
    {
        for (int i = 0; i < n*n; i++)
        {
            if (kolejnosc[i] == organizmy[y][x])
            {
                kolejnosc[i] = null;
                break;
            }
        }
        organizmy[y][x] = null;
    }
    public void zapiszSwiat()
    {
        try 
        {
            FileWriter writer = new FileWriter("swiat.txt");
            writer.write(String.valueOf(tura)+'\n');
            for (int y = 0; y < n; y++)
            {
                for (int x = 0; x < n; x++)
                {
                    if (organizmy[y][x] != null)
                    {
                        organizmy[y][x].zapisz(writer);
                    }
                }
            }
            writer.close();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
    public void wczytajSwiat()
    {
        try
        {
            File file = new File("swiat.txt");
            Scanner reader = new Scanner(file);
            
            for (int i = 0; i < n*n; i++)
            {
                wydarzenia[i] = null;
            }
            for (int y = 0; y < n; y++)
            {
                for (int x = 0; x < n; x++)
                {
                    organizmy[y][x] = null;
                }
            }
            
            tura = reader.nextInt();
            reader.nextLine();
            
            String nazwa;
            int x,y,starszenstwo,sila,inicjatywa;
            while (reader.hasNextLine()) 
            {
                nazwa = reader.next();
                x = reader.nextInt();
                y = reader.nextInt();
                starszenstwo = reader.nextInt();
                sila = reader.nextInt();
                inicjatywa = reader.nextInt();
                for (int i = 0; i < liczba_wzorcow; i++)
                {
                    if (nazwa.equals(wzorce[i].getNazwa()))
                    {
                        organizmy[y][x] = wzorce[i].nowy(starszenstwo, x, y, this);
                        organizmy[y][x].setSila(sila);
                        organizmy[y][x].setInicjatywa(inicjatywa);
                        break;
                    }
                }
                reader.nextLine();
            }
        } 
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        }
    }
    
    public void tablicaNazw(String nazwy[])
    {
        for (int i = 0; i < liczba_wzorcow; i++)
        {
            nazwy[i] = wzorce[i].getNazwa();
        }
    }
    
    public void stworzOrganizm(int x, int y, int index)
    {
        if (organizmy[y][x] == null)
        {
            if (index >= 0 && index <= liczba_wzorcow)
            {
                organizmy[y][x] = wzorce[index].nowy(tura, x, y, this);
            }
        }
    }
}
