#include "Komentarz.h"

Komentarz::Komentarz(Organizm *a, Organizm *b)
{
    atakujacy = a;
    broniacy = b;
}

Komentarz::~Komentarz()
{
    delete zdarzenie;
}

void Komentarz::setZdarzenie(char *z)
{
    zdarzenie = z;
}

char* Komentarz::getChar()
{
    char *komentarz = new char[100];
    char *nazwa_a = atakujacy->getNazwa();
    char *nazwa_b = broniacy->getNazwa();

    int nr_znaku = 0;
    int i = 0;
    while (nazwa_a[i])
    {
        komentarz[nr_znaku] = nazwa_a[i];
        i++;
        nr_znaku++;
    }
    komentarz[nr_znaku] = ' ';
    nr_znaku++;
    i = 0;
    while (zdarzenie[i])
    {
        komentarz[nr_znaku] = zdarzenie[i];
        i++;
        nr_znaku++;
    }
    komentarz[nr_znaku] = ' ';
    nr_znaku++;
    i = 0;
    while (nazwa_b[i])
    {
        komentarz[nr_znaku] = nazwa_b[i];
        i++;
        nr_znaku++;
    }
    komentarz[nr_znaku] = 0;

    delete nazwa_a;
    delete nazwa_b;

    return komentarz;
}
