#ifndef KROLIK_H_INCLUDED
#define KROLIK_H_INCLUDED

#include "Zwierze.h"

class Krolik : public Zwierze
{
private:
    Zwierze* urodz(const int tura, const int X, const int Y, Swiat* S)
    {
        return new Krolik(tura, X, Y, S);
    }
public:
    Krolik(const int tura, const int X, const int Y, Swiat* S);
    char* kolizja(const int tura, Organizm* organizm);
    void rysowanie();
    char* getNazwa()
    {
        return "Krolik";
    }
};


#endif // KROLIK_H_INCLUDED
