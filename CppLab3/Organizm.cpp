#include "Organizm.h"

Organizm::Organizm(const int tura, const int X, const int Y, Swiat* S)
{
    starszenstwo = tura;
    x = X;
    y = Y;
    swiat = S;
}

bool Organizm::szybszyOd(Organizm *organizm)
{
    return  (inicjatywa > organizm->inicjatywa) ||
            (inicjatywa == organizm->inicjatywa && starszenstwo < organizm->starszenstwo);
}

bool Organizm::czyTenSamGatunek(Organizm *organizm)
{
    char *nazwa_a = getNazwa();
    char *nazwa_b = organizm->getNazwa();
    int i = 0;
    while (nazwa_a[i])
    {
        if (nazwa_a[i] != nazwa_b[i])
        {
            return false;
        }
        i++;
    }
    if (nazwa_b[i] != 0)
    {
        return false;
    }
    return true;
}

void Organizm::zapisz(std::ofstream &plik)
{
    plik << getNazwa() << ' ' << x << ' ' << y << ' '<< starszenstwo << ' ' << sila << ' ' << inicjatywa << '\n';
}
