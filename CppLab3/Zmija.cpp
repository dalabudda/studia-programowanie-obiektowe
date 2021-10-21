#include "Zmija.h"
#include <iostream>

using namespace std;

char* Zmija::atak(Organizm* organizm)
{
    bool ginieAtakujacy = false;
    bool ginieBroniacy = true;
    Komentarz komentarz(this, organizm);
    komentarz.setZdarzenie("zatruwa");
    if (sila < organizm->getSila())
    {
        ginieAtakujacy = true;
        komentarz.setZdarzenie("przegrywa ale zatruwa");
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

Zmija::Zmija(const int tura, const int X, const int Y, Swiat* S): Zwierze(tura, X, Y, S)
{
    sila = 2;
    inicjatywa = 3;
}

void Zmija::rysowanie()
{
    cout << " z";
}

void Zmija::obrona(Organizm* organizm, bool &ginieAtakujacy, bool &ginieBroniacy, Komentarz &komentarz)
{
    ginieAtakujacy = true;
    if (ginieBroniacy)
    {
        komentarz.setZdarzenie("wygrywa ale zostaje zatruty przez");
    }
    else
    {
        komentarz.setZdarzenie("zostaje zatruty przez");
    }
}
