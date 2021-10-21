#include "Zwierze.h"
#include "Komentarz.h"
#include <stdlib.h>

bool Zwierze::rozmnazaj(const int tura)
{
    if (swiat->czyWolneMiejsceWOkolicyXY(x, y))
    {
        int X, Y;
        do
        {
            X = rand() % 3 + x - 1;
            Y = rand() % 3 + y - 1;
        }
        while(swiat->czyXYnalezyDoSwiata(X, Y) == false || swiat->getOrganizm(X, Y));
        swiat->setOrganizm(X, Y, urodz(tura, X, Y, swiat));

        return true;
    }

    return false;
}

char* Zwierze::atak(Organizm* organizm)
{
    bool ginieAtakujacy = false;
    bool ginieBroniacy = false;
    Komentarz komentarz(this, organizm);

    if (sila >= organizm->getSila())
    {
        ginieBroniacy = true;
        komentarz.setZdarzenie("wygrywa z");
    }
    else
    {
        ginieAtakujacy = true;
        komentarz.setZdarzenie("przegrywa z");
    }

    organizm->obrona(this, ginieAtakujacy, ginieBroniacy, komentarz);

    char *komentarzChar = komentarz.getChar();

    if (ginieBroniacy)
    {
        int X = organizm->getX();
        int Y = organizm->getY();
        swiat->usunOrganizm(X, Y);
        if (!ginieAtakujacy)
        {
            przemiesc(X, Y);
        }
    }
    if (ginieAtakujacy)
    {
        swiat->usunOrganizm(x, y);
    }

    return komentarzChar;
}

char* Zwierze::kolizja(const int tura, Organizm* organizm)
{
    if (czyTenSamGatunek(organizm))
    {
        if (rozmnazaj(tura))
        {
            Komentarz komentarz(this, organizm);
            komentarz.setZdarzenie("rozmnaza sie z");
            return komentarz.getChar();
        }

        return 0;
    }
    else
    {
        return atak(organizm);
    }
}

void Zwierze::przemiesc(const int X, const int Y)
{
    swiat->setOrganizm(x, y, 0);
    x = X;
    y = Y;
    swiat->setOrganizm(x, y, this);
}

Zwierze::Zwierze(const int tura, const int X, const int Y, Swiat* S): Organizm(tura, X, Y, S)
{

}

char* Zwierze::akcja(const int tura)
{
    int X, Y;
    do
    {
        X = rand() % 3 + x - 1;
        Y = rand() % 3 + y - 1;
    }
    while(!swiat->czyXYnalezyDoSwiata(X, Y) || (X == x && Y == y));
    if (swiat->getOrganizm(X, Y))
    {
        return kolizja(tura, swiat->getOrganizm(X, Y));
    }
    else
    {
        przemiesc(X, Y);
    }

    return 0;
}

