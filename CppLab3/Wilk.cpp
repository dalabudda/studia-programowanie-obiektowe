#include "Wilk.h"
#include <iostream>

using namespace std;

Wilk::Wilk(const int tura, const int X, const int Y, Swiat* S): Zwierze(tura, X, Y, S)
{
    sila = 9;
    inicjatywa = 5;
}

void Wilk::rysowanie()
{
    cout << " w";
}
