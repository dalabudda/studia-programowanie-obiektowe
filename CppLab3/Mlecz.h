#ifndef MLECZ_H_INCLUDED
#define MLECZ_H_INCLUDED

#include "Roslina.h"

class Mlecz : public Roslina
{
private:
    Roslina* zasiej(const int tura, const int X, const int Y, Swiat* S)
    {
        return new Mlecz(tura, X, Y, S);
    }
public:
    Mlecz(const int tura, const int X, const int Y, Swiat* S);
    char* akcja(const int tura);
    void rysowanie();
    char* getNazwa()
    {
        return "Mlecz";
    }
};


#endif // MLECZ_H_INCLUDED
