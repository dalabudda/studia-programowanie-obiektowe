#include "Wyjatek.h"
#include <iostream>

Wyjatek::Wyjatek(string w)
{
    wiadomosc = w;
}

void Wyjatek::wypisz()
{
    cout << wiadomosc << endl;
}
