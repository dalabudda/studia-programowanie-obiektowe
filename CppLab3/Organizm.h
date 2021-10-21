#ifndef ORGANIZM_H_INCLUDED
#define ORGANIZM_H_INCLUDED

#include "Swiat.h"
#include "Komentarz.h"
#include <fstream>

class Swiat;
class Komentarz;

class Organizm
{
private:
    int starszenstwo;
protected:
    int x,y;
    int sila;
    int inicjatywa;
    Swiat* swiat;
public:
    Organizm(const int tura, const int X, const int Y, Swiat* S);
    virtual char* akcja(const int tura) = 0;
    virtual char* kolizja(const int tura, Organizm* organizm) = 0;
    virtual void obrona(Organizm* organizm, bool &ginieAtakujacy, bool &ginieBroniacy, Komentarz &komentarz) = 0;
    virtual void rysowanie() = 0;
    int getInicjatywa()
    {
        return inicjatywa;
    }
    int getStarszenstwo()
    {
        return starszenstwo;
    }
    int getX()
    {
        return x;
    }
    int getY()
    {
        return y;
    }
    int getSila()
    {
        return sila;
    }
    void setSila(const int Sila)
    {
        sila = Sila;
    }
    bool szybszyOd(Organizm *organizm);
    virtual char* getNazwa() = 0;
    bool czyTenSamGatunek(Organizm *organizm);
    void zapisz(std::ofstream &plik);
};


#endif // ORGANIZM_H_INCLUDED
