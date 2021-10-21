#ifndef WILK_H_INCLUDED
#define WILK_H_INCLUDED

#include "Zwierze.h"

class Wilk : public Zwierze
{
private:
    Zwierze* urodz(const int tura, const int X, const int Y, Swiat* S)
    {
        return new Wilk(tura, X, Y, S);
    }
public:
    Wilk(const int tura, const int X, const int Y, Swiat* S);
    void rysowanie();
    char* getNazwa()
    {
        return "Wilk";
    }
};


#endif // WILK_H_INCLUDED
