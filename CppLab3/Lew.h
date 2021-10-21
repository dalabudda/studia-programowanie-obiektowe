#ifndef LEW_H_INCLUDED
#define LEW_H_INCLUDED

#include "Zwierze.h"

class Lew : public Zwierze
{
private:
    Zwierze* urodz(const int tura, const int X, const int Y, Swiat* S)
    {
        return new Lew(tura, X, Y, S);
    }
public:
    Lew(const int tura, const int X, const int Y, Swiat* S);
    void rysowanie();
    void obrona(Organizm* organizm, bool &ginieAtakujacy, bool &ginieBroniacy, Komentarz &komentarz);
    char* getNazwa()
    {
        return "Lew";
    }
};


#endif // LEW_H_INCLUDED
