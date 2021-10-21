#include "Roslina.h"
#include <stdlib.h>

Roslina::Roslina(const int tura, const int X, const int Y, Swiat* S): Organizm(tura, X, Y, S)
{
    inicjatywa = 0;
}

char* Roslina::akcja(const int tura)
{
    if (rand() % 5 == 1 && swiat->czyWolneMiejsceWOkolicyXY(x, y))
    {
        int X, Y;
        do
        {
            X = rand() % 3 + x - 1;
            Y = rand() % 3 + y - 1;
        }
        while(swiat->czyXYnalezyDoSwiata(X, Y) == false || swiat->getOrganizm(X, Y));
        swiat->setOrganizm(X, Y, zasiej(tura, X, Y, swiat));
    }

    return 0;
}

