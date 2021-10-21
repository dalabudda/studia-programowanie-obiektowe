#ifndef ZMIJA_H_INCLUDED
#define ZMIJA_H_INCLUDED

#include "Zwierze.h"

class Zmija : public Zwierze
{
private:
    Zwierze* urodz(const int tura, const int X, const int Y, Swiat* S)
    {
        return new Zmija(tura, X, Y, S);
    }
    char* atak(Organizm* organizm);
public:
    Zmija(const int tura, const int X, const int Y, Swiat* S);
    void rysowanie();
    void obrona(Organizm* organizm, bool &ginieAtakujacy, bool &ginieBroniacy, Komentarz &komentarz);
    char* getNazwa()
    {
        return "Zmija";
    }
};


#endif // ZMIJA_H_INCLUDED
