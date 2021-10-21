#ifndef WARTOSC_LICZBOWA_H_INCLUDED
#define WARTOSC_LICZBOWA_H_INCLUDED

#include <iostream>

class Wartosc_Liczbowa
{
public:
    virtual double modul () = 0; //wartosc bezwzglêdna
    virtual void wypisz(std::ostream &out) = 0;
    virtual ~Wartosc_Liczbowa() {}
    virtual void overriding();
};

#endif // WARTOSC_LICZBOWA_H_INCLUDED
