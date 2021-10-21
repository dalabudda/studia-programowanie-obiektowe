#include "Lew.h"
#include <iostream>

using namespace std;

Lew::Lew(const int tura, const int X, const int Y, Swiat* S): Zwierze(tura, X, Y, S)
{
    sila = 11;
    inicjatywa = 7;
}

void Lew::rysowanie()
{
    cout << " l";
}

void Lew::obrona(Organizm* organizm, bool &ginieAtakujacy, bool &ginieBroniacy, Komentarz &komentarz)
{
    if (organizm->getSila() < 5)
    {
        ginieAtakujacy = ginieBroniacy = false;
        komentarz.setZdarzenie("zostaje odstraszony przez");
    }
}
