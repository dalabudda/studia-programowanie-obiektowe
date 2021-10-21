#ifndef ROSLINA_H_INCLUDED
#define ROSLINA_H_INCLUDED

#include "Organizm.h"

class Roslina : public Organizm
{
protected:
    virtual Roslina* zasiej(const int tura, const int X, const int Y, Swiat* S) = 0;
public:
    Roslina(const int tura, const int X, const int Y, Swiat* S);
    virtual char* akcja(const int tura);
    char* kolizja(const int tura, Organizm* organizm) {return 0;}
    virtual void obrona(Organizm* organizm, bool &ginieAtakujacy, bool &ginieBroniacy, Komentarz &komentarz) {}
    virtual char* getNazwa() = 0;
};


#endif // ROSLINA_H_INCLUDED
