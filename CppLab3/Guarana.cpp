#include "Guarana.h"
#include <iostream>

using namespace std;

Guarana::Guarana(const int tura, const int X, const int Y, Swiat* S): Roslina(tura, X, Y, S)
{
    sila = 0;
}

void Guarana::rysowanie()
{
    cout << " :";
}

void Guarana::obrona(Organizm* organizm, bool &ginieAtakujacy, bool &ginieBroniacy, Komentarz &komentarz)
{
    organizm->setSila(organizm->getSila() + 3);
    komentarz.setZdarzenie("zyskuje +3 do sily bo zjada");
}
