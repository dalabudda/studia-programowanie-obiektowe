#ifndef TRAWA_H_INCLUDED
#define TRAWA_H_INCLUDED

#include "Roslina.h"

class Trawa : public Roslina
{
private:
    Roslina* zasiej(const int tura, const int X, const int Y, Swiat* S)
    {
        return new Trawa(tura, X, Y, S);
    }
public:
    Trawa(const int tura, const int X, const int Y, Swiat* S);
    void rysowanie();
    char* getNazwa()
    {
        return "Trawa";
    }
};


#endif // TRAWA_H_INCLUDED
