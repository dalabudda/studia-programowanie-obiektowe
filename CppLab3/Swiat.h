#ifndef SWIAT_H_INCLUDED
#define SWIAT_H_INCLUDED

#include "Organizm.h"

#define N 20

class Organizm;

class Swiat
{
private:
    int tura = 0;
    Organizm* organizmy[N][N];
    Organizm* kolejnosc[N*N];
    char* wydarzenia[N*N];
    void znajdzWolneXY(int &x, int &y);
    template <class T>
    void wygenerujNOrganizmow(const int n);
    void rysujRamkePoziomo();
public:
    Swiat();
    ~Swiat();
    void wykonajTure();
    void rysujSwiat();
    static bool czyXYnalezyDoSwiata(const int x, const int y);
    bool czyWolneMiejsceWOkolicyXY(const int x, const int y);
    Organizm* getOrganizm(const int x, const int y);
    void setOrganizm(const int x, const int y, Organizm* organizm);
    int getTura()
    {
        return tura;
    }
    void usunOrganizm(const int x, const int y);
    void zapiszSwiat();
    void wczytajSwiat();
};


#endif // SWIAT_H_INCLUDED
