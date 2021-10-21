#include "Trawa.h"
#include <iostream>

using namespace std;

Trawa::Trawa(const int tura, const int X, const int Y, Swiat* S): Roslina(tura, X, Y, S)
{
    sila = 0;
}

void Trawa::rysowanie()
{
    cout << " ,";
}
