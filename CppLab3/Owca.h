#ifndef OWCA_H_INCLUDED
#define OWCA_H_INCLUDED

#include "Zwierze.h"

class Owca : public Zwierze
{
private:
    Zwierze* urodz(const int tura, const int X, const int Y, Swiat* S)
    {
        return new Owca(tura, X, Y, S);
    }
public:
    Owca(const int tura, const int X, const int Y, Swiat* S);
    void rysowanie();
    char* getNazwa()
    {
        return "Owca";
    }
};


#endif // OWCA_H_INCLUDED
