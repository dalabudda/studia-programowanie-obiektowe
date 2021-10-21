#include "Owca.h"
#include <iostream>

using namespace std;

Owca::Owca(const int tura, const int X, const int Y, Swiat* S): Zwierze(tura, X, Y, S)
{
    sila = 4;
    inicjatywa = 4;
}

void Owca::rysowanie()
{
    cout << " o";
}
