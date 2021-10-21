#ifndef ZWIERZE_H_INCLUDED
#define ZWIERZE_H_INCLUDED

#include "Organizm.h"

class Zwierze : public Organizm
{
protected:
    virtual Zwierze* urodz(const int tura, const int X, const int Y, Swiat* S) = 0;
    bool rozmnazaj(const int tura);
    void przemiesc(const int X, const int Y);
    virtual char* atak(Organizm* organizm);
public:
    Zwierze(const int tura, const int X, const int Y, Swiat* S);
    char* akcja(const int tura);
    virtual char* kolizja(const int tura, Organizm* organizm);
    virtual void obrona(Organizm* organizm, bool &ginieAtakujacy, bool &ginieBroniacy, Komentarz &komentarz) {};
    virtual char* getNazwa() = 0;
};


#endif // ZWIERZE_H_INCLUDED
