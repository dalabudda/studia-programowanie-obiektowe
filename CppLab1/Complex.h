#ifndef COMPLEX_H_INCLUDED
#define COMPLEX_H_INCLUDED

#include "Wartosc_Liczbowa.h"
#include <iostream>

class Complex : public Wartosc_Liczbowa
{
protected:
    double re;
    double im; //czesc urojona
public:
    ~Complex(void);
    Complex(double re=0,double im=0) ;
    Complex operator +(Complex & right)
    {
        return Complex (this->re+right.re, this->im+right.im);
    }
    friend std::ostream & operator<< (std::ostream &out, Complex &l);
    double modul();
    void wypisz(std::ostream &out)
    {
        out<<*this;
    }
    void overriding();
    void overloading();
    void overloading(int liczba);
};


#endif // COMPLEX_H_INCLUDED
