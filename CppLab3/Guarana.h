#ifndef GUARANA_H_INCLUDED
#define GUARANA_H_INCLUDED

#include "Roslina.h"

class Guarana : public Roslina
{
private:
    Roslina* zasiej(const int tura, const int X, const int Y, Swiat* S)
    {
        return new Guarana(tura, X, Y, S);
    }
public:
    Guarana(const int tura, const int X, const int Y, Swiat* S);
    void rysowanie();
    void obrona(Organizm* organizm, bool &ginieAtakujacy, bool &ginieBroniacy, Komentarz &komentarz);
    char* getNazwa()
    {
        return "Guarana";
    }
};


#endif // GUARANA_H_INCLUDED
