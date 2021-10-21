#ifndef LICZBA_H_INCLUDED
#define LICZBA_H_INCLUDED

#include "Wartosc_Liczbowa.h"
#include <iostream>

class Liczba : public Wartosc_Liczbowa
{
    double re; //czesc rzeczywista
public:
    Liczba operator+(Liczba & right)
    {
        return Liczba (this->re+right.re);
    }
    double modul();
    Liczba(double re);
    ~Liczba(void);
    friend std::ostream & operator<< (std::ostream &out, Liczba &l);
    void wypisz(std::ostream &out)
    {
        out<<*this;
    }
};

#endif // LICZBA_H_INCLUDED
