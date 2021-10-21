#include "Krolik.h"
#include <iostream>

using namespace std;

Krolik::Krolik(const int tura, const int X, const int Y, Swiat* S): Zwierze(tura, X, Y, S)
{
    sila = 1;
    inicjatywa = 4;
}

char* Krolik::kolizja(const int tura, Organizm* organizm)
{
    if (czyTenSamGatunek(organizm))
    {
        int mlode = 0;
        mlode += rozmnazaj(tura) + rozmnazaj(tura);
        if (mlode == 1)
        {
            Komentarz komentarz(this, organizm);
            komentarz.setZdarzenie("rozmnaza sie z");
            return komentarz.getChar();
        }
        else if (mlode == 2)
        {
            Komentarz komentarz(this, organizm);
            komentarz.setZdarzenie("ma 2 mlode z");
            return komentarz.getChar();
        }

        return 0;
    }
    else
    {
        return atak(organizm);
    }
}

void Krolik::rysowanie()
{
    cout << " k";
}
