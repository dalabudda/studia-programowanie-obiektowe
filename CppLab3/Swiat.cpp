#include "Swiat.h"
#include "Organizm.h"
#include "Trawa.h"
#include "Mlecz.h"
#include "Guarana.h"
#include "Owca.h"
#include "Wilk.h"
#include "Lew.h"
#include "Zmija.h"
#include "Krolik.h"
#include "Wyjatek.h"
#include <iostream>
#include <stdlib.h>
#include <string>

using namespace std;

void Swiat::znajdzWolneXY(int &x, int &y)
{
    do
    {
        x = rand() % N;
        y = rand() % N;
    }
    while (organizmy[y][x]);
}

template <class T>
void Swiat::wygenerujNOrganizmow(const int n)
{
    for (int i = 0; i < n; i++)
    {
        int x, y;
        znajdzWolneXY(x, y);
        organizmy[y][x] = new T(tura, x, y, this);
    }
}

void Swiat::rysujRamkePoziomo()
{
    cout << "+";
    for (int x = 0; x < N; x++)
    {
        cout << "--";
    }
    cout << "+" << endl;
}

Swiat::Swiat()
{
    for (int y = 0; y < N; y++)
    {
        for (int x = 0; x < N; x++)
        {
            organizmy[y][x] = 0;
        }
    }
    kolejnosc[0] = 0;
    wydarzenia[0] = 0;
    wygenerujNOrganizmow<Trawa>(25);
    wygenerujNOrganizmow<Guarana>(6);
    wygenerujNOrganizmow<Mlecz>(2);
    wygenerujNOrganizmow<Owca>(9);
    wygenerujNOrganizmow<Wilk>(8);
    wygenerujNOrganizmow<Lew>(4);
    wygenerujNOrganizmow<Zmija>(6);
    wygenerujNOrganizmow<Krolik>(6);
}

Swiat::~Swiat()
{
    for (int y = 0; y < N; y++)
    {
        for (int x = 0; x < N; x++)
        {
            if (organizmy[y][x])
            {
                delete organizmy[y][x];
            }
        }
    }
}

void Swiat::wykonajTure()
{
    int i = 0;
    for (int y = 0; y < N; y++)
    {
        for (int x = 0; x < N; x++)
        {
            if (organizmy[y][x])
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
            if (kolejnosc[i]->szybszyOd(kolejnosc[i-1]))
            {
                Organizm *temp = kolejnosc[i];
                kolejnosc[i] = kolejnosc[i-1];
                kolejnosc[i-1] = temp;
            }
        }
    }
    int nr_wydarzenia = 0;
    for (i = 0; i < liczba_organizmow; i++)
    {
        if (kolejnosc[i])
        {
            wydarzenia[nr_wydarzenia] = kolejnosc[i]->akcja(tura);
            if (wydarzenia[nr_wydarzenia])
            {
                nr_wydarzenia++;
            }
        }
    }
    wydarzenia[nr_wydarzenia] = 0; //koniec wydarzen

    tura++;
}

void Swiat::rysujSwiat()
{
    int i = 0;
    while (wydarzenia[i])
    {
        cout << wydarzenia[i] << endl;
        i++;
    }
    rysujRamkePoziomo();
    for (int y = 0; y < N; y++)
    {
        cout << "|";
        for (int x = 0; x < N; x++)
        {
            if (organizmy[y][x])
            {
                organizmy[y][x]->rysowanie();
            }
            else
            {
                cout << "  ";
            }
        }
        cout << "|" << endl;
    }
    rysujRamkePoziomo();
}

bool Swiat::czyXYnalezyDoSwiata(const int x, const int y)
{
    return (x >= 0 && x < N && y >= 0 && y < N);
}

bool Swiat::czyWolneMiejsceWOkolicyXY(const int x, const int y)
{
    for (int Y = y - 1; Y <= y + 1; Y++)
    {
        for (int X = x - 1; X <= x + 1; X++)
        {
            if (czyXYnalezyDoSwiata(X, Y) && organizmy[Y][X] == 0)
            {
                return true;
            }
        }
    }
    return false;
}

Organizm* Swiat::getOrganizm(const int x, const int y)
{
    return organizmy[y][x];
}

void Swiat::setOrganizm(const int x, const int y, Organizm* organizm)
{
    organizmy[y][x] = organizm;
}

void Swiat::usunOrganizm(const int x, const int y)
{
    for (int i = 0; i < N*N; i++)
    {
        if (kolejnosc[i] == organizmy[y][x])
        {
            kolejnosc[i] = 0;
            break;
        }
    }
    delete organizmy[y][x];
    organizmy[y][x] = 0;
}

void Swiat::zapiszSwiat()
{
    ofstream plik;
    plik.open("swiat.txt");
    if (!plik)
    {
        throw Wyjatek("Blad otwierania pliku.");
    }

    plik << tura << '\n';

    for (int y = 0; y < N; y++)
    {
        for (int x = 0; x < N; x++)
        {
            if (organizmy[y][x])
            {
                organizmy[y][x]->zapisz(plik);
            }
        }
    }

    plik.close();
}

void Swiat::wczytajSwiat()
{
    ifstream plik;
    plik.open("swiat.txt");
    if (!plik)
    {
        throw Wyjatek("Blad otwierania pliku.");
    }

    wydarzenia[0] = 0;

    for (int y = 0; y < N; y++)
    {
        for (int x = 0; x < N; x++)
        {
            if (organizmy[y][x])
            {
                delete organizmy[y][x];
                organizmy[y][x] = 0;
            }
        }
    }

    plik >> tura;

    string nazwa;
    int x,y,starszenstwo,sila,inicjatywa;
    while (plik >> nazwa)
    {
        plik >> x >> y >> starszenstwo >> sila >> inicjatywa;
        if (nazwa == "Wilk")
        {
            organizmy[y][x] = new Wilk(tura, x, y, this);
        }
        else if (nazwa == "Owca")
        {
            organizmy[y][x] = new Owca(tura, x, y, this);
        }
        else if (nazwa == "Lew")
        {
            organizmy[y][x] = new Lew(tura, x, y, this);
        }
        else if (nazwa == "Zmija")
        {
            organizmy[y][x] = new Zmija(tura, x, y, this);
        }
        else if (nazwa == "Krolik")
        {
            organizmy[y][x] = new Krolik(tura, x, y, this);
        }
        else if (nazwa == "Trawa")
        {
            organizmy[y][x] = new Trawa(tura, x, y, this);
        }
        else if (nazwa == "Guarana")
        {
            organizmy[y][x] = new Guarana(tura, x, y, this);
        }
        else if (nazwa == "Mlecz")
        {
            organizmy[y][x] = new Mlecz(tura, x, y, this);
        }
        else
        {
            cout << "Niezidentyfikowany organizm" << endl;
        }
    }

    plik.close();
}
