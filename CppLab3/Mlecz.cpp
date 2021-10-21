#include "Mlecz.h"
#include <iostream>

using namespace std;

Mlecz::Mlecz(const int tura, const int X, const int Y, Swiat* S): Roslina(tura, X, Y, S)
{
    sila = 0;
}

char* Mlecz::akcja(const int tura)
{
    for (int i = 0; i < 3; i++)
    {
        Roslina::akcja(tura);
    }

    return 0;
}

void Mlecz::rysowanie()
{
    cout << " ;";
}
